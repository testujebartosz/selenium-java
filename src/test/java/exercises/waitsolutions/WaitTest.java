package exercises.waitsolutions;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest {

    @Test
    public void waitTestSleep() throws InterruptedException {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        //test zatrzyma się na 5 sec - czekamy
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("p"));

        driver.quit();
    }

    @Test
    public void waitImplicitlyTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        //definiujemy dla całego skryptu gdy driver nie będzie w stanie znaleźć elementu
        //to driver przez 10 sekund będzie sprawdzał
        //czy ten element jest, jeśli nie to wyjątek zostanie wyrzucony
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        driver.findElement(By.cssSelector("p"));

        driver.quit();
    }

    @Test
    public void explicityWaitWebDriverTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        //wait powiązany z konkretnym miejscem w naszym kodzie
        //WebDriver dziedziczy po klasie FluentWait
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //podajemy warunek korzystając z klasy ExpectedConditions
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        driver.findElement(By.cssSelector("p"));

        driver.quit();
    }

    @Test
    public void fluentWaitWebDriverTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();

        //fluentWait klasa nadrzędna dla WebDriverWait, domysle nie ignorujemy zadnego wyjątku
        //co jakis czas sprawdza czy jest na stronie
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        //sprawdza co 1 sec do momentu osiągnięcia timeoutu
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

        driver.findElement(By.cssSelector("p"));

        driver.quit();
    }
}
