/**Aggiunge un prodotto con tutte le sue caratteristiche alla schermata che al momento si sta visualizzando (lì dove è presente il div con id "showing").
 * @param prod Prodotto che stiamo per aggiungere con tutte le sue informazioni
 * @param q Valore utilizzato per creare un id dinamico della tabella che stiamo per costruire contente il prodotto
 * @param val Valore utilizzato in modo binario, che identifica se stiamo parlando di un utente normale (0), oppure di un amministratore (1)
 * In base a val si avranno dei layout diversi che permetteranno ai due attori di interagire diversamente col sistema
 */
function addProdotto(prod,q,val)
		{
			var tab,tr,td,div;
			div = document.getElementById("showing");//div per indicare da dove inserire gli elementi
			tab = document.createElement("table"); //creo la tabella per ogni singolo elemento
			tab.setAttribute("class","showProduct"); //tutte le tabelle avranno la stessa classe per modificarle in header.css
			tab.setAttribute("border","1");
//			tab.style.borderCollapse = "collapse";
			var testo = "NumeroElemento"+q;
			tab.setAttribute("id",testo);
			valid.push(q);
			
			tr = document.createElement("tr"); //creo la prima riga per l header
			var th = document.createElement("th"); //creo l'unico header che visualizzerà il nome del prodotto
			th.setAttribute("colspan",2);//rendo la riga larga come due colonnne
			th.appendChild(document.createTextNode(prod.nome)); //creo un nodo che inserisco nell'header col nome del prodotto
			tr.appendChild(th); //aggiungo l header prima creato alla riga
			tab.appendChild(tr); //aggiungo alla tabella
			
			tr = document.createElement("tr"); //procedo con la riga per l immagine 
			var center = document.createElement("center"); //creo un elemento html5 per intermediare con l immagine
			var img = document.createElement("img"); //creo l immagine
			img.src= "Imm/"+prod.nomeImg; //assegno all immagine la sua giusta sorgente
			td = document.createElement("td");//creo il table data dove mettere il tutto 
			td.setAttribute("colspan",2);//rendo la riga larga come due colonnne
			td.appendChild(center); //aggiungo al td l involucro dell immagine
			center.appendChild(img); //all involucro dell immagine concateno finalmente l'immagine 
			tr.appendChild(td); //inserisco il tutto nella riga per l immagine)
			tab.appendChild(tr); // aggiungo alla tabella
			
			tr = document.createElement ("tr");//creo la riga per il codice
			td = document.createElement("td"); //creo l elemento dove effettivamete mettero la label per poi mettere il codice
			td.appendChild(document.createTextNode("codice"));//inserisco la label
			tr.appendChild(td);//aggiungo la label alla riga
			
			if(val)
			{
				var codic = document.createElement("input"); //creo un altro td per il codice vero e proprio
				codic.setAttribute("class","nuovi");
				codic.value=prod.codice//inserisco il codice
				tr.appendChild(codic);
			}
			else
			{
				td = document.createElement("td"); //creo un altro td per il codice vero e proprio
				td.appendChild(document.createTextNode(prod.codice));//inserisco il codice
				tr.appendChild(td); //aggiungo nella riga l elemento
			}
			tab.appendChild(tr);
			
			
			
			
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Colore"));
			tr.appendChild(td);//aggiungo la label alla riga
			if(val)
			{
				var color = document.createElement("input"); //creo un altro td per il codice vero e proprio
				color.setAttribute("class","nuovi");
				color.value=prod.prodCol//inserisco il codice
				tr.appendChild(color);
			}
			else
			{
				td = document.createElement("td"); //creo un altro td per il colore vero e proprio
				td.appendChild(document.createTextNode(prod.prodCol));
				tr.appendChild(td);
			}
			tab.appendChild(tr);
			
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Taglia"));
			tr.appendChild(td);//aggiungo la label alla riga
			if(val)
			{
				var tagli = document.createElement("input"); 
				tagli.setAttribute("class","nuovi");
				tagli.value=prod.prodTag;
				tr.appendChild(tagli);
			}
			else
			{
				td = document.createElement("td"); //creo un altro td per la taglia
				td.appendChild(document.createTextNode(prod.prodTag));
				tr.appendChild(td);
			}
			
			tab.appendChild(tr);
			
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Prezzo"));
			tr.appendChild(td);//aggiungo la label alla riga
			if(val)
			{
				var prezz = document.createElement("input"); 
				prezz.setAttribute("class","nuovi");
				prezz.value=prod.prezzo;
				tr.appendChild(prezz);
			}
			else
			{
				td = document.createElement("td"); //creo un altro td per il prezzo
				td.appendChild(document.createTextNode(prod.prezzo));
				tr.appendChild(td);
			}
			
			tab.appendChild(tr);
			
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("Disponibilità"));
			tr.appendChild(td);//aggiungo la label alla riga
			if(val)
			{
				var disponibilit = document.createElement("input"); //creo un altro td per il codice vero e proprio
				disponibilit.setAttribute("class","nuovi");
				disponibilit.value=prod.disp//inserisco il codice
				tr.appendChild(disponibilit);
			}
			else
			{
				td = document.createElement("td"); 
				td.appendChild(document.createTextNode(prod.disp));
				tr.appendChild(td);
			}
			tab.appendChild(tr);
			
			tr = document.createElement("tr");
			td = document.createElement("td");
			td.appendChild(document.createTextNode("sesso"));
			tr.appendChild(td);//aggiungo la label alla riga
			if(val)
			{
				var sess = document.createElement("input"); //creo un altro td per il codice vero e proprio
				sess.setAttribute("class","nuovi");
				sess.value=prod.sesso//inserisco il codice
				tr.appendChild(sess);
			}
			else
			{
				td = document.createElement("td"); 
				td.appendChild(document.createTextNode(prod.sesso));
				tr.appendChild(td);
			}
			tab.appendChild(tr);
			
			
			// quantita di prodotto che voglio acquistare
			tr = document.createElement("tr"); //creo la riga per la quantità del prodotto che voglio selezionare e per il carello
			tr.setAttribute("id","last");
			td = document.createElement("td"); //Campo per inserimento quantità
			center = document.createElement("center"); //Involucro per l input
			if(val)
			{
				var quer="?codice="+prod.codice+"&colore="+prod.prodCol+"&taglia="+prod.prodTag;
				var input1=document.createElement("input");
				input1.setAttribute("type","image");
				input1.src="Imm/Pencil.png";
				input1.id="pencil";
				input1.title="Modifica";
				input1.onclick = function ()
				{
					var xhttp = new XMLHttpRequest();
					if(codic.value!=prod.codice)
						quer+="&codic="+codic.value;
					if(color.value!=prod.prodCol)
						quer+="&color="+color.value;
					if(tagli.value!=prod.prodTag)
						quer+="&tagli="+tagli.value;
					if(prezz.value!=prod.prezzo)
						quer+="&prezz="+prezz.value;
					if(disponibilit.value!=prod.disp)
						quer+="&disponibilit="+disponibilit.value;
					if(sess.value!=prod.sesso)
						quer+="&sess="+sess.value;
					xhttp.open("GET", "Modifica"+quer, true);
	 				////alert("sto inviando"+ quer);
					xhttp.send();
				}
				td.appendChild(center); //incerisco l involucro dell input
				center.appendChild(input1); //inserisco l input nell involucro
				tr.appendChild(td); //inserisco il tutto nella riga
			}
			else
			{
				var input = document.createElement("input"); //creo l elemento per l input
				input.setAttribute("type", "number"); //non tutti i broswer lo prendono (devo ridimensionarlo)
				input.setAttribute("placeholder","Quantità ord."); //suggerisco a cosa serve questo campo
				var x = "Quanti"+q; //assegno un id dinamico a questo elemento, preso dal for
				input.setAttribute("class", "elemento");
				input.setAttribute("id", x); // in modo da prendermi il valore al suo interno quando necessario
//	 			////alert(input.getAttribute("id"));
				td.appendChild(center); //incerisco l involucro dell input
				center.appendChild(input); //inserisco l input nell involucro
				tr.appendChild(td); //inserisco il tutto nella riga
			}
			//CARRELLO. Inserimento ed implementazione del bottone come carrello. O di elimina per amministratore
			var btn = document.createElement("input");
			btn.setAttribute("type","image");
			if(val)//essendo che val sarà 0 per amministratore, e 1 per utenti normali, sono invertiti
			{
				btn.src="Imm/x.png";
				btn.title="Elimina questo elemento";
				btn.onclick = function ()
				{
//	 				////alert(tab.getAttribute("id"));
					div.removeChild(tab);
					valid.splice(q-1,1);//perchè q parte da 1 mentre l array parte da 0
					//splice si usa sia per aggiungere che per eliminare, nell ultimo caso il secondo parametro è settato a 1
//	 				////alert(q);// ricordando che q parte da 0
//	 				////alert(valid);
					//document.getElementById("ciao").innerHTML= prod.codice +" "+ " " +prod.prodCol+ " " + prod.prodTag +" "+ numeroEle;// devi inserire il p con id ciao per vederlo
					var xhttp = new XMLHttpRequest();
					var query="?codice="+prod.codice+"&colore="+prod.prodCol+"&taglia="+prod.prodTag;
					xhttp.open("GET", "Delete"+query, true);
	 				////alert("sto inviando"+ query);
					xhttp.send();
				}
				
			}
			else
			{
				btn.src="Imm/carrello.png";
				btn.title="Aggiungi al carrello";
				// associo al click del bottone una funzione che semplicemnte mi prende i parametri in cui esso viene cliccato
				btn.onclick = function ()
				{
	// 				////alert(tab.getAttribute("id"));
					var numero = parseInt(input.value);
					var altronumero = parseInt(prod.disp);
					if (isNaN(numero)) 
					{
						alert( "si prega di inserire input nella casella delle quantità");
					}
					else 
					{
						if(numero>altronumero || numero<1)
						{
							alert("Hai inserito una quantità non valida");
						}
						else if(isNaN(val))
							{
								alert("Bisogna prima loggarsi per inserire elementi nel carrello");
							}
							else
							{
								alert("Prodotto inserito nel carrello");
		//						div.removeChild(tab);SOLO SE IL VALORE ARRIVA A 0
		//						valid.splice(q-1,1);//perchè q parte da 1 mentre l array parte da 0
								//splice si usa sia per aggiungere che per eliminare, nell ultimo caso il secondo parametro è settato a 1
				// 				////alert(q);// ricordando che q parte da 0
				// 				////alert(valid);
								//document.getElementById("ciao").innerHTML= prod.codice +" "+ " " +prod.prodCol+ " " + prod.prodTag +" "+ numeroEle;// devi inserire il p con id ciao per vederlo
								////alert("numero"+ input.value);
								var numeroEle = input.value;
								var obj;
								var xhttp = new XMLHttpRequest();
								xhttp.onreadystatechange = function ()
								{
				 					if(this.readyState == 4 && this.status == 200 )
				 						{
				  							////alert ("sto ricevendo la seguente risposta "+ this.responseText); // ricevo un oggetto JSON
											obj = JSON.parse(this.responseText);
											console.log(this.responseText);
				  							console.log(obj.prodotti.lenght);
				  							////alert("oggetto javascript"+ obj.prodotti); // ho un oggetto
										}
								};
							var query="?codice="+prod.codice+"&colore="+prod.prodCol+"&taglia="+prod.prodTag+"&numElementi="+numeroEle;//DA INSERIRE # ELE DA INPUT
							xhttp.open("GET", "SalvaCarr"+query, true);
			// 				////alert("sto inviando"+ query);
							xhttp.send();
						}
					}	
			}
			td = document.createElement("td");//per il carrello
			center = document.createElement("center"); //Involucro per il carrello
			td.appendChild(center); //incerisco l involucro dell input
			center.appendChild(btn); //nserisco l input nell involucrp
			tr.appendChild(td);//inserisco involucro td con l involucro nella riga
			tab.appendChild(tr);//aggiungo la riga con l involucro all interno della tabella
			div.appendChild(tab);//aggiungo la tabella creata nel suo div
		}
}