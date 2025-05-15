package testElements;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ElementsPage {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void inputTextData() {
        open("/text-box");
        $(".text-center").shouldHave(text("Text Box"));

        executeJavaScript("$('#Ad.Plus-970x250-1').remove()");

        $("#userName").setValue("Patrick");
        $("#userEmail").setValue("patrickLong@gmail.com");
        $("#currentAddress").setValue("USA\nNew York\nStreet for W name 15");
        $("#permanentAddress").setValue("Here is my\nNew address\nJapan\nAnime street");
        $("#submit").click();

        $("#name").shouldHave(text("Name:Patrick"));
        $("#email").shouldHave(text("patrickLong@gmail.com"));
        $("#output").$("#currentAddress").shouldHave(text("Current Address :USA New York Street for W name 15"));
        $("#output").$("#permanentAddress").shouldHave(text("Permananet Address :Here is my New address Japan Anime street"));
    }
}
