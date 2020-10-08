import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * The TransactionManager class is the user interface class that handles inputs commands, outputs data, and messages. 
 * Commands should begin with OC, OS, OM, CC, CS, CM, DC, DS, DM, WC, WS, WM, PA, PD, PN, Q
 * TransactionManager accounts for any bad input by catching exceptions and notifying the user
 * @author Joshua Atienza, Kyle Lee
 *
 */

public class TransactionManager {
	
	/**
	 * Checks if the command is valid 2 letter abbreviation
	 * @param s The command being checked for validity
	 * @return true if s is valid two letter abbreviation, false otherwise
	 */
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
		
	/**
	 * Checks if command has correct amount of tokens
	 * @param s The command being checked for correct number of tokens
	 * @param maxTokens The threshold we establish to be the correct number of allowed tokens
	 * @return true if number of tokens equal to maxTokens, false otherwise
	 */
	private boolean checkTokens(String s, int maxTokens) { 			//check number of tokens and sees if it matches requirements
		
		int frequency = new StringTokenizer(s, " ").countTokens();
		
		if(frequency == maxTokens) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * Processes commands that only have 1 token
	 * @param com The command being processed
	 * @param db The database being operated on
	 * @return true if program quits, false otherwise
	 */
	private boolean oneTokenScan(String com, AccountDatabase db) {
		
		switch (com) {
		case "PA":												//print accounts
			db.printAccounts();
			return false;
		case "PD":												//print accounts by date opened
			db.printByDateOpen();
			return false;
		case "PN":												//print accounts by last name
			db.printByLastName();
			return false;
		case "Q":												//quit program
			System.out.println();
			System.out.println("Transaction processing completed.");
			return true;
		default:
			return false;	
		}
		
	}
	
	/** 
	 * Processes commands that only have 3 tokens
	 * @param com The command being processed
	 * @param db The database being operated on
	 * @param s The Scanner from which each token is read
	 */
	private void threeTokenScan(String com, AccountDatabase db, Scanner s) {
		 
		String fName = s.next();
		String lName = s.next();
		Profile profile = new Profile(fName, lName);
		boolean closed = false;
		
		switch (com) {
		case "CC":												//close checking account
			Account currCheckAcc = new Checking(profile);
			closed = db.remove(currCheckAcc);					
			break;
		case "CS":												//close savings account
			Account currSavingsAcc = new Savings(profile);
			closed = db.remove(currSavingsAcc);					
			break;
		case "CM":												//close money market account
			Account currMoneyMarketAcc = new MoneyMarket(profile);
			closed = db.remove(currMoneyMarketAcc);				
			break;
		}
		
		 
		if (closed == true) {
			System.out.println("Account closed and removed from the database");
		}
		else {
			System.out.println("Account does not exist");
		}
			  
		
	}
	
	/** 
	 * Processes commands that only have 4 tokens
	 * @param com The command being processed
	 * @param db The database being operated on
	 * @param s The Scanner from which each token is read
	 */
	private void fourTokenScan(String com, AccountDatabase db, Scanner s) {
		
		String fName = s.next();
		String lName = s.next();
		double balance = s.nextDouble();
		Profile profile = new Profile(fName, lName);
		
		if(com.equals("DC") || com.equals("DS") || com.equals("DM")) {
			 
			boolean deposited = false;
			
			switch(com) {
			case "DC":											//deposit into checking account
				Account currCheckingAcc = new Checking(profile);
				deposited = db.deposit(currCheckingAcc, balance);
				break;
			case "DS":											//deposit into savings account
				Account currSavingsAcc = new Savings(profile);
				deposited = db.deposit(currSavingsAcc, balance);
				break;
			case "DM":											//deposit into money market account
				Account currMoneyMarketAcc = new MoneyMarket(profile);
				deposited = db.deposit(currMoneyMarketAcc, balance);
				break;
			}
			
			if (deposited) {
				System.out.println(String.format("%.2f", balance) + " deposited to account.");
			}
			else {
				System.out.println("Account does not exist.");
			}
			 
		}
		
		else if(com.equals("WC") || com.equals("WS") || com.equals("WM")) {
			 
			int withdrawn = 0;
			 
			switch(com) {
			case "WC":											//withdraw from checking account
				Account currCheckingAcc = new Checking(profile);
				withdrawn = db.withdrawal(currCheckingAcc, balance);
				break;
			case "WS":											//withdraw from savings account	
				Account currSavingsAcc = new Savings(profile);
				withdrawn = db.withdrawal(currSavingsAcc, balance);
				break;
			case "WM":											//withdraw from money market account
				Account currMoneyMarketAcc = new MoneyMarket(profile);
				withdrawn = db.withdrawal(currMoneyMarketAcc, balance);
				break;
			}
			
			 
			if (withdrawn == 0) {
				System.out.println(String.format("%.2f", balance) + " withdrawn from account.");
			}
			else if (withdrawn == 1) {
				System.out.println("Insufficient funds.");
			}
			else {
				System.out.println("Account does not exist.");
			}
			 
		}
		
	}
	
	/** 
	 * Processes commands that only have 5 tokens, which is adding MoneyMarket account to database
	 * @param com The command being processed
	 * @param db The database being operated on
	 * @param s The Scanner from which each token is read
	 */
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
				System.out.println("Account opened and added to the database.");
			}
			
			else {
				System.out.println("Account is already in the database.");
			}
		}
		else {
			System.out.println(date + " is not a valid date!");
		}
			
	}
	
	/** 
	 * Processes commands that only have 6 tokens
	 * @param com The command being processed
	 * @param db The database being operated on
	 * @param s The Scanner from which each token is read
	 */
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
			case "OC":											//open checking account
				Checking checking = new Checking(profile, balance, dateOpen, special);
				opened = db.add(checking);
				if(opened == true) {
					System.out.println("Account opened and added to the database.");
				}
				
				else {
					System.out.println("Account is already in the database.");
				}
				break;
			case "OS":											//open savings account
				Savings savings = new Savings(profile, balance, dateOpen, special);
				opened = db.add(savings);
				if(opened == true) {
					System.out.println("Account opened and added to the database.");
				}
				
				else {
					System.out.println("Account is already in the database.");
				}
				break;
			}
		}
		else {
			System.out.println(date + " is not a valid date!");
		}
		
	}
	
	
	/**
	Runs the project, reads text file with input commands, and returns outputs/messages accordingly.
	*/
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
