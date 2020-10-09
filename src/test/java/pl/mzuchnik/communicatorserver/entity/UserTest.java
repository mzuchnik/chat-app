package pl.mzuchnik.communicatorserver.entity;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    static Validator validator;


    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @ParameterizedTest
    @ValueSource(strings = {"admin12345", "haslo123", "qwerty123","trudnehaslo"})
    void passwordWithSizeGreaterThanEightShouldBeValidated(String password) {
        User user = new User("admin", password, "admin@admin.com");
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        assertTrue(validate.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"admin", "hasl23", "qwer13","truaslo"})
    void passwordWithSizeGreaterThanEightShouldNotBeValidated(String password) {
        User user = new User("admin", password, "admin@admin.com");
        Set<ConstraintViolation<User>> validate = validator.validate(user);
        assertFalse(validate.isEmpty());
    }

    @Test
    void afterCreateUserShouldBeEnable() {
        //given
        User user = new User();
        //when
        boolean enable = user.isEnabled();
        //then
        assertThat(enable, is(true));

    }

    @Test
    void afterCreateUserShouldHaveUserRole() {
        //given
        User user = new User();
        //when
        String role = user.getAuthority();
        //then
        assertThat(role, equalTo("USER"));

    }

    @Test
    void afterCreateUserShouldHaveIdEqualZero() {
        //given
        User user = new User();
        //then
        assertThat(user.getId(), equalTo(0L));
    }

    @Test
    void afterCreateUserShouldHaveEmailNotEqualNull() {
        //given
        User user = new User("username", "password", "email@email.com");
        //when
        String email = user.getEmail();
        //then
        assertThat(email, is(notNullValue()));
    }
}