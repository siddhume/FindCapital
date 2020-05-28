import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCapitals extends UserInput {
 
	@Test
  public void positiveTestCasesSearchByCountryName() {
	  
	  Assert.assertEquals(getCapital("Afganistan"), "Kabul");
	  Assert.assertEquals(getCapital("USA"), "Washington, D.C.");
	  Assert.assertEquals(getCapital("Iraq"), "Baghdad");
	  Assert.assertEquals(getCapital("Russia"), "Moscow");
	  Assert.assertEquals(getCapital("Canada"), "Ottawa");
	  Assert.assertEquals(getCapital("Brazil"), "Brasília");
	 	  
	  
	  
  }
  
  @Test
 
  public void NegativeTestCasesSearchByCountryName() {
	  
	 Assert.assertNotEquals(getCapital("Afganistan"), "Moscow");
	 Assert.assertNotEquals(getCapital("USA"), "Ottawa");
	 Assert.assertNotEquals(getCapital("Canada"), "Brasília");
	 Assert.assertNotEquals(getCapital("Iraq"), "Kabul");
	 Assert.assertNotEquals(getCapital("Russia"), "Baghdad");
	 
	  
	  
  }
  
  @Test
  public void positiveTestCasesSearchByCode() {
	 
	  Assert.assertEquals(getCapitalWithCountryCode1("AF"), "Kabul");
	  Assert.assertEquals(getCapitalWithCountryCode1("US"), "Washington, D.C.");
	  Assert.assertEquals(getCapitalWithCountryCode1("IQ"), "Baghdad");
	  Assert.assertEquals(getCapitalWithCountryCode1("RU"), "Moscow");
	  Assert.assertEquals(getCapitalWithCountryCode1("CA"), "Ottawa");
	  Assert.assertEquals(getCapitalWithCountryCode1("BR"), "Brasília");
	 	  
	  
	  
  }
  @Test
  public void NegativeTestCasesSearchByCode() {
	  
	  Assert.assertNotEquals(getCapitalWithCountryCode1("BR"), "Kabul");
	  Assert.assertNotEquals(getCapitalWithCountryCode1("CA"), "Washington, D.C.");
	  Assert.assertNotEquals(getCapitalWithCountryCode1("AFG"), "Baghdad");
	  Assert.assertNotEquals(getCapitalWithCountryCode1("CA"), "Moscow");
	  Assert.assertNotEquals(getCapitalWithCountryCode1("US"), "Ottawa");
	  Assert.assertNotEquals(getCapitalWithCountryCode1("IQ"), "Brasília");
	 	  
	  
	  
  }
  
  
  
  
}
