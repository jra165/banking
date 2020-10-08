import java.text.DecimalFormat;

/**
 * Checking represents a subclass of Account with the properties and methods associated with the Checking object
 * Properties and methods inherited from Account class
 * Additional methods include monthlyInterest, monthlyFee
 * @author Joshua Atienza, Kyle Lee
 *
 */
public class Checking extends Account {

	private boolean directDeposit;
	
	/**
	 * Creates a Checking account with specified holder, balance, dateOpen, directDeposit
	 * Constructor intended to only be used with open account methods
	 * @param holder The holder of the account
	 * @param balance The balance of the account
	 * @param dateOpen The date the account was opened
	 * @param directDeposit Whether or not the account allows direct deposit
	 */
	public Checking(Profile holder, double balance, Date dateOpen, boolean directDeposit) {
		super(holder, balance, dateOpen);
		this.directDeposit = directDeposit;
	}

	/** 
	 * Creates a Checking account with the specified holder
	 * Constructor intended to only be used with withdraw, deposit, close methods
	 * @param profile The profile of the holder
	 */
	public Checking(Profile profile) {
		super(profile);
	}


	/** 
	 * Calculates the monthly interest of checking account
	 * @return monthlyInterest The monthly interest associated with a specific checking account
	 */
	@Override
	public double monthlyInterest() {
		
		//DecimalFormat df = new DecimalFormat("0.00");
		final double annualInterestRate = 0.0005;
		int period = 12;
		
		final double monthlyInterestRate = annualInterestRate/period;
		double monthlyInterest = getBalance() * monthlyInterestRate;
		
		//String strMonthlyInterest = df.format(monthlyInterest);
		
		return monthlyInterest;
	}

	/**
	 * Calculates the monthly fee of checking account
	 * @return monthlyFee The monthly fee associated with a specific checking account
	 */
	@Override
	public double monthlyFee() {
		
		//DecimalFormat df = new DecimalFormat("0.00");
		double monthlyFee;
		final double threshold = 1500;
		final double checkingMonthlyFee = 25;
		
		if(directDeposit == true || getBalance() >= threshold) {
			monthlyFee = 0;
		}
		else {
			monthlyFee = checkingMonthlyFee;
		}

		//String strMonthlyFee = df.format(monthlyFee);
		
		return monthlyFee;
	}
	
	/**
	 * Converts Checking account to its String representation
	 * @return accountInfo The String representation of Checking object
	 */
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
	
	/**
	 * Checks if Checking is equivalent to obj being compared to.
	 * Checks if obj instanceof Checking and if all data fields are equivalent
	 * @param obj The object being compared to a particular Checking account
	 * @return true if Checking is equivalent to object, false otherwise
	 */
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
		double amount = 500;
		boolean directDeposit = true;
		
		Checking capitalOne = new Checking(Kyle, amount, open, directDeposit);
		System.out.println(capitalOne.monthlyInterest());
		//System.out.println(capitalOne.toString());
		
	}
	
	
}
