package org.example.Sem4;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class EditingDummyPage {
    private final SelenideElement firstNameField = $x("//form[@id='upsert-item']/div[1]/label/input");
    private final SelenideElement lastNameField = $x("//form[@id='upsert-item']/div[2]/label/input");
    private final SelenideElement saveButton = $x("//button[@type='submit']");
    private final SelenideElement closButton = $x("//button[@data-mdc-dialog-action='close']");

    public void editDummyName(String firstName, String lastName) {
        firstNameField.shouldBe(visible).setValue(firstName);
        lastNameField.setValue(lastName);
        saveButton.click();
        closButton.click();
    }
}