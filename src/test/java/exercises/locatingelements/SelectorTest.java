package exercises.locatingelements;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    private WebDriver driver;

    @Test
    public void findElements() {

        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        clickOnMeButton.click();
        driver.switchTo().alert().accept();

        driver.findElement(By.name("fname"));
        driver.findElement(By.className("topSecret"));

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("Bartosz");

        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        Assert.assertEquals(inputList.size(), 8);

        WebElement schoolLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        Assert.assertEquals(schoolLink.getText(), "Visit W3Schools.com!");

        driver.findElement(By.partialLinkText("IamW"));
        driver.quit();
    }
}
