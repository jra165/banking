import java.text.DecimalFormat;

/**
 * Savings represents a subclass of Account with the properties and methods associated with the Savings object
 * Properties and methods inherited from Account class
 * Additional methods include monthlyInterest, monthlyFee, toString, and equals
 * @author Joshua Atienza, Kyle Lee
 *
 */
public class Savings extends Account {
	
	private boolean isLoyal;
	
	/**
	 * Creates a Savings account with the specified holder, balance, date opened, and loyalty status
	 * Constructor intended to only be used with open account methods
	 * @param holder The holder of the account
	 * @param balance The balance of the account
	 * @param dateOpen The date the account was opened
	 * @param isLoyal Whether or not the account is in loyalty program
	 */
	public Savings(Profile holder, double balance, Date dateOpen, boolean isLoyal) {
		super(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
	
	/**
	 * Creates a Savings account with the specified holder
	 * Constructor intended to only be used with withdraw, deposit, and close methods
	 * @param profile The profile of the holder
	 */
	public Savings(Profile profile) {
		super(profile);
	}
	
	/** 
	 * Calculates the monthly interest of savings account
	 * @return monthlyInterest The monthly interest associated with a specific savings account
	 */
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
	
	/**
	 * Calculates the monthly fee of savings account
	 * @return monthlyFee The monthly fee associated with a specific savings account
	 */
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
	
	/**
	 * Converts Savings account to its String representation
	 * @return accountInfo The String representation of Savings object
	 */
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
	
	/**
	 * Checks if Savings is equivalent to obj being compared to.
	 * Checks if obj instanceof Savings and if all data fields are equivalent
	 * @param obj The object being compared to a particular Savings account
	 * @return true if Savings is equivalent to object, false otherwise
	 */
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
