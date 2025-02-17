package cats.borzik.autotest.hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CucumberHooks {
    @Before
    public void before() {
        Configuration.headless = true;
    }

    @After
    public void after() {
        closeWebDriver();
    }
}
