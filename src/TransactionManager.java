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
		System.out.println("Transaction processing starts.....");
		AccountDatabase db = new AccountDatabase();
		
		while (sc.hasNext()) {
			String command = sc.nextLine().trim();
			
			// Check for input conditions
			// 1st: Two letter command identifying transaction type and account type
			// 2nd: First Name
			// 3rd: Last Name
			// 4th: amount of money to start
			// 5th: optional for cases of O command (checking and savings only)
				
			Scanner s = new Scanner(command).useDelimiter(("\\s+"));
			String fName = "";
			String lName = "";
			double balance = 0;
			String date = "";
			boolean special = false;
			int open_tokens = 5;
			int open_mm_tokens = 4;
			
			while(s.hasNext()) {
				
				//this is the 2-letter abbreviation at the start of every line
				String com = s.next();
				int count = 0;
				
				if(com.equals("OC") || com.equals("OS") || com.equals("OM")) {
					
					if(s.hasNext()) {
						fName = s.next();
						count++;
						System.out.println("First name: " + fName);
					}
					
					if(s.hasNext()) {
						lName = s.next();
						count++;
						System.out.println("Last name: " + lName);	
					}
					
					if(s.hasNext()) {
						balance = s.nextDouble();
						count++;
						System.out.println("Balance: " + balance);
					}
					
					if(s.hasNext()) {
						date = s.next();
						count++;
						System.out.println("Date: " + date);
					}
					
					if(s.hasNext()) {
						special = s.nextBoolean();
						count++;
						System.out.println("Special: " + special);
					}
						 
					Profile profile = new Profile(fName, lName);
					Date dateOpen = new Date(date);
					boolean opened = false;
					
					//magic numbers
					if(com.equals("OC") && count == open_tokens) {
						Checking checking = new Checking(profile, balance, dateOpen, special);
						opened = db.add(checking);
					} 
						 
					else if(com.equals("OS") && count == open_tokens) {
							 
						Savings savings = new Savings(profile, balance, dateOpen, special);
						opened = db.add(savings);
							 
					}
						 
					else if(com.equals("OM") && count == open_mm_tokens) {
							 
						MoneyMarket moneymarket = new MoneyMarket(profile, balance, dateOpen);
						opened = db.add(moneymarket);
							 
					}
					
					if(opened == true) {
						System.out.println("Account opened and added to the database");
					}
					
					else {
						System.out.println("Account is already in the database.");
					}
					 
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
				
				else if(com.equals("Q")) {
					System.out.println("Transaction processing completed.");
					break;
				}
				
				else {
					System.out.println("Command '" + com + "' not supported!");
					break;
				}
				
			}
			
			s.close();
			
		}
		
		sc.close();
		
	}

}
