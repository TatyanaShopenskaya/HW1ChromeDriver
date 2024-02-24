package Sem1;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerfectGbTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static String USERNAME;
    private static String PASSWORD;


    @BeforeAll
    public static void setupClass(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        USERNAME = System.getProperty("geekbrains-username", System.getenv("geekbrains-username"));
        PASSWORD = System.getProperty("geekbrains-password", System.getenv("geekbrains-password"));
    }

    @BeforeEach
    public void setupTest(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test

    public void testStandGeekBrains(){
        driver.get("https://test-stand.gb.ru/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#login input[type='text]"))).sendKeys(USERNAME);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#login input[type='text]"))).sendKeys(PASSWORD);
        driver.findElement(By.cssSelector("form#login button")).click();
        WebElement loginButton = driver.findElement(By.cssSelector("formlogin button"));  //создали кнопку
        loginButton.click();                                                              //кликнули
        wait.until(ExpectedConditions.invisibilityOf(loginButton));                       //подождали исчезновения

        WebElement usernameLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(USERNAME)));
        assertEquals(String.format("Hello, %s",USERNAME), usernameLink.getText().replace("\n"," ").trim());

    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }
}
