package cats.borzik.autotest.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@Component
public class MainPage {


    public MainPage openMainPage() {
        return Selenide.open("http://192.168.50.201:3000", MainPage.class);
    }

    public void checkPageVisible() {
        $(By.xpath("//a[@href='/']")).should(visible);
    }
}
