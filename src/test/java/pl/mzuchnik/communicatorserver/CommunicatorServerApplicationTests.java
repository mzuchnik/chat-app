package pl.mzuchnik.communicatorserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Files;
import java.sql.Date;
import java.time.Instant;

@SpringBootTest
class CommunicatorServerApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(new Date(System.currentTimeMillis()));
    }

}
