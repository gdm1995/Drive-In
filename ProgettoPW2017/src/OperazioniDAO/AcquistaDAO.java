
package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessioni.DriverManagerConnectionPool;

/**
 * Classe da utilizzare per l'acquisto e la registrazione sul database di un determinato prodotto 
 * da parte di un cliente
 */
public class AcquistaDAO
{
	private static final String TABLE_NAME = "acquisto";

	/**
	 * Metodo per l'inserimento di un prodotto da quelli selezionati a quelli acquistati 
	 * @param User Nome utente della persona che acquista
	 * @param codice Codice del prodotto acquistato
	 * @param colore Colore del prodotto acquistato
	 * @param taglia Taglia del prodotto acquistato
	 * @param data Data di acquisto
	 * @param disp Quantit‡ acquistata dall'utente di quel determinato prodotto
	 * @param indirizzo Indirizzo a cui Ë stato inviato il contenuto
	 * @throws SQLException In caso di errore nell'esecuzione del codice SQL
	 */
	public synchronized void acquista(String User, String codice, String colore, String taglia, String data,
			String disp, String indirizzo) throws SQLException
	{
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null;
		try
		{
			String insert = "INSERT INTO " + AcquistaDAO.TABLE_NAME
					+ "(Username,Codice,ProdCol,ProdTag,DataAcquisto,Quantit‡S,IndirizzoC) " 
					+ "VALUES (?,?,?,?,?,?,?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(insert);
			prep.setString(1, User);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.executeUpdate();
			conn.commit();
			// " WHERE Codice = ? & ProdCol = ? & ProdTag = ? & ProdottoTipo = ?
			// & #Disp = ? & Sesso = ? & Prezzo = ? & Nome = ? & NomeImmagine
			// =?"
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi durante l'esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
	
	// Main per provare AcquistaDAO
	
//		public static void main (String[] args) throws SQLException
//		{
//			AcquistaDAO ciao = new AcquistaDAO();
//			ciao.acquista("Carlo", "F4", "Rosso", "46", "27-01-1995", "2", "Via Roma, 56");;
//		}
}
