import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    private WebDriver driver;

    @Test
    public void openBrowser() {

        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.quit();
    }
}
