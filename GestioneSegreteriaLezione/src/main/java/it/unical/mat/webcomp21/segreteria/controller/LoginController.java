package it.unical.mat.webcomp21.segreteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@PostMapping("doLogin")
	public String login(@RequestParam String username, @RequestParam String password) {
		System.out.println(username);
		System.out.println(password);
		
		return "loginSuccess";
	}
}
