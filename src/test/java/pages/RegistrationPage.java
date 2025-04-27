package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private final String TITLE_TEXT = "Student Registration Form";
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();

    private SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value) {
        $("#userEmail").setValue(value);    //todo move to Selenide elements
        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();    //todo move to Selenide elements
        return this;
    }

    public RegistrationPage setPhone(String value) {
        $("#userNumber").setValue(value);    //todo move to Selenide elements
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();     //todo move to Selenide elements
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyResultsModal() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}
