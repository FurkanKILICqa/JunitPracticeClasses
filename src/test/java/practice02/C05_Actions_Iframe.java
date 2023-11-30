package practice02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions_Iframe extends TestBase {


    @Test
    public void test01() {

        // https://demo.automationtesting.in/Vimeo.html sayfasına gidiniz
        driver.get("https://demo.automationtesting.in/Vimeo.html");
        WebElement video=driver.findElement(By.xpath("//a[text()='Video']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(video).perform();
        waitForSecond(2);
        // ust bolumde bulunan Video menusunun acilmasi icin mouse'u bu menunun ustune getiriniz. Ve Vimeo kısmına tıklayınız.
        driver.findElement(By.xpath("//a[text()='Vimeo']")).click();
        // play tusuna basınız.
        driver.switchTo().frame("foo");
        WebElement playTusu=driver.findElement(By.className("PlayButton_module_playIcon__fc6bec57"));
        playTusu.click();
        waitForSecond(2);
        // 'Automation Demo Site' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        WebElement autoYazi=driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']"));
        Assert.assertTrue(autoYazi.isDisplayed());






    }
}
