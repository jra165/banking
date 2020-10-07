import java.util.Scanner;

public class TransactionManager {

	//private void openAccount() {

	//}
	
	
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
								 
							MoneyMarket moneymarket = new MoneyMarket(profile, balance, dateOpen);
							db.add(moneymarket);
								 
						 }
						 
						 System.out.println("Account opened and added to the database");
						 
					 }
					 
					 else if(com.equals("CC") || com.equals("CS") || com.equals("CM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 Profile profile = new Profile(fName, lName);
						 boolean closed = false;
						 
						 if(com.equals("CC")) {
							 
							 // Create a new Checking Account based on profile (invoke constructor 2)
							 Account currCheckAcc = new Checking(profile);
							 closed = db.remove(currCheckAcc);		// remove that account from the array
							 
						 }
						 
						 else if(com.equals("CS")) {
							 
							// Create a new Savings Account based on profile (invoke constructor 2)
							 Account currSavingsAcc = new Savings(profile);
							 closed = db.remove(currSavingsAcc);		// remove that account from the array
						 }
						 
						 else if(com.equals("CM")) {
							 
							// Create a new Money Market Account based on profile (invoke constructor 2)
							 Account currMoneyMarketAcc = new Savings(profile);
							 closed = db.remove(currMoneyMarketAcc);	// remove that account from the array
						 }
						 
						 if (closed == true) {
							 System.out.println("Account closed and removed from the database");
						 }
						 else {
							 System.out.println("Account does not exist");
						 }
						 
						 
					 }
					 
					 else if(com.equals("DC") || com.equals("DS") || com.equals("DM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 balance = s.nextDouble();
						 Profile profile = new Profile(fName, lName);
						 boolean deposited = false;
						 
						 if (com.equals("DC")) {
							 Account currCheckingAcc = new Checking(profile);
							 deposited = db.deposit(currCheckingAcc, balance);
						 }
						 
						 else if (com.equals("DS")) {
							 Account currSavingsAcc = new Savings(profile);
							 deposited = db.deposit(currSavingsAcc, balance);
						 }
						 
						 else if (com.equals("DM")) {
							 Account currMoneyMarketAcc = new MoneyMarket(profile);
							 deposited = db.deposit(currMoneyMarketAcc, balance);
						 }
						 
						 if (deposited) {
							 System.out.println(balance + " deposited to account.");
						 }
						 else {
							 System.out.println("Account does not exist.");
						 }
						 
					 }
					 
					 else if(com.equals("WC") || com.equals("WS") || com.equals("WM")) {
						 
						 fName = s.next();
						 lName = s.next();
						 balance = s.nextDouble();
						 Profile profile = new Profile(fName, lName);
						 int withdrawn = 0;
						 
						 
						 if (com.equals("WC")) {
							 Account currCheckingAcc = new Checking(profile);
							 withdrawn = db.withdrawal(currCheckingAcc, balance);
						 }
						 
						 else if (com.equals("WS")) {
							 Account currSavingsAcc = new Savings(profile);
							 withdrawn = db.withdrawal(currSavingsAcc, balance);
						 }
						 
						 else if (com.equals("WM")) {
							 Account currMoneyMarketAcc = new MoneyMarket(profile);
							 withdrawn = db.withdrawal(currMoneyMarketAcc, balance);
						 }
						 
						 if (withdrawn == 0) {
							 System.out.println(balance + " withdrawn from account.");
						 }
						 else if (withdrawn == 1) {
							 System.out.println("Insufficient funds.");
						 }
						 else {
							 System.out.println("Account does not exist.");
						 }
						 
					 }
					 
					 //needs to print interest, fee, new balance depending on type of account
					 else if(com.equals("PA")) {
						 db.printAccounts();
					 }
					 
					 //needs to calculate monthly interest and fees
					//needs to print interest, fee, new balance depending on type of account
					 else if(com.equals("PD")) {
						 db.printByDateOpen();
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
