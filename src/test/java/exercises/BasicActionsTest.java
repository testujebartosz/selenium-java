package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {

    private WebDriver driver;

    @Test
    public void performAction() {

        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        Assert.assertEquals(basicPageLink.getText(),"Podstawowa strona testowa");
        basicPageLink.click();
        driver.findElement(By.cssSelector("#clickOnMe")).click();

        driver.switchTo().alert().accept();
        driver.findElement(By.id("fname")).sendKeys("Bartosz");
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.clear();
        usernameField.sendKeys("admin");
        //usernameField.sendKeys(Keys.ENTER);
        usernameField.sendKeys(Keys.TAB);

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@value='male']")).click();

        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        cars.selectByIndex(2);
        cars.selectByVisibleText("Saab");
        cars.selectByValue("volvo");

        List<WebElement> carsList = cars.getOptions();
        //enhanced for Loop
        for (WebElement optionCars : carsList) {
            System.out.println(optionCars.getText());
        }
    }
}
