package com.ashok;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import com.ashok.entity.User;
import com.ashok.repository.UserRepository;
import com.ashok.services.UserService;
@RunWith(SpringRunner.class)

@SpringBootTest
class JunitTestMockitoApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	void contextLoads() {
	}
	@Test
    public void testGetAllUsers() {
        // Arrange
        List<User> mockUsers = Arrays.asList(
                new User((long) 1, "John",34),
                new User((long) 2, "Alice",22),
                new User((long) 3, "Bob",56)
        );
        when(userRepository.findAll()).thenReturn(mockUsers);

        // Act
        List<User> allUsers = userService.getAllUser();

        // Assert
        assertThat(allUsers.size()).isEqualTo(3);
        assertThat(allUsers.get(0).getName()).isEqualTo("John");
        assertThat(allUsers.get(1).getName()).isEqualTo("Alice");
        assertThat(allUsers.get(2).getName()).isEqualTo("Bob");
        // Additional assertions as needed
    }
	
}
