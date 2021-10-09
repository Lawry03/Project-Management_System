// Class name.
public class Person {
	// Class Attributes.
	private String firstName;
	private String lastName;
	private String telephoneNumber;	
	private String emailAddress;	
	private String jobDiscription;	
	private String physicalAddress;
	// Constructor.
	public Person(String firstName, String lastName, String telephoneNumber, String emailAddress, String jobDiscription, String physicalAddress){
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.emailAddress = emailAddress;
		this.jobDiscription = jobDiscription;
		this.physicalAddress = physicalAddress;	
	}
	// Getters and setters.
	public String getLastName() {
		return lastName;
	}public void setLastName(String lastName) {
		this.lastName = lastName;
	}public void setTelephoneNumber(String newTelephoneNumber) {
		telephoneNumber = newTelephoneNumber;
	}public void setEmailAddress(String newEmailAddress) {
		emailAddress = newEmailAddress;
	}public void setPhysicalAddress(String newPhysicalAddress) {
		physicalAddress = newPhysicalAddress;
	}public String getFirstName() {
		return firstName;
	}public void setFirstName(String firstName) {
		this.firstName = firstName;
	}public String getJobDiscription() {
		return jobDiscription;
	}public void setJobDiscription(String jobDiscription) {
		this.jobDiscription = jobDiscription;
	}public String getTelephoneNumber() {
		return telephoneNumber;
	}public String getEmailAddress() {
		return emailAddress;
	}public String getPhysicalAddress() {
		return physicalAddress;
	}public String toString() {
		// toString Method.
		String output = "\n\n\t\t\t-  Full Names\t\t: " + firstName.toUpperCase() + " " + lastName.toUpperCase();
		output += "\n\t\t\t-  Discription\t\t: " + jobDiscription;
		output += "\n\t\t\t-  Telephone number\t: " + telephoneNumber;
		output += "\n\t\t\t-  Email Address\t: " + emailAddress.toLowerCase();
		output += "\n\t\t\t-  Physical Address\t: " + physicalAddress;			
		return output;
	}public String writeToFile() {
		// This method it the shape of our data and how the data will be written in the file.
		String projectInformation = firstName;
		projectInformation += "," + lastName;
		projectInformation += "," + jobDiscription;
		projectInformation += "," + telephoneNumber;
		projectInformation += "," + emailAddress;
		projectInformation += "," + physicalAddress + ",";
		return projectInformation;
	}public String displayPersonInfo() {
		// This Method displays the persons information.
		String output = "\n\n\t\t\t-  Full Names\t\t: " + firstName.toUpperCase() + " " + lastName.toUpperCase();
		output += "\n\t\t\t-  Discription\t\t: " + jobDiscription;
		output += "\n\t\t\t-  Telephone number\t: " + telephoneNumber;
		output += "\n\t\t\t-  Email Address\t: " + emailAddress.toLowerCase();
		output += "\n\t\t\t-  Physical Address\t: " + physicalAddress;
		return output;
	}
}