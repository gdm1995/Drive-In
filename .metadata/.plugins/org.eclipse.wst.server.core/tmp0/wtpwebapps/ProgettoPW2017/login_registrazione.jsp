
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Accedi</title>
<link type="text/css" rel="stylesheet"
	href="CSS/Registrazione-login.css">
<script src="http://code.jquery.com/jquery-1.6.4.min.js"
	type="text/javascript"></script>
<!-- Funziona solo con connessione -->
</head>

<body background="Imm/bianco.jpg">
	<%
		if (session.getAttribute("presente") != null) // se entri per la prima volta, sara nullo, e il tipo OBject puo essere null
		{
			// MI SERVE PER MANDARE IL MESSAGGIO CHE L'UTENTE NON è PRESENTE SUL DATABASE
			boolean flag = false;
			flag = (boolean) session.getAttribute("presente");

			if (flag != false) {
	%>
	<%-- <%=flag %> --%>
<body onload="errore()">
	<%
		}
		}
	%>


	<%
		//SU ACQUISTO
		if (session.getAttribute("loggato") != null) // se entri per la prima volta, sara nullo, e il tipo OBject puo essere null
		{

			boolean nloggato = false;
			nloggato = (boolean) session.getAttribute("loggato");
			if (nloggato != false) {
	%>

<body onload="riaccedi()">

	<%
		}
		}
	%>

	<script type="text/javascript">
		// function riaccedi ()
		// {
		// 	var paragrafo =$('<p>Autentificati</p>');
		// 	$("body").prepend(paragrafo);
		// }
		function errore()
		{
			var paragrafo = $('<h5>Non Risulti, inserisci i dati!!</h5>');
			$(paragrafo).css(
			{
				"color" : "red"
			});
			$(paragrafo).css(
			{
				"text-align" : "center"
			});
			// 	var segnalazione = createElement("script");
			//	segnalazione.appendChild(document.createTextNode("Non sei presente"));
			$("body").prepend(paragrafo);
			// 	$("body").appendChild(segnalazione);
		}
		function ctrluser(user)
		{
			var c = ('^[A-Za-z0-9]+$') // caratteri alfanumerici compresi tra 'a' e 'z', da 0 a 9 con minimo 3 caratteri e massimo 15
			return verifica(user, c);
		}
		function ctrlpass(pass)
		{
			//var d=('((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})'); //password che deve contenere un numero, un carattere minuscolo, uno maiuscolo e un carattere speciale tra @#$% e deve avere lunghezza min 8 e max 20)
			var d = ('^[A-Za-z]+$');
			return verifica(pass, d);
		}
		function verifica(campo, formato)
		{
			if (campo.value.match(formato))
			{
				return true;
			} else
			{
				return false;
			}
		}
		function isEmpty(field)
		{
			if (field.value.length <= 0)
				return true;
			else
				return false;
		}
		function clearForm(form)
		{
			//reset input border color
			var inputs = form.getElementsByTagName("input");
			for (var i = 0; i < inputs.length; i++)
				inputs[i].style.borderColor = "black";
			//delete previous error messages
			/* nel caso di eliminazione del messaggio di errore
			var spans = form.getElementsByTagName("span");
			for(var i = 0; i<spans.length; i++)
				form.removeChild(spans[i]);
			 */
		}
		function controllami(form)
		{
			var errore = "";
			var errpos;
			if (!ctrluser(form.user))
			{
				errpos = form["user"];
				errore = "formato non corretto";
			} else if (!ctrlpass(form.password))
			{
				errpos = form["password"];
				errore = "formato non correttopassword";
			}
			var inputs = form.getElementsByTagName("input");
			for (var i = inputs.length - 2; i >= 0; i--)
				if (isEmpty(inputs[i]))
				{
					errpos = inputs[i];
					errore = "Questo campo non può essere vuoto";
				}
			if (errore != null)
			{
				errpos.style.borderColor = "red";
				/*
				var mex= document.createTextNode("ERROR: "+ errore);
				
				var span= document.createElement('span');
				span.style.color="red";
				span.appendChild(mex);
				form.insertBefore(span, errpos.nextSibiling);
				 */
				return false;
			}
			return true;
		}
	</script>

	<h1>Drive-in</h1>
	<br>
	<div>
		<table>
			<form name="registrazione" action="Controllo" method="post"
				onSubmit="return controllami(this);">

				<tr>
					<th><big><b><i><h1>Accedi</h1></i></b></big></th>
				<tr>
					<th style="color: Green;"><big><b><i>Username</i></b></big></th>
				</tr>
				<tr>
					<td><input id="user" type="text" name="user"
						placeholder="Inserisci Username" autofocus></input></td>
				</tr>

				<tr>
					<th style="color: Green;"><big><i>Password</i></big></th>
				</tr>
				<tr>
					<td><input id="password" type="password" name="password" placeholder="Password"></input><br>
					<br></td>
				</tr>

				<tr>
					<td><input type="submit" value="accedi"></input><br>
					<br>
					<hr>Sei nuovo su Drive-In?</td>
				</tr>
			</form>


			<tr>
				<td><a href="Registrazione.jsp"><button>Crea il tuo Account Drive-In</button></a></td>
			</tr>
		</table>

	</div>

</body>
</html>