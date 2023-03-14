package tests;

import Pages.CatalogPage;
import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Logging;
import utils.Property;

import java.io.IOException;
import java.util.logging.Logger;

public class TestShoppingCart {
    String loginPageURL = "https://magento.softwaretestingboard.com/customer/account/login";
    LoginPage loginPage = new LoginPage(loginPageURL);
    Logger logger = Logger.getLogger(TestLogin.class.getName());


    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @Story("Test Shopping Cart flow1")
    void successfulShoppingCartFirst() throws IOException {
        Logging.getLogProperty();
        logger.info("Test successfulShoppingCartFirst started");
        logger.warning("Open Login Page");
        loginPage.openPage();
        loginPage.loginAsUser(Property.getProperty("email"), Property.getProperty("password"));
        loginPage.goToJacketPage();

        CatalogPage catalogPage = loginPage.returnCatalogPage();

        catalogPage.openMenTops();
        catalogPage.openRainCoat();
        catalogPage.selectListView();
        catalogPage.sortByPrice();
        catalogPage.addProductToCart(1, "M");
        catalogPage.waitForAddingItem();
        catalogPage.clickShoppingCart();
        catalogPage.checkAddedProduct();
        catalogPage.deleteItem();
        catalogPage.checkDeleteMessage();
        catalogPage.confirmDeleting();
        catalogPage.checkNoItemMessage();
        catalogPage.logOut();
        logger.info("Test successfulShoppingCartFirst finished");
    }

    @Test
    @Story("Test Shopping Cart flow2")
    void successfulShoppingCartSecond() throws IOException {
        Logging.getLogProperty();
        logger.info("Test successfulShoppingCartSecond started");
        loginPage.openPage();
        loginPage.loginAsUser(Property.getProperty("email"), Property.getProperty("password"));

        CatalogPage catalogPage = loginPage.returnCatalogPage();

        catalogPage.openMenTops();
        catalogPage.openRainCoat();
        catalogPage.selectListView();
        catalogPage.sortByPrice();
        catalogPage.addProductToCart(2, "L");
        catalogPage.waitForAddingItem();
        catalogPage.clickShoppingCart();
        catalogPage.checkAddedProduct();
        catalogPage.deleteItem();
        catalogPage.checkDeleteMessage();
        catalogPage.confirmDeleting();
        catalogPage.checkNoItemMessage();
        catalogPage.logOut();
        logger.info("Test successfulShoppingCartSecond finished");
    }
}
