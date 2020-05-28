import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class UserInput {

	public static void main(String[] args) throws IOException {
		// prompt the user for entry

		String answer = promptUser();
		// if user enters search by country run this code
		while (!answer.equalsIgnoreCase("exit")) {
			if (answer.equalsIgnoreCase("1")) {
				getCapitalGivenCountry();
				break;
			}

			// if user enters search by code run this code"
			else if (answer.equalsIgnoreCase("2")) {
				getCapitalGivenCode();
				break;
			} else {
				System.out.println("Invalid Entry, please try again");
				answer = promptUser();

			}
		}
	}
	//initial prompt
	public static String promptUser() throws IOException {
		System.out.println(
				"Would you like to search for the capital of a country by providing the name of the Country or the Code?  \n Enter 1 for Country or 2 for Code or exit to quit");
		BufferedReader question = new BufferedReader(new InputStreamReader(System.in));

		String answer = question.readLine();
		return answer;
	}
	// getCapital() gets the capital of a country from the rest api given country
	// name

	public static String getCapital(String country) {
		try {
			RestAssured.baseURI = "https://restcountries.eu/rest/v2/name/";
			String res = given().when().get(country).then().extract().response().asString();

			JsonPath js = new JsonPath(res);

			String capital = js.getString("capital");
			// System.out.println(capital);

			String formated = capital.substring(1, capital.length() - 1);

			return formated;
		} catch (NullPointerException e) {
			// System.out.print("NullPointerException Caught");
			return "invalid country";
		}
	}

	// getCapitalWithCountryCode gets the capital of a country given the code of a
	// country
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

	// used for userinput country
	public static void getCapitalGivenCountry() throws IOException {

		System.out.println(
				"Enter country name to get Capital or type exit to exit program (please hit enter key after input): ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String country = reader.readLine();

		// while user enters country and not exit return the capital of the country
		// entered by user
		while (!country.equalsIgnoreCase("exit")) {

			String capital = getCapital(country);
			if (capital.equals("invalid country")) {
				System.out.println("You have entered an Invalid Country");
			} else {
				System.out.println("The capital of " + country + " is " + capital);
			}
			System.out.println(
					"Enter Country name to get Capital or type exit to exit program or type code to search by code: ");
			reader = new BufferedReader(new InputStreamReader(System.in));
			country = reader.readLine();
			if (country.equalsIgnoreCase("code")) {

				getCapitalGivenCode();
				break;
			}

		}
		// user enters exit, exit the program
		System.out.println("Thank you");

	}

	// used for user input code
	public static void getCapitalGivenCode() throws IOException {
		System.out.println(
				"Enter country code to get Capital or type exit to exit program (please hit enter key after input): ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String code = reader.readLine();
		while (!code.equalsIgnoreCase("exit")) {
			String[] arr = getCapitalWithCountryCode(code);

			if (arr[0] == null) {
				System.out.println("You have entered an invalid Country Code");
				System.out.println("Enter code to get Capital or type exit to exit program: ");
				reader = new BufferedReader(new InputStreamReader(System.in));
				code = reader.readLine();

			} else {
				System.out.println("The capital of country " + arr[0] + " with code " + code + " is " + arr[1]);
				System.out.println(
						"Enter code to get Capital or type exit to exit program or type country to search by country: ");
				reader = new BufferedReader(new InputStreamReader(System.in));
				code = reader.readLine();

			}
			if (code.equalsIgnoreCase("country")) {
				getCapitalGivenCountry();
				break;

			}
		}

		System.out.println("You have exited the program");
	}
}
