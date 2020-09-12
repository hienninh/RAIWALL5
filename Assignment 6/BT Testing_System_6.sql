/*---------- ----------Testing_System_6.pdf---------------------------*/

DROP DATABASE IF EXISTS TESTING_SYSTEM_ASSIGNMENT_1;
USE	TESTING_SYSTEM_ASSIGNMENT_1;

-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS	Account_of_A_Department;
DeLimiter $$
CREATE	PROCEDURE	Get_Account_by_Department_Name (IN IN_Department_Name VARCHAR(20))
BEGIN
SELECT	D.DEPARTMENT_ID, D.DEPARTMENT_NAME, A.FULL_NAME
From	`Account`	A
JOIN	Department	D ON	A.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE	D.Department_Name = IN_Department_Name;
END$$
DeLimiter ;
Call	Account_of_A_Department (6);

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
WHERE	MONTH (CREATE_DATE) = month(NOW())
GROUP BY MONTH (CREATE_DATE);
END$$;
DELIMITER $$
Call	Type_Question_Of_Month ()	

SELECT * From	Question
-- Tai sao phai lenh where roi moi Group by

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
(Select	Count(QUESTION_ID)
FROM		Question Q
JOIN		Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
GROUP BY	Q.TYPE_ID
LIMIT 		1)
SELECT		TQ.TYPE_ID, TYPE_NAME,  CREATE_DATE,Count(QUESTION_ID), Group_Concat(Q.CONTENT)
FROM		Question Q
JOIN		Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
GROUP BY	Q.TYPE_ID
HAVING		Count(QUESTION_ID) = (Select * FROM	Max_Count_Question_Of_Tyde);
END$$
DeLimiter ;
Call	Tyde_Have_Max_Count_Question();	
-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT *
FROM	Typequestion TQ
WHERE	TQ.TYPE_ID = @V_TYPE_ID;

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
WHERE		YEAR (CREATE_DATE) = 2020
GROUP BY	MONTH(CREATE_DATE))

SELECT *
FROM	Question_MONTH
WHERE	MONTH(CREATE_DATE) = in_MONTH_CREATE_DATE;
END$$
DELIMITER ;
-- USE
Call Question_of_Month(4);

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
 -- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS Question_of_6_Month;
DELIMITER $$
CREATE	PROCEDURE Question_of_6_Month (IN in_MONTH_CREATE_DATE TINYINT)
BEGIN
WITH	Question_MONTH AS
(SELECT 		QUESTION_ID, Count(QUESTION_ID),CREATE_DATE , GROUP_CONCAT(CONTENT), Month(CREATE_DATE)
FROM		Question
WHERE		YEAR (CREATE_DATE) = 2020 AND (MONTH(NOW()) - MONTH(CREATE_DATE)) < 6
GROUP BY	MONTH(CREATE_DATE))
SELECT *
FROM	Question_MONTH
WHERE	MONTH(CREATE_DATE) = in_MONTH_CREATE_DATE;
END$$
DELIMITER ;
Call Question_of_6_Month(4);
