package exercises.mytests;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static exercises.ReUsable.checkOption;

public class TestSecond {

    @Test
    public void someActionsTest() {
        WebDriver driver = ReUsable.getDriver("chrome");

        final String mainPageUrl = "https://testeroprogramowania.github.io/selenium/basics.html";
        driver.get(mainPageUrl);
        final String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, mainPageUrl);

        final String pageTitle = "Strona testowa";
        final String currentPageTitle = driver.getTitle();
        Assert.assertEquals(currentPageTitle, pageTitle);

        driver.findElement(By.id("clickOnMe")).click();
        driver.switchTo().alert().accept();

        WebElement w3Link = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        Assert.assertEquals(w3Link.getText(), "Visit W3Schools.com!");

        WebElement carOptions = driver.findElement(By.cssSelector("select"));
        Select carSelect = new Select(carOptions);
        WebElement firstSelectedOption = carSelect.getFirstSelectedOption();
        List<WebElement> carSelectOptions = carSelect.getOptions();

        Assert.assertEquals(4, carSelectOptions.size());
        Assert.assertEquals(firstSelectedOption.getText(), "Audi");
        for (WebElement cars : carSelectOptions) {
            System.out.println(cars.getText());
        }
        checkOption("Mercedes", carOptions);

        driver.findElement(By.cssSelector("input[type='checkbox']")).click();
        WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));
        usernameInput.clear();
        usernameInput.sendKeys("Bartosz");

        driver.get("https://onet.pl");
        driver.quit();
    }
}
