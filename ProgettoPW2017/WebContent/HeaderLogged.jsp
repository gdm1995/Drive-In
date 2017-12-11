<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Content-Language" content="it">
		<meta name=”description” content=”Drive-in.com–Negozio_di_scarpe_online”>
		<meta name="author" content="Giulio Di Maria, Matteo Volpe">
		<meta name="keywords" content="shoes, Drive-in, italian-style"> 
		<meta name="viewport" content="width=device-width, intial-sclae=1.0">
		<link rel="stylesheet" href="CSS/Ammheaders.css">
	</head>
	<body background="Imm/bianco.jpg">
		<header>
			<table>
				<tr>
					<th class="logo"><a href="Benvenuto.jsp"><img id="logo" src="Imm/Logo.png" alt="Logo"></a></th>
					<th class="ricerca">
						<div>
							<h3> Sito ufficiale di Drive-In</h3>
							<!-- <input onsubmit="cambio(null,null,ricerca_oggetti.value,0)" type="text" id="ricercabar" name="ricerca_oggetti"> -->
							<!-- <input onclick="cambio(null,null,ricerca_oggetti.value,0)" type="image" id="lente" src="Imm/Lente.png" alt="lente per la ricerca"> -->
						</div>
					</th>
					<th class="accesso">
						<p>Benvenuto <%=session.getAttribute("user")%></p>
					</th>
					<!-- da linkare al carello -->
					<th class="carts">
						<p id ="testo">Operazioni</p>
						<a href="Carrello.jsp" title="Carrello"><img  alt="Cart" src="Imm/carrello.png"></a>
						<a href="Logout" title="Logout"><img  alt="Cart" src="Imm/Bye.png"></a>
					</th>
				</tr>
			</table>
		</header>
	</body>
</html>