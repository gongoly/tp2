import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {
    WebDriver driver;
    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.google.com");

    }
    @After
    public  void quitBrowser()
    {
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException
    {
      String expected = "French language - Wikipedia";
      WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
      barreRecherche.sendKeys("french");
      barreRecherche.sendKeys(Keys.ENTER);
      WebElement premierResultat = driver.findElement(By.cssSelector(".rc >.r > a"));
        Assert.assertEquals(expected, premierResultat.getText());
      Thread.sleep(1000);


    }
    @Test
    public void testClick() throws InterruptedException
    {
        WebElement barreRecherche = driver.findElement(By.id("lst-ib"));
        barreRecherche.sendKeys("canelé");
      //  Thread.sleep(1000);
        WebElement buttonRecherche = driver.findElement(By.cssSelector(".rc >.r > a"));
        buttonRecherche.click();
        Thread.sleep(1000);
    }
}
