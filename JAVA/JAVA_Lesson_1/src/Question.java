import java.time.LocalDateTime;

public class Question {
	short id;
	String content;
	CategoryQuestion category;
	TypeQuestion type;
	Account creator;
	LocalDateTime createDate;
	Exam[] exams;
	Answer[] answers;
}
