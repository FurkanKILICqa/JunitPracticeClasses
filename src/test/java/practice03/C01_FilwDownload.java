package practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FilwDownload extends TestBase {


    @Test
    public void test01() {

        String farkliYol = System.getProperty("user.home");
        System.out.println(farkliYol);
        String ortakYol = "\\Downloads\\some-file.txt";
        String dosyaYolu = farkliYol + ortakYol;

        Path path = Paths.get(dosyaYolu);

        try {
            Files.delete(path);
            System.out.println("Dosya silindi");
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }


        driver.get("https://the-internet.herokuapp.com/download");
        waitForSecond(2);

        driver.findElement(By.linkText("some-file.txt")).click();

        waitForSecond(2);

        //"C:\Users\BURAK      \Downloads\some-file.txt"


        Assert.assertTrue(Files.exists(path));


    }

}
