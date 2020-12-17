package it.unical.mat.webcomp21.segreteria.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.unical.mat.webcomp21.model.Scuola;
import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.DBManager;

@RestController
public class ServiziController {
	
	@PostMapping("GestioneStudenti/iscriviStudente")
	public String iscriviStudente(@RequestParam(value="matr") String matricola, String cognome, String nome,
								String date, int scuolaId) {
//		System.out.println(matricola);
//		System.out.println(cognome);
//		System.out.println(nome);
//		System.out.println(date);
//		System.out.println(scuolaId);
		
		Studente stud = new Studente();
		stud.setMatricola(matricola);
		stud.setCognome(cognome);
		stud.setNome(nome);
		stud.setDataNascita(date);
		
		Scuola scuola = DBManager.getInstance().scuolaDAO().findByPrimaryKey(scuolaId);
		stud.setScuola(scuola);					
		
		DBManager.getInstance().studenteDAO().save(stud);				

		return "SUCCESS";
	}
}
