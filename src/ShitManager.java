import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ShitManager {
	
	private boolean cmdCheck(String s) {
		
		switch(s) {
		case "OC": return true;
		case "OS": return true;
		case "OM": return true;
		case "CC": return true;
		case "CS": return true;
		case "CM": return true;
		case "DC": return true;
		case "DS": return true;
		case "DM": return true;
		case "WC": return true;
		case "WS": return true;
		case "WM": return true;
		case "PA": return true;
		case "PD": return true;
		case "PN": return true;
		case "Q": return true;
		default: return false;
		}
		
	}
		
	
	private boolean checkTokens(String s, int maxTokens) { //check number of tokens and sees if it matches requirements
		
		int frequency = new StringTokenizer(s, " ").countTokens();
		
		if(frequency == maxTokens) {
			return true;
		}
		return false;
		
	}
	
	
	private boolean oneTokenScan(String com, AccountDatabase db) {
		
		switch (com) {
		case "PA":
			db.printAccounts();
			return false;
		case "PD":
			db.printByDateOpen();
			return false;
		case "PN":
			db.printByLastName();
			return false;
		case "Q":
			System.out.println("Transaction processing completed.");
			return true;
		default:
			return false;	
		}
		
	}
	
	
	private void threeTokenScan(String com, AccountDatabase db, Scanner s) {
		 
		String fName = s.next();
		String lName = s.next();
		Profile profile = new Profile(fName, lName);
		boolean closed = false;
		
		switch (com) {
		case "CC":
			Account currCheckAcc = new Checking(profile);
			closed = db.remove(currCheckAcc);		// remove that account from the array
		case "CS":
			Account currSavingsAcc = new Savings(profile);
			closed = db.remove(currSavingsAcc);		// remove that account from the array
		case "CM":
			Account currMoneyMarketAcc = new MoneyMarket(profile);
			closed = db.remove(currMoneyMarketAcc);	// remove that account from the array
		}
		
		 
		if (closed == true) {
			System.out.println("Account closed and removed from the database");
		}
		else {
			System.out.println("Account does not exist");
		}
			  
		
	}
	
	
	private void fourTokenScan(String com, AccountDatabase db, Scanner s) {
		
		String fName = s.next();
		String lName = s.next();
		double balance = s.nextDouble();
		Profile profile = new Profile(fName, lName);
		
		if(com.equals("DC") || com.equals("DS") || com.equals("DM")) {
			 
			boolean deposited = false;
			
			switch(com) {
			case "DC":
				Account currCheckingAcc = new Checking(profile);
				deposited = db.deposit(currCheckingAcc, balance);
			case "DS":
				Account currSavingsAcc = new Savings(profile);
				deposited = db.deposit(currSavingsAcc, balance);
			case "DM":
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
			 
			int withdrawn = 0;
			 
			switch(com) {
			case "WC":
				Account currCheckingAcc = new Checking(profile);
				withdrawn = db.withdrawal(currCheckingAcc, balance);
			case "WS":
				Account currSavingsAcc = new Savings(profile);
				withdrawn = db.withdrawal(currSavingsAcc, balance);
			case "WM":
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
		
	}
	
	
	public void fiveTokenScan(String com, AccountDatabase db, Scanner s) {
		
		String fName = s.next();
		String lName = s.next();
		double balance = s.nextDouble();
		String date = s.next();

		Profile profile = new Profile(fName, lName);
		Date dateOpen = new Date(date);
		boolean opened = false;
		
		if (dateOpen.isValid()) {
			MoneyMarket moneymarket = new MoneyMarket(profile, balance, dateOpen);
			opened = db.add(moneymarket);
			
			if(opened == true) {
				System.out.println("Account opened and added to the database");
			}
			
			else {
				System.out.println("Account is already in the database.");
			}
		}
		else {
			System.out.println(date + " is not a valid date!");
		}
			
	}
	
	
	public void sixTokenScan(String com, AccountDatabase db, Scanner s) {
			
		String fName = s.next();
		String lName = s.next();
		double balance = s.nextDouble();
		String date = s.next();
		boolean special = s.nextBoolean();
			 
		Profile profile = new Profile(fName, lName);
		Date dateOpen = new Date(date);
		boolean opened = false;
		
		if (dateOpen.isValid()) {
			switch(com) {
			case "OC":
				Checking checking = new Checking(profile, balance, dateOpen, special);
				opened = db.add(checking);
				if(opened == true) {
					System.out.println("Account opened and added to the database");
				}
				
				else {
					System.out.println("Account is already in the database.");
				}
			case "OS":
				Savings savings = new Savings(profile, balance, dateOpen, special);
				opened = db.add(savings);
				if(opened == true) {
					System.out.println("Account opened and added to the database");
				}
				
				else {
					System.out.println("Account is already in the database.");
				}
			}
		}
		else {
			System.out.println(date + " is not a valid date!");
		}
		
	}
	
	
	
	public void run() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Transaction processing starts.....");
		AccountDatabase db = new AccountDatabase();
		
		outer:
		while (sc.hasNext()) {
			
			String command = sc.nextLine().trim();
			Scanner s = new Scanner(command).useDelimiter(("\\s+"));


			int print_quit_tokens = 1;
			int close_tokens = 3;
			int dep_with_tokens = 4;
			int open_mm_tokens = 5;
			int open_tokens = 6;
			
			boolean is_one_token = checkTokens(command, print_quit_tokens);
			boolean is_three_tokens = checkTokens(command, close_tokens);
			boolean is_four_tokens = checkTokens(command, dep_with_tokens);
			boolean is_five_tokens = checkTokens(command, open_mm_tokens);
			boolean is_six_tokens = checkTokens(command, open_tokens);
			
			try {
				inner:
				while(s.hasNext()) {
					
					String com = s.next();
						
					if (!cmdCheck(com)) {
						System.out.println("Command '" + com + "' not supported!");
						break inner;
					}
					
					//command only has one token if it is quit or print
					if(is_one_token) {
						boolean quit = oneTokenScan(com,db);
						if (quit) {
							break outer;
						}
					}
					
					//command with three tokens is close
					else if(is_three_tokens) {
						threeTokenScan(com, db, s);
					}
					
					//command with four tokens is deposit and withdrawal
					else if(is_four_tokens) {
						fourTokenScan(com, db, s);
					}
					
					//command with five tokens is open money market account
					else if(is_five_tokens) {
						fiveTokenScan(com, db, s);	
					}
					
					//command with six tokens is open checking/savings account
					else if(is_six_tokens) {
						sixTokenScan(com, db, s);
					}
					
				}
					
			} catch(InputMismatchException e) {
				System.out.println("Input data type mismatch.");
			}
			catch(NumberFormatException e) {
				System.out.println("Number format exception.");
			}

			s.close();
			
		}
		
		sc.close();
		
	}

}
