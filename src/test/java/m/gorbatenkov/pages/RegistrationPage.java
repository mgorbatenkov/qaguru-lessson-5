package m.gorbatenkov.pages;

import com.codeborne.selenide.SelenideElement;
import m.gorbatenkov.pages.components.CalendarComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String FORM_TITLE = "Student Registration Form",
            SUBMITTED_FORM_TITLE = "Thanks for submitting the form";
    public CalendarComponent calendar = new CalendarComponent();
    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            submittedForm = $(".modal-content");

    public RegistrationPage openForm() {
        open("automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage setName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setPhoneNumber(String number) {
        phoneInput.setValue(number);
        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        pictureInput.uploadFile(new File(path));
        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }
    public RegistrationPage setStateAndCity (String state, String city){
        stateInput.scrollIntoView(true).click();
        stateInput.$(byText(state)).click();
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;

    }

    public void submit() {
        submitButton.click();
        submittedForm.shouldHave(text(SUBMITTED_FORM_TITLE));
    }

    public RegistrationPage checkResultByKey(String key, String value) {
        submittedForm.find(withText(key)).parent().shouldHave(text(value));
        return this;
    }
}