package cats.borzik;

import cats.borzik.model.Borzik;
import cats.borzik.repo.BorzikRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BorzikApplicationTests {

    BorzikRepository borzikRepository;

    @Test
    public void contextLoads() {
        Borzik borzik = new Borzik();
        borzik.setName("Borzik");
        borzik.setDescription("Borzik");
    }
}
