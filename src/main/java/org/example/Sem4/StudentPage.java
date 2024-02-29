package org.example.Sem4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class StudentPage {

    private final SelenideElement userButton = $x("//ul[@class='svelte-1rc85o5']/li[3]");
    private final SelenideElement profileButton = $x("//ul[@role='menu']/li[1]");
    private ElementsCollection rowsInDummies = $$x("//table[@aria-label='Dummies list']/tbody/tr");

    private RowDummyPage getRowByID(String id) {

        rowsInDummies.shouldHave(sizeGreaterThan(0));
        List<SelenideElement> rowsInDummiesList = new ArrayList<>();
        for (SelenideElement element : rowsInDummies) {
            rowsInDummiesList.add(element);
        }
        return rowsInDummiesList.stream().map(RowDummyPage::new)
                .filter(row -> row.getIdDummy().equals(id)).findFirst().orElseThrow();
    }

    public void openEditingDummyById(String id) {
        getRowByID(id).clickEditButton();

    }

    public String getNameDummyById(String id) {
        return getRowByID(id).getNameDummy();
    }

    public void openCredentialsModalById(String id) {
        getRowByID(id).clickCredentialButton();
    }

    public void openProfilePage() {
        Selenide.sleep(5000L);
        userButton.shouldBe(visible).click();
        profileButton.shouldBe(visible).click();
    }
}