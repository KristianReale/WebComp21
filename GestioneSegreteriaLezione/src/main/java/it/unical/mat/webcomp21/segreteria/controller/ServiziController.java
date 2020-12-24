package it.unical.mat.webcomp21.segreteria.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.model.Scuola;
import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
@RequestMapping("GestioneStudenti")
public class ServiziController {
	
//	@PostMapping("/iscriviStudente")
//	public Studente iscriviStudente(@RequestParam(value="matr") String matricola, String cognome, String nome,
//								String date, int scuolaId) {
//		Studente stud = new Studente();
//		stud.setMatricola(matricola);
//		stud.setCognome(cognome);
//		stud.setNome(nome);
//		stud.setDataNascita(date);
//		
//		Scuola scuola = DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuolaId);
//		stud.setScuola(scuola);					
//		
//		DBManager.getInstance().studenteDAO().save(stud);				
//
//		return stud;
//	}
	
	@PostMapping("/iscriviStudente")
	public Studente iscriviStudente(@RequestBody Studente studente) {
		DBManager.getInstance().studenteDAO().save(studente);				

		return studente;
	}
	
	@PostMapping("/dammiScuola")
	public Scuola dammiScuola(@RequestParam Long scuolaId) {
		Scuola scuola = DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuolaId);
		return scuola;				
	}
	
}
