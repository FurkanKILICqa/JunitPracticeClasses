package practice01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05CheckBox extends TestBase {

    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin


    @Test
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");


        WebElement chechBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement chechBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement chechBox3 = driver.findElement(By.id("vfb-6-2"));


       if (!chechBox1.isSelected()){
           chechBox1.click();

       }

       if (!chechBox3.isSelected()){
           chechBox3.click();

       }

       Assert.assertTrue(chechBox1.isSelected());


       Assert.assertTrue(chechBox3.isSelected());


        Assert.assertFalse(chechBox2.isSelected());

    }


















}
