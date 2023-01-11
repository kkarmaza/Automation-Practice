package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestFirstForm {
    @BeforeAll
    static void BeforeAll()
    {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulRegistration()
    {
        String name ="Karina";
        String email ="karinatest@gmail.com";
        String currentAddress ="Vilnius";
        String permanentAddress ="Grodno";
        open("/text-box");

        //removing banners
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //set values
        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue(email);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=permanentAddress]").setValue(permanentAddress);

        $("[id=submit]").click();

        //check the output
        $("[id=output]").shouldHave(text(name), text(email), text(currentAddress), text(permanentAddress));


    }
}
