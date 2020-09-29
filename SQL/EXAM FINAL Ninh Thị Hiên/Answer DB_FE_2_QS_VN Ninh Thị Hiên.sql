USE	Final_Exam_2;
-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
SELECT 		SV.SinhVien_ID, SV.SinhVien_NAME, HD.DeTai_ID
FROM		Sinhvien SV
LEFT JOIN	Huongdan HD ON HD.SinhVien_ID = SV.SinhVien_ID
WHERE		HD.HuongDan_ID IS NULL;

-- b) Lấy ra số sinh viên theo đề tài ‘Sinh Hoc phan tu’
SELECT 		DT.DeTai_NAME, Count(HD.SinhVien_ID), GROUP_CONCAT(SV.SinhVien_NAME)
FROM		 Huongdan HD
JOIN		 Sinhvien SV ON HD.SinhVien_ID = SV.SinhVien_ID
JOIN		 detai DT ON HD.DeTai_ID = DT.DeTai_ID
WHERE		 DT.DeTai_NAME = 'Sinh Hoc phan tu';

-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS 
SELECT 		SV.SinhVien_ID, SV.SinhVien_NAME, HD.DeTai_ID
FROM		Huongdan HD
RIGHT JOIN	Sinhvien SV ON HD.SinhVien_ID = SV.SinhVien_ID;
SELECT		*
FROM		SinhVienInfo J
LEFT JOIN	detai DT ON	J.DeTai_ID = DT.DeTai_ID;
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS SinhVienInfo_update;
CREATE	VIEW SinhVienInfo_update AS
SELECT		J.SinhVien_ID, J.DeTai_ID, DT.DeTai_NAME 
FROM		SinhVienInfo J
LEFT JOIN	detai DT ON	J.DeTai_ID = DT.DeTai_ID;

SELECT *,
CASE
WHEN Department_name is Null THEN 'Chua co'
ELSE Department_name
END AS phan_loai
FROM SinhVienInfo_update;

UPDATE	SinhVienInfo_update
SET		DeTai_NAME = 'Chua co'
WHERE	DeTai_NAME IS NULL; 


-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS	Trigger_Namsinh_1900;
DELIMITER $$
CREATE	TRIGGER Trigger_Namsinh_1900
BEFORE	INSERT ON Sinhvien
FOR EACH ROW
BEGIN	

IF NEW.Namsinh <= '1900' THEN
	SIGNAL SQLSTATE '12345'
	SET MESSAGE_TEXT = 'Field Namsinh > 1900';

END IF;
END$$
DELIMITER ;

INSERT INTO SinhVien	(SinhVien_ID,SinhVien_NAME		,Namsinh	, Quequan)
VALUES 					(15			,'Nguyen Van T'		,1800		,'Nam Dinh'	);
SELECT * FROM Sinhvien;

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ xóa tất cả thôn tin trong table HuongDan liên quan tới sinh viên đó
DROP TRIGGER IF EXISTS	Trigger_Delete_Sinhvien;
DELIMITER $$
CREATE	TRIGGER Trigger_Delete_Sinhvien
BEFORE	DELETE ON Sinhvien
FOR EACH ROW
BEGIN	
DELETE
FROM	HuongDan
WHERE 	SinhVien_ID = OLD.SinhVien_ID;
END$$
DELIMITER ;
DELETE
FROM	HuongDan
WHERE	SinhVien_ID = 1;
DELETE
FROM 	Sinhvien
WHERE	SinhVien_ID = 1;
SELECT * FROM Sinhvien;