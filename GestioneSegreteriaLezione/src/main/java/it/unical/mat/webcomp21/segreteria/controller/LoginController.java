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
		
		if (loginOk(username, password)) {		
			return "loginSuccess";
		}else {
			return "loginError";
		}
	}
	
	private boolean loginOk(String username, String password) {
		if (username.equals("admin") && password.equals("admin")) {
			return true;
		}
		return false;
	}
}
