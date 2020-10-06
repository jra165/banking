
public class Date implements Comparable<Date> {

	private int year;
	private int month;
	private int day;
	
	public Date(String date) {
		String[] dateParsed = date.split("/");
		this.month = Integer.parseInt(dateParsed[0]);
		this.day = Integer.parseInt(dateParsed[1]);
		this.year = Integer.parseInt(dateParsed[2]);
	}
	
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	@Override
	public int compareTo(Date o) {
		return 0;
	}
	
	public String toString() { //in the format mm/dd/yyyy
		String dateStr = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
		return dateStr;
	}
	
	
	// Account for hella edge cases (leap years, 30/31, 28 in feb, etc.) 
	public boolean isValid() { 
		//if (year > 1 && year < 12 &&) 
		return true;
	}
	

}
