<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="it">
<meta name=”description” content=”Drive-in.com–Negozio_di_scarpe_online”>
<meta name="author" content="Giulio Di Maria, Matteo Volpe">
<meta name="keywords" content="shoes, Drive-in, italian-style">
<meta name="viewport" content="width=device-width, intial-sclae=1.0">
<link rel="stylesheet" href="CSS/benvenuto.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="cambio.js"></script>
<script type="text/javascript" src="addProdotto.js"></script>
<script type="text/javascript" src="clearTable.js"></script>
<title>Amministratore</title>
<script>
	var valid =
	[];//variabile per sapere il totale degli elementi realmente caricati precedentemente
</script>
</head>
<body background="Imm/bianco.jpg">
	<%-- <% if (session.getAttribute("modificato")!=null)	 --%>
	<%-- response.setHeader("Refresh", "4;Amministratore.jsp"); %> --%>
	<script type="text/javascript">
		window.onload = (cambio("Tutto", "T", null, 1))
	</script>
	<%@ include file="HeaderAmm.jsp"%>
	<div id="showing">
		<aside>
			<%@ include file="AsideAmm.jsp"%>
		</aside>
	</div>
	<footer>
		<%@ include file="Footer.jsp"%>
	</footer>
</body>
</html>