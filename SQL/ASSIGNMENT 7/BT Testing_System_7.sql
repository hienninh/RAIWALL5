/* ==================Testing_System_7=======================*/
DROP DATABASE IF EXISTS TESTING_SYSTEM_ASSIGNMENT_1;
USE	TESTING_SYSTEM_ASSIGNMENT_1;
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm 
DROP TRIGGER IF EXISTS	Trigger_Create_Date_New;
DELIMITER $$
CREATE	TRIGGER Trigger_Create_Date_New
BEFORE	INSERT ON `Group`
FOR EACH ROW
BEGIN
IF	(YEAR(New.CREATE_DATE) - YEAR(NOW())) >= 1 THEN
SIGNAL SQLSTATE '12345' -- khong cho phep insert vao bang
SET MESSAGE_TEXT = 'Field Create_Date must less than 1 year (NOW())';
END IF;
END$$
DELIMITER ;

INSERT INTO `Group`	(  GROUP_NAME					,CREATOR_ID	,CREATE_DATE)
VALUES 				(N'Testing System LAN 1'		,5			,'2021-03-05');
-- Cách 2: Dùng Date_Sub ()

 DROP TRIGGER IF EXISTS	Trigger_Create_Date_New;
DELIMITER $$
CREATE	TRIGGER Trigger_Create_Date_New
BEFORE	INSERT ON `Group`
FOR EACH ROW
BEGIN
IF	New.CREATE_DATE < DATE_SUB(Curdate(), INTERVAL -1 Year) THEN
SIGNAL SQLSTATE '12345' -- khong cho phep insert vao bang
SET MESSAGE_TEXT = 'Field Create_Date must less than 1 year (NOW())';
END IF;
END$$
DELIMITER ;
INSERT INTO `Group`	(  GROUP_NAME					,CREATOR_ID	,CREATE_DATE)
VALUES 				(N'Testing System LAN 1'		,5			,'2021-03-05');

-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào department "Sale" nữa, 
-- khi thêm thì hiện ra thông báo "Department "Sale" cannot add more user"

DROP TRIGGER IF EXISTS Trigger_not_insert_Sale;
DELIMITER $$
CREATE TRIGGER Trigger_not_insert_Sale
BEFORE INSERT ON `account`
FOR EACH ROW
	BEGIN
		DECLARE	DepartmentID_of_Account TINYINT UNSIGNED;
		SELECT 	D.DEPARTMENT_ID INTO DepartmentID_of_Account
		FROM 	Department D
		WHERE 	D.Department_Name = 'Sale';

		IF NEW.Department_ID = DepartmentID_of_Account THEN
		SIGNAL SQLSTATE '12345' -- khong cho phep insert phong 'sale'
		SET MESSAGE_TEXT = 'Field Department_Name must different sale';
	END IF;
	END$$
DELIMITER ;


INSERT INTO `Account`(Email						, USER_NAME			, FULL_NAME				, DEPARTMENT_ID	,POSITION_ID,CREATE_DATE)
VALUES 				('Nguyenthimy@gmail.com'	, 'MyNguyen'		,'Nguyen Thi My'		,2  			,1			,NULL);

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Group_less_than_6_account;
DELIMITER $$
CREATE	TRIGGER	Group_less_than_6_account
BEFORE INSERT ON groupaccount
FOR EACH ROW
BEGIN
	DECLARE 	AccountAmount TINYINT UNSIGNED;
	SELECT 		Count(ACCOUNT_ID) INTO AccountAmount
	FROM 		groupaccount
	WHERE 		GROUP_ID = New.GROUP_ID;
	IF 	AccountAmount > 5 THEN
		SIGNAL SQLSTATE '12345' -- khong cho phep insert nhieu hơn 5 account
		SET MESSAGE_TEXT = 'Field Group have  Account_ID  must less 6';
	END IF;
END$$
DELIMITER ;
INSERT INTO `GroupAccount`	(  Group_ID		,Account_ID	,CREATE_DATE	 )
VALUES 						(	1		   	,10			,'2019-03-05'	);

SELECT 		Count(ACCOUNT_ID) 
	FROM 		groupaccount
	WHERE 		GROUP_ID = 1;
    
-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Question_Amount_less_than_11;
DELIMITER $$
CREATE TRIGGER	Question_Amount_less_than_11
BEFORE INSERT ON examquestion
FOR EACH ROW
BEGIN
DECLARE		Question_Amount	TINYINT UNSIGNED; 
SELECT		Count(Question_ID) INTO Question_Amount
FROM		Examquestion
WHERE		Exam_ID = NEW.Exam_ID;
IF			Question_Amount > 10  THEN
			SIGNAL SQLSTATE '12345' -- khong cho phep insert nhieu hơn 10 question
			SET MESSAGE_TEXT = 'Field Exam have Question must less 11';
END IF;
END$$
DELIMITER ;
INSERT INTO ExamQuestion(EXAM_ID	,QUESTION_ID) 
VALUES 					(5			,1			);

SELECT		Count(Question_ID) 
FROM		Examquestion
WHERE		Exam_ID = 5;
-- Question 5:Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com 
-- (đây là tài khoản admin, không cho phép user xóa),
-- còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó

DROP TRIGGER IF EXISTS Delete_AcountID;
DELIMITER $$
CREATE	TRIGGER Delete_AcountID
BEFORE DELETE ON `Account`
FOR EACH ROW
BEGIN
	DECLARE		v_Account_ID TINYINT UNSIGNED;
	SELECT 		Account_ID INTO v_Account_ID
	FROM 		`Account`
	WHERE 		Email = OLD.Email;
    
	IF 	OLD.Email = 'admin@gmail.com' THEN
			SIGNAL SQLSTATE '12345' -- khong cho phep xoa admin@gmail.com
			SET MESSAGE_TEXT = 'Field Account dont have admin@gmail.com';
	DELETE	FROM	Groupaccount WHERE	ACCOUNT_ID = v_Account_ID;
	DELETE	FROM	`Group`		WHERE	CREATOR_ID = v_Account_ID;
	DELETE	FROM	Exam		WHERE	CREATOR_ID = v_Account_ID;
	END IF;
END$$
DELIMITER ;

DELETE FROM `account`
WHERE email = 'account1@gmail.com';

-- Question 6: Hãy tạo trigger cho phép người dùng khi tạo account 
-- Neu không điền vào departmentID nao thì sẽ được phân vào phòng ban "waiting Department" 
DROP TRIGGER IF EXISTS	Department_ID_of_Account;
DELIMITER $$
CREATE TRIGGER	Department_ID_of_Account
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN
DECLARE v_Department_ID TINYINT UNSIGNED; 
SELECT	Department_ID INTO	v_Department_ID
FROM	Department
WHERE	Department_Name = 'Phong cho';

IF NEW.Department_ID IS NULL THEN
SET NEW.Department_ID = v_Department_ID;
END IF;
END$$
DELIMITER ;

INSERT INTO `Account`(Email						, USER_NAME		, FULL_NAME				,POSITION_ID,CREATE_DATE)
VALUES 				('NguyenngocDUy@gmail.com'	, 'NgocDuy'		,'Nguyen Ngoc Duy' 		,1			,NULL);

-- (Chua xong) Question 7:  Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
DROP TRIGGER IF EXISTS Answer_of_Question;
DELIMITER $$
CREATE	TRIGGER	Answer_of_Question
BEFORE	INSERT	ON Answer
FOR EACH ROW
BEGIN
DECLARE	Answer_Amount TINYINT UNSIGNED;
DECLARE	isCorrect_Amount	TINYINT UNSIGNED;
SELECT		Count(ANSWER_ID), COUNT(isCorrect) INTO Answer_Amount, isCorrect_Amount
FROM		Answer
WHERE		Question_ID = NEW.Question_ID;
IF 			Answer_Amount > 4 OR
			COUNT(IF( isCorrect = 'T',isCorrect ,null)) > 2 THEN
			SIGNAL SQLSTATE '12345' -- khong cho phep insert nhieu hơn 4 Answer
			SET MESSAGE_TEXT = 'Field Question have Count(Answer) must less than 4';
END IF;
END$$
DELIMITER ;
INSERT INTO Answer	(Content		,Question_ID	,isCorrect)
VALUES 				(N'Trả lời 11'	,3				,'T'		);
SELECT
       Count(ANSWER_ID)
     , COUNT(IF( isCorrect = 'F',isCorrect, null)) AS F
     , COUNT(IF( isCorrect = 'T',isCorrect, null)) AS T
FROM Answer
WHERE Question_ID = 10;





-- Question 8: Viết trigger sửa lại dữ liệu cho đúng: Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
DROP TRIGGER IF EXISTS Fix_Gender_of_Account;
DELIMITER $$

CREATE TRIGGER	Fix_Gender_of_Account
BEFORE INSERT ON `Account`
FOR EACH ROW
BEGIN

DECLARE	v_Gender VARCHAR(50);
SELECT	NEW.GENDER	INTO v_Gender;

IF NEW.GENDER = 'Nam' THEN
SET NEW.GENDER = 'M';
END IF;

IF NEW.GENDER = 'Nu' THEN
SET NEW.GENDER = 'F';
END IF;

IF NEW.GENDER = 'Chua xac dinh' THEN -- is NULL THEN
SET NEW.GENDER = 'U';
END IF;

END$$
DELIMITER ;

INSERT INTO `Account`(Email						, USER_NAME		, FULL_NAME				, DEPARTMENT_ID	,POSITION_ID, CREATE_DATE	,GENDER	)
VALUES 				('hienninh@gmail.com'		, 'hienminh'	,'Ninh Minh Hien'		,2  			,1			,NULL	        ,'Nu'	);

SELECT *
FROM 	`Account`;
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày truoc
SELECT Date_sub(NOW(), INTERVAL 2 DAY);
SELECT Date_ADD(NOW(), INTERVAL -2 DAY);

DROP TRIGGER IF EXISTS NotDelete_CreateDate_Than_2day;
DELIMITER $$
CREATE	TRIGGER NotDelete_CreateDate_Than_2day
BEFORE	DELETE ON exam
FOR EACH ROW

BEGIN

	DECLARE	V_CREATE_DATE DATE;
	SELECT	OLD.CREATE_DATE INTO V_CREATE_DATE;
	IF OLD.CREATE_DATE > Date_sub(NOW(), INTERVAL 2 DAY) THEN
		SIGNAL SQLSTATE '12345' -- dont allow DELETE CREATE_DATE affer 2 day 
		SET MESSAGE_TEXT = 'Field Exam dont Delete, CREATE_DATE affer 2 day';
	DELETE
    FROM	exam
    WHERE	OLD.CREATE_DATE = V_CREATE_DATE;
END IF;
END$$
DELIMITER ;

-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
-- UPDATE
DROP TRIGGER IF EXISTS	Update_question_of_Exam;
DELIMITER $$
CREATE TRIGGER	Update_question_of_Exam
BEFORE UPDATE ON `question`
FOR EACH ROW
BEGIN
    IF	OLD.Question_ID IN (SELECT	DISTINCT Question_ID FROM Examquestion) OR 
	OLD.Question_ID IN (SELECT	DISTINCT Question_ID FROM Answer) THEN
    SIGNAL SQLSTATE '12345' -- dont allow Update Question have on Answer/Examquestion)
	SET MESSAGE_TEXT = 'Field Question dont Update when it have on Answer/ExamQuestion';
END IF;
END$$
DELIMITER ;
UPDATE	Question
SET		Question_ID = 0
WHERE	Question_ID = 5;

-- DELETE
DROP TRIGGER IF EXISTS	Update_question_of_Exam;
DELIMITER $$
CREATE TRIGGER	Update_question_of_Exam
BEFORE DELETE ON `question`
FOR EACH ROW
BEGIN
    IF	OLD.Question_ID IN (SELECT	Question_ID FROM Examquestion) OR 
	OLD.Question_ID IN (SELECT	Question_ID FROM Answer) THEN
    SIGNAL SQLSTATE '12345' -- dont allow Delete Question have on Answer/Examquestion)
	SET MESSAGE_TEXT = 'Field Question dont Delete when it have on Answer/ExamQuestion';
END IF;
END$$
DELIMITER ;
DELETE	
FROM 	Question
WHERE	Question_ID = 5;
-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT 	EXAM_ID, DURATION, CASE
							WHEN  Duration <= 30 THEN 'Short time'
                            WHEN  Duration <= 60 THEN 'Medium time'
                            ELSE  'Long time'
						 END AS Kind_of_Duration
FROM	EXAM;
-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount 
-- và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher

SELECT		G.GROUP_ID, G.GROUP_NAME, Count(GA.ACCOUNT_ID),
CASE		
	WHEN	Count(GA.ACCOUNT_ID) <= 5 THEN 'Few'
    WHEN	Count(GA.ACCOUNT_ID) <= 20 THEN 'Normal'
	ELSE 'higher'
END 		AS 	the_number_user_amount
FROM		Groupaccount GA
RIGHT JOIN	`Group` G ON G.GROUP_ID = GA.GROUP_ID
GROUP BY	G.GROUP_ID;

-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, 
-- nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
SELECT	 	D.Department_ID, D.Department_Name, GROUP_CONCAT(A.USER_NAME), Count(ACCOUNT_ID),
CASE
	WHEN	Count(ACCOUNT_ID) = 0 THEN 'Không có User'
	ELSE	Count(ACCOUNT_ID)
END	AS Phan_loai_Department
FROM		`Account` A
RIGHT JOIN	Department D ON A.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY 	D.DEPARTMENT_ID;
