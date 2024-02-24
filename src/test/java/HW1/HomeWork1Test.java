package HW1;
/**
 * 1) логинимся под своими логином и паролем
 * 2) нажимаем на ‘+’ для добавления dummy
 * 3) вводим имя dummy и логин
 * 4) нажимаем кнопку SAVE
 * 5) проверяем, что dummy с именем появился в таблице
 * - достаточно проверить что появился нужный title
 * - закрывать модальное окно создания dummy не обязательно, таблица и так успешно прочитается
 **/

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;


public class HomeWork1Test {


    WebDriver driver1;
    WebDriverWait wait;

    @BeforeEach
    public void setupTest() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver1 = new ChromeDriver(options);
        wait = new WebDriverWait(driver1, Duration.ofSeconds(20));
        driver1.manage().window().maximize();
        driver1.get("https://test-stand.gb.ru/login");

    }

    @Test
    void loginAndCreateDummy() throws InterruptedException {
        WebElement myLogin = driver1.findElement(By.xpath("//*[@type='text']"));
        WebElement myPassword = driver1.findElement(By.xpath("//*[@type='password']"));
        WebElement buttonLogin = driver1.findElement(By.className("mdc-button__label"));

        myLogin.sendKeys("GB202309fef0812");
        myPassword.sendKeys("73bca41767");
        buttonLogin.click();


        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement buttonPlus = driver1.findElement(By.id("create-btn"));
        WebElement title = driver1.findElement(By.xpath("//*[@type='text']"));

        buttonPlus.click();
        title.sendKeys("New Home Work 1");

        WebElement loginForm = driver1.findElement(By.xpath("//*[@type='text']"));
        WebElement buttonSave = driver1.findElement(By.xpath("//*[@type='submit']"));

        loginForm.sendKeys("GB202309fef0812");
        buttonSave.click();

        List<WebElement> list1 = driver1.findElements(By.xpath("//h1[@class='svelte-tv8alb']"));
        Assertions.assertEquals("New Home Work 1", list1.get(0).getText());

    }
}
