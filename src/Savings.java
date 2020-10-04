
public class Savings extends Account {

	public Savings(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		// TODO Auto-generated constructor stub
	}

	private boolean isLoyal;
	
	@Override
	public double monthlyInterest() {
		final double annualInterestRate = 0.0005;
		int period = 12;
		final double monthlyInterestRate = annualInterestRate/period;
		final double loyalInterestRate = 0.0035;
		double monthlyInterest;
		
		if (isLoyal) {
			monthlyInterest = getBalance() * loyalInterestRate; 
		}
		else {
			monthlyInterest = getBalance() * monthlyInterestRate;
		}
		
		
		return monthlyInterest;
	}

	@Override
	public double monthlyFee() {
		
		double monthlyFee;
		final double threshold = 300;
		final double savingsMonthlyFee = 5;
		
		if(getBalance() >= threshold) {
			monthlyFee = 0;
		}
		else {
			monthlyFee = savingsMonthlyFee;
		}

		return monthlyFee;
		
	}

}
