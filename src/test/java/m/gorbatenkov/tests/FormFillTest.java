package m.gorbatenkov.tests;

import m.gorbatenkov.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static m.gorbatenkov.tests.TestData.*;

public class FormFillTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillTest() {
        registrationPage.openForm()
                .setName(firstName, lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadPicture(picturePath)
                .setAddress(address)
                .setStateAndCity(state, city)
                .submit();

        registrationPage.checkResultByKey("Name", String.format("%s %s", firstName, lastName))
                .checkResultByKey("Email", email)
                .checkResultByKey("Gender", gender)
                .checkResultByKey("Mobile", phoneNumber)
                .checkResultByKey("Birth", String.format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth))
                .checkResultByKey("Subjects", subject)
                .checkResultByKey("Hobbies", hobby)
                .checkResultByKey("Picture", "sampleFile.jpeg")
                .checkResultByKey("Address", address)
                .checkResultByKey("State and City", String.format("%s %s", state, city));
    }
}