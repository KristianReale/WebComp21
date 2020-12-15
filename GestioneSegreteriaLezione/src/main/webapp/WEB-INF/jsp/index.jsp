<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="css/home.css" type="text/css" />

</head>
<body>
	<h1>Pagina Iniziale</h1>
	<div class="row">
		<div class="col-lg-3 col-md-3">
			<figure>		
				<img src="images/segreteria.jpg" />
				<figcaption class="sopraImmagine"><h3>La nostra segreteria studenti</h3></figcaption>
			</figure>
		</div>
		
		<div class="col-lg-5 col-md-5">
			<h1>Portale segreteria studenti</h1><h1>Portale gestione segreteria studenti</h1>
		</div>
		
		<div class="col-lg-4 col-md-4">
			<c:if test="${usernameLogged == null}"> 
				<a href="" data-toggle="modal" data-target="#modalSubscriptionForm">Login</a>
			</c:if>
			<c:if test="${usernameLogged != null}"> 
				Utente loggato: ${usernameLogged}
				<a href="doLogout">Logout</a>
			</c:if>
		</div>
	</div>
	<!-- 
	<figure class="assoluta">
			<img src="images/logo_unical.png" />
		</figure>
		 -->
	
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <!-- Links -->
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Studenti</a>
	      <ul class="dropdown-menu">
	      	<li><a class="dropdown-item" href="GestioneStudenti/studenti.html">Elenco studenti</a></li>
	      	<li><a class="dropdown-item" href="GestioneStudenti/iscriviStudente.html">Iscrivi studente</a></li>
	      	<li><a class="dropdown-item" href="GestioneStudenti/calcolaIsee.html">Calcola ISEE</a></li>
	      </ul>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Corsi</a>
	      <ul class="dropdown-menu">
	      	<li>Elenco Corsi</li>
	      	<li>Corsi a numero chiuso</li>
	      	<li>Corsi a numero aperto</li>
	      </ul>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Corsi di Laurea</a>
	    </li>
	    <li class="nav-item">
	      <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Dipartimenti</a>
	    </li>
	  </ul>
	
	</nav>
	<h3 id="benvenuto">
		Benvenuti nel portale di gestione delle Segreterie Studenti
	</h3>
	<p id="p1">
		Utilizza il menu in alto per navigare tra le varie sezioni della pagina
	</p>
	<p id="p2">
		Ti auguriamo una felice navigazione
	</p>
	
	<section class="row">
		<article class="col-lg-6 col-md-6">
			<section class="jumbotron">
				<h4>Dicono di noi</h4>
				<p>La segreteria è un servizio di riferimento che serve per...</p>
			</section>
		</article>
		
		<article class="col-lg-6 col-md-6">
			<article class="jumbotron">
				<h4>Centro ICT di Ateneo</h4>
				<p>Dalla pagina accessibile da questo <a href="https://www.unical.it/portale/strutture/centri/centroict/">link</a></p>
			</article>
		</article>
	</section>
	
	<section class="row">
		<article class="col-lg-6 col-md-6">
			<section class="jumbotron specifico">
				<h4>Dicono di noi</h4>
				<p>La segreteria è un servizio di riferimento che serve per...</p>
			</section>
		</article>
		<article id="id_fratello" class="col-lg-6 col-md-6 fratello">
			<section class="jumbotron">
				<h4>Centro ICT di Ateneo</h4>
				<p class="specifico">Dalla pagina accessibile da questo <a href="https://www.unical.it/portale/strutture/centri/centroict/">link</a></p>
			</section>
		</article>
	</section>
	<footer>
		Web Computing 2021 Ltd.
	</footer>
	
	
	<div class="modal fade" id="modalSubscriptionForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
		 <form method="POST" action="doLogin">
		    <div class="modal-content">
		      <div class="modal-header text-center">
		        <h4 class="modal-title">Login</h4>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">          
		        </button>
		      </div>
		      <div class="modal-body mx-3">
		        <div class="md-form mb-5">          
		          <input type="text" id="form3" class="form-control" name="username">
		          <label  for="form3">Username</label>
		        </div>
		
		        <div class="md-form mb-4">          
		          <input type="password" id="form2" class="form-control" name="password">
		          <label for="form2">Password</label>
		        </div>
		
		      </div>
		      <div class="modal-footer justify-content-center">
		        <input type="submit" class="btn btn-success" value="Send"> </input>
		      </div>
		    </div>
	    </form>
	  </div>
	
	
	
	
	
</body>
</html>