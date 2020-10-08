import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * The CheckingTest class is a class that runs JUnit Tests on the monthlyInterest/Fee methods of Checking
 * Each test case uses the assertEquals method to compare expected and actual interest/fees
 * @author Joshua Atienza, Kyle Lee
 * 
 */
class CheckingTest {

	/**
	 * Test method for {@link Checking#monthlyInterest()}.
	 * Tests possible test cases for calculating monthly interest in Checking
	 */
	@Test
	void testMonthlyInterest() {
		
		Profile jra = new Profile("Joshua", "Atienza");
		final double BALANCE = 24000;												//sample balance
		Date dateOpened = new Date("09/26/2020");
		boolean directDeposit = true;
		
		Checking checking = new Checking(jra, BALANCE, dateOpened, directDeposit);
		
		final double EXPECTED_INTEREST = 1;											//expected interest
		double result = checking.monthlyInterest();
		
		//checks if expected interest and actual interest are equal
		assertEquals(EXPECTED_INTEREST, result);
		
	}

	/**
	 * Test method for {@link Checking#monthlyFee()}.
	 * Tests possible test cases for calculating monthly fee in Checking
	 */
	@Test
	void testMonthlyFee() {
		
		//Case 1: Checking account is direct deposit, balance >= threshold of 1500
		Profile kl = new Profile("Kyle", "Lee");
		final double BALANCE_C1 = 2000 ;											//sample balance
		Date dateOpened1 = new Date("02/26/2020");
		boolean directDeposit1 = true;
		
		Checking lee = new Checking(kl, BALANCE_C1, dateOpened1, directDeposit1);
		
		final double EXPECTED_FEE_C1 = 0;											//expected monthly fee
		double result1 = lee.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C1, result1);
		
		
		
		//Case 2: Checking account is direct deposit, balance < threshold of 1500
		Profile jp = new Profile("JP", "Edralin");
		final double BALANCE_C2 = 500 ;												//sample balance
		Date dateOpened2 = new Date("04/11/2020");
		boolean directDeposit2 = true;
		
		Checking edralin = new Checking(jp, BALANCE_C2, dateOpened2, directDeposit2);
		
		final double EXPECTED_FEE_C2 = 0;											//expected monthly fee
		double result2 = edralin.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C2, result2);
		
		
		
		//Case 3: Checking account is NOT direct deposit, balance >= threshold of 1500
		Profile oz = new Profile("Owen", "Zhang");
		final double BALANCE_C3 = 2000 ;											//sample balance
		Date dateOpened3 = new Date("11/19/2020");
		boolean directDeposit3 = false;
		
		Checking zhang = new Checking(oz, BALANCE_C3, dateOpened3, directDeposit3);
		
		final double EXPECTED_FEE_C3 = 0;											//expected monthly fee
		double result3 = zhang.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C3, result3);
		
		
		
		//Case 4: Checking account is NOT direct deposit, balance < threshold of 1500
		Profile kc = new Profile("Ken", "Chang");
		final double BALANCE_C4 = 100 ;												//sample balance
		Date dateOpened4 = new Date("07/11/2020");
		boolean directDeposit4 = false;
		
		Checking chang = new Checking(kc, BALANCE_C4, dateOpened4, directDeposit4);
		
		final double EXPECTED_FEE_C4 = 25;											//expected monthly fee
		double result4 = chang.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C4, result4);
		
	}

}
