package cats.borzik.autotest.steps;

import cats.borzik.autotest.pages.MainPage;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class Steps {
    @Autowired
    MainPage mainPage;

    @Given("Open main page borzik")
    public void open() {
        mainPage.openMainPage();
        mainPage.checkPageVisible();
    }
}
