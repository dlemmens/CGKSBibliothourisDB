package be.cegeka.bibliothouris.domain.users;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        userService.addUser("123", "Dauchy", null, null, null, null, "Leuven");

        verify(userRepository).addUser(new User( "123", "Dauchy", null, null, null, null, "Leuven"));
    }

    @Test
    public void getAllUsers() throws Exception {
        User user1 = new User( "668", "Stroobants", "Jeroen", null, null, null, "Leuven");
        User user2 = new User( "456", "Karpisek", null, null, null, null, "Rumst");
        User user3 = new User( "123", "Dauchy", null, null, null, null, "Leuven");

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2, user3));

        assertThat(userService.getAllUsers()).containsOnly(user1, user2, user3);
    }
}