package exercises.executorjs;

import exercises.ReUsable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumTest {

    private WebDriver driver;

    @Test
    public void openGooglePage() {
        driver = ReUsable.getDriver("chrome");

        driver.manage().window().maximize();
        Dimension windowSize = new Dimension(900, 600);
        driver.manage().window().setSize(windowSize);
        driver.get("https://www.google.pl/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('https://www.onet.pl/','blank','height=200,width=200')");
        driver.close();
    }

    @Test
    public void asyncScriptTest() {
        driver = ReUsable.getDriver("firefox");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/V4/");
        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

        long startTime = System.currentTimeMillis();
        executor.executeAsyncScript("window.setTimeout(arguments[arguments.length -1],5000);");
        System.out.println("Passed time: " + (System.currentTimeMillis() - startTime));
    }

    @Test
    public void executeScriptTest() {
        driver = ReUsable.getDriver("chrome");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("http://demo.guru99.com/V4/");

        WebElement button = driver.findElement(By.name("btnLogin"));
        driver.findElement(By.name("uid")).sendKeys("mngr468050");
        driver.findElement(By.name("password")).sendKeys("qAmugAp");

        executor.executeScript("arguments[0].click();", button);
        executor.executeScript("alert('Welcome to Guru99');");


    }

}
