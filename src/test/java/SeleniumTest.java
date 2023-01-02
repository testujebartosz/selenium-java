import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SeleniumTest {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
    }

    @Test
    public void openGooglePage() {
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        Dimension windowSize = new Dimension(200, 200);
        driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.pl/");
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.onet.pl/','blank','height=200,width=200')");
        driver.close();
    }

    public WebDriver getDriver(String browser) {
        switch (browser) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                return new ChromeDriver();
            case "safari":
                return new SafariDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
