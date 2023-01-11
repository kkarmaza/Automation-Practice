package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {
    private SelenideElement titlePage = $(By.xpath("//div[@class='panel header']"));

    public AccountPage(String pageURL) {
        super(pageURL);
    }

    public void verifyPageHeader(String title) {
        titlePage.shouldHave(Condition.text(title));
    }
}
