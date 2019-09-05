package trainingProject.services.userService;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import trainingProject.model.security.Role;
import trainingProject.model.security.User;
import trainingProject.repository.UserRepository;

import java.util.Collections;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;
    @Test
    public void addUser() {
        User user= new User();
        boolean isCreated=userService.addUser(user);
        Assert.assertTrue(isCreated);
        Assert.assertNotNull(user.isActive());
        Assert.assertTrue(CoreMatchers.is(user.isActive()).matches(true));

        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));

        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}