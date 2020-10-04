
public class AccountDatabase {
	private Account[] accounts = new Account[5];
	private int size;
	
	private int find(Account account) { 
		for (int i = 0; i < accounts.length; i++) {
			if(account.equals(accounts[i])) {
				return i;
			}
		}
		System.out.println("Error");
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
		if (account == null || amount < 0) {
			return false;
		}
		
		account.credit(amount);
		
		return true;
		
	} 
	
	// return 0: withdrawal successful, 1: insufficient funds, -1 account doesn't exist
	public int withdrawal(Account account, double amount) {
		if (account == null || amount < 0) {
			return -1;
		}
		
		else if (amount > account.getBalance()) {
			return 1;
		}
		
		else { 
			account.debit(amount);
		}
		
		return 0; 
	}
	
	private void sortByDateOpen()  { 
		
	}
	
	private void sortByLastName() { 
		
	}
	
	public void printByDateOpen() { 
		
	}
	
	public void printByLastName() { 
		
	}
	
	public void printAccounts() { 
		
	}
	
	

}
