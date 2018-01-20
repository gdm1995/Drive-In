<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="utente" scope="session" class="Model.User"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
button
{
	border-radius:10px;
	border-color:green;
}
th,td
{
	border:"bold";
	
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accettazione</title>
</head>
<body background="Imm/bianco.jpg">
<h1 align="center">I tuoi dati</h1>
<table border=1>
<tr>
	<th>Nome</th> <th>Cognome</th><th>Username</th><th>Password</th><th>Indirizzo</th>
</tr>

<tr>
<!-- 	un altro modo potrebbe essere,essendo una servlet sono equivalenti <%=utente.getNome() %>-->
		<td><jsp:getProperty name="utente" property="nome"/></td>
		<td><jsp:getProperty name="utente" property="cognome"/></td>
		<td><jsp:getProperty name="utente" property="username"/></td>
		<td><jsp:getProperty name="utente" property="password"/></td>
		<td><jsp:getProperty name="utente" property="indirizzo"/></td>
	
	<!-- Oppure attraverso la request -->

	
		
</tr>
</table>
<a href="Registrazione.jsp"><button>Modifica!</button></a>
<form action="Salva" method="GET">
<button>Conferma!!!</button>
</form>
	
	
</body>
</html>