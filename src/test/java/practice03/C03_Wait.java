package practice03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_Wait extends TestBase {


    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    }

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
        //driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbox'in etkin olmadıgını(enable) test edin

        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(textBox.isEnabled());

        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enable= driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enable.click();

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        // It's enable! mesajının goruntulendigini test edin
        WebElement itsEnabled=driver.findElement(By.id("message"));
        Assert.assertTrue(itsEnabled.isDisplayed());

        // Textbox'in etkin oldugunu(enable) test edin
        Assert.assertTrue(textBox.isEnabled());

    }

    @Test
    public void test02() {

        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        //==>  Remove tuşuna basın
        //==>  "It's gone!" yazısının görünür oldugunu test edin.


        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        //driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //==>  Remove tuşuna basın
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        //==>  "It's gone!" yazısının görünür oldugunu test edin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        //driver.findElement(By.id("message"));
        WebElement itsGone=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGone.isDisplayed());



    }







}
