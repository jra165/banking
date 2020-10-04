
public class Checking extends Account {

	public Checking(Profile holder, double balance, Date dateOpen) {
		super(holder, balance, dateOpen);
		// TODO Auto-generated constructor stub
	}

	private boolean directDeposit;

	
	@Override
	public double monthlyInterest() {
		final double annualInterestRate = 0.0005;
		int period = 12;
		final double monthlyInterestRate = annualInterestRate/period;
		double monthlyInterest = getBalance() * monthlyInterestRate;
		
		
		return monthlyInterest;
	}

	@Override
	public double monthlyFee() {
		
		double monthlyFee;
		final double threshold = 1500;
		final double checkingMonthlyFee = 25;
		
		if(directDeposit == true || getBalance() >= threshold) {
			monthlyFee = 0;
		}
		else {
			monthlyFee = checkingMonthlyFee;
		}

		return monthlyFee;
	}
	
}
