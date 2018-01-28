<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="CSS/Registrazione-login.css">
<script src="http://code.jquery.com/jquery-1.6.4.min.js" type="text/javascript"></script> <!-- Funziona solo con connessione -->
<title>Registrazione</title>

<script type="text/javascript">


function username(username)
{
	//var confronto = /^[A-Za-z0-9]{3-15}$/; 
	var confronto =('^[A-Za-z0-9]+$');
	return verifica(username, confronto); 
}

function password(password)
{
	//var confronto=('((?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})'); //password che deve contenere un numero, un carattere minuscolo, uno maiuscolo e un carattere speciale tra @#$% e deve avere lunghezza min 8 e max 20)
	var confronto =('^[A-Za-z0-9]+$');
	return verifica(password,confronto);
}
function name(nome)
{
	var confronto = /^[A-Za-z0-9]+$/; 
	return verifica(nome, confronto); 
}
function cognome(cognome)
{
	var confronto = /^[A-Za-z0-9]+$/; 
	return verifica(cognome, confronto); 
}
function indirizzo(indirizzo)
{
	var confronto = /^+[A-Za-z0-9]+$/; 
// 	var confronto=/^(\w)+\s+(\w)+\s+(\d){1,4}$/;   	
	return verifica(indirizzo, confronto);
}

function verifica(campo, formato)
{
	if(campo.value.match(formato))
		{
			return true;
		}
	else
		{
			return false;
		}
}

function isEmpty(field){
    if(field.value.length <= 0)  
		return true;  
    else  
		return false;
}
function clearForm(form){
	//reset input border color
	var inputs = form.getElementsByTagName("input");
	for(var i = 0; i<inputs.length; i++)
		inputs[i].style.borderColor = "black"; 
	
	//delete previous error messages
	var spans = form.getElementsByTagName("span");
	for(var i = 0; i<spans.length; i++)
		form.removeChild(spans[i]);
}

function carica(form)
{
clearForm(form);
	var errore ="";
	var errpos;
	if(!username(form.username))
		{
			errpos= form["username"];
			errore="formato non corretto min 3 max 15";
		}
	else if(!password(form.password))
	{
		errpos= form["password"];
		errore=" formato non corretto, min 8 max 20";
	}
	else if(!indirizzo(form.indirizzo)) 
		{
			errpos=form["indirizzo"];
			errore="formato non corretto";
		}
		
		
		var inputs = form.getElementsByTagName("input");
	for(var i = inputs.length-2; i>=0; i--)
		if (isEmpty(inputs[i])){
	
			errpos = inputs[i];
			err = "Questo campo non può essere vuoto" +i;
			}

	if(errore != null)
		{
			errpos.style.borderColor="red";
			return false;
		}
	return true;
}

</script>


</head>
<body background="Imm/bianco.jpg">
<h1>Drive-in</h1>
<h2 >Registrazione</h2>
	<div id="primo">
		<table>
			<form name='example' action="Registrazione" method="post" onSubmit="return carica(this);">
				<tr>
					<th>Crea il tuo Account Drive-In<br><br></th>
				</tr>
				<tr>
					<td style="color:Green;"><big><b><i>Username</i></b></big><br><br></td>
				</tr>
				<tr>
					<td><input id="username" type="text" name="username" ><br><br></td><br>
				</tr>
				<tr>
					<td style="color:Green;"><big><b><i>Password</i></b></big><br><br></td>
				</tr>
				<tr>
					<td><input id="password" type="password" name="password"><br><br></td>
				</tr>
				<tr>
					<td style="color:Green;"><big><b><i>Nome</i></b></big><br><br></td>
				</tr>
				<tr>
					<td><input id="nome" type="text" name="nome"><br><br></td>
				</tr>
				<tr>
					<td style="color:Green;"><big><b><i>Cognome</i></b></big><br><br></td>
				</tr>
				<tr>
					<td>
					<input id="cognome" type="text" name="cognome" ><br><br></td>
				</tr>
				<tr>
					<td style="color:Green;"><big><b><i>Indirizzo fatturazione</i></b></big><br><br></td>
				</tr>
				<tr>
					<td><input type="text" name="indirizzo" ><br><br>
					<br></td>
				</tr>
				<tr>
					<td><input type="submit" value="Crea il tuo Account Drive-In"><br></td>
				</tr>
				</form>
				
				<form>
				<tr>
					<th>Accedendo dichiari di aver letto e accetti integralmente le nostre Condizioni generali di uso e vendita, la nostra Informativa sulla privacy e le nostre policy su Cookies e pubblicità su Internet. <hr>
				 Disponi già di un account <a href="login_registrazione.jsp">Accedi</a></th>
					</tr>
				</form>
			</table>
		</div>
	</body>
</html>