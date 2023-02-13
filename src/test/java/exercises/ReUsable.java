package exercises;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
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
            if (option.getText().equalsIgnoreCase(optionValue)) {
                return true;
            }
        }
        return false;
    }

    public static boolean elementExist(final By locator, final WebDriver driver) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean elementExistSecondList(final By locator, final WebDriver driver) {
          return  driver.findElements(locator).size() > 0;
    }

    public static void waitForElementToExist(By locator, WebDriver driver) {

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);

//        wait.until(new Function<WebDriver, Boolean>() {
//            @Override
//            public Boolean apply(WebDriver driver) {
//                List<WebElement> elements = driver.findElements(locator);
//                if (elements.size() > 0) {
//                    System.out.println("Element jest na stronie");
//                    return true;
//                } else {
//                    System.out.println("Elementu nie ma na stronie");
//                    return false;
//                }
//            }
//        });

        wait.until(driver1 -> {
            List<WebElement> elements = driver1.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element jest na stronie");
                return true;
            } else {
                System.out.println("Elementu nie ma na stronie");
                return false;
            }
        });
    }
}
