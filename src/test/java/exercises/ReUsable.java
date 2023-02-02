package exercises;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ReUsable {

    public static WebDriver getDriver(final String browser) {
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

    public static boolean checkOption(final String optionValue, final WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        //enhanced for Loop
        for (WebElement option : options) {
            if(option.getText().equalsIgnoreCase(optionValue)){
                return true;
            }
        }
        return false;
    }
}
