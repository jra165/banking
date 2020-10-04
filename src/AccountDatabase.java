
public class AccountDatabase {
	private Account[] accounts;
	private int size;
	
	private int find(Account account) { 
		return 0;
	}
	
	private void grow() { }
	
	public boolean add(Account account) {
		return true;
	}
	
	public boolean remove(Account account) { 
		return false;
	}
	
	public boolean deposit(Account account, double amount) { 
		return false;
	} // return 0: withdrawal successful, 1: insufficient funds, -1 account doesn't exist
	
	
	public int withdrawal(Account account, double amount) {
		return 0; 
	}
	
	private void sortByDateOpen()  { }
	private void sortByLastName() { }
	public void printByDateOpen() { }
	public void printByLastName() { }
	public void printAccounts() { }
	
	

}
