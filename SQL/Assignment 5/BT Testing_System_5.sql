/*=====================Testing_System_5.pdf======================*/
DROP DATABASE IF EXISTS TESTING_SYSTEM_ASSIGNMENT_1;
-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
DROP VIEW IF EXISTS Nhan_Vien_Sales;
-- Su dung VIEW
CREATE	VIEW	Nhan_Vien_Sales AS
SELECT	D.DEPARTMENT_NAME, GROUP_CONCAT(A.FULL_NAME)
FROM	Department D
JOIN	`Account` A	ON	A.Department_ID = D.Department_ID
WHERE	DEPARTMENT_NAME = 'Sale';

SELECT	*
FROM	Nhan_Vien_Sales;

-- Su dung CTE
WITH	DepartmentID_of_Sales AS
(SELECT D.Department_ID 
FROM Department D 
WHERE D.Department_Name = 'Sale')

SELECT	*
FROM	`Account` A
WHERE	A.Department_ID = (SELECT Department_ID  
							FROM	DepartmentID_of_Sales);
                            
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất

-- Su dung VIEW
DROP VIEW IF EXISTS Account_Have_Max_Group;
CREATE	VIEW  Account_Have_Max_Group AS	
SELECT		ACCOUNT_ID, Count(GA.Group_ID) AS So_Luong_Group, Group_Concat(G.GROUP_NAME)
FROM		Groupaccount GA
JOIN		`Group` G	ON	GA.GROUP_ID = G.GROUP_ID
GROUP BY	GA.ACCOUNT_ID
HAVING		Count(GA.Group_ID) = (SELECT	MAX(So_Luong_Group)
								FROM	(SELECT		Count(GA.Group_ID) AS	So_Luong_Group	
								FROM		Groupaccount GA
								JOIN		`Group` G	ON	GA.GROUP_ID = G.GROUP_ID
								GROUP BY	GA.ACCOUNT_ID) AS	SL_Group_Max);

SELECT	*
FROM	Account_Have_Max_Group;
-- Su dung CTE
WITH	
Group_Account_Join	AS
(	SELECT		ACCOUNT_ID, Count(GA.Group_ID) AS So_Luong_Group, Group_Concat(G.GROUP_NAME)
	FROM		Groupaccount GA
	JOIN		`Group` G	ON	GA.GROUP_ID = G.GROUP_ID
	GROUP BY	GA.ACCOUNT_ID
)
	SELECT		*
	FROM		Group_Account_Join
    WHERE		So_Luong_Group = (	SELECT 	Max(So_Luong_Group) 
									FROM 	Group_Account_Join);


-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 19 từ được coi là quá dài) và xóa nó đi
SELECT	* FROM	Question;
DROP View IF EXISTS Long_Cotent_length	;
-- Su dung CTE
WITH Long_Cotent_length AS
(	SELECT	*
	FROM	Question
	WHERE	Length(CONTENT) >= 19)

	SELECT	*
	FROM	Long_Cotent_length;

DELETE
FROM	Answer
WHERE	Question_ID IN (SELECT	Question_ID
						FROM	Long_Cotent_length);


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
DROP VIEW IF EXISTS	Table_Account_Department;
-- Su dung CTE 
WITH Table_Account_Department AS 
(	SELECT		A.DEPARTMENT_ID, Count(A.Account_ID) AS So_luong_Account
	FROM		`account` A, Department D
	WHERE		A.DEPARTMENT_ID = D.DEPARTMENT_ID
	GROUP BY	A.DEPARTMENT_ID
)
	SELECT		*
	FROM		Table_Account_Department
	WHERE		So_luong_Account = (SELECT 		Max(So_luong_Account)
									FROM		Table_Account_Department
);

-- Su dung View
CREATE	VIEW	Department_Have_Max_Account	AS
SELECT			A.DEPARTMENT_ID, D.DEPARTMENT_NAME, GROUP_CONCAT(A.FULL_NAME)
FROM			`account` A
JOIN			Department D ON	A.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY		A.DEPARTMENT_ID
HAVING			Count(A.ACCOUNT_ID) = (SELECT MAX(So_luong_Account) FROM
								(SELECT		Count(A.ACCOUNT_ID) AS So_luong_Account
								FROM		`account` A
								JOIN		Department D ON	A.DEPARTMENT_ID = D.DEPARTMENT_ID
								GROUP BY	A.DEPARTMENT_ID) AS SL_Account_Max);
SELECT	*
FROM	Department_Have_Max_Account;               

-- Question 5: Tạo view có chứa tất ca các câu hỏi do user họ Nguyễn tạo

-- Su dung View
CREATE	VIEW	Question_Of_User_Nguyen AS
SELECT			Full_Name, count(Q.CONTENT), GROUP_CONCAT(Q.CONTENT)
FROM			`Account` A
Left JOIN		Question Q ON	A.ACCOUNT_ID = Q.CREATOR_ID
GROUP BY		FULL_NAME
Having		FULL_NAME	Like '%Nguyen%';

SELECT	*
FROM	Question_Of_User_Nguyen;

-- Su dung CTE
WITH			Question_Of_Lastname_Nguyen AS
(SELECT			Full_Name, count(CONTENT), GROUP_CONCAT(CONTENT)
FROM			`Account` A
Left JOIN		Question Q ON	A.ACCOUNT_ID = Q.CREATOR_ID
GROUP BY		FULL_NAME
Having			FULL_NAME	Like '%Nguyen%')

SELECT	*
FROM	Question_Of_Lastname_Nguyen;

