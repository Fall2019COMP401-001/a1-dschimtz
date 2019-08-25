package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {

		// Set up the scanner object to
		// read space seperated values inputed
		// by the user
		Scanner scan = new Scanner(System.in);
				
		// Read in number of customers to process
		int customercount = scan.nextInt();
		
		for (int j=0; j<customercount; j++) {
			
			// Read in customer first name and call getInitial method
			// to transform the first name to the initial, and then call the last name to be stored into an array later
			String firstname = scan.next();
			String initials = getInitial(firstname);
			String lastname = scan.next();
			lastname += ":";
			
			
			// Initialize string array customers consisting of initials, last name, and total price payed for each customer
			String[][] customerinfo = new String[customercount][3];
			
			// Store initials and last name in customername array
			customerinfo[j][0] = initials;
			customerinfo[j][1] = lastname;
			
			// Read in number of items customer in question bought
			int itemsbought = scan.nextInt();
			
			// Initialize itemsarray that contains three columns: number of items bought, price, total cost.
			// The row of this array will match with the rows of the customername array such that the customer 
			// name and total cost will occupy the same rows in their respective arrays
			
			double[][] itemsarray = new double[itemsbought][2];
			double total = 0;
			
			for (int i=0; i<itemsbought; i++) {
				
				// store the number of said items into itemsarray
				itemsarray[i][0] = scan.nextDouble();
				
				// throwaway item name as it is not necessary and stands in the way
				// of the nextInt
				String throwaway = scan.next();
				
				// store the price of the item into itemsarray
				itemsarray[i][1] = scan.nextDouble();
				
				// calculate and store total cost
				
				total += itemsarray[i][0] * itemsarray[i][1];
			}
			
			customerinfo[j][2] = String.format("%.2f",total);
					
			System.out.println(customerinfo[j][0] + " " + customerinfo[j][1] + " " + customerinfo[j][2]);
			
		}
		
		// Close scan
		
		scan.close();
		
	}
	
	static String getInitial(String firstname) {
		
		// Split input into array such that first letter can be extracted.
		String namearray[] = firstname.split("");
		
		// Extract initial and add a period to the string
		String initials = namearray[0];
		initials += ".";
		
		return initials;
	}
}
