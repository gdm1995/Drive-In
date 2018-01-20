/**
 * Provvede alla disposizione dei vari prodotti all'interno del carrello e alla
 * ta
 */
function caricamento()
{
	// alert("buongiorno");
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			// alert("ricevo la seguente risposta" + this.responseText);
			obj = JSON.parse(this.responseText);
			// alert("oggetto convertito"+ obj);
			// alert (" ho ricevuto tot oggetti"+ obj.Carrello.length);
			if (obj.Carrello.length==0)
			{
				var div = document.getElementById("showing");
				var h3 = document.createElement("h3"); 
				var center = document.createElement("center");
				h3.appendChild(document.createTextNode("Nessun elemento inserito"));
				center.appendChild(h3);
				div.appendChild(center);
				var bottone = document.getElementById("bottone");
				bottone.style.display = "none";
			} else
			{
				var bottone = document.getElementById("bottone");
				bottone.style.display = "block";
				var totale =0;
				for (var i = 0; i < obj.Carrello.length; i++)
				{
					totale += addCarrello(obj.Carrello[i]);
				}
			}

		}
	};
	xhttp.open("GET", "RecuperaDati", true);
	// alert("salve");
	xhttp.send();

}