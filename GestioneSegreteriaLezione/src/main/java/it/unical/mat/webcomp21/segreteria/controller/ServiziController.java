package it.unical.mat.webcomp21.segreteria.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiziController {
	
//	matricola: matr, cognome: cogn, nome: nome, date:date
	
	@PostMapping("GestioneStudenti/iscriviStudente")
	public String iscriviStudente(String matricola, String cognome, String nome,
								String date) {
		System.out.println(matricola);
		System.out.println(cognome);
		System.out.println(nome);
		System.out.println(date);
		
		return "SUCCESS";
	}
}
