package cats.borzik.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(classes = SpringConfiguration.class)
@ActiveProfiles("test")
public class CucumberSpringConfiguration {
}
