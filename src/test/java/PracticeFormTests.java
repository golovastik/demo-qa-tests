import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
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
        //$("#dateOfBirthInput").setValue("12  2025");
        $("#subjectsContainer").setValue("add");
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-3").click();
        //picture
        $("#currentAddress").setValue("USA Los Angeles Big street 14 aleha 44/31");
        //State
        //City
        $("#submit").click();

    }
}
