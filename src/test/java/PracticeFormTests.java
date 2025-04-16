import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    //automation-practice-form

    @Test
    void inputData() {
        open("/automation-practice-form");

        $( "#firstName").setValue("April");
        $("#lastName").setValue("Chocolate");
        $("#userEmail").setValue("chocoapril@mail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("+375292584");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1903")).click();
        $(".react-datepicker__month-container").$(byText("18")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("USA Los Angeles Big street 14 aleha 44/31");
        $(". css-1wy0on6").$(byText("NCR")).click();
        $(". css-1wy0on6").$(byText("Noida")).click();
        $("#submit").click();

    }
}
