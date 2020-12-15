function Studente(matricola, cognome, nome, email){
	this.matricola = matricola;
	this.cognome = cognome;
	this.nome = nome;
	this.email = email;
}

//window.addEventListener("load", inizializza));

window.addEventListener("load", function(){
	//inizializzaDati();
	//popolaTabella();
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
		aggiungiStudente(stud, false);
	});
}

function registraEventi(){
	var butIscrivi = document.getElementById("btnIscrivi");
	butIscrivi.addEventListener("click", iscriviStudente);
	
	var butCancella = document.getElementById("btnCancella");
	butCancella.addEventListener("click", cancellaStudenti);
}

function cancellaStudenti(){
	var checkBox = document.querySelector('input:checked');
	var matricola = checkBox.value;
	if (checkBox != null){
		indexDaCancellare = null;
		tuttiStudenti.forEach(function (stud, index){
			if (stud.matricola == matricola){
				daCancellare = index;
			}
		});
		//alert(tuttiStudenti.length);
		//alert(indexDaCancellare);
		if (daCancellare != null){
			tuttiStudenti.splice(indexDaCancellare, 1);
		}
		cancellaDaTabella(indexDaCancellare);
		//alert(tuttiStudenti.length);
	}else{
		alert("Seleziona almeno un elemento");
	}
}

function cancellaDaTabella(indexDaCancellare){
	var table = document.querySelector(".table");
	var row = table.rows[indexDaCancellare + 1];
	row.remove();
}

function nascondiStudente(){
	var row = document.querySelector(".table").rows[1];	
	row.style.display='none';
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

function aggiungiStudente(studente, salvaInArray = true){
	if (salvaInArray){
		tuttiStudenti.push(studente);
	}
	
	var table = document.querySelector(".table");
	var row = table.insertRow(-1);
	//row.insertCell(studente.matricola);
	var cellCheckbox = row.insertCell(0);
	cellCheckbox.innerHTML= "<input type=\"checkbox\" id=\"" + studente.matricola + "\" name=\"" + studente.matricola + "\" value=\"" + studente.matricola + "\">";
	
	var cellMatricola = row.insertCell(1);
	cellMatricola.textContent = studente.matricola;
	
	var cellCognome = row.insertCell(2);
	cellCognome.textContent = studente.cognome;
	
	var cellNome = row.insertCell(3);
	cellNome.textContent = studente.nome;
	
	var cellEmail = row.insertCell(4);
	cellEmail.textContent = studente.email;
}















