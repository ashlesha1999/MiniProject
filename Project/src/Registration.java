import java.util.Scanner;

public class Registration {

	public static void main(String[] args) {
		String username,password;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter username");
		username=sc.nextLine();
		System.out.println("Enter password");
		password=sc.nextLine();
		if(username.equals("user")&& password.equals("user")) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Invalid user");
		}

	}

}
