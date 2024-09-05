package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class HomeworkWithJavaFaker extends TestBase {


    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("it"));

        String firstname = faker.name().firstName(),
                lastname = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress();

        registrationPage.openPage()

                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2007")
                .setCurrentAddress(currentAddress)
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("img/1.png")
                .setPlaceOfLocation("NCR", "Delhi")
                .clickSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstname + " " + lastname)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", "Other")
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "30 July,2007");


    }

}