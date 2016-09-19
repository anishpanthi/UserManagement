package com.app.usermanagement.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.usermanagement.domain.User;
import com.app.usermanagement.service.IUserService;

@Controller
public class UserRestController {

	private IUserService userService;

	@Autowired(required = true)
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/api/getAllUsers", method=RequestMethod.GET)
	public @ResponseBody
	List<User> getAllUsers(){
			return userService.findAll();
	}

}
