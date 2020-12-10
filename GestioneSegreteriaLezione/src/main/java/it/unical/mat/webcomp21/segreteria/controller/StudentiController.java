package it.unical.mat.webcomp21.segreteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentiController {
	
	@GetMapping("GestioneStudenti/studenti.html")
	public String dammiStudenti() {
		return "studenti";
	}

}
