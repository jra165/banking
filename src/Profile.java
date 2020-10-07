
public class Profile {
	
	private String fname;
	private String lname;

	public Profile(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public String get_fname() {
		return fname;
	}
	
	public String get_lname() {
		return lname;
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == this) {
			return true;
		}
		
		if (obj instanceof Profile) {
			Profile person = (Profile) obj;	
			return fname.equals(person.get_fname()) && lname.equals(person.get_lname()); 	 
		}
		
		return false;
	}
	
}
