import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UserInput {

	public static void main(String[] args) throws IOException {
		// prompt the user for entry
		System.out.println("Would you like to search for the Capital by providing the Name of the Country or the Code?  \n Enter Country or Code ");
		BufferedReader question = new BufferedReader(new InputStreamReader(System.in));

		String answer = question.readLine();
		// if user enters search by country run this code
		if (answer.equalsIgnoreCase("country")) {
			getCapitalGivenCountry();
		}
			
		// if user enters search by code run this code"
		else if (answer.equalsIgnoreCase("code")) {
			getCapitalGivenCode();
		} 
		else {
			System.out.println("Invalid Entry, please run again");
			
		}

	}

	public static String getCapital(String country) {

		RestAssured.baseURI = "https://restcountries.eu/rest/v2/name/";
		String res = given().when().get(country).then().extract().response().asString();

		JsonPath js = new JsonPath(res);

		String capital = js.getString("capital");
		// System.out.println(capital);
		
		String formated = capital.substring(1, capital.length() - 1);

		return formated;

	}

	public static String[] getCapitalWithCountryCode(String code) {

		RestAssured.baseURI = "https://restcountries.eu/rest/v2/alpha/";
		String res = given().when().get(code).then().extract().response().asString();

		JsonPath js = new JsonPath(res);

		String capital = js.getString("capital");

		String country = js.getString("name");

		String[] arr = { country, capital };

		return arr;

	}
	
	// the method below is for testing purpose used in TesCapitals
	public static String getCapitalWithCountryCode1(String code) {

		RestAssured.baseURI = "https://restcountries.eu/rest/v2/alpha/";
		String res = given().when().get(code).then().extract().response().asString();

		JsonPath js = new JsonPath(res);

		String capital = js.getString("capital");

		

		

		return capital;

	}
	
	public static void getCapitalGivenCountry() throws IOException{
		

		System.out.println(
				"Enter country name to get Capital or type exit to exit program(please hit enter key after input): ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String country = reader.readLine();
		
		// while user enters country and not exit return the capital of the country entered by user
		while (!country.equalsIgnoreCase("exit")) {
			
			String capital=getCapital(country);
			System.out.println("The capital of " + country + " is " + capital);
			System.out.println("Enter Country to get Capital or type exit to exit program: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			country = reader.readLine();
		
			
			

		}
		//user enters exit, exit the program
		System.out.println("You have exited the program");

		
	}
	
	
	public static void getCapitalGivenCode() throws IOException {
		System.out.println(
				"Enter country code to get Capital or type exit to exit program(please hit enter key after input): ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String code = reader.readLine();
		while (!code.equalsIgnoreCase("exit")) {
			String[] arr=getCapitalWithCountryCode(code);
			
			if(arr[0]==null) {
				System.out.println("You have entered an invalid Country Code");
				System.out.println("Enter code to get Capital or type exit to exit program: ");
				reader = new BufferedReader(new InputStreamReader(System.in));
				code = reader.readLine();
				
			}
			else {
				System.out.println("The capital of country " +arr[0]+" with code " + code + " is " + arr[1]);
				System.out.println("Enter code to get Capital or type exit to exit program: ");
				reader = new BufferedReader(new InputStreamReader(System.in));
				code = reader.readLine();

		}
		}

		System.out.println("You have exited the program");
	}
}
