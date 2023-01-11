package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TestPracticeForm {
    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void SuccessfulStudentRegistration() {
        String firstName = "Karina";
        String lastName = "Karmaza";
        String email = "karinatest@gmail.com";
        String gender = "Female";
        String phoneNumber = "0123456789";
        String subject = "Maths";
        String hobby = "Sports";
        String currentAddress = "Vilnius";
        String state = "Haryana";
        String city = "Karnal";
        String year = "1997";
        String month = "March";
        String day = "10";

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        //Set values
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);

        //Gender
        $(byText(gender)).click();

        //Phone
        $("[id=userNumber]").setValue(phoneNumber);

        //Date Picker
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day.react-datepicker__day--0" + day).click();

        //Subject
        $("[id=subjectsInput]").sendKeys(subject);
        $("[id=subjectsInput]").pressEnter();

        //Hobbies
        $(byText(hobby)).click();

        //Upload picture
        $("[id=uploadPicture]").uploadFile(new File("src/test/data/sample.jpg"));

        //Current Address
        $("[id=currentAddress]").setValue(currentAddress);

        //Select state
        $("[id=state]").click();
        $(byText(state)).click();

        //Select city
        $("[id=city]").click();
        $(byText(city)).click();

        //Submit the form
        $("[id=submit]").click();

        //Check the output

        //Student Name
        $(By.xpath("//tbody/tr/td[text()=\"Student Name\"]//following::td[1]")).shouldHave(text(firstName), text(lastName));

        //Student Email
        $(By.xpath("//tbody/tr/td[text()=\"Student Email\"]//following::td[1]")).shouldHave(text(email));

        //Student Gender
        $(By.xpath("//tbody/tr/td[text()=\"Gender\"]//following::td[1]")).shouldHave(text(gender));

        //Student Mobile
        $(By.xpath("//tbody/tr/td[text()=\"Mobile\"]//following::td[1]")).shouldHave(text(phoneNumber));

        //Date of Birth
        $(By.xpath("//tbody/tr/td[text()=\"Date of Birth\"]//following::td[1]")).shouldHave(text(day + " " + month + "," + year));

        //Subjects
        $(By.xpath("//tbody/tr/td[text()=\"Subjects\"]//following::td[1]")).shouldHave(text(subject));

        //Hobbies
        $(By.xpath("//tbody/tr/td[text()=\"Hobbies\"]//following::td[1]")).shouldHave(text(hobby));

        //Picture
        $(By.xpath("//tbody/tr/td[text()=\"Picture\"]//following::td[1]")).shouldHave(text("sample.jpg"));

        //Address
        $(By.xpath("//tbody/tr/td[text()=\"Address\"]//following::td[1]")).shouldHave(text(currentAddress));

        //State and City
        $(By.xpath("//tbody/tr/td[text()=\"State and City\"]//following::td[1]")).shouldHave(text(state), text(city));
    }
}
