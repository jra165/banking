import java.text.DecimalFormat;

public class MoneyMarket extends Account {
	
	private int withdrawals;
	
	public MoneyMarket(Profile holder, double balance, Date dateOpen, int withdrawals) {
		super(holder, balance, dateOpen);
		this.withdrawals = withdrawals;
	}

	@Override
	public double monthlyInterest() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		final double annualInterestRate = 0.0065;
		int period = 12;
		final double monthlyInterestRate = annualInterestRate/period;
		double monthlyInterest = getBalance() * monthlyInterestRate;
		
		String strMonthlyInterest = df.format(monthlyInterest);
		
		return Double.parseDouble(strMonthlyInterest);
	}

	@Override
	public double monthlyFee() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		double monthlyFee;
		final double threshold = 2500;
		final double moneyMarketMonthlyFee = 12;
		
		// change withdrawal in future, catch check in TransactionManager.java
		if(withdrawals > 6|| getBalance() >= threshold) {
			monthlyFee = 0;
		}
		else {
			monthlyFee = moneyMarketMonthlyFee;
		}
		
		String strMonthlyFee = df.format(monthlyFee);

		return Double.parseDouble(strMonthlyFee);
	}
	
	public String toString() {
		
		String accountInfo;
		
		if (withdrawals == 1) {
			accountInfo = "*Money Market*" + super.toString() + withdrawals + " withdrawal";
		}
		else {
			accountInfo = "*Money Market*" + super.toString() + withdrawals + " withdrawals";
		}
		
		return accountInfo;
	}

}
