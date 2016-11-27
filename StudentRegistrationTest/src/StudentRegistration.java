import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistration {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		
		// Initialize students list
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student("Jeffrey Lomibao", "default"));
		students.add(new Student("Jessica Felipe", "default"));
		students.add(new Student("Sarah Theiss", "default"));
		students.add(new Student("Sonya Penkova", "default"));
		students.add(new Student("Vanessa Cerda", "default"));

		Student student;
		switch (loginUserSelection(inputScanner)) {
		case 1:
			student = studentCreateAccount(inputScanner, students);
			System.out.println(student);
			break;
		case 2:
			student = studentLogin(inputScanner, students);
			System.out.println(student);
			break;
		case 3:
			System.out.println("Exiting...");
		}
		
		printStudentsList(students);
		System.out.println("Good-bye!");
	}
	
	public static void printStudentsList(ArrayList<Student> students) {
		// print students
		System.out.println("\nStudents List");
		for(Student s : students) {
			System.out.println(s);
		}
	}
	
	// This method creates a new student account and adds it to the students list.
	public static Student studentCreateAccount(Scanner input, ArrayList<Student> students) {
		String userName;
		String password;
		System.out.println("Create Account");
		System.out.println("--------------");
		do {
			System.out.print("Enter User Name: ");
			userName = input.next();
		} while(userName.length() < 1);
		do {
			System.out.print("Enter Password: ");
			password = input.next();
		} while(password.length() < 1);
		Student student = new Student(userName, password);
		students.add(student);
		return student;
	}

	// This method allows students to log-in to their account.
	public static Student studentLogin(Scanner input, ArrayList<Student> students) {
		System.out.println("Account Login");
		System.out.println("--------------");
		System.out.print("Enter User Name: ");
		String userID = input.next();
		Student student = getStudentInstance(students, userID);
		if(student != null) {
			System.out.print("Enter Password: ");
			String password = input.next();
			if(!student.getAccount().getPassword().equals(password)) {
				student = null;
			}
		}
		return student;
	}
	
	// This method gets the instance of a student from a given list and user name.
	public static Student getStudentInstance(ArrayList<Student> students, String userName) {
		Student student = null;
		for(Student s : students) {
			if(s.getAccount().getUserName().equals(userName)) {
				student = s;
				break;
			}
		}
		return student;
	}

	// This method is the initial screen that will be shown to the user.
	public static int loginUserSelection(Scanner input) {
		int userSelection = 0;
		do {
			System.out.println("--------------------");
			System.out.println("Student Registration");
			System.out.println("--------------------");
			System.out.println("1. Create Account");
			System.out.println("2. Log-in");
			System.out.println("3. Exit");
			System.out.println("--------------------");
			System.out.print("> ");
			switch(input.next()) {
			case "1":
				userSelection = 1;
				break;
			case "2":
				userSelection = 2;
				break;
			case "3":
				userSelection = 3;
				break;
			default:
				System.out.println("Error: Invalid selection!");
			}
		} while(userSelection == 0);
		return userSelection;
	}
}
