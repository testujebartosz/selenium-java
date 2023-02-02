package exercises.actionsclick;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClick {

    private WebDriver driver;

    @Test
    public void doubleClickTest() {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();
    }
}
