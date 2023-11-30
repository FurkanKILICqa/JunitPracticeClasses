package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C06_Actions_iframe_Ddm extends TestBase {



    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void test01() {

        // https://amazon.com adresine gidiniz
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();
        String amazonWindowHandle = driver.getWindowHandle();

        // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
        Actions actions =new Actions(driver);
        actions.moveToElement(driver.findElement(By.
                xpath("//span[@class='icp-nav-flag icp-nav-flag-us icp-nav-flag-lop']"))).perform();

        // Change country/region butonuna basiniz
        waitForSecond(2);
        driver.findElement(By.xpath("(//div[text()='Change country/region.'])[1]")).click();

        // United States dropdown'undan 'Turkey (Türkiye)' seciniz
        WebElement ddm = driver.findElement(By.id("icp-dropdown"));
        Select select =new Select(ddm);
        select.selectByVisibleText("Turkey (Türkiye)");
        waitForSecond(2);
        actions.sendKeys(Keys.ENTER).perform();

        // Go to website butonuna tiklayiniz
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        Set<String> whSet = driver.getWindowHandles();
        String yeniHandle =whSet.toArray()[1].toString();
        driver.switchTo().window(yeniHandle);

        // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz
        waitForSecond(2);
        String title =driver.getTitle();
        Assert.assertTrue(title.contains("Elektronik"));













    }
}
