
package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessioni.DriverManagerConnectionPool;
/**
 * Classe per la cancellazione di un prodotto
 */
public class DeleteProdDAO
{
	public static final String TABLE_NAME = "prodotto";

	/**
	 * Cancella un determinato prodotto dall'inventario sul database
	 * @param codice Codice del prodotto da eliminare
	 * @param colore Colore del prodotto da eliminare
	 * @param taglia Taglia del prodotto da eliminare
	 * @throws SQLException in caso di errori SQL
	 */
	public synchronized void doDelete(String codice, String colore, String taglia) throws SQLException
	{
		// inizializzo la connesione
		Connection conn = null;
		PreparedStatement prep = null;
		// scrivo la query
		String elimina = "DELETE FROM "+DeleteProdDAO.TABLE_NAME+" WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(elimina);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi con l'esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
	
	// Main per provare DeleteProdDAO
	
//	public static void main (String[] args) throws SQLException
//	{
//		DeleteProdDAO ciao = new DeleteProdDAO();
//		ciao.doDelete("F4", "Rosso", "46");
//	}
}
