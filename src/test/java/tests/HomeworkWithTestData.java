package tests;



import org.junit.jupiter.api.Test;


public class HomeworkWithTestData extends TestBase {




    @Test
    void fillFormTest() {

        String firstname = "Vasya",
                lastname = "Pupkin",
                email = "email@mail.ru";

        registrationPage.openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setUserEmail(email)
                .setGender("Other")
                .setNumber("1234567890")
                .setBirthDate("30", "July", "2007")
                .setCurrentAddress("internet")
                .setSubjects("Math")
                .setHobbies("Sports")
                .uploadPicture("img/1.png")
                .setPlaceOfLocation("NCR", "Delhi")
                .clickSubmit();



        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstname + " " + lastname)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", "Other" )
                .verifyResults("Mobile", "1234567890")
                .verifyResults("Date of Birth", "30 July,2007");




    }

}