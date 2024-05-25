package com.ashok;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hibernate.sql.ast.tree.expression.Collation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashok.entity.User;
import com.ashok.repository.UserRepository;
import com.ashok.services.UserService;

@RunWith(SpringRunner.class)

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService service;

	@MockBean
	private UserRepository repository;

	@Test
	void test() {
		 MockitoAnnotations.openMocks(this);
	}
	 @Test
	    void testGetUserById_UserExists() {
	        // Arrange
	        Long userId = 1L;
	        User user = new User((long) 1, "ashok", 1);
	        when(repository.findById(userId)).thenReturn(Optional.of(user));

	        // Act
	       User foundUser = service.getUserById(userId);

	        // Assert
	        assertEquals(userId, foundUser.getUserId());
	        assertEquals("ashok", foundUser.getName());
	        assertEquals(1, foundUser.getAge());
	    }

	    @Test
	    void testGetProductById_ProductNotFound() {
	        // Arrange
	        Long userId = 1L;
	        when(repository.findById((long) 1)).thenReturn(Optional.empty());

	        // Act & Assert
	        assertThrows(RuntimeException.class, () -> service.getUserById(userId));
	    }
	    @Test
	    void getAllUser()
	    {
	    	Long userId=1L;
	    	when(repository.findAll()).thenReturn(Stream.of(new User((long) 1,"ashok",1),new User((long) 2,"raj",3)).collect(Collectors.toList()));
	    	assertEquals(2,service.getAllUser().size());
	    }
@Test
void saveUser()
{
	User user=new User((long) 1,"ashok",1);
	when(repository.save(user)).thenReturn(user);
	assertEquals(user,service.addUser(user));
}

/*
 * @Test void deleteUser() { User user=new User((long) 1,"ashok",1);
 * service.deleteUser(user); verify(repository,times(1)).delete(user); }
 */



}
