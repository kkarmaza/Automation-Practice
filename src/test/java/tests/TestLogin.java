package tests;

import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Property;
import utils.Logging;
import java.io.IOException;
import java.util.logging.Logger;


public class TestLogin {
    String loginPageURL = "https://magento.softwaretestingboard.com/customer/account/login";
    LoginPage loginPage = new LoginPage(loginPageURL);
    Logger logger = Logger.getLogger(TestLogin.class.getName());


    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Story("Test user login")
    void successfulLogin() throws IOException {
        Logging.getLogProperty();
        logger.info("Test [successfulLogin] started");
        logger.warning("Open Login Page");
        loginPage.openPage();
        loginPage.loginAsUser(Property.getProperty("email"), Property.getProperty("password"));
        loginPage.returnAccountPage().verifyPageTitle("My Account");
        logger.info("Test [successfulLogin]  finished");
    }
}
