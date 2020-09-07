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