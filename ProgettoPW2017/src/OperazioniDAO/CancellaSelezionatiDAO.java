package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessioni.DriverManagerConnectionPool;
/**
 * Per la cancellazione di un elemento che è stato selezionato nel carrello 
 */
public class CancellaSelezionatiDAO
{
	public static final String TABLE_NAME = "selezionato";

	/**
	 * Cancellazione di uno specifico elemento tra quelli selezionati di un determinato utente
	 * 
	 * @param User Username dell'utente che ha selezionato i valori
	 * @param codice Codice dell'oggetto da eliminare
	 * @param colore  Colore dell'oggetto da eliminare
	 * @param taglia Taglia dell'oggetto da eliminare
	 * @throws SQLException In caso di errori nel codice SQL
	 */
	public synchronized void cancellaSelezionati(String User, String codice, String colore, String taglia) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String elimina = "DELETE FROM "+ CancellaSelezionatiDAO.TABLE_NAME
					+ " WHERE (Username = ? and Codice = ? "
					+ "and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(elimina);
			prep.setString(1, User);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			// Eseguo la query
			prep.executeUpdate();
			conn.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi con il codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
	
	// Main per provare CancellaSelezionatiDAO
	
//		public static void main (String[] args) throws SQLException
//		{
//			CancellaSelezionatiDAO ciao = new CancellaSelezionatiDAO();
//			ciao.cancellaSelezionati("Carlo", "F4", "Rosso", "46");;
//		}
}
