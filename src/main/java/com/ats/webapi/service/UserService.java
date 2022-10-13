package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.User;
import com.ats.webapi.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) throws DataIntegrityViolationException {

		User userSaveResponse = userRepository.save(user);

		if (Objects.isNull(userSaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a user ");
		}

		return userSaveResponse;

	}
	public List<User> findAll()
	{
        return userRepository.findAll();
    }

	public User findUserById(int id) throws ResourceNotFoundException {

		User userOpt = userRepository.findByUserId(id);
		
		if (Objects.isNull(userOpt)) {
			
			throw new ResourceNotFoundException("Unit of Measure Not Found With Id " +id);
		}

		return userOpt;

	}
	
	public int deleteUserById(int id) throws ResourceNotFoundException {


		return userRepository.deleteUserByUserId(id);

	}

}
