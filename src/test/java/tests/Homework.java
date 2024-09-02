package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Homework {
    @BeforeAll
    static void BeforeAll(){
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Vasya");
        $("#lastName").setValue("Pupkin");
        $("#userEmail").setValue("email@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("internet");
        $("#genterWrapper").$(byText("Other")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("July")).click();
        $(".react-datepicker__year-select").$(byText("2007")).click();
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Vasya"), text("Pupkin"),text( "1234567890"));




    }

}