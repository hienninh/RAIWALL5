import java.time.LocalDateTime;

public class Exam {
	byte id;
	String code;
	String title;
	CategoryQuestion category;
	Duration duration;
	Account creator;
	LocalDateTime createDate;
	Question[] questions;
}
