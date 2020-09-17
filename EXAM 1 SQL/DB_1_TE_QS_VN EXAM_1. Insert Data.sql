-- INSERT DATA
USE	Testing_Exam_1;
--  Add data Customer
INSERT INTO Customer	(CustomerName			, PhoneNumber		,Email					,Address		,Note				)
VALUES 					('Hoang Trong Hieu'		,'0936538794'       ,'hoanghieu@gmail.com'	,'Thai Binh'	,'Khach hang tiem nang'),
						('Nguyen Cam Nhung'		,'0966538944'		,'camnhung1@gmail.com'	,'Nam Dinh'		,'Da tu van 1 lan'),
                        ('Hoang Thu Thao'		,'0363578444'		,'hoangthao@yahoo.com'	,'Ha Noi'		,'Giam doc cong ty VTI'),
                        ('Le Manh Hung'         ,'0996176855'       ,'Hung87@gmail.com'     ,'Ha Noi'       ,'Chu doanh nghiep Bat dong san'),
                        ('Tran Binh Minh'		,'0969735123'		,'KHONG CO MAIL'		,'Hung Yen'		,'Da dat coc');			
                                                                    
--  Add data Car
INSERT INTO Car	(CarID		, Maker		,Model			,`Year`			,Car_Color		,Note				)
VALUES 			(012		,'HONDA'    ,'KIA Morning'	,'1996'			,'Blue'			,'Chuan hang nhap khau'),
				(034		,'TOYOTA'	,'Matda 2'		,'2005'			,'Blank'		,'New 99%'),
                (205        ,'HONDA'	,'KIA 3'		,'2010'			,'Blue'			,'Da co khach dat'),
                (222        ,'NISSAN'	,'Vession2'		,'2010'			,'RED'			,'Hang moi ve'),
                (201        ,'TOYOTA'	,'TOYOTA 2'		,'2012'			,'Blank'		,'Con thoi gian bao hanh');
                
--  Add data Car_Oder
INSERT INTO Car_Oder	(CustomerID	, CarID		,Amount			,SalePrice	 ,OrderDate		,DeliveryDate	, DeliveryAddress	,`Status` , Note	)
VALUES 					(1			,034    	,2				,'1200'		 ,'2019-10-09'  ,'2020-01-10'	,'Thai Binh'		,'1'	  ,'Xe chay tot'),
                        (2          ,201        ,2              ,'1500'      ,'2020-02-03'  ,'2020-02-15'   ,'Ha Noi'           ,'1'      ,'Moi qua bao hanh'),
                        (4          ,222        ,1              ,'2300'      ,'2020-07-13'  ,'2020-09-10'   ,'Ha Noi'           ,'0'      ,'da thanh toan 75%'),
                        (1          ,222        ,1              ,'2300'      ,'2020-06-15'  ,'2020-08-05'   ,'Thai Binh'        ,'0'      ,'thanh toan tra gop BIDV'),
                        (5          ,205        ,1              ,'3000'      ,'2018-10-15'  ,NULL   		,'Ha Noi'           ,'2'      ,'xe van chay tot');