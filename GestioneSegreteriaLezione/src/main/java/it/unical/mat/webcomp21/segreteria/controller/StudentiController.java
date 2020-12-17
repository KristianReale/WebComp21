package it.unical.mat.webcomp21.segreteria.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.DBManager;

@Controller
public class StudentiController {
	
	@GetMapping("GestioneStudenti/studenti.html")
	public String dammiStudenti(HttpSession session, Model model) {
		
		if (checkAutorized((String)session.getAttribute("usernameLogged"))) {
			List<Studente> listaStudenti = new ArrayList<Studente>();
			
			listaStudenti = DBManager.getInstance().studenteDAO().findAll();
//			Studente s = DBManager.getInstance().studenteDAO().findByPrimaryKey("554344");
//			if (s != null) {
//				listaStudenti.add(s);
//			}
			model.addAttribute("listStudenti", listaStudenti);
			
			return "studenti";
		}else {
			return "unauthorized";
		}
	}
	
	private boolean checkAutorized(String username) {
//		if (username != null) {
//			//C'e' qualcuno loggato
//			if (username.equals("admin")) {
//				//E' l'admin
//				return true;
//			}
//		}
//		return false;
		return true;
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
