package Email;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Teste paar envio de Email")

public class EmailTest {
    @Test
    public void testePaRaEnvairEmailAoutotatizado() {

        //Abri Navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.manage().window().maximize();

        //Abri Facebook

        navegador.get("https://www.facebook.com/");

        //Fazer Login
        navegador.findElement(By.cssSelector("input[id=\"email\"]")).sendKeys("0@hotmail.com");
        navegador.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Senha");
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        navegador.findElement(By.cssSelector("input[type=\"search\"]")).sendKeys("show me the code");

    }
}
