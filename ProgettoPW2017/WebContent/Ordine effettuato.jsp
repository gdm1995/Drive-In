<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="it">
<meta name=”description” content=”Drive-in.com–Negozio_di_scarpe_online”>
<meta name="author" content="Giulio Di Maria, Matteo Volpe">
<meta name="keywords" content="shoes, Drive-in, italian-style">
<meta name="viewport"
	content="width=device-width, user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="CSS/Profile.css">
<title>Pagina di conferma</title>
<script type="text/javascript" src="caricaProfilo2.js"></script>
<script type="text/javascript"> alert("Acquisto completato ");</script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body background="Imm/bianco.jpg">
<a href="Benvenuto.jsp"><img width="10%" title="Home"
		src="Imm/Logo.png"></a>
		<h1 align="center">Grazie per aver acquistato <i class="fa fa-thumbs-up"></i></h1>
		<h1 align="center">Riepilogo ordine</h1>
	<center><div id="showing">	
	<p>Numero ordine: </p>
		<script type="text/javascript">var nOrdine = Math.floor((Math.random() * 10000000000) + 1);; 
			var div;
			div = document.getElementById("showing");
			div.appendChild(document.createTextNode(nOrdine));
		</script><p></p>
	</form>
	</div>
	<div id="showing1"><script type="text/javascript">window.onload=(caricaProfilo2(nOrdine))</script></div>
	<form action="Benvenuto.jsp" method="get">
		<center style="clear: both;"><button id="bottone" onClick="Arrivederci()">Torna alla Home</button></center></center>
	<footer>
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>