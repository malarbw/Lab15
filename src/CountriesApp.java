
/*
 * Brad Malarkey
 * 
 * Lab 15-- make a program that will maintain a list of countries in a file
 * 
 */
import java.io.File;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		String filePath = "countries.txt"; // string variable to use with file
		Scanner scan = new Scanner(System.in);
		String cont = "y";
		int userPick = 0;
		CountriesTextFile country = new CountriesTextFile(""); // create object to be able to add new countries

		File file = new File(filePath);
		System.out.println("Welcome to the Countries Maintenence Application!");
		System.out.println();

		do {
			System.out.println("1 - See the list of countries."); // prompt menu to help the user
			System.out.println("2 - Add a country");
			System.out.println("3 - Exit");
			System.out.println();

			userPick = Validator.getInt(scan, "Enter menu number: ", 1, 3);// get a number from the user between 1-3

			if (userPick == 1) { // runs the method for reading the file if user enters 1
				CountriesTextFile.readFromFile("");
			} else if (userPick == 2) {// runs method for writing to the file if user enters 2
				CountriesTextFile.writeToFile("countries.txt");
			}
		} while ((userPick == 1) || (userPick == 2)); // loops through so long as the user doesnt enter quit option

		System.out.println("Goodbye!");

	}

}
