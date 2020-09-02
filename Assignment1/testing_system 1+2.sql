
DROP DATABASE IF EXISTS Testing_System_Assignment_1;
create database Testing_System_Assignment_1;
Use	Testing_System_Assignment_1;

-- create table: Department	
Create Table Department (
DepartmentID	tinyint unsigned primary key,
DepartmentName	varchar (50) not null
);

-- create table: Position	
Create table Position (
PositionID		tinyint unsigned primary key,
PositionName	Enum ('Dev', 'Test', 'Scrum Master', 'PM') not null
),

-- create table: Account
Create Table `Account` (
AccountID		tinyint unsigned primary key,
Email			varchar (50) not ,
Username		varchar (50) not null,
Fullname		varchar (50) not null,
DepartmentID	tinyint unsigned,
PositionID		tinyint unsigned,
CreateDate		Date,
Foreign key	(DepartmentID) references Department (DepartmentID),
Foreign key	(PositionID) references Position (PositionID)
);

-- create table: Group
Create Table `Group` (
GroupID			tinyint unsigned primary key,
GroupName		varchar (50) not null,
CreatorID		tinyint unsigned,
CreateDate		Date
);

-- create table: GroupAccount
Create Table GroupAccount (
GroupID			tinyint unsigned primary key,
AccountID		tinyint unsigned,
CreateDate		Date,
primary key (GroupID, AccountID),
Foreign key	(GroupID) references `Group` (GroupID),
Foreign key	(AccountID) references `Account` (AccountID)
);

-- create table: TypeQuestion
Create Table TypeQuestion (
TypeID			tinyint unsigned primary key,
TypeName		enum ('Essay', 'Multiple-Choice') not null
);

-- create table: CategoryQuestion
Create Table CategoryQuestion (
CategoryID		tinyint unsigned primary key,
CategoryName	varchar (50) not null
);

-- create table: Question
Create Table Question (
QuestionID		tinyint unsigned primary key,
Content			varchar (50),
CategoryID		varchar (50),
TypeID			tinyint unsigned,
CreatorID		Smallint unsigned,
CreateDate		Date,
Foreign key	(CategoryID) references CategoryQuestion (CategoryID)
);

-- create table: Answer
Create Table Answer (
AnswerID		tinyint unsigned primary key,
Content			tinyint unsigned,
Title			varchar (50),
CategoryID		tinyint unsigned,
Duration		datetime,
CreatorID		tinyint unsigned,
CreateDate		Date
);

-- create table: Exam
Create Table Exam (
ExamID			tinyint unsigned primary key,
`Code`			Char (20),
Title			varchar (50),
CategoryID		tinyint unsigned,
Duration		datetime,
CreatorID		tinyint unsigned,
CreateDate		Date
);

-- create table: ExamQuestion
Create Table ExamQuestion (
ExamID			tinyint unsigned,
QuestionID		tinyint unsigned,
primary key (ExamID, QuestionID),
Foreign key	(ExamID) references ExamQuestion (ExamID)
);