/**
 * 
 */
package com.spring.boot.swagger.demo.service;

import java.util.List;

import com.spring.boot.swagger.demo.model.User;

/**
 * @author mahes
 *
 */
public interface UserService {

	User addUser(User user);
	
	User getUser(Integer userId);
	
	List<User> getAllUsers();
	
	User updateUser(Integer userId, User user);
	
	String deleteUser(Integer userId);
}
