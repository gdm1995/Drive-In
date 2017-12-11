package OperazioniDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessioni.DriverManagerConnectionPool;
/**
 * Classe java per inserire gli elementi nel carrello ( tabella selezionati)
 */
public class AggCarDAO 
{
	private static final String TABLE_NAME = "selezionato";
	int res=0;
	
	/**Metodo per l'inserimento di un nuova tupla (prodotto) all'interno della tabella selezionati
	 * 
	 * @param user l'utente che sta selezionando tale prodotto
	 * @param codice il codice del prodotto
	 * @param Colore il colore del prodotto
	 * @param Taglia la taglia del prodotto
	 * @param numero la quantità con la quale viene inserito il prodotto in selezionati
	 * @throws SQLException Nel caso di errori SQL
	 */
	public synchronized void doCarrello (String user, String codice, String Colore, String Taglia, String numero) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		
		// effettuo la query di inserimento 
		try
		{
			String inser = "INSERT INTO "+ AggCarDAO.TABLE_NAME+ "(Username, Codice, ProdCol, ProdTag,Quantità) VALUES (?,?,?,?,?)";
			conn= DriverManagerConnectionPool.getConnection();
			prep= conn.prepareStatement(inser);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, Colore);
			prep.setString(4, Taglia);
			prep.setString(5, numero);
			
			prep.executeUpdate();//Volendo inserisce il numero di righe inserite
			conn.commit();
		} catch (SQLException e)
		{
			System.out.println("Problemi durante la query SQL");
			e.printStackTrace();
		}finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}	
	
	// Main per provare AggCarDAO
	
//		public static void main (String[] args) throws SQLException
//		{
//			 AggCarDAO ciao = new AggCarDAO();
//			 ciao.doCarrello("Carlo", "F5", "Verde", "45", "2");
//		}
}