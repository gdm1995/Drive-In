<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci</title>
<script>
function prodotto(val)
{
	var txt="";
	var marc="";
	var prodotto = val; // mi vado a prendere il valore che voglio inserire
	
	if(prodotto == 'Scarpa')
	{
	
	var taglia=[
	           "33",
	           "34",
	           "35",
	           "36",
	           "37",
	           "38",
	           "39",
	           "40",
	           "41",
	           "42",
	           "43",
	           "44",
	           "45",
	           "46"
	          ];
			txt +="<select>"
			for(var i=0; i<taglia.length; i++)
			{
				
				 txt += "<option>" + taglia[i];
			}
			txt+="</select>"
			document.getElementById("taglia").innerHTML= txt;
			
			
			
			
// 			var marca=[
// 			           "Addidas",
// 			           "Puma",
// 			           "Nike",
// 			           "Alcoot"
// 			           ];
		
// 				marc +="<select>"
				
// 			for(var j=0; j<marca.length; j++)
// 				{
// 					marc += "<option>" + marca[j];
// 				}
// 				marc+="</select>"
// 				document.getElementById("Nome").innerHTML= marc;
			
				
	}
	if(prodotto == 'Borsa')
		{
			var misura=[
			            "S",
			            "M",
			            "L"
			            ];
			
			txt +="<select>"
				for(var i=0; i<misura.length; i++)
				{
					 txt += "<option>" + misura[i];
				}
				txt+="</select>"
					document.getElementById("taglia").innerHTML= txt;
				
// 				var marca=[
// 				           "D&G",
// 				           "Pandora",
// 				           "Gucci",
// 				           "Prada"
// 				           ];
			
// 					marc +="<select>"
					
// 				for(var j=0; j<marca.length; j++)
// 					{
// 						marc += "<option>" + marca[j];
// 					}
// 					marc+="</select>"
// 					document.getElementById("Nome").innerHTML= marc;
				
		}
	return prodotto;
}
function sesso (val)
{
	var x = val;
	//alert("fa0"+ x);
	
}


function tag(taglia)
{
	var x = taglia
	//alert("taglia selezionata"+ x); 
	return x;
}
function imm(i)
{
	var z= i;
	//alert("sto selezionando"+ z);
}

function Aggiungi ()
{
	var file = document.getElementById("photo").value;
	file = file.substring(file.lastIndexOf('\\')+1);
	var tipo = document.getElementById("selezione").value;
	var sess = document.getElementById("sesso").value;
	
	var col= document.getElementById("colore").value;
	// si 
	
	var N_ele= document.getElementById("numeroE").value;

	var codice = document.getElementById("codice").value;
	// si
	
	var prezzo = document.getElementById("Prezzo").value;
	//alert("selezionato il prezzo"+ prezzo);
	
	var taglia= document.getElementById("taglia").value;
	//si
	var n= document.getElementById("Nome").value;

	//si
	
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatetchange = function()
	{
		if(this.readyState == 4 && this.status == 200 )
		{
			//alert ("sto ricevendo la seguente risposta "+ this.responseText); // ricevo un oggetto JSON
			obj = JSON.parse(this.responseText);
			//alert("Ecco la risposta"+ obj);
		}
				
	};
	var query="?tipo="+tipo+"&n="+n+"&sesso="+sess+"&col="+col+"&nE="+ N_ele+"&cod="+codice+"&prez="+prezzo+"&tag="+taglia+"&photo="+file;
	xhttp.open("GET","InserisciAmministratore"+query,true);
	xhttp.send();
	//alert("sto inviando la seguente query"+ query);
	// ora il problema sta nel prendere i valori degli oggetti che ho costruito dinamicamente attravreso jsvascript
	alert(" Ho aggiunto il prodotto : tipo="+tipo+" nome ="+n+" sesso="+sess+" col="+col+" con disp="+ N_ele+" codice="+codice+" prez="+prezzo+" tag="+taglia);
	//
}
</script>
</head>

<body background="Imm/bianco.jpg">
<form action="InserisciAmministratore">
<a id="ritorno" href="Amministratore.jsp"><img title="Home amministratore" src="Imm/FRECCIA.png"></a>
<br><br>
Prodotto
<select id="selezione" >
<option id="prodotto" value="Scarpa" onClick="prodotto(this.value)"> Scarpa </option>
<option id="accessori" value="Borsa" onClick="prodotto(this.value)"> Borsa</option>
</select>
<p id="">

<label>Sesso</label>
<select id="sesso">
<option id="Uomo" value ="M" onClick="sesso(this.value)">MASCHILE</option>
<option id="Donna" value="D" onClick="sesso(this.value)" >FEMMINILE </option>
</select>

Colore
<input id="colore" type="color">

#Elementi
<input id="numeroE" type="text">

Taglia
<select id="taglia" onchange="tag(this.value)">
</select>

Codice
<input id="codice" type="text">
Prezzo
<input id="Prezzo" type="text">


Nome
<input id="Nome" type="text">



Photo:
<input type="File" name="photo" id="photo" >

<input type="button" value="Aggiungi" onclick="Aggiungi()"> 

<!-- ora devo far in modo di far apparire la foto ( in stringhe) dell'oggetto che sto selezionando -->
</form>




</body>
</html>