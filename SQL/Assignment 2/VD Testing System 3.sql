SELECT	*
FROM `group`;

SELECT GROUP_NAME 
FROM `group`
where CREATE_DATE < '2019-12-20';

SELECT *
From `account`
WHERE FULL_NAME LIKE 'd%' and FULL_NAME LIKE '%o'; -- WHERE FULL_NAME LIKE 'D%O'

-- Distinct
SELECT Distinct CREATE_DATE
From `account`;

-- Order by
SELECT *
From `account`
ORDER BY ACCOUNT_ID ASC;		-- DESC: giam dan, ASC : Tang dan

SELECT *
From `account`
ORDER BY CREATE_DATE DESC, DEPARTMENT_ID ASC;

-- Max, Min, Count, sum, avg
SELECT Sum(ACCOUNT_ID)
From `account`;

SELECT Min(CREATE_DATE)
From `account`;

SELECT *
From `account`
where CREATE_DATE = (SELECT Min(CREATE_DATE)
From `account`);  -- xem lai

SELECT Max(DEPARTMENT_ID)
From `account`;



SELECT Full_name, LENGTH(Full_name) -- dem ky tu tieng anh Char_LENGTH, LENGTH dem ca dau tieng viet
From `account`;

SELECT Max(LENGTH(Full_name))
From `account`;

-- Limit
SELECT *
From `account`
LIMIT 5;

SELECT *
From `account`
ORDER BY CREATE_DATE DESC
Limit 5;

-- Alias (AS)
SELECT ACCOUNT_ID AS 'ID_Nhan_vien', POSITION_ID AS 'ID_Vi_Tri'
From `account`;
-- Question 10
SELECT *
From `Account`;
SELECT FULL_NAME, department_ID
From `Account`
WHERE department_ID = 2;
SELECT COUNT(FULL_NAME)
From `Account`
WHERE department_ID = 2;

-- Update
Update  `Account`
set		full_name = 'Nguyen Chien Thang'
where	account_ID =2;


-- Trung binh
SELECT avg(account_ID)
From `Account`;

-- count
SELECT count(1)			-- Count (1) nhanh hon count (*)
From `Account`;
SELECT count(CREATE_DATE)
From `Account`;
-- Count so luong tung DEPARTMENT_ID co trong bang Account
SELECT 		DEPARTMENT_ID,	count(1), group_concat(Email)
From		`Account`
GROUP BY	DEPARTMENT_ID;
SELECT 		*
From		`Group`;
-- Having di voi Group by
SELECT 		Group_Name, count(1)
From		`Group`
GROUP BY	Group_Name
Having		count(1) > 1;

-- Show concat, VD: 

-- Join
SELECT	*
FROM	`Account` A
JOIN	Department D ON	A.department_ID = D.department_ID;

SELECT	*
FROM	`Group` G
JOIN	`Account` A ON	G.CREATOR_ID = A.Account_ID
JOIN	Department D ON	A.department_ID = D.department_ID;