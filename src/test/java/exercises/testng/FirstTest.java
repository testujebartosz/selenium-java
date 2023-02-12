package exercises.testng;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;

import static exercises.ReUsable.waitForElementToExist;

@Listeners(value = {ListenerSampleTest.class})
public class FirstTest extends BaseTest{

    @Test
    public void firstTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        waitForElementToExist(By.cssSelector("p"), driver);

        WebElement paraText = driver.findElement(By.cssSelector("p"));
        Assert.assertTrue(paraText.isDisplayed());
        Assert.assertTrue(paraText.getText().startsWith("Dopiero"));
        Assert.assertFalse(paraText.getText().startsWith("Pojawiłem"));
        Assert.assertEquals(paraText.getText(), "Dopiero się pojawiłem!");
        //z komentarzem
        Assert.assertEquals(paraText.getText(), "Dopiero się pojawiłe", "Teksty są różne");

        driver.quit();
    }

    @Test @Ignore
    public void secondFirstTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        waitForElementToExist(By.cssSelector("p"), driver);

        final String paraText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");

        driver.quit();
    }
}
