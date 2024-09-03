package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class HomeworkWithPageObjects extends TestBase {




    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Vasya")
                .setLastName("Pupkin")
                .setUserEmail("email@mail.ru")
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2007")
                .setCurrentAddress("internet")
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("img/1.png")
                .setPlaceOfLocation("NCR", "Delhi")
                .clickSubmit();


//        $("#submit").click();
        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", "Vasya " + "Pupkin")
                .verifyResults("Student Email", "email@mail.ru")
                .verifyResults("Gender", "Other" )
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "30 July,2007");




    }

}