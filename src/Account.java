
public abstract class Account {

	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	public Account(Profile holder, double balance, Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
	
	public Profile getHolder() {
		return holder;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public Date getDateOpen() {
		return dateOpen;
	}
	
	
	public void debit(double amount) { //decrease the balance by amount
		balance -= amount;
	}
	
	public void credit(double amount) { //increase the balance by amount
		balance += amount;
	}
	
	public String toString() { 
		
		//String accountType = "checking/savings/moneymarket";
		String fname = this.holder.get_fname();
		String lname = this.holder.get_lname();
		String date = this.dateOpen.toString();
		// special savings account or not
		// direct deposit account or not
		
		String accountInfo = fname + " " + lname + "* $" + balance + "*" + date;
		
		return accountInfo;
		
	}
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
	
}
