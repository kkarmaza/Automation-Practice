package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import tests.TestLogin;
import utils.ConfirmationMessages;
import java.util.logging.Logger;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends BasePage {

    Logger logger = Logger.getLogger(TestLogin.class.getName());

    private SelenideElement menuTabMen = $(By.xpath("//a[@id='ui-id-5']"));
    private SelenideElement menuItemTops = $(By.xpath("//a[@id='ui-id-17']"));
    private SelenideElement shoppingOptionStyle = $(By.xpath("//div[text()='Style']"));
    private SelenideElement categoryRainCoat = $(By.xpath("//li/a[normalize-space(text())='Rain Coat']"));
    private SelenideElement viewList = $(By.xpath("//a[@id='mode-list']"));
    private SelenideElement sorter = $(By.xpath("//select[@id='sorter']"));
    private SelenideElement sorterOptionPrice = $(By.xpath("//option[@value='price']"));
    private SelenideElement cartCaunter = $(By.xpath("//span[@class='counter qty']"));
    private SelenideElement shoppingCartIcon = $(By.xpath("//span[text()='My Cart']/ancestor::a"));
    private SelenideElement viewCartLink = $(By.xpath("//a[@class='action viewcart']"));
    private SelenideElement totalItem = $(By.xpath("//div[@class='items-total']"));
    private SelenideElement deleteItemButton = $(By.xpath("//a[@title='Remove item']"));
    private SelenideElement deleteMessage = $(By.xpath("//div[text()='" + ConfirmationMessages.REMOVEITEM.getConfirmationMessage() + "']"));
    private SelenideElement confirmDeletingButton = $(By.xpath("//button/span[text()='OK']"));
    private SelenideElement noItemMessage = $(By.xpath("//div[@id='minicart-content-wrapper']/div[2]/strong"));
    private SelenideElement userMemu = $(By.xpath("//button[@class='action switch']"));
    private SelenideElement userMemuSignOut = $(By.xpath("//div[@class='customer-menu']/ul/li[@class='authorization-link']"));

    public CatalogPage(String pageURL) {
        super(pageURL);
    }

    public void openMenTops() {
        menuTabMen.hover();
        logger.warning("Open MenTops Page");
        menuItemTops.click();
    }

    public void openRainCoat() {
        logger.info("Select Shopping Options - Style");
        shoppingOptionStyle.click();
        logger.info("Select Shopping Options - RainCoat");
        categoryRainCoat.click();
    }

    public void selectListView() {
        logger.info("Select List View");
        viewList.click();
    }

    public void sortByPrice() {
        logger.info("Select Sort option - Price");
        sorter.click();
        sorterOptionPrice.click();
    }

    public void addProductToCart(int productID, String size) {
        SelenideElement productSize = $(By.xpath("//ol[@class='products list items product-items']/li["
                + productID + "]//div[text()='" + size + "']"));
        SelenideElement productColor = $(By.xpath("//ol[@class='products list items product-items']/li["
                + productID + "]//div[@aria-label='Color']/div[2]"));
        SelenideElement addToCartButton = $(By.xpath("//ol[@class='products list items product-items']/li["
                + productID + "]//div[@class='actions-primary']"));

        logger.info("Select Size");
        productSize.click();
        logger.info("Select Color");
        productColor.click();
        logger.warning("Add item to the Cart");
        addToCartButton.click();
    }

    public void waitForAddingItem() {
        cartCaunter.should(Condition.appear);
    }

    public void clickShoppingCart() {
        logger.warning("Open Cart");
        shoppingCartIcon.click();
    }

    public void checkAddedProduct() {
        Assertions.assertEquals(totalItem.getText(), "1 Item in Cart");
    }

    public void deleteItem() {
        logger.warning("Delete Item");
        deleteItemButton.click();
    }

    public void checkDeleteMessage() {
        Assertions.assertTrue(deleteMessage.exists());
    }

    public void confirmDeleting() {
        logger.info("Confirm Deleting Item");
        confirmDeletingButton.click();
    }

    public void checkNoItemMessage() {
        noItemMessage.should(Condition.appear);
        Assertions.assertEquals(noItemMessage.getText(), ConfirmationMessages.NOITEMS.getConfirmationMessage());
    }

    public void logOut() {
        logger.warning("Sign Out");
        userMemu.click();
        userMemuSignOut.click();
    }

    public void openCartPage() {
        viewCartLink.click();
    }
}
