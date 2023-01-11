package tests;

import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Property;

import java.io.IOException;


public class TestLogin {
    String loginPageURL = "https://magento.softwaretestingboard.com/customer/account/login";
    LoginPage loginPage = new LoginPage(loginPageURL);

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulLogin() throws IOException {
        loginPage.openPage();
        loginPage.loginAsUser(Property.getProperty("email"), Property.getProperty("password"));
        loginPage.returnAccountPage().verifyPageHeader(Property.getProperty("username"));
    }
}
