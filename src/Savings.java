import java.text.DecimalFormat;

public class Savings extends Account {
	
	private boolean isLoyal;
	
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		super(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
	
	public Savings(Profile profile) {
		super(profile);
	}
	
	
	@Override
	public double monthlyInterest() {
		
		//DecimalFormat df = new DecimalFormat("0.00");
		final double annualInterestRate = 0.0025;
		int period = 12;
		
		final double monthlyInterestRate = annualInterestRate/period;
		final double loyalInterestRate = 0.0035;
		final double monthlyLoyalInterestRate = loyalInterestRate/period;
		double monthlyInterest;
		
		if (isLoyal) {
			monthlyInterest = getBalance() * monthlyLoyalInterestRate; 
		}
		else {
			monthlyInterest = getBalance() * monthlyInterestRate;
		}
		
		//String strMonthlyInterest = df.format(monthlyInterest);
		
		
		return monthlyInterest;
	
	}

	@Override
	public double monthlyFee() {
		
		//DecimalFormat df = new DecimalFormat("0.00");
		double monthlyFee;
		final double threshold = 300;
		final double savingsMonthlyFee = 5;
		
		if(getBalance() >= threshold) {
			monthlyFee = 0;
		}
		else {
			monthlyFee = savingsMonthlyFee;
		}
		
		//String strMonthlyFee = df.format(monthlyFee);

		return monthlyFee;
		
	}
	
	@Override
	public String toString() {
		
		String accountInfo;
		
		if (isLoyal) {
			accountInfo = "*Savings*" + super.toString() + "*special Savings account*";
		}
		else {
			accountInfo = "*Savings*" + super.toString();
		}
		
		return accountInfo;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) && obj instanceof Savings) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		Profile Kyle = new Profile("Kyle", "Lee");
		Date open = new Date("10/6/20");
		double amount = 20.05;
		boolean directDeposit = false;
		
		Savings jpMorganChase = new Savings(Kyle, amount, open, directDeposit);
		System.out.println(jpMorganChase.toString());
		
	}

}
