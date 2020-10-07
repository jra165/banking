import java.text.DecimalFormat;

public class Checking extends Account {

	private boolean directDeposit;
	
	public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
		super(holder, balance, dateOpen);
		this.directDeposit = directDeposit;
	}

	
	public Checking(Profile profile) {
		super(profile);
	}


	@Override
	public double monthlyInterest() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		final double annualInterestRate = 0.0005;
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
		final double threshold = 1500;
		final double checkingMonthlyFee = 25;
		
		if(directDeposit == true || getBalance() >= threshold) {
			monthlyFee = 0;
		}
		else {
			monthlyFee = checkingMonthlyFee;
		}

		String strMonthlyFee = df.format(monthlyFee);
		
		return Double.parseDouble(strMonthlyFee);
	}
	
	@Override
	public String toString() {
		
		String accountInfo;
		
		if (directDeposit) {
			accountInfo = "*Checking*" + super.toString() + "*direct deposit account*";
		}
		else {
			accountInfo = "*Checking*" + super.toString();
		}
		
		return accountInfo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) && obj instanceof Checking) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		Profile Kyle = new Profile("Kyle", "Lee");
		Date open = new Date("10/6/20");
		double amount = 1234.567;
		boolean directDeposit = true;
		
		Checking capitalOne = new Checking(Kyle, amount, open, directDeposit);
		System.out.println(capitalOne.toString());
		
	}
	
	
}
