// Class name.
public class Project {
	
	// Class Attributes.
	private String projectName;	
	private String projectAddress;	
	private String buildingType;	
	private String projectNumber;	
	private int projectErfNumber;	
	private double projectTotalFee;	
	private double amountsPaid = 0.0;	
	private String projectDeadline;	
	private Person customer, architect, contractor;
	// Constructor.
	public Project(String projectName, String projectAddress, String buildingType, String projectNumber, int projectErfNumber, double projectTotalFee, String projectDeadline,double amountsPaid, Person customer, Person architect, Person contractor){
		this.projectName = projectName;		
		this.projectAddress = projectAddress;		
		this.buildingType = buildingType;		
		this.projectNumber = projectNumber;		
		this.projectErfNumber = projectErfNumber;		
		this.projectTotalFee = projectTotalFee;		
		this.projectDeadline = projectDeadline;
		this.amountsPaid = amountsPaid;
		this.customer = customer;
		this.architect = architect;
		this.contractor = contractor;
	}
	// Getters and Setters.
	public void setProjectDeadline(String newProjectDeadline) {
		projectDeadline = newProjectDeadline;
	}public String getProjectAddress() {
		return projectAddress;
	}public void setProjectAddress(String projectAddress) {
		this.projectAddress = projectAddress;
	}public String getBuildingType() {
		return buildingType;
	}public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}public String getProjectNumber() {
		return projectNumber;
	}public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}public int getProjectErfNumber() {
		return projectErfNumber;
	}public void setProjectErfNumber(int projectErfNumber) {
		this.projectErfNumber = projectErfNumber;
	}public void setAmountPaid(double newAmountPaid) {
		amountsPaid = newAmountPaid;
	}public String getProjectName() {
		return projectName;
	}public void setProjectName(String projectName) {
		this.projectName = projectName;
	}public double getProjectTotalFee() {
		return projectTotalFee;
	}public void setProjectTotalFee(double projectTotalFee) {
		this.projectTotalFee = projectTotalFee;
	}public Person getCustomer() {
		return customer;
	}public void setCustomer(Person customer) {
		this.customer = customer;
	}public Person getArchitect() {
		return architect;
	}public void setArchitect(Person architect) {
		this.architect = architect;
	}public Person getContractor() {
		return contractor;
	}public void setContractor(Person contractor) {
		this.contractor = contractor;
	}public double getAmountPaid() {
		return amountsPaid;
	}public String getProjectDeadline() {
		return projectDeadline;
	}public String toString() {
		// toString method
		System.out.println("\n\t----------------------    PROJECT INFORMATION    ----------------------");
		String output = "\n\n\t\t\t-  Project Name\t\t: " + projectName;
		output += "\n\t\t\t-  Project Address\t: " + projectAddress;		
		output += "\n\t\t\t-  Building Type\t: " + buildingType;		
		output += "\n\t\t\t-  Project Number\t: " + projectNumber;		
		output += "\n\t\t\t-  Propert ERF Number\t: " + projectErfNumber;		
		output += "\n\t\t\t-  Total Cost\t\t: R" + projectTotalFee;		
		output += "\n\t\t\t-  Project Deadline\t: " + projectDeadline;		
		output += "\n\t\t\t-  Amount Paid to Date\t: R" + amountsPaid;
		output += "\n" + customer;
		output += "\n" + architect;
		output += "\n" + contractor;
		return output;
	}public String writeToFile() {
		// This method it the shape of our data and how the data will be written in the file.
		String projectInformation = projectName;
		projectInformation += "," + projectNumber;
		projectInformation += "," + projectAddress;
		projectInformation += "," + buildingType;
		projectInformation += "," + projectErfNumber;
		projectInformation += "," + projectTotalFee;
		projectInformation += "," + projectDeadline;
		projectInformation += "," + amountsPaid + ",";
		return projectInformation;
	}public String displayProject(){
		// This Method which displays the project information.
		System.out.println("\n\t----------------------    PROJECT INFORMATION    ----------------------");
		String output = "\n\n\t\t\t-  Project Name\t\t: " + projectName;
		output += "\n\t\t\t-  Project Address\t: " + projectAddress;		
		output += "\n\t\t\t-  Building Type\t: " + buildingType;		
		output += "\n\t\t\t-  Project Number\t: " + projectNumber;		
		output += "\n\t\t\t-  Propert ERF Number\t: " + projectErfNumber;		
		output += "\n\t\t\t-  Total Cost\t\t: R" + projectTotalFee;		
		output += "\n\t\t\t-  Project Deadline\t: " + projectDeadline;		
		output += "\n\t\t\t-  Amount Paid to Date\t: R" + amountsPaid;
		return output;
	}
}