import java.util.Comparator;

public class Address extends Person {

	protected String street;
	protected String city;
	protected String state;
	protected String zip;
	
	public Address() {}
	
	public Address(String fname, String lname, String street, String city, String state, String zip, String phone) {
		super(fname, lname, phone);
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return this.state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getZip() {
		return this.zip;
	}
	
	public void displayEntry() {
		System.out.println("Entry information:");
		System.out.println("First Name: " + super.getFirstName());
		System.out.println("Last Name: " + super.getLastName());
		System.out.println("Street: " + this.street);
		System.out.println("City: " + this.city);
		System.out.println("State: " + this.state);
		System.out.println("Zip: " + this.zip);
		String phone = super.getNumber().trim();
		System.out.println("Phone Number: (" + phone.substring(0,3) + ")-" + phone.substring(3,6) + "-" + phone.substring(6));
	}
}
 class Comp implements Comparator<Address>{
	 
	 @Override
	 public int compare(Address a, Address b) {
		 if(Long.parseLong(a.getNumber().trim()) > Long.parseLong(b.getNumber().trim())) {
			 return 1;
		 }
		 else return -1;
		 
	}
}