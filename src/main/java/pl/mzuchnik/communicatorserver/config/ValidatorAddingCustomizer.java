package pl.mzuchnik.communicatorserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.validation.Validator;
import java.util.Map;


@Configuration
public class ValidatorAddingCustomizer{

    @Bean
    @Autowired
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(final Validator validator) {
        return new HibernatePropertiesCustomizer() {

            @Override
            public void customize(Map<String, Object> hibernateProperties) {
                hibernateProperties.put("javax.persistence.validation.factory", validator);
                hibernateProperties.put("javax.persistence.validation.mode", "none");
            }
        };
    }
}
