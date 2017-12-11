package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessioni.DriverManagerConnectionPool;
import Model.Carta;

/**Consente di registrare sul database un utente
 */
public class RegistraDAO 
{
	private static final String TABLE_NAME = "utente";

	/** Salva sul database un utente con i dati passati nei parametri
	 * @param username L'username dell'utente
	 * @param password Password dell'utente
	 * @param nome Nome dell'utente
	 * @param cognome Cognome dell'utente
	 * @param indirizzo indirizzo dove risiede l'utente 
	 * @throws SQLException In caso di problemi nell'esecuzione del codice SQL
	 */
	public synchronized void doSave(String username, String password, String nome, String cognome, 
			String indirizzo, Carta carta) throws SQLException
	{
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null; // oggetto per inviare query parametriche
		try
		{

			String register ="INSERT INTO "+ RegistraDAO.TABLE_NAME + "(Username,Password,Nome,Cognome,"
					+ "IndirizzoStandard,Iban,Cvv,Expire) VALUES (?,?,?,?,?,?,?,?)";
			conn= DriverManagerConnectionPool.getConnection();
			prep= conn.prepareStatement(register);
			prep.setString(1, username);
			prep.setString(2, password);
			prep.setString(3, nome);
			prep.setString(4, cognome);
			prep.setString(5, indirizzo);
			prep.setString(6, carta.getIban());
			prep.setString(7, carta.getCvv());
			prep.setString(8, carta.getExpire());

			prep.executeUpdate();
			conn.commit();
		} catch ( SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi durante l'esecuzione del codice SQL");
		}
		finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
	
	// Main per provare RegistraDAO.doSave
	
//	public static void main (String[] args) throws SQLException
//	{
//		RegistraDAO ciao = new RegistraDAO();
//		Carta carta = new Carta("IBAN", "CVV", "01-2019");
//		ciao.doSave("MB", "HELLO", "Micheal", "Bublè", "Via della libertà", carta);
//	}
}