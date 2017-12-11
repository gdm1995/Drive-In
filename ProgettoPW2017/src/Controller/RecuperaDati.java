
package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import Model.Prodotti;
import Model.Selezionati;
import OperazioniDAO.RisultatoDAO;
import OperazioniDAO.SelezionatiDAO;

/**
 * Serve per recuperare dati dal database riguardo i prodotti selezionati da un determinato utente
 * Prende in input come attributo della sessione della richiesta l'username
 * Il risultato (tutti i prodotti selezionati) viene scritto sottoforma di attributto nella risposta
 */
@WebServlet("/RecuperaDati")
public class RecuperaDati extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String Username = (String) session.getAttribute("user");
		ArrayList<Selezionati> selezione = new ArrayList<Selezionati>(); // arrayList di tipo prodotto
		SelezionatiDAO sel = new SelezionatiDAO();
		// sfrutto il risultato ottenuto per fare una chiamata ad un'altro metodo per prendermi i parametri
		try
		{
			selezione = sel.doRicerca(Username);
		} catch (SQLException e)
		{
			System.out.println("Problemi durante l'esecuzione del codice SQL in RecuperaDati");
			e.printStackTrace();
		}
		// vado a prendermi i valori i modo poi da settarli
		// mi devo prendere le chiavi e poi passarli alla FindIt in modo tale da restituire i valori
		// mi prendo gli elementi presenti all'interno della risposta della dao.
		String Codice = null;
		String colore = null;
		String taglia = null;
		Prodotti prod = new Prodotti();
		ArrayList<Prodotti> prodotti = new ArrayList<Prodotti>();
		for (Selezionati sant : selezione)
		{
			Codice = sant.getCodice();
			colore = sant.getProdCol();
			taglia = sant.getProdTag();
			try
			{
				prod = salve(Codice, colore, taglia);
				prodotti.add(prod);
				// System.out.println("l'array list contiene"+ prodotti);
			} catch (SQLException e)
			{
				e.printStackTrace();
				System.out.println("Il recupero dei dati relativo a tutti i dati di un determinato "
						+ "prodotto in RecuperaDati.java è fallito");
			}
		}
		response.setContentType("text/plain");
		response.getWriter().write(creare(prodotti, selezione).toString());
		// System.out.println("Sto inviando "+ response);
	}

	/**
	 * Salve permette di ottenere tutte le informazioni riguardanti un determinato prodotto partendo dalle sue
	 * caratteristiche identificative(codice, colore e taglia)
	 * @param codice Codice del prodotto di cui si vogliono le informazioni
	 * @param colore Colore del prodotto di cui si vogliono le informazioni
	 * @param taglia Taglia del prodottto di cui si vogliono le informazioni
	 * @return Prodotto completo di tutte le sue informazioni
	 * @throws SQLException In caso si problemi durante il recupero dei dati dei prodotti selezionati dal database
	 */
	private Prodotti salve(String codice, String colore, String taglia) throws SQLException
	{
		// System.out.println("entro nella funzione" +l);
		RisultatoDAO carr = new RisultatoDAO();
		Prodotti prod = carr.FindIt(codice, colore, taglia);
		return prod;
	}

	private JSONObject creare(ArrayList<Prodotti> pro, ArrayList<Selezionati> prendi)
	{
		JSONArray ja = new JSONArray();
		int i = 0;
		// System.out.println("nel json ricevo"+ pro.size());
		for (Prodotti sel : pro)
		{
			JSONObject obj = new JSONObject();
			obj.put("Codice", sel.getCodice());
			obj.put("ProdTag", sel.getProdTag());
			obj.put("ProdCol", sel.getProdCol());
			obj.put("Nome", sel.getNome());
			obj.put("NomeI", sel.getNomeI());
			obj.put("Sesso", sel.getSesso());
			obj.put("Prezzo", sel.getPrezzo());
			// vado a modificare la disonibilita all'interno dei bean con la quantita che l'utente ha selezionato
			obj.put("Dispo", prendi.get(i).getQuantita());
			ja.put(obj);
			i++;
			// System.out.println("incremento"+i);
		}
		JSONObject main = new JSONObject();
		main.put("Carrello", ja);
		// System.out.println("Sono entrato in json "+ i);
		return main;
	}
}
