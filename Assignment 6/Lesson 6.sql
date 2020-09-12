-- CREATE PROCEDURE IN
DROP PROCEDURE IF EXISTS Position_Full_Name;
DeLimiter $$
CREATE	PROCEDURE	Position_Full_Name (IN IN_Full_Name VARCHAR(50)) -- khong fix cung du lieu
BEGIN
	SELECT	A.POSITION_ID, POSITION_NAME, FULL_NAME
	FROM	Position P
	JOIN	`Account` A	ON	A.Position_ID = P.Position_ID
	WHERE	FULL_NAME = IN_Full_Name;
END$$
DeLimiter ;
-- Using
Call	Position_Full_Name ('Tong Quang Anh');

/*==== CREATE PROCEDURE OUT====*/
-- X (Out_Depaetment_ID) = Department_ID

-- Testing_System_6.pdf

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
Call	Type_Question_Of_Month ();	
-- Tai sao phai lenh where roi moi Group by

-- Su dung Function
-- Nhap UserName va tra ra ID cua User do
DROP FUNCTION IF EXISTS Find_Account_ID;
DELIMITER $$
CREATE FUNCTION	Find_Account_ID (In_User_Name VARCHAR (50)) RETURNS TINYINT UNSIGNED
BEGIN
DECLARE		V_ACCOUNT_ID TINYINT UNSIGNED;
SELECT		ACCOUNT_ID INTO	V_ACCOUNT_ID
FROM		`Account`
WHERE		USER_NAME = In_User_Name;
RETURN		V_ACCOUNT_ID;
END$$
DELIMITER ;
-- Use
SELECT	Find_Account_ID('cocoduongqua');

