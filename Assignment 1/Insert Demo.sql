
/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
USE	TESTING_SYSTEM_ASSIGNMENT_1;
-- Add data Department
INSERT INTO Department	(DEPARTMENT_NAME) 
VALUES					(N'Marketing'	),
						(N'Sale'		),
						(N'Bảo vệ'		),
						(N'Nhân sự'		),
						(N'Kỹ thuật'	),
						(N'Tài chính'	),
						(N'Phó giám đốc'),
						(N'Giám đốc'	),
						(N'Thư kí'		),
						(N'Bán hàng'	);
						
                        
-- Add data position     
INSERT INTO Position	(POSITION_NAME	)
VALUES 					('Dev'			),
						('Test'			),
						('Scrum Master'	),
                        ('PM'			);

-- Add data Account
INSERT INTO `Account`(Email								, USER_NAME			, FULL_NAME				, DEPARTMENT_ID	,POSITION_ID,CREATE_DATE)
VALUES 				('haidang29productions@gmail.com'	, 'dangblack'		,'Nguyen Hai Dang'		,5  			,1			,NULL),
					('account1@gmail.com'				, 'quanganh'		,'Tong Quang Anh'		,3  			,2			,'2019-10-20'),
                    ('account2@gmail.com'				, 'vanchien'		,'Nguyen Van Chien'		,2  			,3			,'2020-03-07'),
                    ('account3@gmail.com'				, 'cocoduongqua'	,'Duong Do'				,4  			,4			,'2020-03-08'),
                    ('account4@gmail.com'				, 'doccocaubai'		,'Nguyen Chien Thang'	,4  			,4			,'2020-03-10'),
                    ('dapphatchetngay@gmail.com'		, 'khabanh'			,'Ngo Ba Kha'			,6  			,3			,Null),
                    ('songcodaoly@gmail.com'			, 'huanhoahong'		,'Bui Xuan Huan'		,7  			,2			,'2020-04-05'),
                    ('sontungmtp@gmail.com'				, 'tungnui'			,'Nguyen Thanh Tung'	,3  			,1			,'2020-04-07'),
                    ('duongghuu@gmail.com'				, 'duongghuu'		,'Duong Van Huu'		,4  			,2			,'2020-04-07'),
                    ('vtiaccademy@gmail.com'			, 'vtiaccademy'		,'Vi Ti Ai'				,10 			,1			,'2020-04-09');

-- Add data Group
INSERT INTO `Group`	(  GROUP_NAME			,CREATOR_ID	,CREATE_DATE)
VALUES 				(N'Testing System'		,5			,'2019-03-05'),
					(N'Developement'		,1			,'2020-03-07'),
                    (N'VTI Sale 02'			,2			,'2020-03-09'),
                    (N'VTI Sale 02'			,4			,'2020-03-10'),
                    (N'VTI Sale 03'			,4			,'2020-03-28'),
                    (N'VTI Creator'			,5			,'2020-04-06'),
                    (N'VTI Marketing 01'	,7			,'2020-04-07'),
                    (N'Management'			,8			,'2020-04-08'),
                    (N'VTI Sale 03'			,9			,'2020-04-09'),
                    (N'Vi Ti Ai'			,10			,'2020-04-10');

-- Add data GroupAccount
INSERT INTO `GroupAccount`	(  Group_ID		,Account_ID	,CREATE_DATE	 )
VALUES 						(	1		   	,1			,'2019-03-05'),
							(	4		   	,2			,'2020-03-07'),
							(	1		   	,3			,'2020-03-09'),
							(	1		   	,4			,'2020-03-10'),
							(	5		   	,5			,'2020-03-28'),
							(	4		   	,3			,'2020-04-06'),
							(	1		   	,7			,'2020-04-07'),
							(	8		   	,3			,'2020-04-08'),
							(	1		   	,9			,'2020-04-09'),
							(	1		   	,10			,'2020-04-10');


-- Add data TypeQuestion
INSERT INTO TypeQuestion	(Type_Name			) 
VALUES 						('Essay'			), 
							('Multiple-Choice'	); 


-- Add data CategoryQuestion
INSERT INTO CategoryQuestion		(Category_Name	)
VALUES 								('Java'			),
									('ASP.NET'		),
									('ADO.NET'		),
									('SQL'			),
									('Postman'		),
									('Ruby'			),
									('Python'		),
									('C++'			),
									('C Sharp'		),
									('PHP'			);
													
-- Add data Question
INSERT INTO Question	(Content			, Category_ID	, Type_ID		, Creator_ID	,Create_Date )
VALUES 					(N'Câu hỏi về Java'	,	1		   	,'1'			,1		         ,'2020-04-05'),
						(N'Câu Hỏi về PHP'	,	9		   	,'2'			,2		         ,'2020-04-05'),
						(N'Hỏi về C#'		,	9		   	,'2'			,1		         ,'2020-04-06'),
						(N'Hỏi về Ruby'		,	6		   	,'1'			,3		         ,'2020-04-06'),
						(N'Hỏi về Postman'	,	1		   	,'1'			,1		         ,'2020-04-06'),
						(N'Hỏi về ADO.NET'	,	3		   	,'2'			,6		         ,'2020-04-06'),
						(N'Hỏi về ASP.NET'	,	2		   	,'1'			,7		         ,'2020-04-06'),
						(N'Hỏi về C++'		,	8		   	,'1'			,5		         ,'2020-04-07'),
						(N'Hỏi về SQL'		,	4		   	,'2'			,9		         ,'2020-04-07'),
						(N'Hỏi về Python'	,	7		   	,'1'			,5	         	 ,'2020-04-07');

-- Add data Answers
INSERT INTO Answer	(Content		,Question_ID	,isCorrect)
VALUES 				(N'Trả lời 01'	,1				,0		),
					(N'Trả lời 02'	,1				,1		),
                    (N'Trả lời 03'	,1				,0		),
                    (N'Trả lời 04'	,1				,1		),
                    (N'Trả lời 05'	,2				,1		),
                    (N'Trả lời 06'	,3				,1		),
                    (N'Trả lời 07'	,4				,0		),
                    (N'Trả lời 08'	,8				,0		),
                    (N'Trả lời 09'	,9				,1		),
                    (N'Trả lời 10'	,10				,1		);
	
-- Add data Exam
INSERT INTO Exam	(`Code`			, Title					,Category_ID	,Duration	,Creator_ID		,Create_Date )
VALUES 				('VTIQ001'		, N'Đề thi C#'			,1				,'90'			,5			,'2019-04-10'),
					('VTIQ002'		, N'Đề thi PHP'			,10				,'60'			,1			,'2019-04-05'),
                    ('VTIQ003'		, N'Đề thi C++'			,9				,'120'			,2			,'2019-04-07'),
                    ('VTIQ004'		, N'Đề thi Java'		,6				,'60'			,3			,'2020-04-08'),
                    ('VTIQ005'		, N'Đề thi Ruby'		,5				,'120'			,4			,'2020-04-10'),
                    ('VTIQ006'		, N'Đề thi Postman'		,3				,'60'			,6			,'2020-04-05'),
                    ('VTIQ007'		, N'Đề thi SQL'			,2				,'60'			,7			,'2020-04-05'),
                    ('VTIQ008'		, N'Đề thi Python'		,8				,'60'			,8			,'2020-04-07'),
                    ('VTIQ009'		, N'Đề thi ADO.NET'		,4				,'90'			,9			,'2020-04-07'),
                    ('VTIQ010'		, N'Đề thi ASP.NET'		,7				,'90'			,10			,'2020-04-08');
                    
                    
-- Add data ExamQuestion
INSERT INTO ExamQuestion(EXAM_ID	,QUESTION_ID) 
VALUES 					(1			,5	),
						(2			,10	), 
						(3			,4	), 
						(4			,3	), 
						(5			,7	), 
						(6			,10	), 
						(7			,2	), 
						(8			,10	), 
						(9			,9	), 
						(10			,8	); 
