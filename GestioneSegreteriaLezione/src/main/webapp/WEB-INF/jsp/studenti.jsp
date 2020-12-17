<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<script src="/js/studenti.js"></script>
</head>
<body>

Elenco studenti
<div class="table-responsive">
<table id="tblStudenti" class="table table-striped table-bordered table-hover table-sm">
	<thead>
		<tr>
			<th></th>
			<th>Matricola</th>
			<th>Cognome</th>
			<th>Nome</th>
			<th>Data di Nascita</th>
			<th>Scuola di diploma</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="stud" items="${listStudenti}">
			<tr>
				<td><input type="checkbox" id="${stud.matricola}" name="${stud.matricola}" value="${stud.matricola}"></td>
				<td>${stud.matricola}</td>
				<td>${stud.cognome}</td>
				<td>${stud.nome}</td>
				<td>${stud.dataNascita}</td>
				<td>${stud.scuola.id}</td>				
			</tr>
		</c:forEach>	
	</tbody>
</table>
</div>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#formIscrivi">Iscrivi studente</button>
<button id="btnCancella" type="button" class="btn btn-danger">Cancella studente</button>

<!-- Modal -->
<!-- The Modal -->
<div class="modal" id="formIscrivi">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Iscrizione Studente</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
		<form>
			<div class="form-group">
				<label for="matricola">Matricola:</label> 
				<input type="number" class="form-control" placeholder="Insert student id" id="matricola" />
			</div>
			
			<div class="form-group">
				<label for="cognome">Cognome:</label> 
				<input type="text" class="form-control" placeholder="Insert surname" id="cognome" />
			</div>
			
			<div class="form-group">
				<label for="nome">Nome:</label> 
				<input type="text" class="form-control" placeholder="Insert name" id="nome" />
			</div>
			
			<div class="form-group">
				<label for="date">Data di Nascita:</label> <input type="date"
					class="form-control" placeholder="Enter Date" id="date">
			</div>
			
			<div class="form-group">
				<label for="school">Id Scuola:</label> <input type="text"
					class="form-control" placeholder="Enter School id" id="school">
			</div>
			
		</form>
	</div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button id="btnIscrivi" type="button" class="btn btn-primary">Iscrivi studente</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Chiudi</button>
      </div>

    </div>
  </div>
</div>


</body>
</html>