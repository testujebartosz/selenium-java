package exercises.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(priority = 0)
    public void firstThirdTest() {
        System.out.println("I am first test");
    }

    @Test(priority = 1)
    public void secondThirdTest() {
        System.out.println("I am second test");
    }

    @Test(priority = 2)
    public void thirdThirdTest() {
        System.out.println("I am third test");
    }

    @Test(dataProvider = "data")
    public void dpTest(String value, String num) {
        System.out.println(value + " " + num);
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{{"I am first test", "First"}, {"I am second test", "Second"}, {"I am third test", "Third"}};
    }
}
