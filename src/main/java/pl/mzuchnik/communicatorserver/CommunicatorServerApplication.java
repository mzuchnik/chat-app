package pl.mzuchnik.communicatorserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class CommunicatorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunicatorServerApplication.class, args);
    }


}
