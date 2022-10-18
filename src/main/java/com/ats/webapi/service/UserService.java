package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ats.webapi.controller.UserController;
import com.ats.webapi.entity.LoginResponse;
import com.ats.webapi.entity.User;
import com.ats.webapi.model.ErrorMessage;
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
			
			throw new ResourceNotFoundException("User Not Found With Id " +id);
		}

		return userOpt;

	}
	
	public int deleteUserById(int id) throws ResourceNotFoundException {


		return userRepository.deleteUserByUserId(id);

	}
	
	
	public  LoginResponse checkUserNameForLogin(@RequestParam String userName, @RequestParam String pass) {
	
		LoginResponse loginResponse=null;
		User loginUser = new User();
		ErrorMessage errorMessage;
		try {
			if (userName != null) {
				try {
					loginUser = userRepository.findUserByUserName(userName);
				} catch (Exception e) {
					loginResponse=new LoginResponse();
		            errorMessage=new ErrorMessage();
					errorMessage.setError(true);
					errorMessage.setMessage("User is not registered");
					e.printStackTrace();
				}
				
				if (loginUser != null) {
					if (pass.trim().equals(loginUser.getUserPassword().trim())) {
						System.err.println("in iff");
						loginResponse=new LoginResponse();
						errorMessage=new ErrorMessage();
						errorMessage.setError(false);
						errorMessage.setMessage("Login Successful");
						loginResponse.setErrorMessage(errorMessage);
						loginResponse.setUser(loginUser);
					} else {
						System.err.println("if null");
						loginResponse=new LoginResponse();
			            errorMessage=new ErrorMessage();
						errorMessage.setError(true);
						errorMessage.setMessage("Invalid user name or password");
						loginResponse.setErrorMessage(errorMessage);
						loginResponse.setUser(loginUser);
						
					}
				}
			
			else {
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("Invalid user name or password");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(loginUser);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return loginResponse;

	}
	
	
	public LoginResponse checkValidEmail(String email) {
		LoginResponse loginResponse=null;
		User loginUser = new User();
		ErrorMessage errorMessage;
		try {
			if (email != null) {
				try {
					loginUser = userRepository.findUserByEmail(email);
				} catch (Exception e) {
					loginResponse=new LoginResponse();
		            errorMessage=new ErrorMessage();
					errorMessage.setError(true);
					errorMessage.setMessage("User is not registered");
					e.printStackTrace();
				}
				
				if (loginUser != null) {
					if (email.trim().equals(loginUser.getEmail().trim())) {
						loginResponse=new LoginResponse();
						errorMessage=new ErrorMessage();
						errorMessage.setError(false);
						errorMessage.setMessage("Validate Successfully");
						loginResponse.setErrorMessage(errorMessage);
						loginResponse.setUser(loginUser);
					} else {
						loginResponse=new LoginResponse();
			            errorMessage=new ErrorMessage();
						errorMessage.setError(true);
						errorMessage.setMessage("Invalid email");
						loginResponse.setErrorMessage(errorMessage);
						loginResponse.setUser(loginUser);
						
					}
				}
			
			else {
				loginResponse=new LoginResponse();
	            errorMessage=new ErrorMessage();
				errorMessage.setError(true);
				errorMessage.setMessage("Invalid Email");
				loginResponse.setErrorMessage(errorMessage);
				loginResponse.setUser(loginUser);
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return loginResponse;
	}
	public int updateUserPass(int userId, String newPassword) {
		// TODO Auto-generated method stub
		return userRepository.updateUserPass(userId,newPassword);
	}
	
	

}
