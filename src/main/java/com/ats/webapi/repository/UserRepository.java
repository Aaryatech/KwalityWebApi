package com.ats.webapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import com.ats.webapi.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
	
	User findByUserId(int id);

	@Transactional
	@Modifying
	int deleteUserByUserId(int id);

}
