import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransactionManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String command = sc.nextLine().trim();
			String[] commandArr = command.split("\\s+");
			
			
			// Check for input conditions
			// 1st: Two letter command identifying transaction type and account type
			// 2nd: First Name
			// 3rd: Last Name
			// 4th: amount of money to start
			// 5th: optional for cases of O command (checking and savings only)
			
			for (int i = 0; i < commandArr.length; i++) {
				
				
				if (i == 0 && commandArr[i] != null) {
					
					
				}
				

				
			}
			
			
		}
		
	}

}
