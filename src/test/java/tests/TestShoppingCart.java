package tests;

import Pages.CatalogPage;
import Pages.LoginPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.Property;

import java.io.IOException;

public class TestShoppingCart {
    String loginPageURL = "https://magento.softwaretestingboard.com/customer/account/login";
    LoginPage loginPage = new LoginPage(loginPageURL);

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulShoppingCartFirst() throws IOException {

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
    }

    @Test
    void successfulShoppingCartSecond() throws IOException {
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
    }
}
