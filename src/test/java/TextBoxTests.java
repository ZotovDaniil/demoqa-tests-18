import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
@BeforeAll
static void BeforeAll(){
    com.codeborne.selenide.Configuration.browserSize = "1920x1080";
    Configuration.baseUrl = "https://demoqa.com";
}
    @Test
    void fillFormTest(){
        open("/text-box");
        $("[id=userName]").setValue("Alex Egorov");
        $("[id=userEmail]").setValue("alex@egorov.ru");
        $("[id=currentAddress]").setValue("Some address 1");
        $("[id=permanentAddress]").setValue("Another address 1");
        $("[id=submit]").click();
        $("[id=output]").shouldHave(text("Alex Egorov"), text("alex@egorov.ru"),
                text("Some address 1"), text("Another address 1"));

    }
}
