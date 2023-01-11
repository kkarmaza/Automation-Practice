package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.ConfirmationMessages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage extends BasePage {

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

    //Open tab Men - > Tops
    public void openMenTops() {
        menuTabMen.hover();
        menuItemTops.click();
    }

    //Select Style -> Rain coat
    public void openRainCoat() {
        shoppingOptionStyle.click();
        categoryRainCoat.click();
    }

    //Select via as List
    public void selectListView() {
        viewList.click();
    }

    //Sort by Price
    public void sortByPrice() {
        sorter.click();
        sorterOptionPrice.click();
    }

    public void addProductToCart(int productID, String size) {
        SelenideElement productSize = $(By.xpath("//ol[@class='products list items product-items']/li[" + productID + "]//div[text()='" + size + "']"));
        SelenideElement productColor = $(By.xpath("//ol[@class='products list items product-items']/li[" + productID + "]//div[@aria-label='Color']/div[2]"));
        SelenideElement addToCartButton = $(By.xpath("//ol[@class='products list items product-items']/li[" + productID + "]//div[@class='actions-primary']"));
        //Select size
        productSize.click();
        //Select color
        productColor.click();
        //Click “Add to cart” button
        addToCartButton.click();
    }

    //Waiting for the item to be added to the shopping cart
    public void waitForAddingItem() {
        cartCaunter.should(Condition.appear);
    }

    //Click to shopping cart
    public void clickShoppingCart() {
        shoppingCartIcon.click();
    }

    //Check that coat is added
    public void checkAddedProduct() {
        totalItem.shouldHave(Condition.text("1 Item in Cart"));
    }

    //Click delete item
    public void deleteItem() {
        deleteItemButton.click();
    }

    //Check that “Are you sure you would like to remove this item from the shopping cart?” is visible
    public void checkDeleteMessage() {
        deleteMessage.shouldBe(Condition.visible);
    }


    //Click on “Ok” button
    public void confirmDeleting() {
        confirmDeletingButton.click();
    }

    //Check that cart provides the message “You have no items in your shopping cart“.

    public void checkNoItemMessage() {
        noItemMessage.shouldHave(text(ConfirmationMessages.NOITEMS.getConfirmationMessage()));
    }

    public void logOut() {
        userMemu.click();
        userMemuSignOut.click();
    }

    //Open cart page
    public void openCartPage() {
        viewCartLink.click();
    }
}
