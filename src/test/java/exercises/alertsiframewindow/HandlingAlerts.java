package exercises.alertsiframewindow;

import exercises.ReUsable;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlingAlerts {

    @Test
    public void handlingOfAlerts() {

        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/");

        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        Assert.assertEquals(basicPageLink.getText(),"Podstawowa strona testowa");
        basicPageLink.click();

        driver.findElement(By.id("fname")).sendKeys("Bartosz");
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.clear();
        usernameField.sendKeys("admin");
        usernameField.sendKeys(Keys.ENTER);

        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        driver.switchTo().alert().accept();

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        driver.findElement(By.xpath("//input[@value='male']")).click();
    }
}
