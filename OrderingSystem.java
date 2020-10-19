import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class Grocery {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// add arrays here for each column of customer data table
		ArrayList<Integer> client_number_array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
		ArrayList<String> client_names_array = new ArrayList<>(Arrays.asList("Watson, John", "Offner, Frederick",
				"Moriarty, James", "Holmes, Sherlock", "Eberli, Christine", "PEP, Inc."));
		ArrayList<String> category_array = new ArrayList<>(
				Arrays.asList("Produce", "Sundries", "Dairy & Bakery", "Meat"));
		ArrayList<String> product_description_array = new ArrayList<>(Arrays.asList("Bananas", "Toilet Paper",
				"Skim Milk", "Canned Tuna", "Roma Tomatoes", "Laundry Detergent", "Cottage Cheese",
				"Chicken Breast", "Facial Tissue", "French Bread", "Green Grapes", "Whole Milk", "Sink Cleaner",
				"Real Whipped Cream", "Lettuce", "Hamburger Buns", "Ground Beef", "Carrots", "Croissants", "Round Steak"));
		ArrayList<Double> quantity_array = new ArrayList<>(
				Arrays.asList(1.0, 12.0, 1.0, 1.0, 1.0, 64.0, 4.0, 2.0, 6.0, 1.0, 1.0, 1.0, 8.0, 8.0, 1.0, 1.0, 2.0, 1.0, 6.0, 3.0));
		ArrayList<Double> unit_cost_array = new ArrayList<>(
				Arrays.asList(0.49, 1.50, 3.0, 1.50, 1.0, 92.5, 2.0, 0.95, 4.0, 2.0, 3.0, 3.0, 0.90, 1.65, 0.80, 2.89, 1.90, 0.80, 4.0, 3.50));
		ArrayList<String> discount_type_array = new ArrayList<>(
				Arrays.asList("Student", "Senior", "Birthday", "Corporate", "None"));
		ArrayList<String> delivery_type_array = new ArrayList<>(Arrays.asList("Pick Up", "Next Day", "2 Hours", "Next Week"));
		ArrayList<Double> sales_tax_array = new ArrayList<>(Arrays.asList(.09, .07, .06));

		// obtain today's date
		Date date = new Date();

		// the program's header
		System.out.println("[ Name: Hareem Akram ]");
		System.out.println("-------------------------------\n");
		System.out.println("Today's Date: " + date + "\n");
		System.out.println("******************************************************");
		System.out.println("----Welcome to Northwoods Wholesale Market----");
		System.out.println("******************************************************");
		System.out.println("");

		Boolean loop_flag = true; 
		
		// flag for loop
		while (loop_flag) {
			
			// prompt customer's details for reservation
			client_number_array.add(client_number_array.size() + 1);

			// add new customer data to each array
			System.out.println("Enter Client's Name:");
			String client_name = scan.nextLine();
			client_names_array.add(client_name); 
			
			System.out.println("Enter Product Category:");
			String category = scan.nextLine();
			category_array.add(category);
			
			System.out.println("Enter Product Name:");
			String product = scan.nextLine();
			product_description_array.add(product);

			System.out.println("Enter Quantity:");
			double quantity = scan.nextDouble();
			quantity_array.add(quantity);

			System.out.println("Enter Delivery Type:");
			String delivery = scan.nextLine();
			delivery_type_array.add(delivery);

			System.out.println("Enter Discount Type:");
			String discount = scan.nextLine();
			discount_type_array.add(discount);

			System.out.println("Enter unit cost:");
			double cost = scan.nextDouble();
			cost = Math.round(cost * 100) / 100;
			unit_cost_array.add(cost);

			System.out.println("Sales tax (in decimals | e.g. 0.05 for 5%):");
			double tax = tax = scan.nextDouble();

			sales_tax_array.add(tax);

			int discount_type = 0;
			double discount_amount = 0;

			// if statement to select discount type name
			if (discount.equalsIgnoreCase("student")) {
				discount_type = 1;
			} else if (discount.equalsIgnoreCase("birthday")) {
				discount_type = 2;
			} else if (discount.equalsIgnoreCase("senior")) {
				discount_type = 3;
			} else if (discount.equalsIgnoreCase("corporate") && cost > 2000) {
				discount_type = 4;
			}

			// switch case statement to calculate discount percentage
			switch (discount_type) {
			case 1:
				discount_amount = 0.10;
				break;
			case 2:
				discount_amount = 0.15;
				break;
			case 3:
				discount_amount = 0.20;
				break;
			case 4:
				discount_amount = 0.25;
				break;
			default:
				discount_amount = 0;
			}

			cost = cost * quantity;
			cost = cost * (1 - discount_amount);

			// add the new customer data to each array
			double groceryTotal = cost * (1 + tax);

			String to_print = "\n" + client_number_array.size() + "\t\t" + client_name + "\t\t" + category + "\t\t" + product + "\t\t" + quantity + "\t\t" + cost + "\t\t" + discount + "\t\t" + delivery + "\t\t$" + cost + "\t\t%" + tax + "\t\t" + round(groceryTotal, 2);
	
			System.out.println(to_print);

			System.out.println("Number of items on shopping list: " + client_number_array.size());

			scan.nextLine();
			System.out.println("Would you like to rerun the program? Enter Y for yes, N for no.");
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("n")) {
				loop_flag = false;

				System.out.println("Thanks for shopping with us!");
				System.out.println("Number of items on shopping list: " + client_number_array.size());

				// Printing out all the customers
				for (int i = 0; i < client_number_array.size(); i++) {

					System.out.println(client_number_array.get(i) + "\t\t" + client_names_array.get(i) + "\t\t" + category_array.get(i) + "\t\t" + product_description_array.get(i) + "\t\t" + quantity_array.get(i) + "\t\t" + unit_cost_array.get(i) + "\t\t" + delivery_type_array.get(i) + "\t\t" + sales_tax_array.get(i) + "\t\t" + discount_type_array.get(i));
				}

				break;
			}
		}
		scan.close();
	}

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = BigDecimal.valueOf(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

