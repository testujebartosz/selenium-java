package exercises.alertsiframewindow;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;


public class NewWindowTest {


    @Test
    public void testNewWindow() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        String currentWindow = driver.getWindowHandle();
        driver.findElement(By.id("newPage")).click();
        Set<String> windowNames = driver.getWindowHandles();
        for (String window : windowNames) {
            //jeśli nazwa jest inna to przełącz do nowego okna
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
            }
        }
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='L2AGLb']/div"));
        agreeButton.click();
        driver.switchTo().defaultContent();
        WebElement q = driver.findElement(By.cssSelector("[name='q']"));
        q.sendKeys("Selenium");
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Bartosz");
    }

}
