package exercises.waitsolutions;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static exercises.ReUsable.waitForElementToExist;

public class ExpectedConditionsTest {

    WebDriver driver;

    @Test
    public void fluentWaitWebDriverTest() {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        //czekamy na widoczność, z góry zakładamy, że element istnieje w naszej strukturze - wyrzuci wyjątek
       // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p"))));
        //tu sprawdzamy czy element jest widoczny,nie wiemy tego, wyszukiwanie następuje wew. wait'a
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        //driver.findElement(By.cssSelector("p"));

        waitForElementToExist(By.cssSelector("p"), driver);

        driver.quit();
    }


}
