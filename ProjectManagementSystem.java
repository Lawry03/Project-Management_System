//
//																							 CAPSTONE PROJECT ONE
//																							 COMPUSULSORY TASK 2
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Import all the required modules.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
// Class name.
public class ProjectManagementSystem {
	public static void main(String[] args) throws IOException {
		while(true) {
			// While loop to ensure that the program runs continuously.
			System.out.println("\n\t*************************************************************************\n\t------------------------------------------------------------------------");
			System.out.println("\n\t\t\t*****       POISED ENGINEERING\t    *****\n\t\t\t*****   PROJECT MANAGEMENT SYSTEM   *****\n\n\t------------------------------------------------------------------------ ");
			// Prompt user for input to determine selection.
			int option = mainMenuSelection();
			if(option == 1) {
				System.out.println("\n\n\n\t\t****************   PROJECT REGISTRATION   ***************\n\n\tPROJECT INFORMATION");
				// To register a new project create a Customer,Architect and a Contractor for the project.
				String jobDiscription = "Customer";
				Person customer = createPerson(jobDiscription);
				jobDiscription = "Architect";
				Person architect = createPerson(jobDiscription);
				jobDiscription = "Contractor";
				Person contractor = createPerson(jobDiscription);
				// Create project.
				Project project = createProject(customer.getLastName(),customer,architect,contractor);
				System.out.println(project);
				// Write information to file.
				String fileContent = readFileContent();
				writeFileContent(fileContent,project.writeToFile(),customer.writeToFile(),architect.writeToFile(),contractor.writeToFile());
				returnToMenu();
			}else if(option == 2) {
				System.out.println("\n\n\n\t***********************   EDIT EXSISTING PROJECT   ***********************\n");
				// To edit a project the project should already exist, Request user to enter valid project number.
				String projectNumber = projectNumberSelection();
				editproject(projectNumber);
				returnToMenu();
			}else if(option == 3) {
				System.out.println("\n\n\n\t\t***************   VIEW EXSISTING PROJECT   ***************\n\n");
				// Print out the file content within the CurrentProject.txt file which contains information of existing projects. 
				printAllProjects();
				returnToMenu();
			}
		}
	}public static int mainMenuSelection() {
		// This method returns an integer used for the main menu selection.
		boolean mainMenu = true;
		int option = 0;
		while(mainMenu == true) {
			//While loop to ensure a valid input is entered.
			System.out.print("\n\t\t\t\t  --- MAIN MENU ---\n\n\t\t------|  To register a new project press  ---- '1' |------\n\t\t------|  To edit a project press          ---- '2' |------\n\t\t------|  To veiw exsisting projects press ---- '3' |------\n\n\t\t\t\t\t----> : ");
			try {
				Scanner input = new Scanner(System.in);
				option = input.nextInt();
				if(option == 1 || option == 2 || option == 3) {
					mainMenu = false;
				}else {
					// Error message.
					System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
					continue;
				}
			}catch(InputMismatchException ex) {
				//Error message.
				System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
			}
		}return option;
	}public static String requestFirstName(String discription) {
		// This Method prompts the user for a First Name input and is directed to the 'Job Description' parameter. Eg : Customer, Architect, Contractor.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t"+ discription.toUpperCase() +" DETAILS -\n\n\t- Please enter the "+ discription + "'s First Name\t\t: ");
		input = new Scanner(System.in);
		String firstName = input.nextLine();
		return firstName;
		
	}public static String requestLastName(String discription) {
		// This Method prompts the user for a Last Name input and is directed to the 'Job Description' parameter. Eg : Customer, Architect, Contractor.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the " + discription + "'s Last Name\t\t\t: ");
		input = new Scanner(System.in);
		String lastName = input.nextLine();
		return lastName;
		
	}public static String requestPhysicalAddress(String discription) {
		// This Method prompts the user for a Physical Address input and is directed to the 'Job Description' parameter. Eg : Customer, Architect, Contractor.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the "+ discription + " Physical Address\t\t: ");
		input = new Scanner(System.in);
		String physicalAddress = input.nextLine();
		return physicalAddress;
		
	}public static String requestTelephoneNumber(String discription) {
		// This Method prompts the user for a Telephone Number input and is directed to the 'Job Description' parameter. Eg : Customer, Architect, Contractor.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the "+ discription + " Telephone Number\t\t: ");
		input = new Scanner(System.in);
		String telephoneNumber = input.nextLine();
		return telephoneNumber;
		
	}public static String requestEmailAddress(String discription) {
		// This Method prompts the user for an Email Address input and is directed to the 'Job Description' parameter. Eg : Customer, Architect, Contractor.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the "+ discription + " Email Address\t\t: ");
		input = new Scanner(System.in);
		String emailAddress = input.nextLine();
		return emailAddress;
		
	}public static String requestProjectName() {
		// This Method prompts the user for a Project Name.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the Project Name\t\t\t\t: ");
		input = new Scanner(System.in);
		String projectName = input.nextLine();
		return projectName;
		
	}public static String requestProjectNumber() {
		// This Method prompts the user for a Project Number.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the Project Number\t\t\t: ");
		String projectNumber = input.nextLine();
		return projectNumber;	
		
	}public static String requestBuildingType() {
		// This Method prompts the user for the type of Building.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the Building Type\t\t\t: ");
		input= new Scanner(System.in);
		String buildingType = input.nextLine();
		return buildingType;
		
	}public static String requestProjectAddress() {
		// This Method prompts the user for the Project Address.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the Project Address\t\t\t: ");
		input= new Scanner(System.in);
		String projectAddress = input.nextLine();
		return projectAddress;
		
	}public static int requestErfNumber() {
		// This Method prompts the user for an integer ERF number allocated to the project.
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.print("\n\n\t- Please enter the Property ERF Number\t\t\t: ");
			try {
				int erfNumber = input.nextInt();
				return erfNumber;
			}catch(InputMismatchException ex) {
				System.out.println("\n\n\t\t---- INVALID ERF-NUMBER ENTERED ----\n\t\t\t\tTRY AGAIN");
			}	
		}	
	}public static double requestTotalFee() {
		// This Method prompts the user for a double value of the Total fee the project will cost.
		while(true) {
			Scanner input = new Scanner(System.in);
			System.out.print("\n\n\t- Please enter the Project Total Fee Paid to Date\t R ");
			try {
				double projectTotalFee = input.nextDouble();
				return projectTotalFee;
			}catch(InputMismatchException ex) {
				System.out.println("\n\n\t\t---- INVALID AMOUNT ENTERED ----\n\t\t\t\tTRY AGAIN");
			}		
		}
	}public static String requestProjectDeadline() {
		// This Method prompts the user for the Project Deadline.
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\t- Please enter the Project Deadline\t\t\t: ");
		input = new Scanner(System.in);
		String projectDeadline = input.nextLine();
		return projectDeadline;
		
	}public static Person createPerson(String discription) {
		// This Method creates and returns a "PERSON" datatype object.
		String jobDiscription = discription;
		String firstName = requestFirstName(jobDiscription);
		String lastName = requestLastName(jobDiscription);
		String physicalAddress = requestPhysicalAddress(jobDiscription);
		String telephoneNumber = requestTelephoneNumber(jobDiscription);
		String emailAddress = requestEmailAddress(jobDiscription);
		Person person = new Person(firstName, lastName,telephoneNumber,emailAddress,jobDiscription, physicalAddress);
		return person;
		
	}public static Project createProject(String lastName,Person customer, Person architect, Person contractor) {
		// This Method creates and returns a "PROJECT" datatype object.
		double amountsPaid = 0.0;
		System.out.println("\n\n\t**************************************************************************\n\n\tPROJECT DETAILS -\n");
		String projectName = requestProjectName();
		String projectNumber = requestProjectNumber();
		String buildingType = requestBuildingType();
		String projectAddress = requestProjectAddress();
		int erfNumber = requestErfNumber();
		double totalFee = requestTotalFee();
		String projectDeadline = requestProjectDeadline();
		System.out.println("\n\n\t\t\t\tPROJECT ACCEPTED\n\n\t**************************************************************************\n\n");
		if(projectName.length() <= 1) {
			projectName = buildingType + " " + lastName;
		}
		Project project = new Project(projectName,projectAddress,buildingType,projectNumber,erfNumber,totalFee,projectDeadline,amountsPaid,customer,architect,contractor);
		return project;
		
	}public static String returnToMenu() {
		// This Method is to return back to the main menu.
		boolean menu = true;
		String option = " ";
		while(menu == true) {
			System.out.print("\n\n\t\t------|  To return to MAIN-MENU press ---- 'e' |------\n\n\t\t\t\t\t----> : ");
			try {
				Scanner input = new Scanner(System.in);
				option = input.nextLine();
				if(option.equals("e") || option.equals("E")) {
					menu = false;
				}else{
					continue;
				}
			}catch(InputMismatchException ex) {
				continue;
			}	
		}
		return option;
		
	}public static int secondMenuSelection() {
		// This method prompts the user for an input used to determined weather to edit an architects details, a contractors details or a projects information.
		boolean menu = true;
		int selectedOption = 0;
		while(menu == true) {
			System.out.print("\n\t\t------|  To Edit Architect Details press  ---- '1' |------\n\t\t------|  To Edit Contractor Details press ---- '2' |------\n\t\t------|  To Edit 'Project' Details press  ---- '3' |------\n\n\t\t\t\t\t----> : ");
			try {
				Scanner input = new Scanner(System.in);
				selectedOption = input.nextInt();
				if(selectedOption == 1 || selectedOption == 2 || selectedOption == 3 ) {
					menu = false;
				}else {
					System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
					continue;
				}
			}catch(InputMismatchException ex) {
				System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
			}
		}return selectedOption;
		
	}public static String readFileContent() throws FileNotFoundException {
		// This Method reads the file content and returns the content as a string.
		File file = new File("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt");
		Scanner scan = new Scanner(file);
		String fileContent = "";
		while(scan.hasNextLine()) {
			fileContent = fileContent.concat(scan.nextLine() + "\n");
		}
		return fileContent;
		
	}public static void writeFileContent(String fileContent, String projectInformation, String customerInformation, String architectInformation, String contractorInformation) throws IOException {
		// This Method writes the new data to the file.
		FileWriter writer = new FileWriter("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt");
		writer.write(fileContent);
		writer.write(projectInformation + customerInformation + architectInformation + contractorInformation +  "\n");
		writer.close();	
	}public static ArrayList<String> validProjectNumber() throws IOException {
		// This method checks the valid project numbers and returns an array of strings.
		ArrayList<String> validProjectNumbers = new ArrayList<String>();
		File file = new File("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			String[] splittedInformation = currentLine.split(",");
			validProjectNumbers.add(splittedInformation[1]);
		}
		return validProjectNumbers;
		
	}public static String projectNumberSelection() throws IOException {
		// This method prompts the user for a project number and validates the project number and returns a string.
		ArrayList<String> validProjectNumber = validProjectNumber();
		while(true) {
			System.out.println("\n\t\tValid Project Numbers ---> : " + validProjectNumber);
			System.out.print("\n\tEnter the 'Project Number' for the Project you wish to Edit : ");
			Scanner input = new Scanner(System.in);
			try {
				String selection = input.nextLine();
				if(validProjectNumber.contains(selection)) {
					return selection;
				}else {
					System.out.println("\n\n\t\t\t---- INVALID PROJECT NUMBER PLEASE TRY AGAIN ----\n\n");
				}
			}catch(InputMismatchException e) {
				System.out.println("\n\n\t\t\t---- INVALID PROJECT NUMBER PLEASE TRY AGAIN ----\n\n");
			}
		}
	}public static void printAllProjects () throws FileNotFoundException {
		// This method reads the file data and unpacks it to be displayed and print all existing projects.
		File file = new File("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			String currentLine = scan.nextLine();
			String[] splittedInformation = currentLine.split(",");
			Person customer = new Person(splittedInformation[8], splittedInformation[9],splittedInformation[11],splittedInformation[12],splittedInformation[10], splittedInformation[13]);
			Person achitect = new Person(splittedInformation[14], splittedInformation[15],splittedInformation[17],splittedInformation[18],splittedInformation[16], splittedInformation[19]);
			Person contractor = new Person(splittedInformation[20], splittedInformation[21],splittedInformation[23],splittedInformation[24],splittedInformation[22], splittedInformation[25]);
			Project project = new Project(splittedInformation[0], splittedInformation[2],splittedInformation[3],splittedInformation[1],Integer.valueOf(splittedInformation[4]), Double.valueOf(splittedInformation[5]),splittedInformation[6],Double.valueOf(splittedInformation[7]),customer,achitect,contractor);
			System.out.println(project);
		}
	}public static void editproject (String projectNumber) throws IOException {
		// This Methods uses the class getters and setters to change project information and write the new information to the existing file.
		String fileContents = readFileContent();
		String[] fileLines = fileContents.split("\n");
		int numOfLines = fileLines.length; 
		for(int i = 0 ; i <= (numOfLines - 1) ; i++ ) {
			String[] splittedInformation = fileLines[i].split(",");
			if(projectNumber.equals(splittedInformation[1])) {
				Person customer = new Person(splittedInformation[8], splittedInformation[9],splittedInformation[11],splittedInformation[12],splittedInformation[10], splittedInformation[13]);	
				Person achitect = new Person(splittedInformation[14], splittedInformation[15],splittedInformation[17],splittedInformation[18],splittedInformation[16], splittedInformation[19]);	
				Person contractor = new Person(splittedInformation[20], splittedInformation[21],splittedInformation[23],splittedInformation[24],splittedInformation[22], splittedInformation[25]);
				Project project = new Project(splittedInformation[0], splittedInformation[2],splittedInformation[3],splittedInformation[1],Integer.valueOf(splittedInformation[4]), Double.valueOf(splittedInformation[5]),splittedInformation[6],Double.valueOf(splittedInformation[7]),customer,achitect,contractor);
				int secondOption = secondMenuSelection();
				if(secondOption == 1) {
					System.out.println(project.displayProject());
					System.out.println("\n\tARCHITECT DETAILS -\t\t\tPROJECT NUMBER " + projectNumber);
					System.out.println(achitect.displayPersonInfo());
					int thirdSelection = thirdMenuSelection();
					if(thirdSelection == 1) {
						String telephoneNumber = requestTelephoneNumber("new");
						achitect.setTelephoneNumber(telephoneNumber);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}else if(thirdSelection == 2) {
						String emailAddress = requestEmailAddress("new");
						achitect.setEmailAddress(emailAddress);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}else if(thirdSelection == 3) {
						String physicalAddress = requestPhysicalAddress("new");
						achitect.setPhysicalAddress(physicalAddress);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}
				}else if(secondOption == 2) {
					System.out.println(project.displayProject());
					System.out.println("\n\tCONTRACTOR DETAILS -\t\t\tPROJECT NUMBER " + projectNumber);
					System.out.println(contractor.displayPersonInfo());
					int thirdSelection = thirdMenuSelection();
					if(thirdSelection == 1) {
						String telephoneNumber = requestTelephoneNumber("new");
						contractor.setTelephoneNumber(telephoneNumber);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}else if(thirdSelection == 2) {
						String emailAddress = requestEmailAddress("new");
						contractor.setEmailAddress(emailAddress);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}else if(thirdSelection == 3) {
						String physicalAddress = requestPhysicalAddress("new");
						contractor.setPhysicalAddress(physicalAddress);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}
				}else if (secondOption == 3) {
					System.out.println("\n\tPROJECT NAME : " + project.getProjectName().toUpperCase() + "\t\t\tPROJECT NUMBER : " + projectNumber);
					System.out.println(project.displayProject());
					int thirdOption = editProjectMenu();
					if(thirdOption == 1) {
						System.out.print("\n\t\tEnter The New Project Deadline\t: ");
						Scanner input = new Scanner(System.in);
						String dueDate = input.nextLine();
						project.setProjectDeadline(dueDate);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}else if (thirdOption == 2 ) {
						double feePaid = requestTotalFee();
						project.setAmountPaid(feePaid);
						writeEditedProject(projectNumber,project.writeToFile(),customer.writeToFile(),achitect.writeToFile(),contractor.writeToFile());
						System.out.println("\n\n\t\t\t\t\t***** UPDATED *****");
					}else if(thirdOption == 3) {
						// To Finalise a project.
						finaliseProject(project);
					}
				}
			}else {
				continue;
			}
		}
	}public static int thirdMenuSelection() {
		// This method prompts the user for an input used to determined weather to edit the telephone number, Email Address or the Physical Address.
		boolean menu = true;
		int selectedOption = 0;
		while(menu == true) {
			System.out.print("\n\n\t\t------|  To Edit Telephone Number press  ---- '1' |------\n\t\t------|  To Edit Email Address press     ---- '2' |------\n\t\t------|  To Edit Physical Address press  ---- '3' |------\n\n\t\t\t\t\t----> : ");
			try {
				Scanner input = new Scanner(System.in);
				selectedOption = input.nextInt();
				if(selectedOption == 1 || selectedOption == 2 || selectedOption == 3 ) {
					menu = false;
				}else {
					System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
					continue;
				}
			}catch(InputMismatchException ex) {
				System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
			}
		}return selectedOption;
	}public static void writeEditedProject(String projectNumber, String projectInfo, String customerInfo, String architectInfo, String contractorInfo) throws IOException {
		// This Method rewrites the edited information to the file.
		String fileContent = readFileContent();
		String[] fileLines = fileContent.split("\n");
		int lineNum = fileLines.length;
		FileWriter clearFile = new FileWriter("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt");
		clearFile.close();
		for(int i = 0; i <= (lineNum - 1) ; i++) {
			String[] splittedInfo = fileLines[i].split(",");
			if(projectNumber.equals(splittedInfo[1])) {
				FileWriter writer = new FileWriter("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt", true);
				writer.write(projectInfo + customerInfo + architectInfo + contractorInfo + "\n");
				writer.close();
				continue;
			}
			FileWriter writer = new FileWriter("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CurrentProjects.txt", true);
			writer.write(fileLines[i] + "\n");
			writer.close();
		}
	}public static int editProjectMenu() {
		// This method prompts the user for an input integer input used to determine weather to edit the due date, amount paid or to Finalise the project
		boolean menu = true;
		int selectedOption = 0;
		while(menu == true) {
			System.out.print("\n\t\t------|  To Change Project Due Date press  ---- '1' |------\n\t\t------|  To Change Amounts Paid press      ---- '2' |------\n\t\t------|  To Finalise 'Project' press       ---- '3' |------\n\n\t\t\t\t\t----> : ");
			try {
				Scanner input = new Scanner(System.in);
				selectedOption = input.nextInt();
				if(selectedOption == 1 || selectedOption == 2 || selectedOption == 3 ) {
					menu = false;
				}else {
					System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
					continue;
				}
			}catch(InputMismatchException ex) {
				System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
			}
		}return selectedOption;
	}public static void finaliseProject(Project project) throws IOException {
		// This Method Finalises the selected project.
		System.out.println("\n\n\n\t***********************   FINALISE CURRENT PROJECT   ***********************\n");
		System.out.println(project.displayProject());
		if(project.getProjectTotalFee() != project.getAmountPaid()) {
			System.out.print("\n\n\t\t\tPOISED ENGINEERING\n\tINVOICE\n\n\tClient Full Names\t: " + project.getCustomer().getFirstName() + " " + project.getCustomer().getLastName() + " \n\n\tEmail Address\t\t\t: " + project.getCustomer().getEmailAddress() + "\n\tTelophone Number\t\t: " + project.getCustomer().getTelephoneNumber() + "\n\tPysical Address\t\t\t: " + project.getCustomer().getPhysicalAddress() );
			System.out.print("\n\n\tTotal Cost of Project\t\t R " + project.getProjectTotalFee() + "\n\tAmount Paid to Date\t\t R " + project.getAmountPaid() + "\n\t-----------------------------------------------------------------\n\tANOUNT DUE\t\t\t R" );
			System.out.format(" %.2f",amountDue(project.getProjectTotalFee(),project.getAmountPaid()));
			System.out.println("\n\t-----------------------------------------------------------------\n\n");
		}
		int selection = markProjectFinalised(project);
		if(selection == 1) {
			System.out.println("\n\n\t\t\t**** FINALISING PROJECT ******");
			FileWriter writer = new FileWriter("/Users/Jason/Dropbox/Musenge jason Mwansa-95855/Introduction to Software Engineering/Task 7/CompletedProject.txt");
		}else {
			return;
		}
	}public static double amountDue(double totalCost, double totalAmountPaid) {
		// This Method calculates the Amount due for invoicing.
		return totalCost - totalAmountPaid;
	}public static int markProjectFinalised(Project project) {
		// Method to mark project as finalised.
		boolean menu = true;
		int selectedOption = 0;
		while(menu == true) {
			System.out.println("\n\t\t      PROJECT NAME : " + project.getProjectName().toUpperCase() + "\t\tPROJECT NUMBER : " + project.getProjectNumber() );
			System.out.print("\n\t\t------|  To Mark Current Project as 'FINALISED' press  ---- '1' |------\n\t\t------|  To Exit press\t\t\t\t       ---- '2' |------\n\n\t\t\t\t\t----> : ");
			try {
				Scanner input = new Scanner(System.in);
				selectedOption = input.nextInt();
				if(selectedOption == 1 || selectedOption == 2) {
					menu = false;
				}else {
					System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
					continue;
				}
			}catch(InputMismatchException ex) {
				System.out.println("\n\n\t\t\t---- INVALID INPUT PLEASE TRY AGAIN ----\n\n");
			}
		}return selectedOption;
	}
}