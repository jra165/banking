import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * The DateTest class is the JUnit test class, where the method isValid is tested with individual test cases
 * Each test case uses the assertFalse or assertTrue methods to validate dates
 * @author Joshua Atienza, Kyle Lee
 *
 */
class DateTest {

	/**
	 * Test method for {@link Date#isValid()}.
	 * Displays all test cases for isValid() method
	 * Accounts for generally invalid years, months, and days
	 * Validates proper days for specific months as well.
	 */
	@Test
	void testIsValid() {
		
		//Case 1: Invalid Year, where year < 0
		Date d1 = new Date("09/26/-5");
		assertFalse(d1.isValid()); //expected output is false
		
		
		//Case 2a: Invalid Month, where month < 1
		Date d2a = new Date("0/1/2020");
		assertFalse(d2a.isValid());
		
		
		//Case 2b: Invalid Month, where month > 12
		Date d2b = new Date("13/1/2020");
		assertFalse(d2b.isValid());
		
		
		//Case 3a: Invalid day (in general), where day < 1
		Date d3a = new Date("09/0/2020");
		assertFalse(d3a.isValid());
		
		
		//Case 3b: Invalid day (in general), where day > 31
		Date d3b = new Date("10/32/2020");
		assertFalse(d3b.isValid());
		
		
		//Case 4: Valid day in January
		Date d4 = new Date("01/31/2020");						//there are 31 days in January
		assertTrue(d4.isValid());
		
		
		//Case 5a: Valid day in February
		Date d5a = new Date("02/01/2020");
		assertTrue(d5a.isValid());
		
		
		//Case 5b: Valid leap year day in February
		Date d5b = new Date("02/29/2020");						//2020 is a leap year
		assertTrue(d5b.isValid());
		
		
		//Case 5c: Invalid leap year day in February
		Date d5c = new Date("02/29/2019");						//2019 is not a leap year
		assertFalse(d5c.isValid());
		
		
		//Case 6: Valid day in March
		Date d6 = new Date("03/31/2020");						//there are 31 days in March
		assertTrue(d6.isValid());
		
		
		//Case 7a: Valid day in April
		Date d7a = new Date("04/01/2020");
		assertTrue(d7a.isValid());
		
		
		//Case 7b: Invalid day in April, > 30 days
		Date d7b = new Date("04/31/2020");						//there are not 31 days in April
		assertFalse(d7b.isValid());
		
		
		//Case 8: Valid day in May
		Date d8 = new Date("05/31/2020");
		assertTrue(d8.isValid());
		
		
		//Case 9a: Valid day in June
		Date d9a = new Date("06/01/2020");
		assertTrue(d9a.isValid());
		
		
		//Case 9b: Invalid day in June, > 30 days
		Date d9b = new Date("06/31/2020");						//there are not 31 days in June
		assertFalse(d9b.isValid());
		
		
		//Case 10: Valid day in July
		Date d10 = new Date("07/31/2020");
		assertTrue(d10.isValid());
		
		
		//Case 11: Valid day in August
		Date d11 = new Date("08/31/2020");
		assertTrue(d11.isValid());
		
		
		//Case 12a: Valid day in September
		Date d12a = new Date("09/01/2020");
		assertTrue(d12a.isValid());
		
		
		//Case 12b: Invalid day in September, > 30 days
		Date d12b = new Date("09/31/2020");						//there are not 31 days in September
		assertFalse(d12b.isValid());
		
		
		//Case 13: Valid day in October
		Date d13 = new Date("10/31/2020");
		assertTrue(d13.isValid());
		
		
		//Case 14a: Valid day in November
		Date d14a = new Date("11/1/2020");
		assertTrue(d14a.isValid());
		
		
		//Case 14b: Invalid day in November, > 30 days
		Date d14b = new Date("11/31/2020");						//there are not 31 days in November
		assertFalse(d14b.isValid());
		
		
		//Case 15: Valid day in December
		Date d15 = new Date("12/31/2020");
		assertTrue(d15.isValid());
		
		
	}

}
