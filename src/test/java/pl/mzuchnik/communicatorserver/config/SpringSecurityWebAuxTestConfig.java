package pl.mzuchnik.communicatorserver.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import pl.mzuchnik.communicatorserver.entity.User;

import java.util.Arrays;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {

    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        User basicUser = new User("user", "password", "user@company.com");

        return new InMemoryUserDetailsManager(Arrays.asList(basicUser));
    }
}
