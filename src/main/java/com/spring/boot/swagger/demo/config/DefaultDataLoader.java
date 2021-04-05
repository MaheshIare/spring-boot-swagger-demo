/**
 * 
 */
package com.spring.boot.swagger.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.spring.boot.swagger.demo.model.User;
import com.spring.boot.swagger.demo.repository.UserJpaRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mahes
 *
 */
@Component
@Slf4j
public class DefaultDataLoader {
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@EventListener(classes = ApplicationReadyEvent.class)
	public void loadDefaultData() {
		log.info("Default data loading process started...");
		try {
			List<User> users = defaultData();
			List<User> savedUsers = userJpaRepository.saveAll(users);
			log.info("Saved {} user(s) into the database...", savedUsers.size());
			
			if(savedUsers.size() == users.size())
				log.info("All the user data is loaded into db successfully");
			else
				log.info("Only few users data is loaded into db. Please verify the database for missing records...");
			
			log.info("Default data loading process finished...");
		} catch (Exception e) {
			log.error("Exception occured while loading default data due to: {}", e);
		}
	}
	
	private List<User> defaultData(){
		List<User> list = new ArrayList<>();
		list.add(new User("First1", "Middle1", "Last1", "First1.Last1@gmail.com"));
		list.add(new User("First2", "Middle2", "Last2", "First2.Last2@gmail.com"));
		list.add(new User("First3", "Middle3", "Last3", "First3.Last3@gmail.com"));
		return list;
	}

}
