import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * The MoneyMarketTest class is a class that runs JUnit Tests on the monthlyInterest/Fee methods of MoneyMarket
 * Each test case uses the assertEquals method to compare expected and actual interest/fees
 * @author Joshua Atienza, Kyle Lee
 *
 */
class MoneyMarketTest {

	/**
	 * Test method for {@link MoneyMarket#monthlyInterest()}.
	 * Tests possible test cases for calculating monthly interest in MoneyMarket
	 */
	@Test
	void testMonthlyInterest() {
		
		Profile jra = new Profile("Joshua", "Reyes");
		final double BALANCE = 24000;								//sample balance
		Date dateOpened = new Date("09/26/2020");
		
		MoneyMarket mm = new MoneyMarket(jra, BALANCE, dateOpened);
		
		final double EXPECTED_INTEREST = 13;						//expected monthly interest
		double result = mm.monthlyInterest();
		
		//checks if expected interest and actual interest are equal
		assertEquals(EXPECTED_INTEREST, result);
		
	}

	/**
	 * Test method for {@link MoneyMarket#monthlyFee()}.
	 * Tests possible test cases for calculating monthly fee in MoneyMarket
	 */
	@Test
	void testMonthlyFee() {
		
		//Case 1: MoneyMarket has > 6 withdrawals, balance >= threshold of 2500
		Profile js = new Profile("Jasmine","Shen");
		final double BALANCE_C1 = 2500;								//sample balance
		Date dateOpened1 = new Date("09/16/2020");
		
		
		MoneyMarket shen = new MoneyMarket(js, BALANCE_C1, dateOpened1);
		
		//set number of withdrawals to 7, which is greater than the threshold
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		
		
		final double EXPECTED_FEE_C1 = 12;							//expected monthly fee
		double result1 = shen.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C1, result1);
		
		
		
		//Case 2: MoneyMarket has > 6 withdrawals, balance < threshold of 2500
		Profile at = new Profile("Alissa","Tsai");
		final double BALANCE_C2 = 500;								//sample balance
		Date dateOpened2 = new Date("02/14/2020");
		
		MoneyMarket tsai = new MoneyMarket(at, BALANCE_C2, dateOpened2);
		
		//set number of withdrawals to 7, which is greater than the threshold
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		
		final double EXPECTED_FEE_C2 = 12;								//expected monthly fee
		double result2 = tsai.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C2, result2);
		
		
		
		//Case 3: MoneyMarket has <= 6 withdrawals, balance >= threshold of 2500
		Profile jc = new Profile("Joanna","Cui");
		final double BALANCE_C3 = 4000;									//sample balance
		Date dateOpened3 = new Date("10/02/2020");
		
		MoneyMarket cui = new MoneyMarket(jc, BALANCE_C3, dateOpened3);
		
		//set number of withdrawals to 2, which is less than the threshold
		cui.setWithdrawals();
		cui.setWithdrawals();
		
		final double EXPECTED_FEE_C3 = 0;								//expected monthly fee
		double result3 = cui.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C3, result3);
		

		
		//Case 4: MoneyMarket has <= 6 withdrawals, balance < threshold of 2500
		Profile cc = new Profile("Cleo","Chang");
		final double BALANCE_C4 = 200;									//sample balance
		Date dateOpened4 = new Date("08/10/2020");
		
		MoneyMarket changg = new MoneyMarket(cc, BALANCE_C4, dateOpened4);
		
		//set number of withdrawals to 1, which is less than the threshold
		changg.setWithdrawals();
		
		final double EXPECTED_FEE_C4 = 12;								//expected monthly fee
		double result4 = changg.monthlyFee();
		
		//checks if expected fee and actual fee are equal
		assertEquals(EXPECTED_FEE_C4, result4);
		
		
	}

}
