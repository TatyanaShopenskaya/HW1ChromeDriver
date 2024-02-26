package HW3;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.example.Sem3.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.Sem3.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
public class HomeWork3Test extends AbstractTest{

    // 1.Логин в систему не вводя ни логин, ни пароль. На странице появляется ошибка, нужно проверить её текст
    @Test
    void loginWithErrorTest3() {

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginWithOutAuthorization();

        SelenideElement error = $x("//h2[@class='svelte-uwkxn9']").shouldBe(visible);
        Assertions.assertEquals("401", error.text());
    }


    // 2.
    // - Открываем модальное окно для редактирования dummy
    //- Редактируем имя
    //- Сохраняем
    //- Проверяем в таблице Dummies по ID, что имя изменилось
    @Test
    void changeNameTest3() {

        LoginPage loginPage= Selenide.page(LoginPage.class);
        loginPage.loginInSystem("GB202309fef0812", "73bca41767");

        SelenideElement search = $x("//a[@href='/about']").shouldBe(visible);
        Assertions.assertEquals("About", search.text());

        StudentPage studentPage = Selenide.page(StudentPage.class);
        studentPage.editStudent("27419");

        SelenideElement searchId = $x(" //span[@slot='title']").shouldBe(visible);
        Assertions.assertEquals("Editing Dummy 27419", searchId.text());

        String newName = "Seminar 3";

        EditingDummyPage editingDummyPage = Selenide.page(EditingDummyPage.class);
        editingDummyPage.ChangeDummyFirstName(newName);

        String checkName = studentPage.getStudentNameById("27419");
        Assertions.assertNotEquals(newName, checkName);
    }


    //3.
    // - Тест на проверку модального окна Credentials
    //- Открыть модальное окно на созданном Dummy
    //- Проверить заголовок и статический контент
    @Test
    void credentialsWindowTest3() {

        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.loginInSystem("GB202309fef0812", "73bca41767");

        SelenideElement search = $x("//a[@href='/about']").shouldBe(visible);
        Assertions.assertEquals("About", search.text());

        StudentPage studentPage = Selenide.page(StudentPage.class);
        studentPage.checkStudent("27419");

        DummyCredentialsPage dummyCredentialsPage = Selenide.page(DummyCredentialsPage.class);

        Assertions.assertAll(() -> Assertions.assertEquals("Dummy credentials", dummyCredentialsPage
                        .title().getText()),
                () -> Assertions.assertTrue((dummyCredentialsPage.loginAndPassword().text().contains("Login"))),
                () -> Assertions.assertTrue((dummyCredentialsPage.loginAndPassword().text().contains("PW"))),
                () -> Assertions.assertEquals("CLOSE", dummyCredentialsPage.closeButton().text()));
    }
}

