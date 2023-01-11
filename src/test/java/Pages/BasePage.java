package Pages;

import com.codeborne.selenide.Selenide;

public class BasePage {
    protected String pageURL;

    public BasePage(String pageURL) {
        this.pageURL = pageURL;
    }

    public void openPage() {
        Selenide.open(pageURL);
    }
}
