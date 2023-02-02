package exercises.locatingelements;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class CssSelectorsTest {

    private WebDriver driver;

    @Test
    public void findElementsByCss() {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //# = id & . = class
        driver.findElement(By.cssSelector("#clickOnMe"));
        driver.findElement(By.cssSelector(".topSecret"));
        driver.findElement(By.cssSelector("[class='topSecret']"));

        driver.findElement(By.cssSelector("input")).sendKeys("Pierwszy");
        driver.findElement(By.cssSelector("[name='fname']"));
        driver.findElement(By.cssSelector("[href='https://www.w3schools.com']"));

        By allTags = By.cssSelector("*");
        driver.findElement(allTags);

        By firstChild = By.cssSelector("div > ul");
        driver.findElement(firstChild);

        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormAfterLabel);

        By attrTag = By.cssSelector("input[name='fname']");
        By attrContains = By.cssSelector("[name*='name']");
        By attrStarts = By.cssSelector("[name^='f'");
        By attrEnds = By.cssSelector("[name$='ame']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);

        driver.quit();
    }
}
