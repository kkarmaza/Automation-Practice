import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestShoppingCart {
    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://magento.softwaretestingboard.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulShoppingCart() {
        String messageNoItems = "You have no items in your shopping cart";
        String messageRemoveItem = "Are you sure you would like to remove this item from the shopping cart?";

        open("/men/tops-men/jackets-men.html");

        //Open tab Men - > Tops
        $(By.xpath("//a[@id='ui-id-5']")).hover();
        $(By.xpath("//a[@id='ui-id-17']")).click();

        //Select Style -> Rain coat
        $(By.xpath("//div[text()='Style']")).click();
        $(By.xpath("//li/a[normalize-space(text())='Rain Coat']")).click();

        //Select via as List
        $(By.xpath("//a[@id='mode-list']")).click();

        //Sort by Price
        $(By.xpath("//select[@id='sorter']")).click();
        $(By.xpath("//option[@value='price']")).click();

        //Select size of first coat
        $(By.xpath("//ol[@class='products list items product-items']/li[1]//div[text()='M']")).click();

        //Select color of fist coat
        $(By.xpath("//ol[@class='products list items product-items']/li[1]//div[@aria-label='Color']/div[2]")).click();

        //Click “Add to cart” button
        $(By.xpath("//ol[@class='products list items product-items']/li[1]//div[@class='actions-primary']")).click();

        //Waiting for the item to be added to the shopping cart
        $(By.xpath("//span[@class='counter qty']")).should(appear);

        //Click to shopping cart
        $(By.xpath("//span[text()='My Cart']/ancestor::a")).click();

        //Check that coat is added
        $(By.xpath("//div[@class='items-total']")).shouldHave(text("1 Item in Cart"));

        //Click delete item
        $(By.xpath("//a[@title='Remove item']")).click();

        //Check that “Are you sure you would like to remove this item from the shopping cart?” is visible
        $(By.xpath("//div[text()='" + messageRemoveItem + "']")).shouldBe(visible);

        //Click on “Ok” button
        $(By.xpath("//button/span[text()='OK']")).click();

        //Check that cart provides the message “You have no items in your shopping cart“.
        $(By.xpath("//div[@id='minicart-content-wrapper']/div[2]/strong")).shouldHave(text(messageNoItems));
    }
}
