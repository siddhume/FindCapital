# FindCapital


Under FindCapital/src/test/java/ you will find 2 files

TestCapitals.java is the testNG file where I have written test cases to validate positive and negative scenario’s.
These test cases have been written using the TestNG Framework, and can be run as a testNG Test or through the mvn test command.

The UserInput.java file is the Application which prompts the user to enter either a code or country name and returns the capital

## Steps to run the tests:
1. Clone the folder

```git clone https://github.com/siddhume/FindCapital.git```

2. change directory to FindCapital

```cd FindCapital```

3. Run following command to run tests

```mvn clean test```

4. To see the results of the tests

```cd ./target/surefire-reports/```

5. Open index.html in the browser



===========================================================

## Steps to run main program from eclipse
1. Open project in eclipse

2. Run the UserInput.java under src/test/java as a Java Application

===========================================================

## Please see the following log of a sample test execution:


![image](https://user-images.githubusercontent.com/66041042/83098343-33d29f00-a05f-11ea-9a6b-c00a80c067cd.png)


Run using mvn test

![image](https://user-images.githubusercontent.com/66041042/83098542-d559f080-a05f-11ea-8d32-d41671c97595.png)

 Below is the screenshot of one workflow:

![image](https://user-images.githubusercontent.com/66041042/83098893-a4c68680-a060-11ea-9b4f-e4235cfc4e89.png)

In the first prompt in the above workflow after running the program as a JavaApplication you will be prompted to enter 1 if you would like to search the capital by providing the country name, 2 if you would like to search the capital by providing the code of the country, or you can exit the app by typing exit.

In the example above I have entered 1, and in the next prompt have entered the country germany and got the capital-Berlin, in the next prompt I typed in the country France and got the result of Paris as the capital.

Any time you want to change your search type from searching capital with country to searching capital with code just type in the code, and your search type will change.

Then you can enter the code of the country and get the capital back. In the example above I typed in "ca" as the code and got back Ottawa as the Capital of Canada

To get a list of the codes of the country see:https://www.iban.com/country-codes

Anytime you want to exit the program pleast type exit to exit.

I have used RestAssured libraries with Java in order to retrieve the capital from the Rest API provided.

If you have any additional questions dont hesitate in reaching my at 949 310 2054, or through email at siddhume90@gmail.com.

Thank you




