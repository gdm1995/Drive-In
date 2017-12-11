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
}
