<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="it">
<meta name=”description” content=”Drive-in.com–Negozio_di_scarpe_online”>
<meta name="author" content="Giulio Di Maria, Matteo Volpe">
<meta name="keywords" content="shoes, Drive-in, italian-style">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="CSS/headers.css">
<script>
		function verifica() 
		{
			alert("Loggati per accedere al carrello");
		}
	</script>
</head>
<body background="Imm/bianco.jpg">
	<header>
		<table class="top">
			<tr>
				<th class="logo"><a href="Benvenuto.jsp"><img id="logo"
						src="Imm/Logo.png" alt="Logo"></a></th>
				<th class="ricerca">
					<div>
						<h3>Benvenuto sul Drive-In</h3>
						<!-- <input onsubmit="cambio(null,null,ricerca_oggetti.value,0)" type="text" id="ricercabar" name="ricerca_oggetti"> -->
						<!-- <input onclick="cambio(null,null,ricerca_oggetti.value,0)" type="image" id="lente" src="Imm/Lente.png" alt="lente per la ricerca"> -->
					</div>
				</th>
				<th class="accesso"><a href="login_registrazione.jsp">
				<input type="submit" value="Accedi"></a> <a href="Registrazione.jsp">
				<input type="submit" value="Registrati"></a></th>
				<!-- da linkare al carello -->
				<th class="cart"><a href="login_registrazione.jsp" id="testo"
					onclick="verifica()">Carrello</a> <a href="login_registrazione.jsp"><img
						id="cart" alt="Cart" src="Imm/carrello.png" onclick="verifica()"></a>
				</th>
			</tr>
		</table>
	</header>
</body>
</html>