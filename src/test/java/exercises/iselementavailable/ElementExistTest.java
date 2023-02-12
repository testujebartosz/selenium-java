package exercises.iselementavailable;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static exercises.ReUsable.elementExist;
import static exercises.ReUsable.elementExistSecondList;

public class ElementExistTest {

    private WebDriver driver;

    @BeforeMethod
    public void openPage() {
        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
    }

    //element jest dostępny w strukturze HTML, sprawdzanie czy element istnieje
    @Test
    public void elementExistTest() {
        System.out.println(elementExist(By.tagName("p"), driver));
        System.out.println(elementExist(By.id("topSecret"), driver));

        System.out.println(elementExistSecondList(By.tagName("p"), driver));
        System.out.println(elementExistSecondList(By.id("topSecret"), driver));
    }

    @Test
    public void elementDisplayedTest() {
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.id("newPage")).isDisplayed());
    }

    @Test
    public void isElementEnabled() {
        System.out.println(driver.findElement(By.id("clickOnMe")).isEnabled());
    }

    @Test
    public void isCheckBoxSelected() {
        WebElement checkBox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        System.out.println(checkBox.isSelected());
        System.out.println("===============================================");
        checkBox.click();
        System.out.println(checkBox.isSelected());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
