
DROP DATABASE IF EXISTS Extra_Assignment_6;
CREATE DATABASE Extra_Assignment_6;
USE	Extra_Assignment_6;
-- Create TABLE: Employee
DROP DATABASE IF EXISTS Employee;
CREATE	TABLE Employee (
Employee_ID				TINYINT	UNSIGNED PRIMARY KEY AUTO_INCREMENT, 
Employee_LastName		VARCHAR (50),
Employee_FirstName		VARCHAR (50),
Employee_Hire_Date		DATE DEFAULT(current_date),
Employee_Status			NVARCHAR (100),
Supervisor_ID			TINYINT	UNSIGNED,
SocialSecurity_Number	TINYINT	UNSIGNED
-- FOREIGN KEY	(Supervisor_ID) REFERENCES Employee (Employee_ID)
);

-- Create TABLE: Projects
DROP DATABASE IF EXISTS Projects;
CREATE	TABLE Projects (
Project_ID				TINYINT	UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Manager_ID				TINYINT	UNSIGNED,
Project_Name			VARCHAR (50),
Project_Sart_Date		DATE DEFAULT(current_date),
Project_Description		NVARCHAR (100),
Project_Detailt			NVARCHAR (100),
Project_Completed_On	DATETIME DEFAULT NOW()
-- FOREIGN KEY	(Manager_ID) REFERENCES Employee (Employee_ID)
);

-- Create TABLE: Project_Modules
DROP DATABASE IF EXISTS Project_Modules;
CREATE	TABLE Project_Modules (
Module_ID						TINYINT	UNSIGNED NOT NULL,
Project_ID						TINYINT	UNSIGNED NOT NULL,
Employee_ID						TINYINT	UNSIGNED,
Project_Modules_Date			DATE,
Project_Modules_Completed_On	DATETIME DEFAULT NOW(),
Project_Modules_Description		NVARCHAR (200) NOT NULL,
PRIMARY KEY (Module_ID, Project_ID),
FOREIGN KEY	(Project_ID) REFERENCES Projects (Project_ID),
FOREIGN KEY	(Employee_ID) REFERENCES Employee (Employee_ID)
);

-- Create TABLE: Work_Done
DROP DATABASE IF EXISTS Work_Done;
CREATE	TABLE Work_Done (
WorkDone_ID				TINYINT	UNSIGNED PRIMARY KEY AUTO_INCREMENT,
Employee_ID				TINYINT	UNSIGNED NOT NULL,
Module_ID				TINYINT	UNSIGNED,
WorkDone_Date			DATE DEFAULT(current_date),
WorkDone_Description	NVARCHAR (100),
WorkDone_Status			NVARCHAR (50),
FOREIGN KEY	(Employee_ID) REFERENCES Employee (Employee_ID)
);






