
public class Person {

	protected String firstName;
	protected String lastname;
	protected String phoneNumber;
		
		
	public Person(){};
		
	public Person(String fname, String lname, String phone) {
		this.firstName = fname;
		this.lastname = lname;
		this.phoneNumber = phone;
	}
	
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setLastName(String lname) {
		this.lastname = lname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public void setPhone(String phone) {
		this.phoneNumber = phone;
	}
	
	public String getNumber() {
		return this.phoneNumber;
	}
}