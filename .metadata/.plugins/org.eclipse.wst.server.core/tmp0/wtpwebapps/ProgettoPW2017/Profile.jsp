<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	<meta http-equiv="Content-Language" content="it">
<meta name=”description” content=”Drive-in.com–Negozio_di_scarpe_online”>
<meta name="author" content="Giulio Di Maria, Matteo Volpe">
<meta name="keywords" content="shoes, Drive-in, italian-style"> 
<meta name="viewport" content="width=device-width, user-scalable=yes, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="CSS/Profile.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile of <%=session.getAttribute("user")%></title>
<script type="text/javascript" src="caricaProfilo.js"></script>
</head>
<body>
<body background="Imm/bianco.jpg">
			<script type="text/javascript">window.onload=(caricaProfilo())</script>
			<%if(session.getAttribute("user")!=null) 
				{%>
				<%@include file="HeaderLogged.jsp" %>
				<%}else{ %>
			<%@ include file="Header.jsp" %>
			<%} %>
			<div id="showing"></div>
		<footer>
			<%@ include file="Footer.jsp" %>
		</footer>
</body>
</html>