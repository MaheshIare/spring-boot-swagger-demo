/**
 * 
 */
package com.spring.boot.swagger.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.swagger.demo.model.User;
import com.spring.boot.swagger.demo.repository.UserJpaRepository;
import com.spring.boot.swagger.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mahes
 *
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	public User addUser(User user) {
		return userJpaRepository.saveAndFlush(user);
	}

	@Override
	public User getUser(Integer userId) {
		Optional<User> optional = userJpaRepository.findById(userId);
		return optional.isPresent() ? optional.get() : optional.orElse(null);
	}

	@Override
	public List<User> getAllUsers() {
		return userJpaRepository.findAll();
	}

	@Override
	public User updateUser(Integer userId, User user) {
		user.setUserId(userId);
		return userJpaRepository.saveAndFlush(user);
	}

	@Override
	public String deleteUser(Integer userId) {
		String response = "Failed to delete the user";
		try {
			userJpaRepository.deleteById(userId);
			response = "Successfully deleted the user with id: " + userId;
		} catch (Exception e) {
			log.error("Exception occured while deleting the user due to: {}", e);
		}
		return response;
	}

}
