
DROP DATABASE IF EXISTS Table_Trainee;
CREATE DATABASE Table_Trainee;
USE Table_Trainee;
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu
-- CREATE TABLE: Trainee
CREATE TABLE Trainee (
TraineeID			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Full_Name			VARCHAR (20) NOT NULL CHECK (LENGTH(Full_Name)>=10),
Birth_Date			DATE CHECK (Birth_Date >='1990-01-01'),
Gender				ENUM ('M', 'F', 'U') NOT NULL,
ET_IQ				TINYINT UNSIGNED CHECK(ET_IQ<=20), -- DECIMAL (5, 3)
ET_Gmath			TINYINT UNSIGNED CHECK(ET_Gmath<=20),
ET_English			TINYINT UNSIGNED CHECK(ET_English<=20),
Training_Class		CHAR (10) NOT NULL,
Evaluation_Notes	NVARCHAR (500)
);
-- Question 2: thêm trường VTI_Account với điều kiện not null & unique
-- Chú ý: chú tới tới các best practice

ALTER TABLE Trainee
ADD VTI_Account VARCHAR (20) AFTER TraineeID;

-- QUESTION 2:  Data Types
CREATE TABLE `Data Types` (
ID					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`Name`				VARCHAR(20) CHECK (LENGTH(`Name`)>=6),
`Code`				CHAR (5),
ModifiedDate 		DATETIME DEFAULT NOW()		-- Thời gian của lần sửa đổi cuối cùng (Datatime)
);

-- CREATE TABLE: Data Types (2)
CREATE TABLE `Data Types (2)` (
    ID TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(20) CHECK (LENGTH(`Name`) >= 6),
    BirthDate CHAR(8) CHECK (BirthDate >= 2000 AND BirthDate <= 1970),
    Gender BIT NULL,
    `Code` CHAR(5),
    IsDeletedFlag BIT
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/

-- Add data Trainee
INSERT INTO `Trainee`(FULL_NAME				,Birth_Date		, Gender	,ET_IQ	, ET_Gmath	,ET_English		,Training_Class	,Evaluation_Notes)
VALUES 				(N'Trần Phú Đạt'		, '1997-10-07'	, 'M'		, '15'	, '13'		, '13'			, 'MSSQL13'		, N'Bài làm khá, cần cố gắng'),
					(N'Lê Ngọc Du'		    , '1997-05-08'  , 'M'       , '13'  , '15'      , '15'          , 'MSSQL15'     , N'cần cố gắng'),
                    (N'Nguyễn Thế Đức'	    , '1995-07-19'  , 'M'       , '15'  , '17'      , '17'          , 'MSSQL17'     , NULL),
                    (N'Trịnh Hà Hải'	    , '1997-10-21'  , 'M'       , '17'  , '10'      , '10'          , 'MSSQL10'     , N'chú ý trình bày'),
                    (N'Phạm Văn Huy'	    , '1997-08-27'  , 'M'       , '10'  , '18'      , '18'          , 'MSSQL18'     , N'Cần cố gắng'),
                    (N'Nguyễn Thị Mỵ'	    , '1995-07-24'  , 'F'       , '17'  , '15'      , '15'          , 'MSSQL15'     , N'Bài làm khá'),
                    (N'Ninh Thi Hien'	    , '1995-10-18'  , 'F'       , '15'  , '15'      , '15'          , 'MSSQL13'     , N'Cần phát huy'),
                    (N'Tống Thị Nhung'	    , '1992-06-07'  , 'F'	    , '19'  , '17'      , '17'          , 'MSSQL17'     , N'Bài làm rất tốt'),
                    (N'Vũ Văn Ước'		    , '1996-03-02'  , 'M'       , '13'  , '18'      , '18'          , 'MSSQL18'     , Null),
                    (N'Trần Lưu Võ'		    , '1996-10-15'  , 'M'       , '10'  , '15'      , '15'          , 'MSSQL13'     , Null);



