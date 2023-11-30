package practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C04_ScreenShot extends TestBase {


    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.
                xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'])[1]")).click();
        waitForSecond(10);
        // tüm sayfanın fotografını cekin
        //1- cekilen scr kaydedecegim bir yer belirliyorum
        String dosyaYolu="src\\test\\java\\utilities\\tumSayfaEkranGoruntusu\\amazon.jpeg";
        //2- tsc objesi deklare edelim
        TakesScreenshot ts= (TakesScreenshot) driver;
        //3-sc al
        //ts.getScreenshotAs(OutputType.BYTES);
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
    }
    @Test
    public void test02() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.
                xpath("(//a[@class='a-link-normal s-underline-text " +
                        "s-underline-link-text s-link-style a-text-normal'])[1]")).click();
        waitForSecond(3);
        //classı her calıstırdıgımızda scr aynı dosyanın uzerine kaydeilmemesi için
        //dosya yolunu her defasında degıstırmeliyiz
       /* LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyMMddHHmmss");//231130124650
        String tarih=dtf.format(ldt);*/
        String tarih= DateTimeFormatter.ofPattern("yyMMddHHmmss").format(LocalDateTime.now());
        String dosyaYolu="src\\test\\java\\utilities\\tumSayfaEkranGoruntusu\\amazon"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void test03() {
        //reusable method olusturup ekran goruntusu alırken onu kullanacagım
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        // ilk ürüne tıklayın
        driver.findElement(By.
                xpath("(//a[@class='a-link-normal s-underline-text " +
                        "s-underline-link-text s-link-style a-text-normal'])[1]")).click();
        waitForSecond(3);
       // screenShot("amazonIlkNutella");
    }
}
