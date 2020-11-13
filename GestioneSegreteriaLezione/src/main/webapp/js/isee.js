function Studente(nome, cognome, matricola, numeroComponenti){
	this.nome = nome;
	this.cognome = cognome;
	this.matricola = matricola;
	this.numeroComponenti = numeroComponenti;
	
	this.datiPersonali = function(){
		return "Nome: " + nome + " Cognome: " + cognome; 
	}
}

Studente.prototype.nazione = "Italia";

// Chiedere il numero dei componenti del nucleo familiare

window.onload = function(){
	var stud = new Studente("Mario", "Rossi", 123456, 2);
	var stud2 = new Studente("Bruno", "Bianchi", 32334, 1);
	calcolaIsee(stud);	
	calcolaIsee(stud2);	
}

// window.onload = calcolaIsee();	// Non funziona

function calcolaIsee(studente){
	alert ("Inizio calcolo ISEE sullo studente " + studente.datiPersonali());
	
	var numeroComponenti;  //undefined
	
	//numeroComponenti = prompt("Inserisci il numero dei componenti.");
	numeroComponenti = studente.numeroComponenti;
	
	var redditoComponenti = new Array();
	//redditoComponenti.push(345);
	var patrimonioComponenti = new Array();
	
	for (var i = 0; i < numeroComponenti; i++){
		redditoComponenti[i] = prompt("Dammi il reddito del componenti " + (i + 1));
		while (isNaN(redditoComponenti[i])){
			alert("Sono richiesti solo valori numerici. Riprovare");
			redditoComponenti[i] = prompt("Dammi il reddito del componenti " + (i + 1));
		}
		patrimonioComponenti[i] = prompt("Dammi il patrimonio del componenti " + (i + 1));
		while (isNaN(patrimonioComponenti[i])){
			alert("Sono richiesti solo valori numerici. Riprovare");
			patrimonioComponenti[i] = prompt("Dammi il patrimonio del componenti " + (i + 1));
		}
	}
	
	var redditoComplessivo = 0;
	var patrimonioComplessivo = 0;
	
	for (var i = 0; i < numeroComponenti; i++){
		redditoComplessivo += parseInt(redditoComponenti[i]);
		patrimonioComplessivo += parseInt(patrimonioComponenti[i]);
	}
	
	console.log(redditoComplessivo);
	console.log(patrimonioComplessivo);
	
	var ISR, ISP, ISE, ISEE, SE;
	
	ISR = redditoComplessivo;
	ISP = patrimonioComplessivo;
	
	scaleEquivalenza = {
		"1" : 1,	
		"2" : 1.57,
		"3" : 2.04,
		"4" : 2.46,
		m5 : 2.85
	};
	
	ISE = ISR + ISP * 20/100;
	
	funzioneCalcolaSe = function(numComp, scaleEq){
		if (numComp < 5){
			SE = scaleEq[numComp];	
		}else{
			SE = scaleEq.m5;
		}
		return SE;
	}
	
	var f = funzioneCalcolaSe;
	
	SE = f(numComponenti, scaleEquivalenza);
	
	
	console.log("SE " + SE);
	
	ISEE = ISE / SE;
	
	document.getElementById("numComponenti").innerText = numeroComponenti;
	document.getElementById("redditoComplessivo").innerText = redditoComplessivo;
	document.getElementById("patrimonioComplessivo").innerText = patrimonioComplessivo;
	document.getElementById("ise").innerText = ISE;
	document.getElementById("se").innerText = SE;
	document.getElementById("isee").innerText = ISEE;
}















