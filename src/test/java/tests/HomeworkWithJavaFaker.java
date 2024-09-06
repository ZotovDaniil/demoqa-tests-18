package tests;


import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static tests.TestDate.*;
import static utils.RandomUtils.*;


public class HomeworkWithJavaFaker extends TestBase {


    @Test
    void fillFormTest() {
        Faker faker = new Faker();

        String firstname = faker.name().firstName(),
                lastname = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                userGender = getRandomItemFromArray(genders),
                userNumber = faker.phoneNumber().subscriberNumber(10),
                userBirthDay_day = String.format("%02d", faker.number().numberBetween(1,28)),
                userBirthDay_month = getRandomItemFromArray(months),
                userBirthDay_year = String.valueOf(faker.number().numberBetween(1990,2000)),
                userSubject = getRandomItemFromArray(subjects),
                userHobby = getRandomItemFromArray(hobbies),
                uploadPicture = "img/1.png",
                userState = getRandomItemFromArray(states),
                userCity = getRandomCities(userState);



        registrationPage.openPage()

                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setGender(userGender)
                .setNumber(userNumber)
                .setBirthDate(userBirthDay_day, userBirthDay_month, userBirthDay_year)
                .setCurrentAddress(currentAddress)
                .setSubjects(userSubject)
                .setHobbies(userHobby)
                .uploadPicture(uploadPicture)
                .setPlaceOfLocation(userState, userCity)
                .clickSubmit();


        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstname + " " + lastname)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", userGender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", userBirthDay_day + " " + userBirthDay_month + "," + userBirthDay_year);


    }

}