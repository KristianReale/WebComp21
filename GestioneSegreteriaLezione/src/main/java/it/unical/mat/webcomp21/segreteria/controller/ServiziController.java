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
	
//	matricola: matr, cognome: cogn, nome: nome, date:date
	
	@PostMapping("GestioneStudenti/iscriviStudente")
	public String iscriviStudente(@RequestParam(value="matr") String matricola, String cognome, String nome,
								String date, int scuola) {
		System.out.println(matricola);
		System.out.println(cognome);
		System.out.println(nome);
		System.out.println(date);
		System.out.println(scuola);
		
		Studente stud = new Studente();
		stud.setMatricola(matricola);
		stud.setCognome(cognome);
		stud.setNome(nome);
		stud.setDataNascita(date);
		
		Scuola scuolaObj = null;// dal dao;
		stud.setScuola(scuolaObj);					
		
		DBManager.getInstance().studenteDAO().save(stud);				
		
		return "SUCCESS";
	}
}
