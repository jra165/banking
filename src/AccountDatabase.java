
public class AccountDatabase {
	private Account[] accounts = new Account[5];
	private int size;
	
	public int getSize() {
		return size;
	}
	
	
	private int find(Account account) { 
		for (int i = 0; i < size; i++) {
			if(account.equals(accounts[i])) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	private void grow() { 
		Account[] newAccounts = new Account[accounts.length+5];
		accounts = newAccounts;
	}
	
	
	public boolean add(Account account) {
		
		if (find(account) != -1) {
			return false;
		}
		
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] == null) {
				accounts[i] = account;
				break;
			}
		}
		size++;
		
		// Check whether the account database is full or not
		if (size%5 == 0) {
			grow();
		}
		
		return true;
	
	}
	
	
	public boolean remove(Account account) {
		
		int index = find(account);
		
		if(account == null || index == -1 || size < 1) {		//checks if account not found or account database is empty
			return false;
		}
		
		accounts[index] = accounts[size-1];			//replaces removing element with last element
		accounts[size-1] = null;
		
		size--;
		
		return true;
		
	}
	
	public boolean deposit(Account account, double amount) {
		
		int index = find(account);
		
		if (account == null || index == -1 || amount < 0) {
			return false;
		}
		
		accounts[index].credit(amount);
		
		return true;
		
	} 
	
	// return 0: withdrawal successful, 1: insufficient funds, -1 account doesn't exist
	public int withdrawal(Account account, double amount) {
		
		int index = find(account);
		
		if (account == null || index == -1 || amount < 0) {
			return -1;
		}
		
		else if (amount > accounts[index].getBalance()) {
			return 1;
		}
		
		else { 
			accounts[index].debit(amount);
		}
		
		return 0; 
	}
	
	// Selection Sort
	private void sortByDateOpen()  { // sort in ascending order
		int numAccounts = size;
		Date firstDateOpen;
		Date secondDateOpen;
		
		for (int i = 0; i < numAccounts-1; i++) {
			
			// Set left side index to min_idx
			int min_idx = i;
			
			// Compare left side index with iterator j
			for (int j = i+1; j < numAccounts; j++) {
				
				// Retrieve last name of two that you are comparing
				firstDateOpen = accounts[j].getDateOpen();
				secondDateOpen = accounts[min_idx].getDateOpen();
				
				if (firstDateOpen.compareTo(secondDateOpen) < 0) {
					min_idx = j;
				}
			}
			
			Account temp = accounts[min_idx];
			accounts[min_idx] = accounts[i];
			accounts[i] = temp;
		}
		
	}
	
	private void sortByLastName() { 
		
		int numAccounts = size;
		String firstHolder_lname;
		String secondHolder_lname;
		
		for (int i = 0; i < numAccounts-1; i++) {
			
			// Set left side index to min_idx
			int min_idx = i;
			
			// Compare left side index with iterator j
			for (int j = i+1; j < numAccounts; j++) {
				
				// Retrieve last name of two that you are comparing
				firstHolder_lname = (accounts[j].getHolder()).get_lname();
				secondHolder_lname = (accounts[min_idx].getHolder()).get_lname();
				
				if (firstHolder_lname.compareTo(secondHolder_lname) < 0) {
					min_idx = j;
				}
			}
			
			Account temp = accounts[min_idx];
			accounts[min_idx] = accounts[i];
			accounts[i] = temp;

			
		}
	}
	
	public void printByDateOpen() { 
		
		sortByDateOpen();
		
		
		System.out.println();
		System.out.println("--Printing statements by last name--");
		
		for (int i = 0; i < size; i++) {
			System.out.println();
			System.out.println(accounts[i].toString());
			System.out.println("-interest: $ " + accounts[i].monthlyInterest());
			System.out.println("-fee: $ " + accounts[i].monthlyFee());
			System.out.println("-new balance: $ " + accounts[i].getBalance());
		}
	
		System.out.println("--end of listing--");
		System.out.println();
		
	}
	
	public void printByLastName() { 
		
		sortByLastName();
		
		System.out.println();
		System.out.println("--Printing statements by last name--");
		
		for (int i = 0; i < size; i++) {
			System.out.println();
			System.out.println(accounts[i].toString());
			System.out.println("-interest: $ " + accounts[i].monthlyInterest());
			System.out.println("-fee: $ " + accounts[i].monthlyFee());
			System.out.println("-new balance: $ " + accounts[i].getBalance());
		}
		
		System.out.println("--end of printing--");
		System.out.println();
		
	}
	
	public void printAccounts() { 
		
		System.out.println();
		System.out.println("--Listing accounts in the database--");
		
		for (int i = 0; i < size; i++) {
			System.out.println();
			System.out.println(accounts[i].toString());
		}
		
		System.out.println("--end of listing--");
		System.out.println();
		
	}
	
	

}
