package com.ats.webapi.entity;

import com.ats.webapi.entity.User;
import com.ats.webapi.model.ErrorMessage;

public class LoginResponse {
User user;
ErrorMessage errorMessage;
public User getUser() {
	return user;
}
public ErrorMessage getErrorMessage() {
	return errorMessage;
}
public void setUser(User user) {
	this.user = user;
}
public void setErrorMessage(ErrorMessage errorMessage) {
	this.errorMessage = errorMessage;
}

}
