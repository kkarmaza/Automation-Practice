package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage extends BasePage {
    private SelenideElement titlePage = $(By.xpath("//span[@data-ui-id='page-title-wrapper']"));

    public AccountPage(String pageURL) {
        super(pageURL);
    }

    public void verifyPageTitle(String title) {
        Assertions.assertEquals(titlePage.getText(), title);
    }
}
