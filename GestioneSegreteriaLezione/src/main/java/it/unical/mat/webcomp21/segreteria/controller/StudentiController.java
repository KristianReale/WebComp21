package it.unical.mat.webcomp21.segreteria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentiController {
	
	@GetMapping("GestioneStudenti/studenti.html")
	public String dammiStudenti() {
//		ArrayList<Studente>
		
		return "studenti";
	}
	
	@PostMapping("GestioneStudenti/faiIscrizione")
	public String iscrivi(@RequestParam String matricola, @RequestParam String nome, @RequestParam String cognome, 
								@RequestParam String luogonascita, @RequestParam String datanascita) {
		System.out.println(matricola);
		System.out.println(nome);
		System.out.println(cognome);
		System.out.println(luogonascita);
		System.out.println(datanascita);
		return "studenti";
	}
	
	

}
