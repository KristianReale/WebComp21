package it.unical.mat.webcomp21.segreteria;

import java.util.List;

import it.unical.mat.webcomp21.model.Studente;
import it.unical.mat.webcomp21.persistence.DBManager;
import it.unical.mat.webcomp21.persistence.dao.StudenteDAO;

public class TestDB {
	public static void main(String[] args) {
		StudenteDAO sDao = DBManager.getInstance().studenteDAO();
		List<Studente> studenti = sDao.findAll();
		for (Studente s : studenti) {
			System.out.println(s.getCognome());
			System.out.println(s.getNome());
		}
		
	}
}
