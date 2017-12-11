/**
 * Visualizza i prodotti che si stanno acquistando in un determinato momento all'interno del div "comprando"
 * @param prod prodotto selezionato che deve essere inserito tra quelli che si sta ipotizzando di acquistare
 */
function mostraCosaStoAcquistando(prod)
{
	var div, btn, tab, th, tr, td, totale; //totale per il prezzo totale a fine tabella
	var i=0;
	if(!entrato)
		{
			entrato=true;

			div = document.getElementById("comprando");
			tab = document.createElement("table");
			tab.setAttribute("border-collapse", "collapse");
			tab.setAttribute("border", "1");
			tab.setAttribute("width", "100%");
			tab.setAttribute("id","tabellaAcquisti");
			tr = document.createElement("tr");
			tr.id=("header");
			
			th = document.createElement("th");
			th.appendChild(document.createTextNode("  "));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Nome Prodotto"));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Codice"));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Colore"));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Taglia"));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Sesso"));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Quantità"));
			tr.appendChild(th);
			th = document.createElement("th");
			th.appendChild(document.createTextNode("Prezzo totale"));
			tr.appendChild(th);
			
			tab.appendChild(tr);
			div.appendChild(tab);
		}
	tab = document.getElementById("tabellaAcquisti"); //prendo la tabella creata per l'interimento degli oggetti acquistati
	tr = document.createElement("tr"); //creo una nuova riga
	tr.id=("tr"+i);
	i=i+1;
	acquistando.push(prod);

	
	var center = document.createElement("center"); //creo un elemento html5 per inserire l'immagine centrale
	var img = document.createElement("input"); //creo l immagine
//	img.setAttribute("id","frecciaDiRitorno");
	img.setAttribute("type","image");
	img.id=("ritorno");
	img.src= "Imm/return.jpg"; //assegno all immagine la sua giusta sorgente
	img.title="Escludi dall'acquisto";
	// scrivo la funzione
	img.onclick = function ()
	{
		//rimozione dell'elemento da quelli che si vogliono acquistare
		addCarrello(prod);
		var posizioneDaEliminareTemporanea = 0; //per trovare l'elemento da eliminare
		for(i=0;i<acquistando.length;i++)
		{
			if((acquistando[i].Codice===prod.Codice)&&(acquistando[i].ProdCol===prod.ProdCol)&&(acquistando[i].ProdTag===prod.Prodtag))
				posizioneDaEliminareTemporanea=i;alert("posizione da eliminare: "+posizioneDaEliminareTemporanea);
		}
		//Devo eliminare da acquistando l'elemento. Quindi ne prendo l'indice e unisco quello che ne viene prima con quello che ne viene dopo.
		var primaParte = acquistando.slice(0,posizioneDaEliminareTemporanea);alert("cosa prende prima parte: "+primaParte);
		var secondaParte = acquistando.slice((posizioneDaEliminareTemporanea+1),(acquistando.length+1));alert("cosa prende seconda parte: "+secondaParte);
		acquistando = primaParte.concat(secondaParte); //restituiscono la prima parte seguita dalla seconda e la inseriscono in acquistando
		x=document.getElementById("tr"+(i-(1+acquistando.length)));
		alert(acquistando.length);
		alert(x);
		tab.removeChild(x);
		if(!(acquistando.length>0))
		{
			entrato=false;
			x=document.getElementById("header");
			tab.removeChild(x);
		}
	}
	td = document.createElement("td");
	td.setAttribute("class","ritornoAcquisti");
	td.appendChild(center); //aggiungo al td l involucro dell immagine
	center.appendChild(img); //all involucro dell immagine concateno finalmente l'immagine 
	tr.appendChild(td); //inserisco il tutto nella riga per l immagine)
	
	td = document.createElement("td");
	td.appendChild(document.createTextNode(prod.Nome));
	tr.appendChild(td);
	td = document.createElement("td");
	td.appendChild(document.createTextNode(prod.Codice));
	tr.appendChild(td);
	td = document.createElement("td");
	td.appendChild(document.createTextNode(prod.ProdCol));
	tr.appendChild(td);
	td = document.createElement("td");
	td.appendChild(document.createTextNode(prod.ProdTag));
	tr.appendChild(td);
	td = document.createElement("td");
	td.appendChild(document.createTextNode(prod.Sesso));
	tr.appendChild(td);
	td = document.createElement("td");
	td.appendChild(document.createTextNode(prod.Dispo));
	tr.appendChild(td);
	td = document.createElement("td");
	td.appendChild(document.createTextNode((prod.Dispo)*(prod.Prezzo)));
	tr.appendChild(td);
	
	tab.appendChild(tr); // aggiungo alla tabella
	if(!uscito)
	{
		uscito=true;
		tr = document.createElement("tr"); //creo una nuova riga per il totale
		tr.id="tot";
		td = document.createElement("td");
		td.setAttribute("colspan", 7);
		td.appendChild(document.createTextNode("Totale"));
		tr.appendChild(td);

		td = document.createElement("td");
		totale=prod.Prezzo*prod.Dispo; //Prende il totale momentaneo dei prodotti per cui si è realmente interessati ad acquistare
		td.appendChild(document.createTextNode(totale));
		tr.appendChild(td);
	}
	else
	{
		if(!(acquistando.length > 1))
		{
			uscito=false;
			tota=document.getElementById("tot")
			tab.removeChild(tota);
		}
		tot=document.getElementById("tot")
		tab.removeChild(tot);//oppure tot.parentNode

		tr = document.createElement("tr"); //creo una nuova riga per il totale
		tr.id="tot";
		td = document.createElement("td");
		td.setAttribute("colspan", 7);
		td.appendChild(document.createTextNode("Totale"));
		tr.appendChild(td);
		
		td = document.createElement("td");
		totale=0;
		for(i=0;i<acquistando.length;i++)
		{
			totale = (totale+(acquistando[i].Prezzo*acquistando[i].Dispo));
		}
		td.appendChild(document.createTextNode(totale));
		tr.appendChild(td);
	}
	tab.appendChild(tr);
	
}
