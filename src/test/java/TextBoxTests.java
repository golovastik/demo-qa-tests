import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open( "/text-box");
        //$( "[id=userName]").setValue("Name First");
        $( "#userName").setValue("Name First");
        $( "#userEmail").setValue("email@First.ru");
        $( "#currentAddress").setValue("address 123 /11 DLF");
        $( "#permanentAddress").setValue("second Address");
        $( "#submit").click();
        $( "#output").shouldHave(text("Name First"), text("email@First.ru"),
                text("address 123 /11 DLF"), text("second Address"));
    }
}
