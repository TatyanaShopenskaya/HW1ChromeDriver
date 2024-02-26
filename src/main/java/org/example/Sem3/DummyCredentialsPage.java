package org.example.Sem3;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
public class DummyCredentialsPage {
    private final SelenideElement titleElement = $x("//h2[@id='simple-title']");
    private final SelenideElement contentElement = $x("//div[@id='simple-content']");
    private final SelenideElement buttonCloseElement = $x("//div[@class='mdc-dialog__actions']/button/span");

    public SelenideElement title () {
        return titleElement.shouldBe(visible);
    }

    public SelenideElement loginAndPassword () {
        return contentElement.shouldBe(visible);
    }

    public SelenideElement closeButton () {
        return buttonCloseElement.shouldBe(visible);
    }

}
