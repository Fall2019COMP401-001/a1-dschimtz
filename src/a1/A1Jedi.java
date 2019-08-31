package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		// Set up scanner object to be used
		Scanner scan = new Scanner(System.in);

		int numberOfItems = scan.nextInt();

		String[][] itemMenu = new String[numberOfItems][2];
		String[] customerItemNameBought = new String[numberOfItems];
		int[] customerItemQuantBought = new int[numberOfItems];
		int[] numberOfCustomersBought = new int[numberOfItems];
		
		// Populate itemMenu
		for (int i=0; i<numberOfItems; i++) {
			itemMenu[i][0] = scan.next();
			itemMenu[i][1] = Double.toString(scan.nextDouble());
			
			customerItemNameBought[i] = itemMenu[i][0];
		}
		
		int numberOfCustomers = scan.nextInt();
		
		String[][] customerName = new String[numberOfCustomers][2];
		
		for (int i=0; i<numberOfCustomers; i++) {
			customerName[i][0] = scan.next();
			customerName[i][1] = scan.next();
			
			int numberOfItemsBought = scan.nextInt();
			int[] itemsBoughtTMP = new int[numberOfItems]; 
			
			for (int j=0; j<numberOfItemsBought; j++) {
				int itemQuantity = scan.nextInt();
				String itemName = scan.next();
				
				// Compare the item name customer bought to customerItemBought and if there's a match add the quantity to itemQuantBought array
				// at that index
				for (int k=0; k<numberOfItems; k++) {
					if (itemName.equals(customerItemNameBought[k])) {
						customerItemQuantBought[k] += itemQuantity;
						itemsBoughtTMP[k] = 1;
					}
				}
			}
			
			for (int j=0; j<itemsBoughtTMP.length; j++) {
				numberOfCustomersBought[j] += itemsBoughtTMP[j];
			}
		}
		
		for (int i=0; i<numberOfItems; i++) {
			if (numberOfCustomersBought[i] == 0) {
				System.out.println("No customers bought " + customerItemNameBought[i]);
			}	else {
				System.out.println(numberOfCustomersBought[i] + " customers bought " + customerItemQuantBought[i] + " " + customerItemNameBought[i]);	
			}

		}
		
		scan.close();
	}
}
