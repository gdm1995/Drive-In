function caricaProfilo2(nOrdine)
{
	var persona;
	var dataCompleta;
	var oggi = new Date();
	var year = oggi.getFullYear()
	var month = oggi.getMonth() + 1;
	var day = oggi.getDate();
	var ore = oggi.getHours();
	var minuti = oggi.getMinutes();
	dataCompleta = ("" + day + "/" + month + "/" + year + " alle " + ore + ":" + minuti);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function()
	{
		if (this.readyState == 4 && this.status == 200)
		{
			persona = JSON.parse(this.responseText);
			var tab, tr, td, div, center;

			div = document.getElementById("showing");// div per indicare da
			// dove inserire gli
			// elementi
			tab = document.createElement("table"); // creo la tabella per ogni
			// singolo elemento
			tab.setAttribute("class", "showProduct"); // tutte le tabelle
			// avranno la stessa
			// classe per
			// modificarle in
			// header.css
			tab.setAttribute("border", "1"); // tab.style.borderCollapse =
			// "collapse";

			tr = document.createElement("tr");// creo la riga per il codice
			td = document.createElement("td"); // creo l elemento dove
			// effettivamete mettero la
			// label per poi mettere il
			// codice
			td.appendChild(document.createTextNode("Acquirente"));// inserisco
			// la
			// label
			tr.appendChild(td);
			td = document.createElement("td");
			td.appendChild(document.createTextNode(persona.Nome + " "));
			td.appendChild(document.createTextNode(persona.Cognome));
			center = document.createElement("center");
			center.appendChild(td);
			tr.appendChild(center);
			tab.appendChild(tr);

			// data
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Data e ora in cui è stato effettuato ordine"));
			tr.appendChild(td);
			td = document.createElement("td");
			td.appendChild(document.createTextNode(dataCompleta));
			center = document.createElement("center");
			center.appendChild(td);
			tr.appendChild(center);
			tab.appendChild(tr);

			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Indirizzo di Spedizione"));
			tr.appendChild(td);
			td = document.createElement("td");
			td.appendChild(document.createTextNode(persona.IndirizzoStandard));
			center = document.createElement("center");
			center.appendChild(td);
			tr.appendChild(center);
			tab.appendChild(tr);

			var xhtp = new XMLHttpRequest();
			xhtp.onreadystatechange = function()
			{
				if (this.readyState == 4 && this.status == 200)
				{
					// alert("ricevo la seguente risposta" + this.responseText);
					var obj = JSON.parse(this.responseText);
					// alert("oggetto convertito"+ obj);
					// alert (" ho ricevuto tot oggetti"+ obj.Carrello.length);
					var totale = 0;
					for (var i = 0; i < obj.Carrello.length; i++)
					{
						totale += ((obj.Carrello[i].Prezzo) * (obj.Carrello[i].Dispo));
					}
					tr = document.createElement("tr");// creo la riga per il
					// codice
					td = document.createElement("td"); // creo l elemento dove
					// effettivamete mettero
					// la label per poi
					// mettere il codice
					td.appendChild(document.createTextNode("Totale Pagato"));// inserisco
					// la
					// label
					tr.appendChild(td);// aggiungo la label alla riga
					td = document.createElement("td"); // creo un altro td per
					// il codice vero e
					// proprio
					center = document.createElement("center");
					td.appendChild(document.createTextNode(totale + "€"));// inserisco
					// il
					// codice
					center.appendChild(td);
					tr.appendChild(center); // aggiungo nella riga l elemento

					var tab1 = document.getElementById("showing");
					tab.appendChild(tr);
				}
			};
			xhtp.open("GET", "RecuperaDati", true);
			// alert("salve");
			xhtp.send();

			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Iban utilizzato per il pagamento "));
			tr.appendChild(td);
			td = document.createElement("td");
			center = document.createElement("center");
			td.appendChild(document.createTextNode(persona.Iban));
			center.appendChild(td);
			tr.appendChild(center);
			tab.appendChild(tr);
			div.appendChild(tab);

			var xhp = new XMLHttpRequest();
			xhp.onreadystatechange = function()
			{
				if (this.readyState == 4 && this.status == 200)
				{
					var obji = JSON.parse(this.responseText);

					for (var i = 0; i < obji.Carrello.length; i++)
					{
						// acquisto il prodotto
						
						var xp = new XMLHttpRequest();// acquisto tutti gli elementi nel carrello
						var quy = "?codice=" + obji.Carrello[i].Codice + "&nOrdine=" + nOrdine + "&indirizzo=" + persona.IndirizzoStandard + "&colore=" + obji.Carrello[i].ProdCol + "&taglia=" + obji.Carrello[i].ProdTag + "&data=" + dataCompleta + "&dispo="
								+ obji.Carrello[i].DisponibTotale + "&quantita=" + obji.Carrello[i].Dispo;
						xp.open("GET", "Acquista" + quy, true);
						// //alert("sto inviando"+ query);
						xp.send();
					
						var xpt = new XMLHttpRequest(); // Elimino gli elementi acquistati dal carrello
						var quer = "?codice=" + obji.Carrello[i].Codice + "&colore=" + obji.Carrello[i].ProdCol + "&taglia=" + obji.Carrello[i].ProdTag;
						xpt.open("GET", "Delete" + quer, true);
						// //alert("sto inviando"+ quer);
						xpt.send();
					}
				}
			};
			xhp.open("GET", "RecuperaDati", true);// Qui invece otteniamo tutti i dati del prodotto + disponibilità selezionata
			// alert("salve");
			xhp.send();
		}
	};
	xhttp.open("GET", "Utente", true);
	// //alert("sto inviando"+ query);
	xhttp.send();
}
