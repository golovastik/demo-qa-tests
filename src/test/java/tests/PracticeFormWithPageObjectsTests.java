package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTests extends TestBase {

    @Test
    void inputDataRegistration() {
        String userName = "April";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName("Chocolate")
                .setEmail("chocoapril@mail.com")
                .setGender("Male")
                .setPhone("1234567890")
                .setBirthDay("25", "July", "2008");




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


        registrationPage.verifyResultsModal()
                .verifyResult("Student Name", userName + " Chocolate")
                .verifyResult("Student Email", "chocoapril@mail.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890");

        $("#closeLargeModal").click();
    }

    @Test
    void inputDataRegistration1() {
        String userName = "April";

        registrationPage.openPage();

        registrationPage.setFirstName(userName);
        registrationPage.setLastName("Chocolate");
        registrationPage.setEmail("chocoapril@mail.com");
        registrationPage.setGender("Male");
        registrationPage.setPhone("1234567890");


        //....
    }
}
