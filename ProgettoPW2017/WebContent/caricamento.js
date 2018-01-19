/**
 * Provvede alla disposizione dei vari prodotti all'interno del carrello e alla ta
 */
function caricamento()
{
	// alert("buongiorno");
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			alert("ricevo la seguente risposta" + this.responseText);
			obj = JSON.parse(this.responseText);
			// alert("oggetto convertito"+ obj);
			// alert (" ho ricevuto tot oggetti"+ obj.Carrello.length);
			for (var i = 0; i < obj.Carrello.length; i++)
			{
				addCarrello(obj.Carrello[i],obj.Username);
			}
		}
	};
	xhttp.open("GET", "RecuperaDati", true);
	// alert("salve");
	xhttp.send();
	
	
}
