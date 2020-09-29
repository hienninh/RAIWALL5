/*=========================================== INSERT TABLE====================================================*/
USE	Extra_Assignment_6;
-- Add data  Employee
INSERT INTO Employee	(Employee_LastName	,Employee_FirstName	,Employee_Hire_Date ,Employee_Status 	,Supervisor_ID	,SocialSecurity_Number)
VALUES           		('Hoang'			,'Hieu'				,'2018-05-02'		,'PM'				,5				,3				),		
                        ('Nguyen'           ,'Quang'            ,'2018-08-10'       ,'DEP'              ,7              ,10             ),
                        ('Nguyen'           ,'My'               ,'2017-01-20'       ,'DEP'              ,5              ,6              ),
                        ('Ta'          		,'Nhung'            ,'2020-01-20'       ,'Test'             ,5              ,15             ),
                        ('Le'             	,'Binh'             ,'2020-01-15'       ,'Test'             ,7              ,1              );

-- Add data Projects  
INSERT INTO Projects	(Manager_ID	,Project_Name	,Project_Sart_Date  ,Project_Description 			,Project_Detailt	, Project_Completed_On)
VALUES               	(1			,'JAVA WEB 1'	,'2019-01-02'		,N'THiết kế Recod 1'			,N'JAVAR 3'			,'2019-05-20'),
                        (2          ,'MYSQL 1'      ,'2020-02-10'       ,N'Dạy thử bài 1'               ,N'Tạo bảng'        ,'2020-04-22'),
                        (5          ,'w3schools'    ,'2020-04-20'       ,N'Cách ứng dụng vào bài tập'   ,N'Tạo bảng online' ,'2020-07-18'),
                        (3          ,'MYSQL 2'      ,'2020-01-20'       ,N'Dạy thử bài 2'               ,N'Insert DATABASE' ,'2020-05-18'),
                        (7          ,'JAVA WEB 2'   ,'2019-04-28'       ,N'THiết kế Recod 2'            ,N'JAVAR Game'      ,'2020-07-20');

-- Add data Project_Modules
INSERT INTO Project_Modules	(Module_ID	,Project_ID ,Employee_ID	,Project_Modules_Date	,Project_Modules_Completed_On  ,Project_Modules_Description)
VALUES						(10			,1			,2				,'2019-10-15'			,'2019-10-10'				,N'Dự án công nghệ AI'),
                            (15         ,2          ,3              ,'2020-01-20'           ,'2019-12-20'               ,N'Tìm hiểu thông tin về MSQL'),
                            (20         ,1          ,1              ,'2020-12-15'           , NULL           			,N'Hoàn thiện dự thảo VTI'),
                            (23         ,3          ,3              ,'2020-05-15'           ,'2020-05-10'               ,N'Kế hoạch mở rộng thị trường tuyển sinh'),
                            (10         ,4          ,5              ,'2020-08-24'           , NULL               		,N'Làm thể nào để đảm bảo việc làm cho các học viên sau khi tốt nghiệp');

-- Add data Work_Done                         
INSERT INTO Work_Done	(Employee_ID	,Module_ID	,WorkDone_Date  ,WorkDone_Description					,WorkDone_Status)
VALUES                  (1          	,10			,'2019-01-20'	,N'Thuyết trình về MYSQL WorkBench'		,N'Đã hoàn thành'),
                        (2              ,20         ,'2020-01-22'   ,N'Quay lại tất cả record MYSQL'        ,N'Bổ sung thêm Record 1'), 
                        (2              ,15         ,'2020-04-18'   ,N'hoàn thiện bài tập MYSQL Server'     ,N'Chưa hoàn thành'),
                        (4              ,15         ,'2020-05-10'   ,N'Tuyển sinh đủ học viên'              ,N'Đã hoàn thành'),
                        (5              ,23         ,'2020-01-20'   ,N'Quay lại tất cả JAVA'                ,N'Bổ sung thêm Record 2');

