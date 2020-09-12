
DROP DATABASE IF EXISTS Extra_Assignment_6;
CREATE DATABASE Extra_Assignment_6;
USE	Extra_Assignment_6;

-- Create TABLE: Project_Modules
CREATE	TABLE Project_Modules (
Module_ID					TINYINT	UNSIGNED Primary Key,
Project_ID					TINYINT	UNSIGNED NOT NULL,
Employee_ID					TINYINT	UNSIGNED,
Project_Modules_Date		DATE,
Project_Modules_CompledOn	DATETIME DEFAULT NOW(),
Project_Modules_Description	NVARCHAR (100)
);
