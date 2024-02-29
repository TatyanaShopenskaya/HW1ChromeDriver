package org.example.Sem4;

import com.codeborne.selenide.SelenideElement;

public class RowDummyPage {
    private final SelenideElement root;

    public RowDummyPage(SelenideElement root) {
        this.root = root;
    }

    public String getIdDummy() {
        return root.$x("./td[1]").text();
    }

    public String getNameDummy() {
        return root.$x("./td[2]").text();
    }

    public void clickEditButton() {
        root.$x("./td[7]/button[2]").click();
    }

    public void clickCredentialButton() {

        root.$x("./td[7]/button[1]").click();
    }
}