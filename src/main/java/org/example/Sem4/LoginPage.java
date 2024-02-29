package org.example.Sem4;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement fieldLogin = $x("//input[@type='text']");
    private final SelenideElement fieldPassword = $("input[type='password']");
    private final SelenideElement buttonLogin = $(".mdc-button__label");

    public void authorize(String login, String password) {
        fieldLogin.shouldBe(visible).setValue(login);
        fieldPassword.setValue(password);
        buttonLogin.click();
    }

}