
package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import OperazioniDAO.RisultatoDAO;
import Model.Prodotti;

/**
 * Prodotto analizza il sesso, il tipo oopure una stringa di ricerca per nome, per ottenere uno 
 * o più prodotti che scriverà in un oggetto JSON inserito nella risposta.
 * Praticamente è una classe di controller che fa da intermediario per conto di js
 * con i beans e i database per ottenere uno o più prodotti.
 */
@WebServlet("/Prodotto")
public class Prodotto extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * Servlet per gestire i dati inseriti nella richiesta e fornire dei risultati nella risposta
	 * Restituisce tutti gli oggetti, oppure tutti gli oggetti di un determinato sesso, oppure 
	 * tutti gli oggetti di un determinato tipo e sesso, oppure tutti gli oggetti che matchano una 
	 * determinata stringa.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		String tipoArticolo = request.getParameter("art");
		String sesso = request.getParameter("sesso");
		String stringa = request.getParameter("stringa");
//		System.out.println("leggo" + tipoArticolo+sesso+stringa);
		RisultatoDAO ris = new RisultatoDAO();
		Collection<Prodotti> data= null;
		if(tipoArticolo.equals("Tutto"))
		{
			if(sesso.equals("T"))
			{
				try
				{
					data= ris.justAll();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					data= ris.doAll(sesso);
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			if((tipoArticolo.equals("Scarpa")||tipoArticolo.equals("Borsa")))
			{
				try
				{
//					System.out.println(sesso+tipoArticolo+"");
					data= ris.doRicerca(tipoArticolo,sesso);
				} 	catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					stringa=stringa.toUpperCase();
					data= ris.justAll();
					Collection<Prodotti> dataTemp = new ArrayList<Prodotti>();
					for(Prodotti prod : data)
					{
						String nome=prod.getNome().toUpperCase();
						if(nome.indexOf(stringa)==-1)
							//Se la stringa cercata non è contenuta nel nome di un prodotto nel database
							//Allora lo aggiungo ad un array, per escluderlo da quelli che mi interessano
							dataTemp.add(prod);
					}
					data.removeAll(dataTemp);System.out.println(data); //elimini i risultati non utili
				} catch (SQLException e)
				{
					e.printStackTrace();
					System.out.println("Problema durante il recupero di tutti i prodotti in Prodotto.java");
				}
			}
		}
		response.setContentType("text/plain");
		response.getWriter().write(creare(data).toString());
	}
	
	private JSONObject creare (Collection<Prodotti> data)
	{
		JSONArray ja = new JSONArray();// mi creo un array
		for(Prodotti prod : data)
		{
			JSONObject obj = new JSONObject(); // per ogni ogni iterazione mi crei un oggetto
			obj.put("codice", prod.getCodice());
			obj.put("prodCol", prod.getProdCol());
			obj.put("nomeImg", prod.getNomeI());
			obj.put("prodTag", prod.getProdTag());
			obj.put("disp", prod.getDisp());
			obj.put("sesso", prod.getSesso());
			obj.put("prezzo", prod.getPrezzo());
			obj.put("nome", prod.getNome());
			ja.put(obj);
		}
		JSONObject main = new JSONObject();
		main.put("prodotti", ja);
		return main;
	}
}