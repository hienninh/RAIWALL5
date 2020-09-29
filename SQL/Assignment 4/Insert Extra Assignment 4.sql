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
						            (1            	,'SKILL_MS2'        ,'2020-04-05'   ),
						            (7            	,'Java'       		,'2020-04-07'   ),
						            (6            	,'Java'        		,'2020-04-07'  	),
						            (1           	,'SKILL_MS11'       ,'2020-04-09'  	);
