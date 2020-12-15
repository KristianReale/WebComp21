package it.unical.mat.webcomp21.segreteria.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.mat.webcomp21.model.Studente;

@Controller
public class StudentiController {
	
	@GetMapping("GestioneStudenti/studenti.html")
	public String dammiStudenti(HttpSession session, Model model) {
		
		if (checkAutorized((String)session.getAttribute("usernameLogged"))) {
			ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
			
			Studente s1 = new Studente();
			s1.setMatricola("123456");
			s1.setNome("Mario");
			s1.setCognome("Bianchi");
			
			Studente s2 = new Studente();
			s2.setMatricola("56789");
			s2.setNome("Bruno");
			s2.setCognome("Verdi");
			
			Studente s3 = new Studente();
			s3.setMatricola("345345");
			s3.setNome("Giorgio");
			s3.setCognome("Rossi");
			
			listaStudenti.add(s1);
			listaStudenti.add(s2);
			listaStudenti.add(s3);
			
			model.addAttribute("listStudenti", listaStudenti);
			
			return "studenti";
		}else {
			return "unauthorized";
		}
	}
	
	private boolean checkAutorized(String username) {
		if (username != null) {
			//C'e' qualcuno loggato
			if (username.equals("admin")) {
				//E' l'admin
				return true;
			}
		}
		return false;
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
