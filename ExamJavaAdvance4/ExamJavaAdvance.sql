
DROP DATABASE IF EXISTS TESTING_SYSTEM_ASSIGNMENT;
CREATE DATABASE TESTING_SYSTEM_ASSIGNMENT;
USE	TESTING_SYSTEM_ASSIGNMENT;

-- CREATE TABLE: User
CREATE TABLE `Account`(
	AccountID				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fullname				VARCHAR(50) NOT NULL UNIQUE KEY
);

-- CREATE TABLE: GROUP
CREATE TABLE `Group` (
id				INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
`name`			VARCHAR (50) NOT NULL CHECK (LENGTH(`name`)>=6),
amountMember	INT UNSIGNED,
CreatorID		INT UNSIGNED,
createTime		DATE DEFAULT (CURRENT_DATE)
);

CREATE TABLE GroupAccount(
	GroupID					INT UNSIGNED NOT NULL,
    AccountID				INT UNSIGNED NOT NULL,
    JoinDate				DATETIME DEFAULT NOW(),
    PRIMARY KEY (GroupID, AccountID),
    FOREIGN KEY(AccountID) REFERENCES `Account` (AccountID),
	FOREIGN KEY(GroupID) REFERENCES `Group` (id)
);
USE	TESTING_SYSTEM_ASSIGNMENT;
-- Add data `Account`
INSERT INTO `Account`(fullname					)
VALUES 				('Nguyen Hai Dang'	   	),
					('Tong Quang Anh'		),
                    ('Nguyen Van Chien'		),
                    ('Duong Do'				),
                    ('Nguyen Chien Thang'	),
                    ('Ngo Ba Kha'			),
                    ('Bui Xuan Huan'		),
                    ('Nguyen Thanh Tung'	),
                    ('Duong Van Huu'		),
                    ('Vi Ti Ai'				);
                    
-- Add data Group
INSERT INTO `Group`	(`name`				, amountMember	, CreatorID		,createTime)
VALUES 				('Testing System'	,   100		,   5			,'2020-03-05'),
					('Developement'		,   155		,   1			,'2020-03-07'),
                    ('VTI Sale 02'		,   50		,   2			,'2020-09-09'),
                    ('VTI Sale 02'		,   49		,   5			,'2020-05-10'),
                    ('VTI Sale 03'		,   101		,   1			,'2020-03-28'),
                    ('VTI Creator'		,   50		,   6			,'2020-04-06'),
                    ('VTI Marketing 01'	,   47		,   1			,'2020-07-07'),
                    ('Management'		,   101		,   8			,'2020-04-08'),
                    ('VTI Sale 03'		,   99		,   10			,'2020-08-09'),
                    ('Vi Ti Ai'			,   101		,   10			,'2020-04-10');
                    
INSERT INTO `GroupAccount`	(  GroupID	, AccountID	, JoinDate	 )
VALUES 						(	1		,    1		,'2019-03-05'),
							(	1		,    2		,'2020-03-07'),
							(	3		,    3		,'2020-03-09'),
							(	3		,    4		,'2020-03-10'),
							(	5		,    5		,'2020-03-28'),
							(	1		,    3		,'2020-04-06'),
							(	1		,    7		,'2020-04-07'),
							(	8		,    3		,'2020-04-08'),
							(	1		,    9		,'2020-04-09'),
							(	10		,    10		,'2020-04-10');

