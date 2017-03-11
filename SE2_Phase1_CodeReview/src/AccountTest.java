
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountTest {

	@DataProvider(name="test1")
	public static Object[][] evenNumbers(){
	return new Object[][]{{"ahmed","Score: 5 in game: TOF\n"},
		{"mhmd Assem","Score: 10 in game: MSQ\n"},
		{"AyKlam" , ""}};
}
	@Test(dataProvider="test1")
  public void ShowScore(String name , String Result) {
    Student x = new Student();
		 Assert.assertEquals(Result, x.ShowScore(name));

  }
	
}


