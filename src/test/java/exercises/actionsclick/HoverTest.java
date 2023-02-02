package exercises.actionsclick;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HoverTest {

    @Test
    public void hoverTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        Actions actions = new Actions(driver);
        WebElement h1 = driver.findElement(By.tagName("h1"));

        actions.moveToElement(h1).perform();
    }
}
