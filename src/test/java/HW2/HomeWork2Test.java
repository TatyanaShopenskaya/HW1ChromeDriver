package HW2;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.Sem2.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.example.Sem2.*;


    public class HomeWork2Test extends AbstractTest {

        // 1.Логин в систему не вводя ни логин, ни пароль. На странице появляется ошибка, нужно проверить её текст
        @Test
        void loginWithErrorTest() {
            driver.get("https://test-stand.gb.ru/login");

            LoginPage loginPage = new LoginPage(driver, wait);
            loginPage.loginWithOutLoginAndPassword();

            WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//h2[@class='svelte-uwkxn9']")));
            Assertions.assertEquals("401", error.getText());
        }

        // 2.
        // - Открываем модальное окно для редактирования dummy
        //- Редактируем имя
        //- Сохраняем
        //- Проверяем в таблице Dummies по ID, что имя изменилось
        @Test

        void changeNameTest() throws InterruptedException {
            driver.get("https://test-stand.gb.ru/login");

            LoginPage loginPage = new LoginPage(driver, wait);
            loginPage.loginInSystem("GB202309fef0812", "73bca41767");

            WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//a[@href='/about']")));
            Assertions.assertEquals("About", search.getText());

            StudentPage studentPage = new StudentPage(driver, wait);
            studentPage.editStudent("27419");

            WebElement searchId = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath(" //span[@slot='title']")));
            Assertions.assertEquals("Editing Dummy 27419", searchId.getText());

            String newName = "New name testing";

            EditingDummyPage editingDummyPage = new EditingDummyPage(driver, wait);
            editingDummyPage.ChangeDummyFirstName(newName);

            String checkName = studentPage.getStudentNameByid("27419");
            Assertions.assertNotEquals(newName, checkName);
        }


        //3.
        // - Тест на проверку модального окна Credentials
        //- Открыть модальное окно на созданном Dummy
        //- Проверить заголовок и статический контент

        @Test
        void credentialsModalWindowTest() throws InterruptedException {
            driver.get("https://test-stand.gb.ru/login");
            LoginPage loginPage = new LoginPage(driver, wait);
            loginPage.loginInSystem("GB202309fef0812", "73bca41767");

            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='/about']")));
            Assertions.assertEquals("About", element.getText());
            StudentPage studentPage = new StudentPage(driver, wait);
            studentPage.checkStudent("27419");

            WebElement titleSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //h2[@id='simple-title']")));
            WebElement loginPasswordSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //div[@id='simple-content']")));
            WebElement closeButtonSearch = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //div[@class='mdc-dialog__actions']/button/span")));

            Assertions.assertEquals("Dummy credentials", titleSearch.getText());
            Assertions.assertTrue((loginPasswordSearch.getText().contains("Login")));
            Assertions.assertTrue((loginPasswordSearch.getText().contains("PW")));
            Assertions.assertEquals("CLOSE", closeButtonSearch.getText());
        }
    }


