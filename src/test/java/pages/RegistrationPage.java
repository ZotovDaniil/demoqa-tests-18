package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setNumber (String value){
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationPage setBirthDate (String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate (day, month, year);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears (){
        registrationResultsModal.verifyModalAppears();

        return this;

    }

    public RegistrationPage verifyResults (String key, String value){
        registrationResultsModal.verifyResults(key, value);

        return this;

    }
}
