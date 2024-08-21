import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test
    void fillFormTest(){
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Alex Egorov");
        $("#userEmail").setValue("alex@egorov.ru");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Another address 1");
        $("#submit").click();
        $("#output").shouldHave(text("Alex Egorov"), text("alex@egorov.ru"),
                text("Some address 1"), text("Another address 1"));

    }
}
