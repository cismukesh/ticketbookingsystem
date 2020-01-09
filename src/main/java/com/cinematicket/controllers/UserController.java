package com.cinematicket.controllers;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cinematicket.dto.UserDTO;
import com.cinematicket.entities.User;
import com.cinematicket.services.UserService;

@Controller
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserService userService;

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/login", "/login?id", "/login?id&cancel" })
	public String login() {
		return "login";
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/register")
	public String Register() {
		return "register";
	}

	/**
	 * 
	 * @param userLogin
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/loginuser" }, method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("loginForm") UserDTO userLogin, Model model, HttpServletRequest request) {
		String password = userService.encryptPassword(userLogin.getPassword());
		User user = userService.getUserByEmailPassword(userLogin.getEmail(), password);
		if (user != null) {
			request.getSession().setAttribute("loggedInUserId", user.getId());
			LOGGER.info("Logged in succesfully by == " + user.getUsername());
			if (userLogin.getSeatId() != null) {
				if (userLogin.getCancel()!= null && userLogin.getCancel()) {
					return "redirect:/cancelticket?id=" + userLogin.getSeatId();
				}
				return "redirect:/bookticket?id=" + userLogin.getSeatId();
			} else
			return "redirect:/";
		} else {
			model.addAttribute("message", "Wrong credentials...please try again");
			return "login";
		}
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User user) {
		user.setPassword(userService.encryptPassword(user.getPassword()));
		userService.saveUser(user);
		LOGGER.info("registered successfully");
		return "login";
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		LOGGER.info("logged out successfully");
		return "redirect:/";
	}

}
