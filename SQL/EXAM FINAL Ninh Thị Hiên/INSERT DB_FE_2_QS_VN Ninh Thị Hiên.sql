
/*============================== INSERT DATABASE =======================================*/


-- Add data GiangVien
INSERT INTO GiangVien	(GiangVien_NAME		,Luong) 
VALUES 					('Nguyen Thi Tam'	,3000	),
						('Ta Ba Dung'		,5000	), 
						('Nguyen Hai Nam'	,7000	); 
						
-- Add data SinhVien
INSERT INTO SinhVien	(SinhVien_ID,SinhVien_NAME		,Namsinh, Quequan)
VALUES 					(1			,'Nguyen Van A'		,1996	,'Nam Dinh'	),
						(4		  	,'Tran Thi C'		,1996	,'Ha Noi'	),
						(5			,'Hoang Trong Hai'	,1997	,'Ha Noi'	);                      
-- Add data DeTai
INSERT INTO DeTai		(DeTai_ID	, DeTai_NAME			,Kinhphi		,NoiThucTap)
VALUES 					(10			,'Sinh Hoc phan tu'		,1000			,'Ha Noi' ),
						(20         , 'Cac loai hoa'		,2000			,'Son La' ),
						(40         , 'Di truyen'			,1000			,'Ha Noi'); 
		
 -- Add data HuongDan
INSERT INTO HuongDan	(HuongDan_ID	,SinhVien_ID	,DeTai_ID	, GiangVien_ID ,ketqua )
VALUES 					(5				,1				,20 		,1				,'Loai A'),
						(10				,4				,10 		,1				,'Loai B'),
						(30				,1				,20	        ,3              ,'Loai C'); 
						
  