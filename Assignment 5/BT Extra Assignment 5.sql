/*=====================Extra Assignment 5======================*/

/*===================== Exercise 1: Subquery =====================*/
-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'.
DROP DATABASE IF EXISTS	adventureworks;
USE	adventureworks;
SELECT	P.`Name`
FROM	Product P
WHERE	P.ProductSubcategoryID IN (SELECT	ProductSubcategoryID
									FROM	Productsubcategory	PS
									WHERE	PS.`Name` = 'Saddles');
-- Su dung CTE
With ProductSubcategory_Name_Saddles AS
(SELECT	ProductSubcategoryID
FROM	Productsubcategory	PS
WHERE	PS.`Name` = 'Saddles')
SELECT	*
FROM	ProductSubcategory_Name_Saddles;

-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau
-- Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory chứa 'Bo'
-- Cach 1:
SELECT	P.`Name`
FROM	Product P
WHERE	P.ProductSubcategoryID IN (SELECT	ProductSubcategoryID
									FROM	Productsubcategory	PS
									WHERE	PS.`Name` Like '%Bo%');
-- Cach 2: Su dung Join

-- Question 3: Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và 
-- Touring Bike (nghĩa là ProductSubcategoryID = 3)
-- Cach 1: CTE
-- Cach 2: Subsquer
SELECT		* -- P.ListPrice, Count(P.ListPrice) ,P.ProductSubcategoryID, P.`Name` 
From		Product P
JOIN		Productsubcategory PS ON	PS.ProductSubcategoryID = P.ProductSubcategoryID
WHERE		PS.ProductSubcategoryID = 3 AND	P.ListPrice = (SELECT		MIN(ListPrice)
															From		Product P
															JOIN		Productsubcategory PS ON	PS.ProductSubcategoryID = P.ProductSubcategoryID
															WHERE		PS.ProductSubcategoryID = 3);
                                                            
 /*===================== Exercise 2: JOIN nhiều bảng =====================*/
-- Question 1: Viết query lấy danh sách tên country và province được lưu trong AdventureWorks2008sample database. 
SELECT	SP.CountryRegionCode, SP.`Name`, C.`Name`
FROM	Stateprovince SP 
JOIN	countryregion C	ON	SP.CountryRegionCode = C.CountryRegionCode;

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country: Germany và Canada
SELECT	SP.CountryRegionCode, SP.`Name`, C.`Name`
FROM	Stateprovince SP 
JOIN	countryregion C	ON	SP.CountryRegionCode = C.CountryRegionCode
HAVING	C.`Name`like '%Germany%' OR C.`Name`like '%Canada%';

-- Question 3: SalesOrderID, OrderDate and SalesPersonID. Từ bảng SalesPerson, chúng ta lấy cột
-- BusinessEntityID (là định danh của người sales), Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay)
CREATE VIEW	Join_salesorderheader_Salesperson AS
SELECT		SO.SalesOrderID, SO.OrderDate, SO.SalesPersonID, SP.Bonus, SP.SalesYTD
FROM		salesorderheader SO
JOIN		Salesperson SP	ON	SO.SalesPersonID = SP.SalesPersonID;

SELECT	*
FROM	Join_salesorderheader_Salesperson;
-- Question 4: Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID.
SELECT	SOP.SalesOrderID, SOP.OrderDate ,SOP.Bonus, SOP.SalesYTD, E.Title
FROM	Join_salesorderheader_Salesperson SOP
JOIN	Employee E ON	E.EmployeeID = SOP.SalesPersonID;



