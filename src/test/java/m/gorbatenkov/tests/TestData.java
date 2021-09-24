package m.gorbatenkov.tests;

import com.github.javafaker.Faker;


public class TestData {
    static Faker faker = new Faker();
    static String firstName = faker.funnyName().name(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            phoneNumber = faker.number().randomNumber(10, true) + "",
            address = faker.address().fullAddress(),
            subject = faker.options().option("Maths", "Physics", "Arts"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            dayOfBirth = "23",
            monthOfBirth = "June",
            yearOfBirth = "1978",
            picturePath = "src/test/resources/sampleFile.jpeg",
            state = "NCR",
            city = "Gurgaon";

}
