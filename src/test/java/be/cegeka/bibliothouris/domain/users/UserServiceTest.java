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
import java.util.List;
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
    private UserRoleRepository userRoleRepository;

    @Mock
    private UserRepository userRepository;

    @Test
    public void addUser_ShouldCallUserRepository() throws Exception {
        List<UserRole> userRoles = Arrays.asList(new UserRole(1, "hgcf"));
        when(userRoleRepository.findUserRole("USER")).thenReturn(userRoles);

        userService.addUser("123", "Dauchy", null, "unicorn", null, null, "3000", "Leuven");

        verify(userRepository).addUser(new User( "123", "Dauchy", null, "unicorn", null, null, "3000", "Leuven", userRoles));
    }

    @Test
    public void getAllUsers() throws Exception {
        List<UserRole> userRoles = Arrays.asList(new UserRole(1, "hgcf"));
        when(userRoleRepository.findUserRole("USER")).thenReturn(userRoles);
        User user1 = new User( "668", "Stroobants", "Jeroen", "zalig", null, null, "3000", "Leuven", userRoles);
        User user2 = new User( "456", "Karpisek", null, "weerwolf", null, null, "4000", "Leuven", userRoles);
        User user3 = new User( "123", "Dauchy", null, "unicorn", null, null, "3000", "Leuven", userRoles);

        when(userRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2, user3));

        assertThat(userService.getAllUsers()).containsOnly(user1, user2, user3);
    }
}