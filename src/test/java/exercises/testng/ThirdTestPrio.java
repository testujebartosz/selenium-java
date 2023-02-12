package exercises.testng;

import org.testng.annotations.Test;

public class ThirdTestPrio extends BaseTest {

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
}
