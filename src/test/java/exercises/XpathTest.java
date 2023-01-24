package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    private WebDriver driver;

    @Test
    public void findElementsByXpath() {

        driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        //przeszukujemy całą strukturę strony
        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By buttonClickOnMe = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(buttonClickOnMe);

        driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("Pierwszy");

        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        By linkText = By.xpath("//a[text() ='Visit W3Schools.com!']");
        driver.findElement(linkText);

        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        driver.findElement(partialLink);

        By lastInput = By.xpath("(//input)[last()]");
        driver.findElement(lastInput);

        By secondInput = By.xpath("(//input)[2]");
        driver.findElement(secondInput);

        By elementWithAttribute = By.xpath("//*[@name]");
        List<WebElement> elementsWithNameAtrr = driver.findElements(elementWithAttribute);
        Assert.assertEquals(elementsWithNameAtrr.size(), 6);

        WebElement clickOnMebtn = driver.findElement(By.xpath("//button[@id='clickOnMe']"));
        clickOnMebtn.click();

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[contains(@name, 'ame')]"));
        driver.findElement(By.xpath("//*[starts-with(@name, 'fname')]"));

        By child = By.xpath("//div/child::ul");
        // dsc - idziemy w dół
        By descendant = By.xpath("//div/descendant::ul");
        // anc = idziemy w górę
        By ancestor = By.xpath("//div/ancestor::*");
        //występują po naszym elemencie
        By followingEle = By.xpath("//img/following::*");
        By followingSiblingEle = By.xpath("//img/following-sibling::*");

        //elementy przed naszym tagiem
        By prec = By.xpath("//img/preceding::*");
        By precSibling = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(descendant);
        driver.findElement(ancestor);
        driver.findElement(followingEle);
        driver.findElement(followingSiblingEle);
        driver.findElement(precSibling);
        driver.findElement(prec);

        By divsAndLinks = By.xpath("//a | //div");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='fname' or @id='fnam']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);

        driver.quit();
    }
}
