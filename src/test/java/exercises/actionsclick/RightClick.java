package exercises.actionsclick;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClick {

    private WebDriver driver;

    @Test
    public void rightClickTest() {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        Actions actions = new Actions(driver);
        //actions.contextClick().perform();
        actions.contextClick(driver.findElement(By.id("myFile"))).perform();
    }
}
