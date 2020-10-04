
public class MoneyMarket extends Account {
	
	public MoneyMarket(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		// TODO Auto-generated constructor stub
	}
	
	private int withdrawals;

	@Override
	public double monthlyInterest() {
		final double annualInterestRate = 0.0065;
		int period = 12;
		final double monthlyInterestRate = annualInterestRate/period;
		double monthlyInterest = getBalance() * monthlyInterestRate;
		
		
		return monthlyInterest;
	}

	@Override
	public double monthlyFee() {
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

		return monthlyFee;
	}

}
