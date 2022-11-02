package com.ats.webapi.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.webapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

	User findByUserId(int id);

	@Transactional
	@Modifying
	int deleteUserByUserId(int id);

	User findUserByUserName(String userName);

	User findUserByEmail(String email);

	@Transactional
	@Modifying
	@Query(value = "UPDATE m_user SET user_pwd=:newPassword WHERE user_id=:userId", nativeQuery = true)
	int updateUserPass(@Param("userId") int userId, @Param("newPassword") String newPassword);

	@Query("select c from User c ")
	List<User> findAllUser();

}
