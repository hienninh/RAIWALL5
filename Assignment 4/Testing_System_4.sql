-- G:\My Drive\EPD_03\SQL_Document\Assignment\Testing System\Testing_System_4

-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT 	A.Department_ID, Full_Name, DEPARTMENT_NAME
FROM 	`Account` A
JOIN	Department D ON	A.Department_ID = D.Department_ID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2019
SELECT 	ACCOUNT_ID, USER_NAME, CREATE_DATE
FROM 		`Account`
Where		CREATE_DATE> '2019-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT	A.POSITION_ID, POSITION_NAME, FULL_NAME
FROM	Position P
JOIN	`Account` A	ON	A.Position_ID = P.Position_ID
WHERE	POSITION_NAME = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >=3 nhân viên

SELECT		A.DEPARTMENT_ID, Department_Name,Group_concat(USER_NAME)
FROM		`Account` A
JOIN		Department D ON	A.Department_ID = D.Department_ID
Group by	A.DEPARTMENT_ID
Having		COUNT(account_ID) >=3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT		EQ.QUESTION_ID
FROM		Examquestion EQ
LEFT JOIN	question Q ON	EQ.question_ID = Q.QUESTION_ID
GROUP BY	EQ.question_ID
HAVING		count(EQ.exam_ID) = (SELECT	Max(So_luong_Exam)	
								From (SELECT Count(EQ.Exam_ID) AS So_luong_Exam
										FROM	Examquestion EQ
										LEFT JOIN	question Q ON	EQ.question_ID = Q.QUESTION_ID
										GROUP BY	EQ.Question_ID) As Max_Exam);

-- Hoac
SELECT 		Q.Question_ID -- , COUNT(EQ.ExamID), GROUP_CONCAT(EQ.ExamID)
FROM 		Question Q
Right JOIN	examquestion EQ ON EQ.Question_ID = Q.Question_ID
GROUP BY	Q.Question_ID
HAVING 		COUNT(EQ.Exam_ID) = (SELECT Max(So_Luong_Exam) 
								FROM ( SELECT 		COUNT(EQ.Exam_ID) AS So_Luong_Exam
										FROM 		Question Q
										LEFT JOIN	examquestion EQ ON EQ.Question_ID = Q.Question_ID
										GROUP BY	Q.Question_ID) AS statistic_Question_Exam);
                                        
-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT		*, COUNT(Q.Question_ID)
FROM		Question Q
-- JOIN		categoryquestion CQ ON	CQ.CATEGORY_ID	=	Q.CATEGORY_ID
GROUP BY	Q.CATEGORY_ID;

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT		QUESTION_ID,`CODE`,Group_concat(EQ.exam_ID), Count(EQ.exam_ID)
FROM		examquestion EQ
JOIN		exam E ON	EQ.exam_ID	=	E.exam_ID
GROUP BY	EQ.QUESTION_ID;

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT		AN.Question_ID, GROUP_CONCAT(AN.Answer_ID), count(AN.Answer_ID) AS So_luong_Answer
FROM		Answer AN
LEFT JOIN	question Q ON	AN.question_ID	=	Q.question_ID
GROUP BY	AN.QUESTION_ID
HAVING		COUNT(AN.Answer_ID) = (SELECT Max(So_luong_Answer) 
From 
(SELECT		count(AN.Answer_ID) AS So_luong_Answer
FROM		Answer AN
LEFT JOIN	question Q ON	AN.question_ID	=	Q.question_ID
GROUP BY	AN.QUESTION_ID) AS SL_Answer_Max);

SELECT		count(AN.Answer_ID) AS So_luong_Answer
FROM		Answer AN
LEFT JOIN	question Q ON	AN.question_ID	=	Q.question_ID
GROUP BY	AN.QUESTION_ID;

-- Question 9: Thống kê số lượng account trong mỗi group 
SELECT		GA.GROUP_ID, GROUP_CONCAT(ACCOUNT_ID), COUNT(ACCOUNT_ID) 
FROM		groupaccount GA
LEFT JOIN	`group` G ON	GA.GROUP_ID	=	G.GROUP_ID
GROUP BY	GA.GROUP_ID;

-- Question 10: Tìm chức vụ có ít người nhất
SELECT		P.POSITION_ID, P.POSITION_NAME, Count(ACCOUNT_ID), Group_concat(A.USER_NAME)
FROM		`Account` A
JOIN	Position P ON	A.POSITION_ID	=	P.POSITION_ID
GROUP BY	P.POSITION_ID
HAVING		COUNT(A.ACCOUNT_ID) = (SELECT MIN(So_luong_Account) 
From 
(SELECT		count(A.ACCOUNT_ID) AS So_luong_Account
FROM		`Account` A
JOIN	Position P ON	A.POSITION_ID	=	P.POSITION_ID
GROUP BY	P.POSITION_ID) AS SL_Account_Min);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM ( CHUA XONG)
--  Cross Join
SELECT		* -- POSITION_NAME, GROUP_CONCAT (A.FULL_NAME), count(A.ACCOUNT_ID)
FROM		`Account` A
JOIN		Position P ON	A.POSITION_ID	=	P.POSITION_ID
JOIN		Department D ON	A.Department_ID	=	D.Department_ID
Group By	P.POSITION_NAME;
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm:
-- thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi
SELECT		* -- TQ.TYPE_ID, Q.QUESTION_ID, Q.CONTENT, A.ACCOUNT_ID, A.FULL_NAME, 
FROM		Question Q
JOIN		Typequestion TQ ON	Q.TYPE_ID	=	TQ.TYPE_ID
RIGHT JOIN	`Account` A ON	A.ACCOUNT_ID	=	Q.CREATOR_ID;

-- câu trả lời là gì
SELECT		*
FROM		Answer AN
-- LEFT JOIN Question Q ON	AN.QUESTION_ID	=	Q.QUESTION_ID
GROUP BY	AN.QUESTION_ID;
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm ( su dung left join hoac right join)
SELECT		Q.TYPE_ID, CONTENT, count(Q.QUESTION_ID), GROUP_CONCAT(Q.QUESTION_ID)
FROM		Question Q
-- JOIN	Typequestion T ON	Q.TYPE_ID	=	T.TYPE_ID
GROUP BY	Q.TYPE_ID;

-- Question 14:Lấy ra group không có account nào
SELECT			*
From			GroupAccount GA
Right JOIN  	`Group` G ON GA.GROUP_ID = G.GROUP_ID
WHERE			GA.GROUP_ID is Null;

-- Question 16: Lấy ra question không có answer nào
SELECT			*
From			Answer AN  
Right JOIN  	Question Q ON AN.Question_ID = Q.Question_ID
WHERE			AN.Answer_ID is Null;

-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
-- b) Lấy các account thuộc nhóm thứ 2
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT	GA.GROUP_ID, A.ACCOUNT_ID, EMAIL, USER_NAME
From	Groupaccount GA
JOIN	`account` A	ON	GA.account_ID = A.account_ID
WHERE	GA.Group_ID = 1
UNION
SELECT	GA.GROUP_ID, A.ACCOUNT_ID, EMAIL, USER_NAME
From	GroupAccount GA
JOIN	`account` A ON	GA.account_ID = A.account_ID
WHERE	GA.Group_ID=2;

-- Question 18
-- a) Lấy các group có lớn hơn 5 thành viên
-- b) Lấy các group có nhỏ hơn 7 thành viên
-- c) Ghép 2 kết quả từ câu a) và câu b)

(SELECT		GA.GROUP_ID, USER_NAME, EMAIL, count(A.ACCOUNT_ID)
From		GroupAccount GA
JOIN		`account` A ON	GA.account_ID = A.account_ID
GROUP BY	GA.GROUP_ID
HAVING		count(A.ACCOUNT_ID) > 5)
UNION
(SELECT		GA.GROUP_ID, USER_NAME, EMAIL, count(A.ACCOUNT_ID)
From		GroupAccount GA
JOIN		`account` A ON	GA.account_ID = A.account_ID
GROUP BY	GA.GROUP_ID
HAVING		count(A.ACCOUNT_ID) < 7);