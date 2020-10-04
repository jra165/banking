
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
		return "";
	}
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
	

}
