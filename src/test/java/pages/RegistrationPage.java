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
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumber =  $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),
            hobbiesWrapper =  $("#hobbiesWrapper"),
            uploadPicture =   $("#uploadPicture"),
            currentAddress =  $("#currentAddress"),
            state =  $("#state"),
            city =  $("#city"),
            submit = $("#submit");



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
        userEmail.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPhone(String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDay(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subj) {
        subjectsInput.setValue(subj).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbie) {
        hobbiesWrapper.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage uplPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage serAddress(String address){
        currentAddress.setValue(address);
        return this;
    }

    public RegistrationPage setState(String stateValue) {
        state.click();
        $("#stateCity-wrapper").$(byText(stateValue)).click(); //todo Create component
        return this;
    }

    public RegistrationPage setCity(String cityValue) {
        city.click();
        $("#stateCity-wrapper").$(byText(cityValue)).click();   //todo Create component
        return this;
    }

    public void clickSubmitButton() {
        submit.click();
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
