
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
		if (year < o.getYear()) {
			return -1;
		}
		else if (year > o.getYear()) {
			return 1;
		}
		else {
			if (month < o.getMonth()) {
				return -1;
			}
			else if (month > o.getMonth()) {
				return 1;
			}
			else { 
				if (day < o.getDay()) {
					return -1;
				}
				else if (day > o.getDay()) {
					return 1;
				}
				else {
					return 0;
				}
			}
			
		}
		
	}
	
	public String toString() { //in the format mm/dd/yyyy
		String dateStr = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
		return dateStr;
	}
	
	
	public boolean isValid() { 
		
		if ((year < 0) || (month < 1) || (month > 12) || (day < 1) || (day > 31)) {
			return false;
		}
		
		switch (month) {
		case 1: return true;
		case 2: return (isLeap(year) ? day <= 29 : day <= 28);
		case 3: return true;
		case 4: return day < 31;
		case 5: return true;
		case 6: return day < 31;
		case 7: return true;
		case 8: return true;
		case 9: return day < 31;
		case 10: return true;
		case 11: return day < 31;
		default: return true;
		
		}
		
	}
	
	private boolean isLeap(int year) {
		if (year % 4 != 0) {
			return false;
		}
		else if (year % 400 == 0) {
			return true;
		}
		else if (year % 100 == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	


}
