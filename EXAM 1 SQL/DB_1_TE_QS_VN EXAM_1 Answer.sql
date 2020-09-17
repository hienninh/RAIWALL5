/*-- Requirement 1--*/
/*-- Questions --*/
USE	Testing_Exam_1;
-- 2. Viết lệnh lấy ra thông tin của khách hàng: tên, số lượng oto khách hàng đã mua và sắp sếp tăng dần theo số lượng oto đã mua.
SELECT C.CustomerID, C.CustomerName, CO.Amount, CO.CarID 
FROM	Car_oder CO
JOIN	Customer C ON CO.CustomerID = C.CustomerID
ORDER BY	Amount ASC;

-- 3. Viết hàm (không có parameter) trả về tên hãng sản xuất đã bán được nhiều oto nhất trong năm nay.
DROP PROCEDURE IF EXISTS Max_car_of_2020;
DELIMITER $$
CREATE PROCEDURE Max_car_of_2020 ()
BEGIN
WITH Amount_Car_of_2020 AS
(SELECT 	CA.Maker, Group_Concat(CA.Model), Count(CO.Amount) AS So_luong, Group_Concat(CO.OrderDate)
FROM	Car_oder CO
JOIN	Car CA ON CO.CarID = CA.CarID
WHERE	Year(OrderDate) = Year(NOW()))

SELECT 	* 
FROM 	Amount_Car_of_2020
WHERE	So_luong = (SELECT Max(So_luong) FROM	Amount_Car_of_2020);
END$$
DELIMITER ;
Call Max_car_of_2020();
-- 4. Viết 1 thủ tục (không có parameter) để xóa các đơn hàng đã bị hủy của những năm trước. In ra số lượng bản ghi đã bị xóa.
DROP PROCEDURE IF EXISTS Delete_Satus_2;
DELIMITER $$
CREATE PROCEDURE Delete_Satus_2 ()
BEGIN
DELETE
FROM	Car_oder
WHERE	`Status` = '2';
END$$
DELIMITER ;
Call Delete_Satus_2();

-- 5. Viết 1 thủ tục (có CustomerID parameter) để in ra thông tin của các đơn hàng đã đặt hàng bao gồm: 
-- tên của khách hàng, mã đơn hàng, số lượng oto và tên hãng sản xuất.
DROP PROCEDURE IF EXISTS Car_of_Customer;
DELIMITER $$
CREATE PROCEDURE Car_of_Customer (IN In_CustomerID TINYINT UNSIGNED)
BEGIN
SELECT CO.CustomerID, C.CustomerName, CO.OrderID, CO.Amount, CA.Maker
FROM	Car_oder CO 
JOIN	customer C ON	CO.CustomerID = C.CustomerID
JOIN	car CA ON CO.CarID = CA.CarID
WHERE	CO.CustomerID = In_CustomerID;
END$$
DELIMITER ;
Call Car_of_Customer(1);

-- 6. Viết trigger để tránh trường hợp người dung nhập thông tin không hợp lệ vào database (DeliveryDate < OrderDate + 15).
DROP PROCEDURE IF EXISTS DeliveryDate_less_OderDate;
DELIMITER $$
CREATE TRIGGER DeliveryDate_less_OderDate
BEFORE	INSERT ON  Car_oder
FOR EACH ROW
-- DECLARE

BEGIN

DECLARE		DeliveryDate_IN DATETIME;
DECLARE		OrderDate_IN	DATETIME;
-- get DeliveryDate and OrderDate inserted recent 
SELECT	DeliveryDate, OrderDate INTO @DeliveryDate_IN, @OrderDate_IN
FROM	Car_oder;
-- Logic: If DeliveryDate < OrderDate + 15 then ROLLBACK
IF 	DeliveryDate_IN < DATE_ADD(OrderDate_IN, INTERVAL 15 DAY) THEN
SIGNAL SQLSTATE '12345' -- khong cho phep insert vao bang
SET MESSAGE_TEXT = 'Field DeliveryDate must more than 15 day OrderDate_IN';
END IF;
END$$
DELIMITER ;

INSERT INTO Car_Oder	( CarID		,Amount			,SalePrice	 ,OrderDate		,DeliveryDate	, DeliveryAddress	,`Status` , Note	)
VALUES 					(034    	,1				,'1200'		 ,'2020-10-09'  ,'2020-09-10'	,'Thai Binh'		,'1'	  ,'Xe chay tot');