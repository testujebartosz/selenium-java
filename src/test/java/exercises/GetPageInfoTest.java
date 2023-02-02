package exercises;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetPageInfoTest {

    @Test
    public void getPageInfoTest() {
        WebDriver driver = ReUsable.getDriver("chrome");
        final String mainPageUrl = "https://testeroprogramowania.github.io/selenium/basics.html";
        driver.get(mainPageUrl);

        final String pageTitle = driver.getTitle();
        final String currentUrl = driver.getCurrentUrl();
        System.out.println(pageTitle);
        System.out.println(currentUrl);

        Assert.assertEquals(currentUrl, mainPageUrl);
    }
}
