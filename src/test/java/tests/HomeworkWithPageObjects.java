package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;


public class HomeworkWithPageObjects extends TestBase {


    @BeforeAll
    static void beforeAll() {
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Feature("Fill Form Test")
    @Story("Заполнение и проверка формы")
    @Owner("zotovds")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Заполнение анкеты студента")
    @Tag("demoqa")
    void fillFormTest() {
        step("Открываем форму", () -> {
            registrationPage.openPage();
        });

        step("Заполняем форму", () -> {
            registrationPage.setFirstName("Vasya")
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
            ;
        });


        step("Проверяем заполненную форму", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResults("Student Name", "Vasya " + "Pupkin")
                    .verifyResults("Student Email", "email@mail.ru")
                    .verifyResults("Gender", "Other")
                    .verifyResults("Mobile", "1234567890")
                    .verifyResults("Date of Birth", "30 July,2007");
        });

    }
}

