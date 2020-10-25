USE	Final_Exam_JavaCORE;
-- Add data Manager
-- INSERT INTO Manager		(FullName			, Email					, `Password`	, `Role`) 
-- VALUES					('Ninh Thi Hien'	,'hienninh@gmail.com'	,'12312a'		,'Manager'),
-- 						('Hoang Minh Hanh'	,'minhhanh12@gmail.com'	,'1289'			,'Manager'),
-- 						('Le Duong'			,'Duong@gmail.com'		,'22278bn'		,'Manager'),
-- 						('Le Bao Han'		,'han@gmail.com'		,'m56'			,'Manager'),
-- 						('Nguyen Bich Ngoc'	,'bichngoc@gmail.com'	,'67hn'			,'Manager'),
--                         ('Ninh Thi Hien'	,'hienninh@gmail.com'	,'12312a'		,'Employee'),
--                         ('Hoang Minh Hanh'	,'minhhanh12@gmail.com'	,'1289'			,'Employee'),
--                         ('Le Duong'			,'Duong@gmail.com'		,'22278bn'		,'Employee'),
--                         ('Le Bao Han'		,'han@gmail.com'		,'m56'			,'Employee'),
--                         ('Nguyen Bich Ngoc'	,'bichngoc@gmail.com'	,'67hn'			,'Employee');
--                         
-- Add data Manager
INSERT INTO Manager		(FullName			, Email					, `Password`	,ExpInYear) 
VALUES					('Ninh Thi Hien'	,'hienninh@gmail.com'	,'12312a'		,5		),
						('Hoang Minh Hanh'	,'minhhanh12@gmail.com'	,'1289'			,2		),
						('Le Duong'			,'Duong@gmail.com'		,'22278bn'		,1		),
						('Le Bao Han'		,'han@gmail.com'		,'m56'			,2		),
						('Nguyen Bich Ngoc'	,'bichngoc@gmail.com'	,'67hn'			,3		);
                        
-- Add data Employee
INSERT INTO Employee	(FullName			, Email					, `Password`	,projectId	,ProSkill) 
VALUES					('Minh Thi Hien'	,'hienninh@gmail.com'	,'12312a'		,5			,'sql'),
						('Hoang Le Ha'		,'12@gmail.com'			,'12'			,2			,'dev'),
						('Mai Du'			,'Du@gmail.com'			,'x278bn'		,1			,'java'),
						('Le Bao Han'		,'han1@gmail.com'		,'l56'			,2			,'dev'),
						('Nguyen Bich Nga'	,'nga@gmail.com'		,'x7hn'			,1			,'sql1');
                        
-- Add data Project
INSERT INTO Project		(teamSizes	, idManager	, idEmployees) 
VALUES					(50			,1			,2			),
						(37			,5			,5			),
						(51			,2			,3			),
						(11			,4			,1			),
						(23			,4			,2			);