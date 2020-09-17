USE	Extra_Assignment_6;
-- b) Viết stored procedure (không có parameter) để Remove tất cả thông tin project đã hoàn thành sau 3 tháng kể từ ngày bat dau. 
-- In số lượng record đã remove từ các table liên quan trong khi removing (dùng lệnh print)
DROP PROCEDURE IF EXISTS Project_Done_3_Month;
DELIMITER $$
CREATE PROCEDURE Project_Done_3_Month ()
BEGIN	
Select *
FROM	Projects
Where	MONTH(Project_Completed_On) - MONTH(Project_Sart_Date) = 3 AND 
YEAR(Project_Completed_On) = YEAR(Project_Sart_Date);
END$$
DELIMITER ;
CALL Project_Done_3_Month ();
-- c) Viết stored procedure (có parameter) để in ra các module đang được thực hiện  -- chua dung
DROP PROCEDURE IF EXISTS	Modules_doing;
DELIMITER $$
CREATE	PROCEDURE	Modules_doing ()
BEGIN
SELECT 	*
FROM	Project_modules
WHERE	Project_Modules_Completed_On is NULL 
AND 	Project_Modules_Date > NOW();
END$$
DELIMITER ;
CALL Modules_doing ();

-- d) Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works)
SELECT 	*
FROM	Work_done