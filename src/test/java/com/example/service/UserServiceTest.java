package com.example.service;

import com.example.common.ServerResponse;
import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private IUserService userService;


    @Test
    public void testLogin() {
        User user = new User();
        user.setUsername("user1");
        user.setPassword("password");

        ServerResponse<User> response = userService.login(user.getUsername(), user.getPassword());

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals("user1", response.getData().getUsername());
        assertEquals("", response.getData().getPassword());
    }

    @Test
    public void testRegister() {
        User user = new User();
        user.setUsername("user11");
        user.setPassword("password");
        user.setEmail("user11@gmail.com");
        user.setRole("customer");

        ServerResponse<String> response = userService.register(user);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals("Register successful!", response.getMsg());
    }

    @Test
    public void testCheckValid() {
        ServerResponse<String> response = userService.checkValid("testuser", "USERNAME");

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals("Check successful.", response.getMsg());
    }

    @Test
    public void testCheckAdminRole() {
        User user = new User();
        user.setRole("adviser");

        ServerResponse response = userService.checkAdminRole(user);

        assertNotNull(response);
        assertTrue(response.isSuccess());
    }
}
