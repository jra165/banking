import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author joshua.atienza
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
		double balance = 24000;
		Date dateOpened = new Date("09/26/2020");
		boolean directDeposit = true;
		
		Checking checking = new Checking(jra, balance, dateOpened, directDeposit);
		
		double expectedInterest = 1;
		double result = checking.monthlyInterest();
		
		assertEquals(expectedInterest, result);
		
	}

	/**
	 * Test method for {@link Checking#monthlyFee()}.
	 * Tests possible test cases for calculating monthly fee in Checking
	 */
	@Test
	void testMonthlyFee() {
		
		//Case 1: Checking account is direct deposit, balance >= threshold of 1500
		Profile kl = new Profile("Kyle", "Lee");
		double balance1 = 2000 ;
		Date dateOpened1 = new Date("02/26/2020");
		boolean directDeposit1 = true;
		
		Checking lee = new Checking(kl, balance1, dateOpened1, directDeposit1);
		
		double expectedFee1 = 0;
		double result1 = lee.monthlyFee();
		
		assertEquals(expectedFee1, result1);
		
		//Case 2: Checking account is direct deposit, balance < threshold of 1500
		Profile jp = new Profile("JP", "Edralin");
		double balance2 = 500 ;
		Date dateOpened2 = new Date("04/11/2020");
		boolean directDeposit2 = true;
		
		Checking edralin = new Checking(jp, balance2, dateOpened2, directDeposit2);
		
		double expectedFee2 = 0;
		double result2 = edralin.monthlyFee();
		
		assertEquals(expectedFee2, result2);
		
		
		//Case 3: Checking account is NOT direct deposit, balance >= threshold of 1500
		Profile oz = new Profile("Owen", "Zhang");
		double balance3 = 2000 ;
		Date dateOpened3 = new Date("11/19/2020");
		boolean directDeposit3 = false;
		
		Checking zhang = new Checking(oz, balance3, dateOpened3, directDeposit3);
		
		double expectedFee3 = 0;
		double result3 = zhang.monthlyFee();
		
		assertEquals(expectedFee3, result3);
		
		//Case 4: Checking account is NOT direct deposit, balance < threshold of 1500
		Profile kc = new Profile("Ken", "Chang");
		double balance4 = 100 ;
		Date dateOpened4 = new Date("07/11/2020");
		boolean directDeposit4 = false;
		
		Checking chang = new Checking(kc, balance4, dateOpened4, directDeposit4);
		
		double expectedFee4 = 25;
		double result4 = chang.monthlyFee();
		
		assertEquals(expectedFee4, result4);
		
	}

}
