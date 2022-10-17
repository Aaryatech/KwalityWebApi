package com.ats.webapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.LoginResponse;
import com.ats.webapi.entity.User;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ServiceResponse saveUser(@RequestBody @Valid User user)
			throws DataIntegrityViolationException {
		
		return ServiceResponse.asSuccess(userService.saveUser(user));

	}

	@GetMapping("/{id}")
	public ServiceResponse getUserById(@PathVariable int id) {

		User user = userService.findUserById(id);
		return ServiceResponse.asSuccess(user);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(userService.findAll());

	}
	
	@GetMapping("get-all")
	public List<User> getAll() throws Exception {

		return userService.findAll();

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		userService.deleteUserById(id);

		return ServiceResponse.asSuccess("success");
	}
	
	@GetMapping("/{id}/delete-by-user-id")
	public  Info deleteCity(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = userService.deleteUserById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("UOM Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete UOM");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete UOM");
			e.printStackTrace();
		}

		return info;

	}
	
	@PostMapping("/checkUserCredentialForLogin")
	public  LoginResponse checkUserNameForLogin(@RequestParam String userName, @RequestParam String pass ) {

		LoginResponse loginResponse=new LoginResponse();
		loginResponse=userService.checkUserNameForLogin(userName, pass);
		System.err.println(loginResponse);
		return loginResponse;

	}
	
	
	
	@PostMapping("/checkValidEmail")
	public  LoginResponse checkValidEmail(@RequestParam String email ) {

		LoginResponse loginResponse=new LoginResponse();
		loginResponse=userService.checkValidEmail(email);
		System.err.println(loginResponse);
		return loginResponse;

	}
	
	
	@RequestMapping(value = { "/updateUserPassword" }, method = RequestMethod.POST)
	public @ResponseBody Info updateUserPassword(@RequestParam int userId, @RequestParam String newPassword) {

		Info info = new Info();
		int res = 0;
		try {
			res = userService.updateUserPass(userId, newPassword);

			if (res > 0) {
				info.setError(false);
				info.setMsg("Password changed successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed to change password");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}
	
	
	
	

}
