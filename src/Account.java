
public abstract class Account {

	private Profile holder;
	private double balance;
	private Date dateOpen;

	
	public Account(Profile holder, double balance, Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
	
	public Account(Profile holder) {
		this.holder = holder;
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
	
	
	public void setBalance(double interest, double fee) {
		this.balance = this.balance + interest - fee;
	}
	
	public void debit(double amount) { //decrease the balance by amount
		balance -= amount;
	}
	
	public void credit(double amount) { //increase the balance by amount
		balance += amount;
	}
	
	@Override
	public String toString() { 
		
		String fname = this.holder.get_fname();
		String lname = this.holder.get_lname();
		String date = this.dateOpen.toString();
		
		String accountInfo = fname + " " + lname + "* $" + String.format("%.2f", balance) + "*" + date;
		
		return accountInfo;
		
	}
	
	
	@Override 
	public boolean equals(Object obj){ 
		if (obj == this) { 
			return true;
		}
	  
		if (obj instanceof Account) { 
			Account currAcc = (Account) obj;
			return this.holder.equals(currAcc.getHolder()); 
		}
	  
		return false; 
	
	}
	 
	
	public abstract double monthlyInterest();
	public abstract double monthlyFee();
	
}
