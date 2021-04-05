/**
 * 
 */
package com.spring.boot.swagger.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.swagger.demo.model.User;

/**
 * @author mahes
 *
 */
public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
