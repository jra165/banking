import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TransactionManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/* Sometimes you need to scan line-by-line, with multiple tokens on a line. 
	 * The easiest way to accomplish this is to use two Scanner, 
	 * where the second Scanner takes the nextLine() from the first Scanner as input. Here's an example:
	 */
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		AccountDatabase db = new AccountDatabase();
		
		while (sc.hasNext()) {
			String command = sc.nextLine().trim();
			
			// Check for input conditions
			// 1st: Two letter command identifying transaction type and account type
			// 2nd: First Name
			// 3rd: Last Name
			// 4th: amount of money to start
			// 5th: optional for cases of O command (checking and savings only)
			
			//while command is not Quit
			while(!sc.hasNext("Q")) {
				
				Scanner s = new Scanner(command).useDelimiter(("\\s+"));
				String fName = "";
				String lName = "";
				double balance = 0;
				String date = "";
				boolean special = false;
				
				while(s.hasNext()) {
					
					//this is the 2-letter abbreviation at the start of every line
					String com = s.next();
					
					 if(com.equals("OC") || com.equals("OS") || com.equals("OM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 balance = s.nextDouble();
						 date = s.next();
						 special = s.nextBoolean();
						 
						 Profile profile = new Profile(fName, lName);
						 Date dateOpen = new Date(date);
						 
						 if(com.equals("OC")) {
							 
							 Checking checking = new Checking(profile, balance, dateOpen, special);
							 db.add(checking);
							 
						 }
						 
						 if(com.equals("OS")) {
							 
							 Savings savings = new Savings(profile, balance, dateOpen, special);
							 db.add(savings);
							 
						 }
						 
						 if(com.equals("OM")) {
							 
							 MoneyMarket moneymarket = new MoneyMarket(profile, balance, dateOpen, 0);
							 db.add(moneymarket);
							 
						 }
						 
						 
					 }
					 
					 else if(com.equals("CC") || com.equals("CS") || com.equals("CM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 
						 if(com.equals("CC")) {
							 
						 }
						 
						 else if(com.equals("CC")) {
							 
						 }
						 
						 else if(com.equals("CC")) {
							 
						 }
						 
					 }
					 
					 else if(com.equals("DC") || com.equals("DS") || com.equals("DM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 balance = s.nextDouble();
						 
					 }
					 
					 else if(com.equals("WC") || com.equals("WS") || com.equals("WM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 balance = s.nextDouble();
						 
					 }
					 
					 //needs to print interest, fee, new balance depending on type of account
					 else if(com.equals("PA")) {
						 db.printAccounts();
					 }
					 
					 //needs to calculate monthly interest and fees
					//needs to print interest, fee, new balance depending on type of account
					 else if(com.equals("PD")) {
						 
					 }
					 
					//needs to print interest, fee, new balance depending on type of account
					 else if(com.equals("PN")) {
						 db.printByLastName();
					 }
					 
					s.close(); 
					
				}
				
			}
			
			System.out.println("Transaction processing completed.");
			sc.close();
			
		}
		
		
		
	}

}
