import java.time.LocalDate;

public class Test_2 {

	public static void main(String[] args) {
		// Logic
		// Create Department
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "sale";

		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketting";

		Department department3 = new Department();
		department3.id = 3;
		department3.name = "purchasing";

		// Create Group
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "c#";

		Group group2 = new Group();
		group2.id = 1;
		group2.name = "Java Basic";

		Group group3 = new Group();
		group3.id = 1;
		group3.name = "Java Import";

		// Create Position
		Position position1 = new Position();
		position1.id = 1;
		position1.name = PositionName.DEV;

		Position position2 = new Position();
		position2.id = 2;
		position2.name = PositionName.TEST;

		Position position3 = new Position();
		position3.id = 3;
		position3.name = PositionName.TEST;

		// Create Account
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "Nguyenminh@gmail.com";
		account1.userName = "Nguyenminh";
		account1.fullName = "Nguyen Van Minh";
		account1.department = department2;
		account1.position = position1;

		Account account2 = new Account();
		account2.id = 2;
		account2.email = "tranle@gmail.com";
		account2.userName = "tranle";
		account2.fullName = "Tran Le Anh";
		account2.department = department2;
		account2.position = position2;

		Account account3 = new Account();
		account3.id = 3;
		account3.email = "Lean@gmail.com";
		account3.userName = "Lean";
		account3.fullName = "Le Hoai AN";
		account3.department = department1; // lay thong tin tu bang Department
		account3.position = position1;
		account3.cearteDate = LocalDate.of(2019, 12, 01);

		// Create GroupAccount
		GroupAccount groupAccount1 = new GroupAccount();
		groupAccount1.group = group1; // lay thong tin tu bang Group
		groupAccount1.account = account1;
		groupAccount1.joinDate = LocalDate.of(2019, 11, 01);

		GroupAccount groupAccount2 = new GroupAccount();
		groupAccount2.group = group2;
		groupAccount2.account = account1;
		groupAccount2.joinDate = LocalDate.of(2019, 10, 01);

		GroupAccount groupAccount3 = new GroupAccount();
		groupAccount3.group = group3;
		groupAccount3.account = account2;
		groupAccount3.joinDate = LocalDate.of(2019, 11, 01);

		// lay tat ca Group thuoc Account1, lay ca joinDate
		GroupAccount[] GroupAccount1 = { groupAccount1, groupAccount2 };
		account1.groupAccounts = GroupAccount1;

		// lay tat ca Group thuoc Account2, lay ca joinDate
		GroupAccount[] GroupAccount2 = { groupAccount1, groupAccount3 };
		account2.groupAccounts = GroupAccount2;

		// lay cac account thuoc Department1
		Account[] accountOfDeapartment1 = { account1, account2, account3 };
		department1.accounts = accountOfDeapartment1;
		
		Account[] accountOfDeapartment2 = { account1, account3 };
		department2.accounts = accountOfDeapartment2;

		// Create TypeQuestion
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.id = 1;
		typeQuestion1.name = TypeQuestionName.ESSAY;

		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.id = 2;
		typeQuestion2.name = TypeQuestionName.ESSAY;

		TypeQuestion typeQuestion3 = new TypeQuestion();
		typeQuestion3.id = 3;
		typeQuestion3.name = TypeQuestionName.MULTIPLE_CHOICE;

		// Create CategoryQuestion
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.id = 1;
		categoryQuestion1.name = "SQL";

		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.id = 1;
		categoryQuestion2.name = "SQL2";

		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.id = 3;
		categoryQuestion3.name = "SQL3";

		// Create Question
		Question question1 = new Question();
		question1.id = 1;
		question1.content = "SLQ la gi";
		question1.category = categoryQuestion1;
		question1.type = typeQuestion2;
		question1.creator = account3;


		Question question2 = new Question();
		question2.id = 2;
		question2.content = "C# la gi";
		question2.category = categoryQuestion1;
		question2.type = typeQuestion1;
		question2.creator = account2;


		Question question3 = new Question();
		question3.id = 3;
		question3.content = "Lam the nao de code tot";
		question3.category = categoryQuestion3;
		question3.type = typeQuestion1;
		question3.creator = account2;


		// Create Answer
		Answer Answer1 = new Answer();
		Answer1.id = 1;
		Answer1.content = "lam bai tap day du";
		Question[] QuestionOfAnswer1 = { question3, question1 };
		Answer1.questions = QuestionOfAnswer1; // So question trong bang Answer

		Answer Answer2 = new Answer();
		Answer2.id = 2;
		Answer2.content = "Di hoc tap day du";
		Question[] QuestionOfAnswer2 = { question1, question2 };
		Answer2.questions = QuestionOfAnswer2; // So question trong bang Answer

		Answer Answer3 = new Answer();
		Answer3.id = 3;
		Answer3.content = "Thi cuoi ky";
		Question[] QuestionOfAnswer3 = { question1, question2 };
		Answer3.questions = QuestionOfAnswer3; // So question trong bang Answer

		// Create Exam
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "EXAM1";
		exam1.category = categoryQuestion1;
		exam1.duration = Duration.MINUTE_15;
		exam1.creator = account1;
		Question[] questionOfExam1 = { question1, question2, question3 };
		exam1.questions = questionOfExam1;

		Exam exam2 = new Exam();
		exam2.id = 2;
		exam2.code = "EXAM2";
		exam2.category = categoryQuestion3;
		exam2.duration = Duration.MINUTE_15;
		exam2.creator = account3;
		Question[] questionOfExam2 = { question1, question3 };
		exam2.questions = questionOfExam2;

		Exam exam3 = new Exam();
		exam3.id = 3;
		exam3.code = "EXAM10";
		exam3.category = categoryQuestion1;
		exam3.duration = Duration.MINUTE_15;
		exam3.creator = account2;
		Question[] questionOfExam3 = { question1, question2, question3 };
		exam3.questions = questionOfExam3;



	}

}
