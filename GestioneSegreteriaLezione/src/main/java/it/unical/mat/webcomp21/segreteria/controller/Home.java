package it.unical.mat.webcomp21.segreteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Home {

	@GetMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return "<strong>Hello World!!</strong>";
	}
	
	@GetMapping("/")	
	public String home() {
		return "index";
	}
}