package exercises;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOne {

    private WebDriver driver;

    @Test
    public void openGooglePage() {
        driver = ReUsable.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='L2AGLb']/div"));
        agreeButton.click();

        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(By.xpath(("//div/input[@class='gLFyf']")));

        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    public void searchMeczykiWebSite() {
        driver = ReUsable.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='L2AGLb']/div"));
        agreeButton.click();
        driver.switchTo().defaultContent();
        WebElement searchField = driver.findElement(By.cssSelector("[name='q']"));
        searchField.sendKeys("Meczyki");

        WebElement searchButton = driver.findElement(By.cssSelector("input[name='btnK']"));
        jsExecutor.executeScript("arguments[0].click();", searchButton);

        WebElement linkToMeczyki = driver.findElement(By.xpath("//div/a/h3[contains(text(),'Meczyki.pl - Jedyny')]"));
        linkToMeczyki.click();

        driver.quit();
    }
}