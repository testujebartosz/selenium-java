package exercises.testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public static WebDriver driver;

    //przed całym zestawem testów
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before suite");
    }

    //przed klasą
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After class");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("I am running before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I am running before method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I am running after test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I am running after method");
    }
}
