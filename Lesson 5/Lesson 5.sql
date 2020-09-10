SELECT * FROM testing_system_assignment_1.question;

DROP VIEW IF EXISTS long_question_lenght;
CREATE VIEW long_question_lenght AS
SELECT	*
FROM	Question
WHERE	Length(CONTENT)>17;

SELECT	*
FROM	long_question_lenght

-- Subquery
-- question 1

