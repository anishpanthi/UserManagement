package com.app.usermanagement.main;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.usermanagement.domain.User;
import com.app.usermanagement.service.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomeController.class);

	private IUserService userService;

	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setPersonService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "authFailed", required = false) String authFailed,
			@RequestParam(value = "unauthorized", required = false) boolean unauthorized,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (authFailed != null) {
			model.addObject("authFailed", "Invalid username and password!");
		}

		if (unauthorized) {
			model.addObject("authFailed", "Sorry, you are not allowed to view this page. You are automatically logged out.");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
	
	@RequestMapping(value = "/auth/admin", method = RequestMethod.GET)
	public String afterAdminAuth(Model model) {
		model.addAttribute("users", userService.findAll());
		return "home";
	}

	@RequestMapping(value = "/auth/admin/add", method = RequestMethod.GET)
	public String addUser(Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}

	@RequestMapping(value = "/auth/admin/add", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, Model model) {
		userService.addUser(user);
		return "redirect:/auth/admin";
	}

	@RequestMapping(value = "/auth/admin/edit", params = { "id" }, method = RequestMethod.GET)
	public String editUser(@RequestParam("id") long id, Model model) {

		model.addAttribute("user", userService.getUserById(id));
		return "add-user";
	}

	@RequestMapping(value = "/auth/admin/edit", method = RequestMethod.POST)
	public String saveEditedUser(@RequestParam(value = "_submit", required = false) String submit,
			@RequestParam(value = "_cancel", required = false) String cancel, @ModelAttribute User user) {
		if (cancel != null) {
			return "redirect:/auth/admin";
		} else {
			userService.updateUser(user);
		}
		return "redirect:/auth/admin";
	}

	@RequestMapping(value = "/auth/admin/remove", params = { "id" }, method = RequestMethod.GET)
	public String deleteUser(@RequestParam("id") long id, Model model) {
		userService.removeUser(id);
		return "redirect:/auth/admin";
	}
}
