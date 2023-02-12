package exercises.iselementavailable;

import exercises.ReUsable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ImageLoadedCorrectly {

    @Test
    public void isImageLoaded() {
        WebDriver driver = ReUsable.getDriver("chrome");
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement smileImage = driver.findElement(By.id("smileImage"));
        String naturalHeight = smileImage.getAttribute("naturalHeight");
        boolean isFirstImageLoaded = Integer.parseInt(naturalHeight) > 0;
        System.out.println(naturalHeight);
        Assert.assertTrue(isFirstImageLoaded);

        driver.get("https://testeroprogramowania.github.io/selenium/image.html");
        WebElement smileImageSecond = driver.findElement(By.id("smileImage"));
        String naturalHeightSecond = smileImageSecond.getAttribute("naturalHeight");
        boolean isSecondImageLoaded = Integer.parseInt(naturalHeightSecond) == 0;
        System.out.println(naturalHeightSecond);
        Assert.assertTrue(isSecondImageLoaded);

        driver.quit();
    }
}
