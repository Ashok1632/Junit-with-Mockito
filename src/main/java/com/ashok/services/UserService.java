package com.ashok.services;

import java.util.List;

import com.ashok.entity.User;

public interface UserService {
List<User> getAllUser();
User addUser(User user);
User getUserById(Long userId);
void deleteUser(Long userId);
}
