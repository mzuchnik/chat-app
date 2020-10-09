package pl.mzuchnik.communicatorserver.model;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.mzuchnik.communicatorserver.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ActiveUsersTest {

    Set<String> usernames;

    @BeforeEach
    void setUp(){
        usernames = new HashSet<>();
    }

    @Test
    void afterAddedUsernameListShouldBeNotEmpty(){
        User user = new User("admin","haslo123","admin@admin.com");
        usernames.add(user.getUsername());

        assertThat(usernames, is(not(empty())));
    }

    @Test
    void afterRemoveUsernameSizeOfListShouldBeDecrease(){
        User user = new User("admin","haslo123","admin@admin.com");
        User user2 = new User("admin2","haslo123","admin@admin.com");

        usernames.addAll(List.of(user.getUsername(), user2.getUsername()));

        usernames.remove(user.getUsername());

        assertThat(usernames, hasSize(1));
    }

}