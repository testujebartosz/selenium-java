package exercises.testng;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static exercises.ReUsable.waitForElementToExist;

public class SoftAssertTest {

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

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(paraText.isDisplayed());
        softAssert.assertEquals(paraText.getText(), "Dopiero się poja", "Teksty są różne");
        softAssert.assertTrue(paraText.getText().startsWith("Dopiero"));
        softAssert.assertFalse(paraText.getText().startsWith("Dopiero"));
        softAssert.assertEquals(paraText.getText(), "Dopiero się pojawiłem!");

        driver.quit();

        softAssert.assertAll();
    }
}
