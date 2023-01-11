package Pages;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private SelenideElement emailField = $(By.xpath("//input[@id='email']"));
    private SelenideElement passwordField = $(By.xpath("//input[@id='pass']"));
    private SelenideElement signInButton = $(By.xpath("//button[@id='send2']"));
    private SelenideElement menuTabMen = $(By.xpath("//a[@id='ui-id-5']"));
    private SelenideElement menuItemTops = $(By.xpath("//a[@id='ui-id-17']"));
    private SelenideElement menuItemJackets = $(By.xpath("//a[@id='ui-id-19']"));


    public LoginPage(String pageURL) {
        super(pageURL);
    }

    public void loginAsUser(String email, String password) {
        emailField.setValue(email);
        passwordField.setValue(password);
        signInButton.click();
    }

    public AccountPage returnAccountPage() {
        return new AccountPage(WebDriverRunner.getWebDriver().getCurrentUrl());
    }

    public void goToJacketPage() {
        menuTabMen.hover();
        menuItemTops.hover();
        menuItemJackets.click();
    }

    public CatalogPage returnCatalogPage() {
        return new CatalogPage(WebDriverRunner.getWebDriver().getCurrentUrl());
    }
}
