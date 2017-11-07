package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.UserService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class UserControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void whenGetAllUsers_shouldActivateCorrespondingMethodInUserService() throws Exception{
        userController.getAllUsers();
        verify(userService).getAllUsers();
    }

    @Test
    public void whenAddUser_shouldActivateCorrespondingMethod() throws Exception {
        userController.addUser("123", "Dauchy", null, "unicorn", null, null, "3000", "Leuven");
        verify(userService).addUser("123", "Dauchy", null, "unicorn", null, null, "3000", "Leuven");
    }
}