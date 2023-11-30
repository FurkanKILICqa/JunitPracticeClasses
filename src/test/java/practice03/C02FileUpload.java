package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02FileUpload extends TestBase {

    // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
    // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
    // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
    // 'Press' butonuna basın
    // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
    // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.


    @Test
    public void test01() {

        String denemeYol=System.getProperty("user.home")+"\\Desktop\\deneme.txt";
        //"C:\Users\BURAK\Desktop\deneme.txt"

        System.out.println(denemeYol);

        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.name("note")).sendKeys("Benim Dosyam");
        waitForSecond(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
        driver.findElement(By.name("upfile")).sendKeys(denemeYol);

        waitForSecond(2);
        // 'Press' butonuna basın
        driver.findElement(By.xpath("//input[@value='Press']")).click();
        waitForSecond(2);

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz

        WebElement dosyaNotu= driver.findElement(By.tagName("blockquote"));
        waitForSecond(2);
        Assert.assertEquals("Benim Dosyam",dosyaNotu.getText());

        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.

        WebElement dosyaIcerik=driver.findElement(By.tagName("pre"));
        Assert.assertEquals("Merhaba Dunya",dosyaIcerik.getText());






    }
}
