package com.app.usermanagement.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ErrorPageController {
	
	@RequestMapping(value = "/400", method = RequestMethod.GET)
	public String get400ErrorPage() {
		return "errorPage";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String get403Denied(Model model) {
		model.addAttribute("unauthorized", true);
		return "redirect:/login?authFailed";
	}
	
	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String get404ErrorPage() {
		return "errorPage";
	}
	
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String get500ErrorPage() {
		return "errorPage";
	}
}
