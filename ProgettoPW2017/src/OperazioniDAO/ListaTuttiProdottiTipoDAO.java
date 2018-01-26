package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import Connessioni.DriverManagerConnectionPool;
import Model.Prodotti;

/**
 * Ricerca e restituisce tutti i prodotti nell'inventario di un certo tipo
 */
public class ListaTuttiProdottiTipoDAO
{
	private static final String TABLE_NAME = "prodotto";

	/** Ricerca e restituisce tutti i prodotti di un determinato tipo
	 * @param tipo Il tipo di prodotto che bisogna ritrovare
	 * @return Collezione di prodotti di quel determinato tipo
	 * @throws SQLException In caso di problemi durante l'esecuzione del codice SQL
	 */
	public synchronized Collection<Prodotti> doRicerca(String tipo) throws SQLException
	{
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null;
		Collection<Prodotti> prodotto = new LinkedList<Prodotti>(); 
		try
		{
			String insert = "SELECT * " + "FROM " + ListaTuttiProdottiTipoDAO.TABLE_NAME + " WHERE ProdottoTipo = ?";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(insert);
			prep.setString(1, tipo);
			ResultSet res = prep.executeQuery();
			while (res.next())
			{
				Prodotti data = new Prodotti(); // creo un oggetto e aggiorno i
				// beans
				data.setCodice(res.getString("Codice"));
				data.setProdCol(res.getString("ProdCol"));
				data.setProdTag(res.getString("ProdTag"));
				data.setDisp(res.getString("Disp"));
				data.setSesso(res.getString("Sesso"));
				data.setNome(res.getString("Nome"));
				data.setNomeI(res.getString("NomeImmagine"));
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
	
	// Main per provare ListaTuttiProdottiTipoDAO
	
//		public static void main (String[] args) throws SQLException
//		{
//			ListaTuttiProdottiTipoDAO ciao = new ListaTuttiProdottiTipoDAO();
//			Collection<Prodotti> ciaone = new LinkedList<>();
//			ciaone = ciao.doRicerca("Scarpa");
//			System.out.println(ciaone);
//		}
	
	/**
	 * Utilizzato per trovare un determinato prodotto unicamente identificato con tutte le sue caratteristiche dal
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
		String controllo = "SELECT * " + "FROM " + ListaTuttiProdottiTipoDAO.TABLE_NAME
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
		// System.out.println(prodotto);
		return prodotto;
	}
	
	// Main per provare ListaTuttiProdottiTipoDAO
	
//	public static void main (String[] args) throws SQLException
//	{
//		ListaTuttiProdottiTipoDAO ciao = new ListaTuttiProdottiTipoDAO();
//		Prodotti ciaone = new Prodotti();
//		ciaone = ciao.FindIt("A100", "Rosso", "45");
//		System.out.println(ciaone+" "+ciaone.getDisp());
//	}
}
