package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int numberOfItems = scan.nextInt();
		
		// Initialize itemMenu with the following columns: Item name, price
		String[][] itemMenu = new String[numberOfItems][2];
		
		// Read each item name, item price into itemMenu
		for (int i=0; i<numberOfItems; i++) {
			itemMenu[i][0] = scan.next();
			itemMenu[i][1] = Double.toString(scan.nextDouble());
		}
		
		// Read in the number of customers
		int numberOfCustomers = scan.nextInt();
		
		// Initialize customerInfo string array which will have the following columns: firstname, lastname, total spent
		String[][] customerInfo = new String[numberOfCustomers][3];
		
		// Loop over the amount of customers
		for (int i=0; i<numberOfCustomers; i++) {
			
			// Read in the first and last name and store it in customerInfo. total spent will be stored later
			String firstname = scan.next();
			customerInfo[i][0] = firstname;
			String lastname = scan.next();
			customerInfo[i][1] = lastname;
			
			// Read in number of items customer i bought
			int numberPurchasedItems = scan.nextInt();
			
			// initialize array purchased itemsBought filled with: Item name, item quantity
			String[][] itemsBought = new String[numberPurchasedItems][2];
			
			// Loop over each item purchased by customer and read in item quantity and item name into itemsBought
			for (int j=0; j<numberPurchasedItems; j++) {
				
				// Read in item quantity into first column
				itemsBought[j][0] = scan.next(); 
				//System.out.println(itemsBought[j][0]);
				
				// Read in item name into second column
				itemsBought[j][1] = scan.next();
				//System.out.println(itemsBought[j][1]);
			}
			// itemsBought array is now filled with item quantities and item names for customer i
			
			// This for loop is used to go over each item name in itemsBought. For each item name, there is a nested for loop
			// that checks over each item in the itemMenu. If they match, it calculates the amount the customer payed, and
			// then move onto the next item the customer bought.
			double total = 0;
			for (int itemIndex=0; itemIndex<numberPurchasedItems; itemIndex++) {
				for (int check=0; check<itemMenu.length; check++) {
					//System.out.println(itemsBought[itemIndex][1]);
					//System.out.println(itemMenu[check][0]);
					if (itemsBought[itemIndex][1].contentEquals(itemMenu[check][0])) {
						double itemprice = Double.parseDouble(itemsBought[itemIndex][0]);
						double itemquantity = Double.parseDouble(itemMenu[check][1]);
						total += itemprice * itemquantity;
					}
				}
			}
			
			// Load in the previously calculated amount payed by customer i
			customerInfo[i][2] = String.format("%.2f",total);
			//System.out.println(customerInfo[i][2]);
			//System.out.println(customerInfo[i][0]);
			//System.out.println(customerInfo[i][1]);
		}			
		scan.close();
		
		double Average = findAvg(customerInfo);
		
		int idxHighestPaying = findMax(customerInfo);
		int idxLowestPaying = findMin(customerInfo);
		
		System.out.println("Biggest: " + customerInfo[idxHighestPaying][0] + " " + customerInfo[idxHighestPaying][1] + " (" + customerInfo[idxHighestPaying][2] + ")");
		System.out.println("Lowest: " + customerInfo[idxLowestPaying][0] + " " + customerInfo[idxLowestPaying][1] + " (" + customerInfo[idxLowestPaying][2] + ")");
		System.out.println("Average: " + String.format("%.2f",  Average));
	}
	/*
	 * Function finds average of the third column of an array
	 * 
	 * Input: Needs to be an array of strings and the values you want to find the average of needs to be in the third column
	 * 
	 * Output: The Average
	 */
	static Double findAvg(String[][] Array) {
		double total = 0;
		for (int i=0; i<Array.length; i++) {
			total = total + Double.parseDouble(Array[i][2]);
		}
		double Average = total / Array.length; 
		return Average;
	}
	/*
	 * This function takes in the customer info array and returns the index of the highest paying customer
	 * 
	 * Input: Needs to be the customerinfo array created in main
	 * 
	 * Output: Index of highest paying customer
	 */
	static int findMax(String[][] Array) {
		int currentHigh = 0;
		for (int i=1; i<Array.length; i++) {
			if (Double.parseDouble(Array[i][2]) > Double.parseDouble(Array[currentHigh][2])) {
				currentHigh = i;
			}
		}
		return currentHigh;
	}
	
	/*
	 * This function takes in the customer info array and returns the index of the lowest paying customer
	 * 
	 * Input: Needs to be the customerinfo array created in main
	 * 
	 * Output: Index of lowest paying customer
	 */
	static int findMin(String[][] Array) {
		int currentLow = 0;
		for (int i=1; i<Array.length; i++) {
			if (Double.parseDouble(Array[i][2]) < Double.parseDouble(Array[currentLow][2])) {
				currentLow = i;
			}
		}
		return currentLow;
	}
}
	

