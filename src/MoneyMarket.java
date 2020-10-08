import java.text.DecimalFormat;

public class MoneyMarket extends Account {
	
	private int withdrawals = 0;
	
	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
	}
	
	public MoneyMarket(Profile profile) {
		super(profile);
	}
	
	
	// For case in which withdrawal is successful we increment withdrawal total
	public void setWithdrawals() {
		this.withdrawals++;
	}
	

	@Override
	public double monthlyInterest() {
		
		//DecimalFormat df = new DecimalFormat("0.00");
		final double annualInterestRate = 0.0065;
		int period = 12;
		final double monthlyInterestRate = annualInterestRate/period;
		double monthlyInterest = getBalance() * monthlyInterestRate;
		
		//String strMonthlyInterest = df.format(monthlyInterest);
		
		return monthlyInterest;
	}

	@Override
	public double monthlyFee() {
		
		//DecimalFormat df = new DecimalFormat("0.00");
		double monthlyFee;
		final double threshold = 2500;
		final double moneyMarketMonthlyFee = 12;
		
		// change withdrawal in future, catch check in TransactionManager.java
		if(getBalance() >= threshold) {
			if (withdrawals > 6) {
				monthlyFee = moneyMarketMonthlyFee;
			}
			else {
				monthlyFee = 0;
			}
		}
		else {
			monthlyFee = moneyMarketMonthlyFee; 
		}
		
		//String strMonthlyFee = df.format(monthlyFee);

		return monthlyFee;
	}
	
	@Override
	public void debit(double amount) { //decrease the balance by amount
		super.debit(amount);
		setWithdrawals();
		
	}
	
	@Override
	public String toString() {
		
		String accountInfo;
		
		if (withdrawals == 1) {
			accountInfo = "*Money Market*" + super.toString() + "*" + this.withdrawals + " withdrawal*";
		}
		else {
			accountInfo = "*Money Market*" + super.toString() + "*" + this.withdrawals + " withdrawals*";
		}
		
		return accountInfo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) && obj instanceof MoneyMarket) {
			return true;
		}
		return false;
	}

}
