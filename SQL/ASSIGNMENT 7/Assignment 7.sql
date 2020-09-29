/* ==================Testing_System_7=======================*/
DROP DATABASE IF EXISTS TESTING_SYSTEM_ASSIGNMENT_1;
USE	TESTING_SYSTEM_ASSIGNMENT_1;
--  Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"

SELECT 	EXAM_ID, DURATION,
CASE
	WHEN	DURATION <= 30 THEN	'Short time'
    WHEN	DURATION <= 60 THEN	'Medium time'
	ELSE	'Long time'
END AS 		Long_time_DURATION
FROM	Exam;
-- TRIGGER
-- Check email truoc khi insert vao bang
DROP TRIGGER IF EXISTS check_mail_trigger;
DELIMITER $$
CREATE	TRIGGER check_mail_trigger
BEFORE INSERT	ON `Account`
FOR EACH ROW
BEGIN
-- Get email from user
DECLARE	out_put_Email VARCHAR (50);
SELECT	New.Email	INTO	out_put_Email;
-- check email
IF out_put_Email NOT LIKE '%@gmail.com' THEN
-- Lenh huy insert neu not like %@gmail.com
SIGNAL	SQLSTATE	'12345'
SET	MESSAGE_TEXT = 'Email khong hop le';
END IF;
-- check User
END $$
DELIMITER ;

INSERT INTO `Account`(Email								, USER_NAME			, FULL_NAME				, DEPARTMENT_ID	,POSITION_ID)
VALUES 				('haiminh29productions@gmail.com'	, 'dangblack1'		,'Nguyen Hai Dang1'		,5  			,1			);



SELECT Count(Question_ID) FROM Answer;
SELECT Count(DISTINCT Question_ID) FROM Answer;

