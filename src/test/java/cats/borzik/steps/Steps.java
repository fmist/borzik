package cats.borzik.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class Steps {

    @Given("Open main page borzik")
    public void open() {
        Selenide.open("http://localhost:3000");
        $(By.xpath("//a[@href='/']")).should(visible);
    }
}
