import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author joshua.atienza
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
		double balance = 24000;
		Date dateOpened = new Date("09/26/2020");
		
		MoneyMarket mm = new MoneyMarket(jra, balance, dateOpened);
		
		double expectedInterest = 13;
		double result = mm.monthlyInterest();
		
		assertEquals(expectedInterest, result);
		
	}

	/**
	 * Test method for {@link MoneyMarket#monthlyFee()}.
	 * Tests possible test cases for calculating monthly fee in MoneyMarket
	 */
	@Test
	void testMonthlyFee() {
		
		//Case 1: MoneyMarket has > 6 withdrawals, balance >= threshold of 2500
		Profile js = new Profile("Jasmine","Shen");
		double balance1 = 2500;
		Date dateOpened1 = new Date("09/16/2020");
		
		
		
		MoneyMarket shen = new MoneyMarket(js, balance1, dateOpened1);
		
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		shen.setWithdrawals();
		
		
		double expectedFee1 = 12;
		double result1 = shen.monthlyFee();
		
		assertEquals(expectedFee1, result1);
		
		
		//Case 2: MoneyMarket has > 6 withdrawals, balance < threshold of 2500
		Profile at = new Profile("Alissa","Tsai");
		double balance2 = 500;
		Date dateOpened2 = new Date("02/14/2020");
		
		MoneyMarket tsai = new MoneyMarket(at, balance2, dateOpened2);
		
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		tsai.setWithdrawals();
		
		double expectedFee2 = 12;
		double result2 = tsai.monthlyFee();
		
		assertEquals(expectedFee2, result2);
		
		
		//Case 3: MoneyMarket has <= 6 withdrawals, balance >= threshold of 2500
		Profile jc = new Profile("Joanna","Cui");
		double balance3 = 4000;
		Date dateOpened3 = new Date("10/02/2020");
		
		MoneyMarket cui = new MoneyMarket(jc, balance3, dateOpened3);
		
		cui.setWithdrawals();
		cui.setWithdrawals();
		
		double expectedFee3 = 0;
		double result3 = cui.monthlyFee();
		
		assertEquals(expectedFee3, result3);
		
		
		//Case 4: MoneyMarket has <= 6 withdrawals, balance < threshold of 2500
		Profile cc = new Profile("Cleo","Chang");
		double balance4 = 200;
		Date dateOpened4 = new Date("08/10/2020");
		
		MoneyMarket changg = new MoneyMarket(cc, balance4, dateOpened4);
		
		changg.setWithdrawals();
		
		double expectedFee4 = 12;
		double result4 = changg.monthlyFee();
		
		assertEquals(expectedFee4, result4);
		
		
	}

}
