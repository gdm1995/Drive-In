/**
 * Rende il sito responsive a seconda delle varie grandezze dello schermo. Sotto la grandezza dei 680 px, sposta la
 * selezione laterale in una tabella che si troverà sulla parte superiore della schermata
 * 
 * @param val Permette di comprendere se la richiesta di eseguire lo spostamento della tabella è stata fatta da un
 *            amministratore (1) oppure da un utente normale (0)
 */
function SelezioneVeloce(val)
{
	var width = $(window).width();
	if (flag)
	{
		if (width < 680)
		{
			flag = false; // flag essenziale altrimenti fa migliaia di volte la stessa operazione
			// così invece ricontrolla solo una condizione quando lo schermo viene ridimensionato.
			var div, btn, tab, th, tr, td;
			div = document.getElementById("selezione");
			tab = document.createElement("table");
			tab.setAttribute("border-collapse", "collapse");
			tab.setAttribute("border", "1");
			tab.setAttribute("id", "mod");
			tab.setAttribute("width", "100%");
			tr = document.createElement("tr");
			th = document.createElement("th");
			th.setAttribute("colspan", 2);
			btn = document.createElement("button");
			btn.setAttribute("onclick", "cambio('Tutto','M',null," + val + ")");
			btn.appendChild(document.createTextNode("Uomo"));
			th.appendChild(btn);
			tr.appendChild(th);
			th = document.createElement("th");
			th.setAttribute("colspan", 2);
			btn = document.createElement("button");
			btn.setAttribute("onclick", "cambio('Tutto','D',null," + val + ")");
			btn.appendChild(document.createTextNode("Donna"));
			th.appendChild(btn);
			tr.appendChild(th);
			tab.appendChild(tr);
			tr = document.createElement("tr");
			td = document.createElement("td");
			btn = document.createElement("button");
			btn.setAttribute("onclick", "cambio('Scarpa','M',null," + val + ")");
			btn.appendChild(document.createTextNode("Scarpe"));
			td.appendChild(btn);
			tr.appendChild(td);
			td = document.createElement("td");
			btn = document.createElement("button");
			btn.setAttribute("onclick", "cambio('Borsa','M',null," + val + ")");
			btn.appendChild(document.createTextNode("Borse"));
			td.appendChild(btn);
			tr.appendChild(td);
			td = document.createElement("td");
			btn = document.createElement("button");
			btn.setAttribute("onclick", "cambio('Scarpa','D',null," + val + ")");
			btn.appendChild(document.createTextNode("Scarpe"));
			td.appendChild(btn);
			tr.appendChild(td);
			td = document.createElement("td");
			btn = document.createElement("button");
			btn.setAttribute("onclick", "cambio('Borsa','D',null," + val + ")");
			btn.appendChild(document.createTextNode("Borse"));
			td.appendChild(btn);
			tr.appendChild(td);
			tab.appendChild(tr);
			div.appendChild(tab);
		}
	}
}
