
DROP DATABASE IF EXISTS Table_Trainee;
CREATE DATABASE Table_Trainee;

-- CREATE TABLE: Trainee
CREATE TABLE Trainee (
TraineeID			TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Full_Name			VARCHAR (20) NOT NULL CHECK (LENGTH(Full_Name)<=10),
Birth_Date			DATE CHECK(Birth_Date>=20 AND Birth_Date<40),
Gender				ENUM ('male', 'female', 'unknown') NOT NULL,
ET_IQ				FLOAT UNSIGNED CHECK(ET_IQ<=20), -- DECIMAL (5, 3)
ET_Gmath			DECIMAL (5, 3) UNSIGNED CHECK(ET_Gmath<=20),
ET_English			DECIMAL (5, 3) UNSIGNED CHECK(ET_English<=20),
Training_Class		CHAR (20) NOT NULL CHECK (LENGTH(Training_Class)<=10) ,
Evaluation_Notes	NVARCHAR (500)
);
-- CREATE TABLE: Data Types
-- QUESTION 1:  thêm trường VTI_Account với điều kiện not null & unique
ALTER TABLE Trainee ADD column VTI_Account TINYINT UNSIGNED AUTO_INCREMENT UNIQUE KEY NOT NULL;

-- QUESTION 2:  Data Types
CREATE TABLE `Data Types` (
ID					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`Name`				VARCHAR(20) CHECK (LENGTH(`Name`)>=20),
`Code`				CHAR (5),
ModifiedDate 		DATETIME DEFAULT NOW()		-- Thời gian của lần sửa đổi cuối cùng (Datatime)
);

-- CREATE TABLE: Data Types (2)
CREATE TABLE `Data Types (2)` (
ID					TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`Name`				VARCHAR (20) CHECK (LENGTH(`Name`)>=20),
BirthDate			CHAR (8) CHECK (BirthDate>=2000 AND BirthDate<=1970),
Gender				BIT NULL,
`Code`				CHAR (5),
IsDeletedFlag		BIT
);



