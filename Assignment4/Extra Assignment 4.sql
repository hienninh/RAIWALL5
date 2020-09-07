/*========================= Extra Assignment 4_VN==============================*/
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
DROP DATABASE IF EXISTS Extra_Assignment_4;
CREATE DATABASE Extra_Assignment_4;
USE	Extra_Assignment_4;

-- CREATE TABLE: DEPARTMENT	
CREATE TABLE DEPARTMENT (
DEPARTMENT_ID		TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
DEPARTMENT_NAME		VARCHAR (20) UNIQUE KEY
);

-- CREATE TABLE: Employee_Table
CREATE TABLE Employee_Table (
Employee_ID			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Employee_NAME		VARCHAR (20)	NOT NULL,
Department_ID		TINYINT UNSIGNED CHECK	(Department_ID<10),
FOREIGN KEY	(Department_ID) REFERENCES DEPARTMENT	(Department_ID)
);

-- CREATE TABLE: Employee_Skill_Table	
CREATE TABLE Employee_Skill_Table (
Employee_ID			TINYINT UNSIGNED,
Skill_Code			VARCHAR (10),
`Date Registered`	DATETIME	DEFAULT NOW()
);
-- Question 2: Thêm ít nhất 10 bản ghi vào table
/*============================== INSERT DATABASE ===============================*/
-- Add data Department
INSERT INTO Department	(DEPARTMENT_NAME) 
VALUES					(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Account'		);

-- Add data Employee_Table
INSERT INTO Employee_Table	(Employee_NAME 		,Department_ID	)
VALUES						(N'Trần Phú Đạt'	,	1			),
						    (N'Lê Ngọc Du'		,   2           ),
						    (N'Nguyễn Thế Đức'	,   5           ),
						    (N'Trịnh Hà Hải'	,   1           ),
						    (N'Phạm Văn Huy'	,   5           ),
						    (N'Nguyễn Thị Mỵ'	,   3           ),
						    (N'Ninh Thi Hien'	,   4           ),
						    (N'Tống Thị Nhung'	,   6           ),
						    (N'Vũ Văn Ước'		,   8           ),
						    (N'Trần Lưu Võ'		,   1           );

-- Add data Employee_Skill_Table
INSERT INTO Employee_Skill_Table	(Employee_ID 	,Skill_Code			,`Date Registered`)
VALUES								(1				,'SKILL_MS5'		,NULL			),
						            (4            	,'Java'        		,'2019-10-20'   ),
						            (5            	,'SKILL_MS6'        ,'2020-03-07'   ),
						            (7            	,'SKILL_MS4'        ,'2020-03-08'   ),
						            (8            	,'SKILL_MS2'        ,'2020-03-10'   ),
						            (8            	,'SKILL_MS7'        ,'2019-10-22'   ),
						            (1            	,'SKILL_MS3'        ,'2020-04-05'   ),
						            (7            	,'Java'       		,'2020-04-07'   ),
						            (6            	,'Java'        		,'2020-04-07'  	),
						            (1           	,'SKILL_MS11'       ,'2020-04-09'  	);
-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java
SELECT 		* -- DISTINCT EST.Employee_ID -- ,	GROUP_CONCAT(ET.Employee_NAME), count(ET.Employee_NAME)	
From		Employee_Skill_Table	EST
-- JOIN		Employee_Table	ET	ON	EST.Employee_ID	=	ET.Employee_ID
-- GROUP BY	EST.Skill_Code
WHERE		EST.Skill_Code = 'Java';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >=3 nhân viên
SELECT		D.DEPARTMENT_NAME, GROUP_CONCAT(ET.Employee_NAME), COUNT(ET.Department_ID)
FROM		Employee_Table	ET
JOIN		Department	D ON	ET.Department_ID =	D.Department_ID
GROUP BY	ET.Department_ID
HAVING		COUNT(ET.Department_ID)>=3;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban. 
SELECT		D.DEPARTMENT_NAME, GROUP_CONCAT(ET.Employee_NAME), COUNT(ET.Department_ID)
FROM		Employee_Table	ET
JOIN		Department	D ON	ET.Department_ID =	D.Department_ID
GROUP BY	ET.Department_ID;