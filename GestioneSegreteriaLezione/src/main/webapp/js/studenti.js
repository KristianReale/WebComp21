function Studente(matricola, cognome, nome, email){
	this.matricola = matricola;
	this.cognome = cognome;
	this.nome = nome;
	this.email = email;
}

//window.addEventListener("load", inizializza));

window.addEventListener("load", function(){
	inizializzaDati();
	popolaTabella();
	registraEventi();	
});

var tuttiStudenti = new Array();

function inizializzaDati(){	
	var studente1 = new Studente(123456, "Rossi", "Mario", "mario@unical.it");	
	tuttiStudenti.push(studente1);
	
	var studente2 = new Studente(34562, "Bianchi", "Bruno", "bruno@unical.it");	
	tuttiStudenti.push(studente2);
	
	var studente3 = new Studente(76443, "Verdi", "Giulio", "giulio@unical.it");	
	tuttiStudenti.push(studente3);
	
	var studente4 = new Studente(66444, "Neri", "Marco", "marco@unical.it");	
	tuttiStudenti.push(studente4);	
}

function popolaTabella(){
	// for (Studente stud : tuttiStudenti)  // Versione Java 
	tuttiStudenti.forEach(function (stud, index){
		aggiungiStudente(stud);
	});
}

function registraEventi(){
	var butIscrivi = document.getElementById("btnIscrivi");
	butIscrivi.addEventListener("click", iscriviStudente);
}

function iscriviStudente(){
	// var bottone = document.querySelector("#btnIscrivi");
	
	var matricola = document.querySelector("#matricola").value;			
	var cognome = document.querySelector("#cognome").value;
	var nome = document.querySelector("#nome").value;
	var email = document.querySelector("#email").value;
	
	var studente = new Studente(matricola, cognome, nome, email);
	
	aggiungiStudente(studente);
}

function aggiungiStudente(studente){
	tuttiStudenti.push(studente);
	
	var table = document.querySelector(".table");
	var row = table.insertRow(-1);
	//row.insertCell(studente.matricola);
	var cellMatricola = row.insertCell(0);
	cellMatricola.textContent = studente.matricola;
	
	var cellCognome = row.insertCell(1);
	cellCognome.textContent = studente.cognome;
	
	var cellNome = row.insertCell(2);
	cellNome.textContent = studente.nome;
	
	var cellEmail = row.insertCell(3);
	cellEmail.textContent = studente.email;
}















