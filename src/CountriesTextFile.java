import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CountriesTextFile {
	private String country;

	public CountriesTextFile() {

	}

	public CountriesTextFile(String country) {
		super();
		this.country = country;
	}

	public static void readFromFile(String filePath) {
		Path readFile = Paths.get("countries.txt");
		File file = readFile.toFile();
		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something went wrong.");
			e.printStackTrace();
		}

	}

	public static void writeToFile(String fileString) {
		Scanner scan = new Scanner(System.in);
		String country = null;

		Path writeFile = Paths.get(fileString);

		File file = writeFile.toFile(); // the toFile() converts the path to a file object
		try {
			country = Validator.getString(scan, "Enter a country: ");
			PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));// will append to the end of file

			printOut.println(country);
			System.out.println("Country has been saved to list.");

			printOut.close(); // flushes our data and closes printWriter
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
