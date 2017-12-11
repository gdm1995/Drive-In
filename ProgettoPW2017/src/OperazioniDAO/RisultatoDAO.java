
package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.http.HttpServlet;

import Connessioni.DriverManagerConnectionPool;
import Model.Prodotti;

/**
 * Utilizzato per restituire una collezione di uno o più prodotti dal database
 */
public class RisultatoDAO extends HttpServlet
{

	private static final long serialVersionUID = 7843443049909701751L;
	private static final String TABLE_NAME = "prodotto";

	/**
	 * Utilizzato per ricercare una collezione di prodotti di un determinato tipo e di un determinato sesso dal database
	 * @param tipo Tipologia di prodotto ricercata
	 * @param sesso Sesso del prodotto ricercato
	 * @return Ritorna un insieme di prodotti che rispettano le caratteristiche rispettate
	 * @throws SQLException In caso di errori nell'esecuzione del codice SQL
	 */
	public synchronized Collection<Prodotti> doRicerca(String tipo, String sesso)
			throws SQLException
	{
		Connection conn = null; // istanzio una nuova connessione
		PreparedStatement prep = null;
		Collection<Prodotti> prodotto = new LinkedList<Prodotti>(); // arrayList di tipo prodotto
		// Effettuo la query
		String controllo = "SELECT * " + "FROM " + RisultatoDAO.TABLE_NAME
				+ " WHERE ProdottoTipo = ? AND Sesso = ?";
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(controllo);
			prep.setString(1, tipo);
			prep.setString(2, sesso);
			// eseguo la query
			ResultSet res = prep.executeQuery();
			while (res.next())
			{
				Prodotti data = new Prodotti();
				data.setCodice(res.getString("Codice"));
				data.setProdCol(res.getString("ProdCol"));
				data.setNomeI(res.getString("NomeImmagine"));
				data.setProdTag(res.getString("ProdTag"));
				data.setDisp(res.getString("Disp"));
				data.setSesso(res.getString("Sesso"));
				data.setPrezzo(res.getDouble("Prezzo"));
				data.setNome(res.getString("Nome"));
				// JOptionPane.showMessageDialog(null, data.getNomeI());
				prodotto.add(data); 
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
		return prodotto;
	}
	// Main per testare RisultatoDAO.doRicerca

	// public static void main (String[] args) throws SQLException
	// {
	// RisultatoDAO ciao = new RisultatoDAO();
	// System.out.println(ciao.doRicerca("Scarpa","M"));
	// }
	/**
	 * Utilizzato per trovare un determinato prodotto, unicamente identificato, con tutte le sue caratteristiche dal
	 * database
	 * @param codice Codice del prodotto ricercato
	 * @param colore Colore del prodotto ricercato
	 * @param tag Taglia del prodotto ricercato
	 * @return Ritorna il prodotto ricercato che presenta tutte e tre i caratteri identificativi
	 * @throws SQLException In caso di problemi durante l'esecuzione del codice SQL
	 */
	public synchronized Prodotti FindIt(String codice, String colore, String tag)
			throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		Prodotti prodotto = new Prodotti();
		String controllo = "SELECT * " + "FROM " + RisultatoDAO.TABLE_NAME
				+ " WHERE  Codice=? AND ProdCol=? AND ProdTag=?";
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(controllo);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, tag);
			// eseguo la query
			ResultSet res = prep.executeQuery();
			while (res.next())
			{
				prodotto.setCodice(res.getString("Codice"));
				prodotto.setProdCol(res.getString("ProdCol"));
				prodotto.setProdTag(res.getString("ProdTag"));
				prodotto.setDisp(res.getString("disp"));
				prodotto.setSesso(res.getString("Sesso"));
				prodotto.setPrezzo(res.getDouble("Prezzo"));
				prodotto.setNome(res.getString("Nome"));
				prodotto.setNomeI(res.getString("NomeImmagine"));
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
		return prodotto;
	}
	// Main per testare RisultatoDAO.FindIt

//	 public static void main (String[] args) throws SQLException
//	 {
//	 RisultatoDAO ciao = new RisultatoDAO();
//	 System.out.println(ciao.FindIt("A17", "Rosso", "46"));
//	 }
	/**
	 * Utilizzato per restituire una collezione di prodotti con un determinato sesso dal database
	 * @param sesso Parametro per ricercare tutti i prodotti di un determinato sesso
	 * @return Ritorna una collezione di prodotti tutti dello stesso sesso
	 * @throws SQLException In caso di errore durante l'esecuzione del codice SQL
	 */
	public synchronized Collection<Prodotti> doAll(String sesso) throws SQLException
	{
		{
			Connection conn = null;
			PreparedStatement prep = null;
			Collection<Prodotti> prodotto = new LinkedList<Prodotti>();
			// Effettuo la query
			String controllo = "SELECT * " + "FROM " + RisultatoDAO.TABLE_NAME + " WHERE Sesso = ?";
			try
			{
				conn = DriverManagerConnectionPool.getConnection();
				prep = conn.prepareStatement(controllo);
				prep.setString(1, sesso);
				// eseguo la query
				ResultSet res = prep.executeQuery();
				while (res.next())
				{
					Prodotti data = new Prodotti();
					data.setCodice(res.getString("Codice"));
					data.setProdCol(res.getString("ProdCol"));
					data.setNomeI(res.getString("NomeImmagine"));
					data.setProdTag(res.getString("ProdTag"));
					data.setDisp(res.getString("Disp"));
					data.setSesso(res.getString("Sesso"));
					data.setPrezzo(res.getDouble("Prezzo"));
					data.setNome(res.getString("Nome"));
					// JOptionPane.showMessageDialog(null, data.getNomeI());
					prodotto.add(data);// lo aggiungo
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
			return prodotto;
		}
	}
	// Main per testare RisultatoDAO.doAll

//	 public static void main (String[] args) throws SQLException
//	 {
//	 RisultatoDAO ciao = new RisultatoDAO();
//	 System.out.println(ciao.doAll("M"));
//	 }
	/**
	 * Utilizzato per recuperare tutti i prodotti dal database
	 * @return
	 * @throws SQLException
	 */
	public synchronized ArrayList<Prodotti> justAll() throws SQLException
	{
		Connection conn = null; // istanzio una nuova connessione
		PreparedStatement prep = null;
		ArrayList<Prodotti> prodotto = new ArrayList<Prodotti>(); // arrayList di tipo prodotto
		// Effettuo la query
		String controllo = "SELECT * " + "FROM " + RisultatoDAO.TABLE_NAME;
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(controllo);
			ResultSet res = prep.executeQuery();
			while (res.next())
			{
				Prodotti data = new Prodotti();
				data.setCodice(res.getString("Codice"));
				data.setProdCol(res.getString("ProdCol"));
				data.setNomeI(res.getString("NomeImmagine"));
				data.setProdTag(res.getString("ProdTag"));
				data.setDisp(res.getString("Disp"));
				data.setSesso(res.getString("Sesso"));
				data.setPrezzo(res.getDouble("Prezzo"));
				data.setNome(res.getString("Nome"));
				prodotto.add(data);// lo aggiungo
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
		return prodotto;
	}

	// Main per testare RisultatoDAO.justAll
//	public static void main(String[] args) throws SQLException
//	{
//		RisultatoDAO ciao = new RisultatoDAO();
//		System.out.println(ciao.justAll());
//	}
}