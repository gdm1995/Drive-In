
package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connessioni.DriverManagerConnectionPool;
import Model.Selezionati;

/**
 * Utilizzato per ottenere tutti i prodotti selezionati da un determinato utente
 */
public class SelezionatiDAO
{

	private static final String TABLE_NAME = "selezionato";

	/**
	 * Serve per ottenere un insieme di prodotti selezionati da un determinato utente che sono salvati sul database
	 * @param Username Username dell'utente di cui si vuole sapere i prodotti selezionati
	 * @return Ritorna tutti i prodotti selezionati da quel determinato cliente
	 * @throws SQLException In caso di problemi durante l'esecuzione del codice SQL
	 */
	public synchronized ArrayList<Selezionati> doRicerca(String Username) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		ArrayList<Selezionati> selezione = new ArrayList<Selezionati>(); // arrayList di tipo prodotto
		String ricava = "SELECT *" + "FROM " + SelezionatiDAO.TABLE_NAME + " WHERE Username = ?";
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(ricava);
			prep.setString(1, Username);
			ResultSet res = prep.executeQuery();
			while (res.next())
			{
				Selezionati oggetti = new Selezionati();
				oggetti.SetUser(res.getString("Username"));
				oggetti.setProdCol(res.getString("ProdCol"));
				oggetti.setProdTag(res.getString("ProdTag"));
				oggetti.setQuantita(res.getString("Quantità"));
				oggetti.SetCodice(res.getString("Codice"));
				selezione.add(oggetti); // aggiungo
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi durante l'esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
		return selezione;
	}
	
	// Main per testare SelezionatiDAO.doRicerca
	
//	public static void main (String[] args) throws SQLException
//	{
//		SelezionatiDAO ciao = new SelezionatiDAO();
//		System.out.println(ciao.doRicerca("Carlo"));
//	}
}
