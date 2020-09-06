
-- Extra Assignment 3_VN
-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào,nhóm chúng thành các tháng sinh khác nhau

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau:tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT *
From `account`
WHERE LENGTH(Full_name) = (SELECT Max(LENGTH(Full_name)) From `account`);
