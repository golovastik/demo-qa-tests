import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    //automation-practice-form

    @Test
    void inputDataRegistration() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $( "#firstName").setValue("April");
        $("#lastName").setValue("Chocolate");
        $("#userEmail").setValue("chocoapril@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
//        $(".react-datepicker__month-dropdown-container").selectOptionByValue("6");
//        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
//        $(".react-datepicker__month-dropdown-container").selectOption("July");
//        $(".react-datepicker__year-dropdown-container").$(byText("1903")).click();
        $(".react-datepicker__year-select").selectOption("1995");
//        $(".react-datepicker__month-container").$(byText("18")).click();
        $(".react-datepicker__day--023:not(.react-datepicker__day--outside-month)").click();


        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("pxfuel.jpg");

        $("#currentAddress").setValue("USA Los Angeles Big street 14 aleha 44/31");


        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
//        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();
//        $("#react-select-4-input").setValue("Noida").pressEnter();
        $("#submit").click();


        $(".modal-dialog").should(appear);
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".modal-content").shouldHave(text("April"));
        $(".modal-content").shouldHave(text("Chocolate"));
        $(".modal-content").shouldHave(text("chocoapril@mail.com"));
        $(".modal-content").shouldHave(text("1234567890"));
        $(".modal-content").shouldHave(text("NCR Noida"));
        $("#closeLargeModal").click();
    }
}
