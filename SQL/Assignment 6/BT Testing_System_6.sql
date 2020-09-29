/*---------- ----------Testing_System_6.pdf---------------------------*/

DROP DATABASE IF EXISTS TESTING_SYSTEM_ASSIGNMENT_1;
USE	TESTING_SYSTEM_ASSIGNMENT_1;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS Account_Of_Department;
DELIMITER $$
CREATE	PROCEDURE Account_Of_Department (IN in_Department_Name VARCHAR(20))
BEGIN
SELECT *
FROM	`Account` A
JOIN	Department D ON A.Department_ID = D.Department_ID
WHERE	D.Department_Name = in_Department_Name;
END$$
DELIMITER ;
call Account_Of_Department('sale');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP	PROCEDURE	IF EXISTS Count_Account_of_Group;
DeLimiter $$
CREATE	PROCEDURE	Count_Account_of_Group	(IN in_Group_ID TINYINT	UNSIGNED)
BEGIN
SELECT	DISTINCT	 Group_ID, Count(Account_ID), GROUP_CONCAT(ACCOUNT_ID)
FROM		Groupaccount
WHERE		Group_ID = in_Group_ID
GROUP BY	Group_ID;
END$$
DeLimiter ;
Call	Count_Account_of_Group (8);

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP	PROCEDURE	IF EXISTS Type_Question_Of_Month;
DeLimiter $$
CREATE	PROCEDURE Type_Question_Of_Month ()
BEGIN
SELECT	TQ.TYPE_ID, TYPE_NAME,  CREATE_DATE,Count(QUESTION_ID), Group_Concat(Q.CONTENT)
FROM	Question Q
JOIN	Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
WHERE	MONTH (CREATE_DATE) = month(NOW());
END$$;
DELIMITER $$
Call	Type_Question_Of_Month ()	

SELECT * From	Question

--  Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
-- Su dung OUT
DROP	PROCEDURE	IF EXISTS Type_Have_Max_Count_Question;
DeLimiter $$
CREATE	PROCEDURE Type_Have_Max_Count_Question (OUT out_TYPE_ID TINYINT UNSIGNED) 
BEGIN
Select		Q.TYPE_ID INTO out_TYPE_ID
FROM		Question Q
GROUP BY	Q.TYPE_ID
HAVING		Count(Q.QUESTION_ID) = (SELECT Max(X) 
									FROM 
                                    ( SELECT Count(Q1.QUESTION_ID) AS X
                                    FROM		Question Q1
									GROUP BY	Q1.TYPE_ID) AS Max_X);
END$$
DeLimiter ;
SET 	@V_TYPE_ID = 0;
Call	Type_Have_Max_Count_Question(@V_TYPE_ID);
SELECT 	@V_TYPE_ID;

-- Su dung IN
DROP	PROCEDURE	IF EXISTS Tyde_Have_Max_Count_Question;
DeLimiter $$
CREATE	PROCEDURE Tyde_Have_Max_Count_Question ()
BEGIN
With	Max_Count_Question_Of_Tyde AS
(SELECT		TQ.TYPE_ID, TYPE_NAME,  CREATE_DATE,Count(QUESTION_ID) AS So_luong, Group_Concat(Q.CONTENT)
FROM		Question Q
JOIN		Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
GROUP BY	Q.TYPE_ID
LIMIT 		1)
SELECT		*
FROM		Max_Count_Question_Of_Tyde;
END$$
DeLimiter ;
Call	Tyde_Have_Max_Count_Question();	
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT *
FROM	Typequestion
WHERE	TYPE_ID = @V_TYPE_ID;

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào 
-- hoặc trả về user có username chứa chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS	get_Infomation_of_Name;
DELIMITER $$
CREATE	PROCEDURE	get_Infomation_of_Name (IN Input_String Varchar(50))
BEGIN
SELECT	GROUP_NAME
FROM	`Group`
WHERE	GROUP_NAME  LIKE CONCAT('%',Input_String, '%');

SELECT 	USER_NAME
FROM	`Account`
WHERE	USER_NAME LIKE	CONCAT('%',Input_String, '%');
END$$;
DELIMITER ;

CALL get_Infomation_of_Name('a');
-- cach 2

DROP PROCEDURE IF EXISTS	get_Infomation_of_Name;
DELIMITER $$
CREATE	PROCEDURE	get_Infomation_of_Name (IN Input_String Varchar(50))
BEGIN
SELECT	GROUP_NAME, Null AS USER_NAME
FROM	`Group`
WHERE	GROUP_NAME  LIKE CONCAT('%',Input_String, '%')
UNION
SELECT 	Null AS GROUP_NAME, USER_NAME
FROM	`Account`
WHERE	USER_NAME LIKE	CONCAT('%',Input_String, '%');
END$$;
DELIMITER ;

CALL get_Infomation_of_Name('a');

-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
-- Sau đó in ra kết quả tạo thành công

DROP PROCEDURE IF EXISTS Get_Information_of_Table;
DELIMITER $$
CREATE	PROCEDURE Get_Information_of_Table (IN in_Full_Name VARCHAR (50), in_Email VARCHAR (50))
BEGIN
DECLARE	v_position_ID 		TINYINT UNSIGNED;
DECLARE	v_DEPARTMENT_ID 	TINYINT UNSIGNED;
SELECT	position_ID INTO v_position_ID
FROM	Position
WHERE	POSITION_NAME = 'DEV';
SELECT	DEPARTMENT_ID  INTO	v_DEPARTMENT_ID
FROM	Department
WHERE	DEPARTMENT_NAME = 'Waiting_room';

INSERT INTO `Account`(Email		, USER_NAME								,FULL_NAME		,DEPARTMENT_ID	 ,POSITION_ID )
VALUE				 (in_Email	, SUBSTRING_INDEX (in_Email,'@', 1)		,in_Full_Name	,v_DEPARTMENT_ID ,v_position_ID);

IF ROW_COUNT() > 0 THEN
		SELECT 'You created record successfully!';
    ELSE 
		SELECT 'You did not create record successfully!';
	END IF;
    END$$;
DELIMITER ;
Call Get_Information_of_Table('Ninh Thi Hien', 'hienninh1510@gmail.com');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS	Type_Name_Have_Content_longest;
DELIMITER $$
CREATE	PROCEDURE	Type_Name_Have_Content_longest (IN in_TYPE_NAME enum('ESSAY','MULTIPLE-CHOICE'))
BEGIN
		SELECT	Q.Content, MAX(LENGTH(Q.Content))
		FROM	Question Q
        JOIN	typequestion	TQ ON	Q.TYPE_ID = TQ.TYPE_ID
		WHERE	TQ.TYPE_NAME = in_TYPE_NAME;
END$$
DELIMITER ;
-- USE
call Type_Name_Have_Content_longest('Essay');

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE	IF EXISTS Delete_Exam;
DELIMITER $$
CREATE	PROCEDURE Delete_Exam (IN in_Exam_ID TINYINT UNSIGNED)
BEGIN
DELETE	
FROM	Exam
WHERE	EXAM_ID = in_Exam_ID;
END$$;
DELIMITER ;
call Delete_Exam(1);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing -- Chưa làm được
-- PROCEDURE 
SELECT	YEAR(CREATE_DATE), EXAM_ID
FROM	Exam
WHERE	(YEAR(NOW()) - YEAR(CREATE_DATE)) > 3;
call Delete_Exam(6); 
-- CTE
DROP PROCEDURE	IF EXISTS Delete_Exam_3_year_Ago;
DELIMITER $$
CREATE	PROCEDURE Delete_Exam_3_year_Ago (IN in_Exam_ID TINYINT UNSIGNED)
BEGIN
WITH	Exam_3_year_Ago AS
(SELECT	YEAR(CREATE_DATE), EXAM_ID
FROM	Exam
WHERE	(YEAR(NOW()) - YEAR(CREATE_DATE)) > 3)
DELETE	
FROM	EXAM
WHERE	EXAM_ID = (SELECT	* 
					FROM 	Exam_3_year_Ago
					WHERE	EXAM_ID = in_Exam_ID);
END$$;
DELIMITER ;
Call	Delete_Exam_3_year_Ago (6);

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban
-- và các account thuộc phòng ban đó sẽ được chuyển về phòng ban default là phòng ban chờ việc -- Chưa làm được
DROP PROCEDURE	IF EXISTS Delete_Account;
DELIMITER $$
CREATE	PROCEDURE Delete_Account (IN in_DEPARTMENT_NAME VARCHAR (20))
BEGIN
DECLARE	v_DEPARTMENT_ID TINYINT	UNSIGNED;
DELETE
FROM 	`Account` A
WHERE 	A.DEPARTMENT_ID = (SELECT D.DEPARTMENT_ID FROM	Department D WHERE D.DEPARTMENT_NAME = in_DEPARTMENT_NAME);
END$$;
DELIMITER ;
call Delete_Account('Nhân sự');

UPDATE `Account` A
SET			A.Department_Name = 'Waiting room'
WHERE		A.DEPARTMENT_NAME = in_DEPARTMENT_NAME;
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE	IF EXISTS Question_of_Month;
DELIMITER $$
CREATE	PROCEDURE Question_of_Month (IN in_MONTH_CREATE_DATE TINYINT)
BEGIN
WITH	Question_MONTH AS
(SELECT 	QUESTION_ID, Count(QUESTION_ID),CREATE_DATE , GROUP_CONCAT(CONTENT), Month(CREATE_DATE)
FROM		Question
WHERE		YEAR (CREATE_DATE) = year(NOW())
GROUP BY	MONTH(CREATE_DATE))

SELECT *
FROM	Question_MONTH
WHERE	MONTH(CREATE_DATE) = in_MONTH_CREATE_DATE;
END$$
DELIMITER ;
-- USE
Call Question_of_Month(4);
-- Cách 2: Tối ưu hơn
DROP PROCEDURE	IF EXISTS Question_of_month;
DELIMITER $$
CREATE	PROCEDURE	Question_of_month ()
BEGIN
SELECT Each_Month.Month, Count(QUESTION_ID), GROUP_CONCAT(CONTENT)
FROM
	(SELECT	1 AS MONTH UNION
	SELECT	2 AS MONTH UNION
	SELECT	3 AS MONTH UNION
	SELECT	4 AS MONTH UNION
	SELECT	5 AS MONTH UNION
	SELECT	6 AS MONTH UNION
	SELECT	7 AS MONTH UNION
	SELECT	8 AS MONTH UNION
	SELECT	9 AS MONTH UNION
	SELECT	10 AS MONTH UNION
	SELECT	11 AS MONTH UNION
	SELECT	12 AS MONTH) AS Each_Month
LEFT JOIN	Question ON	Each_Month.Month = Month(Create_Date)
GROUP BY	Each_Month.Month
ORDER BY	Each_Month.Month ASC;
END$$
DELIMITER ;
CALL Question_of_month ();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
 -- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS Question_of_6_Month;
DELIMITER $$
CREATE	PROCEDURE Question_of_6_Month (IN in_MONTH_CREATE_DATE TINYINT)
BEGIN
WITH	Question_MONTH AS
(SELECT 		QUESTION_ID, Count(QUESTION_ID),CREATE_DATE , GROUP_CONCAT(CONTENT), Month(CREATE_DATE)
FROM		Question
WHERE		YEAR (CREATE_DATE) = year(NOW()) AND (MONTH(NOW()) - MONTH(CREATE_DATE)) < 6
GROUP BY	MONTH(CREATE_DATE))
SELECT *
FROM	Question_MONTH
WHERE	MONTH(CREATE_DATE) = in_MONTH_CREATE_DATE;
END$$
DELIMITER ;
Call Question_of_6_Month(4);

-- Cách 2: Tối ưu hơn

-- Select	NOW();
-- Select	DATE_ADD(NOW() , INTERVAL (-6) Month) AS Date_6_Month;
DROP PROCEDURE	IF EXISTS	Question_of_Six_Month;
DELIMITER $$
CREATE	PROCEDURE	Question_of_Six_Month ()
BEGIN
SELECT	Each_Month_Last6month.MONTH, Count(Question_ID), GROUP_CONCAT(CONTENT)
FROM
	(SELECT	MONTH(NOW() - INTERVAL 5 MONTH) AS MONTH
	UNION	
	SELECT	MONTH(NOW() - INTERVAL 4 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 3 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 2 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 1 MONTH) AS MONTH
	UNION
	SELECT	MONTH(NOW() - INTERVAL 0 MONTH) AS MONTH) 
	AS Each_Month_Last6month
	LEFT JOIN	Question ON Each_Month_Last6month.MONTH = MONTH(CREATE_DATE)
    GROUP BY Each_Month_Last6month.MONTH
	ORDER BY Each_Month_Last6month.MONTH ASC;
    END$$
    DELIMITER ;
CALL	Question_of_Six_Month ();
