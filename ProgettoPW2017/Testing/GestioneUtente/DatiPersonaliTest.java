package GestioneUtente;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import OperazioniDAO.DatiPersonaliDAO;
import OperazioniDAO.DeleteProdDAO;
import junit.framework.TestCase;

public class DatiPersonaliTest extends TestCase
{
	private Connection conn;
	private PreparedStatement prep;
	private DatiPersonaliDAO personali;
	
	private static final String TABLE_NAME = "utente";

	protected void setUp() throws Exception
	{
		super.setUp();
		personali = new DatiPersonaliDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		personali=null;	
	}
	
	
	
	@Test
	public void testAggiornaDatiPersonaliNome () throws SQLException
	{
		// inserisco un nuovo utente e successivamente effettuo
		// la modifica e dopo di che verifico se effettivamente 
		// è statto modificato
		
		
		String Username ="Mattheos65";
		String nome ="Mirco";
		String cognome ="lorto";
		String password ="Gikkino98";
		
		conn = null;
		prep = null;
		
		try
		{
			String insert ="INSERT INTO "+DatiPersonaliTest.TABLE_NAME + "(Username, Nome, Cognome, Password)" + "VALUES (?, ?, ?, ?)";
			
			prep = conn.prepareStatement(insert);
			
			prep.setString(1, Username);
			prep.setString(2, nome);
			prep.setString(3, cognome);
			prep.setString(4, password);
			
			
			prep.executeUpdate();
			conn.commit();
			
			// ora una volta inserito, lo porovo a modificare
			// con la classe di test
			String nomenuovo = "Luca";
			personali.modificaNome(Username, nomenuovo);
			
			
			// verifico effettivamente se è stato modificato
			
			String selezione = "SELECT Nome FROM utente WHERE Username =?";
			prep = conn.prepareStatement(selezione);
			prep.setString(1, Username);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			while (rs.next())
			{
				try
				{
					assertEquals(nomenuovo, rs.getString("Nome"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			// elimino l'utente inserito
			String delete = "DELETE FROM utente WHERE Username=?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, Username);
			prep.executeUpdate();
			conn.commit();
			prep.close();
		}
		finally
		{
		try
		{
			if(prep != null)
			{
				prep.close();
			}
		}finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}
		
	}
	
	
	@Test
	public void testAggiornaDatiPersonaliCognome () throws SQLException
	{
		// inserisco un nuovo utente e successivamente effettuo
		// la modifica e dopo di che verifico se effettivamente 
		// è statto modificato
		
		
		String Username ="Matheos65";
		String nome ="Mirco";
		String cognome ="lorto";
		String password ="Gikkino98";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String insert ="INSERT INTO "+DatiPersonaliTest.TABLE_NAME + "(Username, Nome, Cognome, Password)" + "VALUES (?, ?, ?, ?)";
			
			prep = conn.prepareStatement(insert);
			
			prep.setString(1, Username);
			prep.setString(2, nome);
			prep.setString(3, cognome);
			prep.setString(4, password);
			
			
			prep.executeUpdate();
			conn.commit();
			
			// ora una volta inserito, lo porovo a modificare
			// con la classe di test
			String cogn = "Pica";
			personali.modificaCognome(Username, cogn);
			
			
			// verifico effettivamente se è stato modificato
			
			String selezione = "SELECT Cognome FROM utente WHERE Username =?";
			prep = conn.prepareStatement(selezione);
			prep.setString(1, Username);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			while (rs.next())
			{
				try
				{
					assertEquals(cogn, rs.getString("Cognome"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			// elimino l'utente inserito
			String delete = "DELETE FROM utente WHERE Username=?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, Username);
			prep.executeUpdate();
			conn.commit();
			prep.close();
		}
		finally
		{
		try
		{
			if(prep != null)
			{
				prep.close();
			}
		}finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}
		
	}

	
	@Test
	public void testAggiornaDatiPersonaliIndirizzo () throws SQLException
	{
		// inserisco un nuovo utente e successivamente effettuo
		// la modifica e dopo di che verifico se effettivamente 
		// è statto modificato
		
		
		String Username ="Matheos65";
		String nome ="Mirco";
		String cognome ="lorto";
		String password ="Gikkino98";
		String indirizzo = "Viale Marconi 54";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String insert ="INSERT INTO "+DatiPersonaliTest.TABLE_NAME + "(Username, Nome, Cognome, Password, IndirizzoStandard)" + "VALUES (?, ?, ?, ?, ?)";
			
			prep = conn.prepareStatement(insert);
			
			prep.setString(1, Username);
			prep.setString(2, nome);
			prep.setString(3, cognome);
			prep.setString(4, password);
			prep.setString(5, indirizzo);
			
			
			prep.executeUpdate();
			conn.commit();
			
			// ora una volta inserito, lo porovo a modificare
			// con la classe di test
			String nuovo = "Viale Medaglia 12";
			personali.modificaIndirizzo(Username, nuovo);
			
			
			// verifico effettivamente se è stato modificato
			
			String selezione = "SELECT IndirizzoStandard FROM utente WHERE Username =?";
			prep = conn.prepareStatement(selezione);
			prep.setString(1, Username);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			while (rs.next())
			{
				try
				{
					assertEquals(nuovo, rs.getString("IndirizzoStandard"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			// elimino l'utente inserito
			String delete = "DELETE FROM utente WHERE Username=?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, Username);
			prep.executeUpdate();
			conn.commit();
			prep.close();
		}
		finally
		{
		try
		{
			if(prep != null)
			{
				prep.close();
			}
		}finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}
		
	}
	
	
	@Test
	public void testAggiornaDatiPersonaliIban() throws SQLException
	{
		// inserisco un nuovo utente e successivamente effettuo
		// la modifica e dopo di che verifico se effettivamente 
		// è statto modificato
		
		
		String Username ="Matheos65";
		String nome ="Mirco";
		String cognome ="lorto";
		String password ="Gikkino98";
		String iban = "ABC123";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String insert ="INSERT INTO "+DatiPersonaliTest.TABLE_NAME + "(Username, Nome, Cognome, Password, Iban)" + "VALUES (?, ?, ?, ?, ?)";
			
			prep = conn.prepareStatement(insert);
			
			prep.setString(1, Username);
			prep.setString(2, nome);
			prep.setString(3, cognome);
			prep.setString(4, password);
			prep.setString(5, iban);
			
			
			prep.executeUpdate();
			conn.commit();
			
			// ora una volta inserito, lo porovo a modificare
			// con la classe di test
			String nuovo = "ABC789";
			personali.modificaIban(Username, nuovo);
			
			
			// verifico effettivamente se è stato modificato
			
			String selezione = "SELECT Iban FROM utente WHERE Username =?";
			prep = conn.prepareStatement(selezione);
			prep.setString(1, Username);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			while (rs.next())
			{
				try
				{
					assertEquals(nuovo, rs.getString("Iban"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
			// elimino l'utente inserito
			String delete = "DELETE FROM utente WHERE Username=?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, Username);
			prep.executeUpdate();
			conn.commit();
			prep.close();
		}
		finally
		{
		try
		{
			if(prep != null)
			{
				prep.close();
			}
		}finally
		{
			if(conn != null)
			{
				conn.close();
			}
		}
	}
		
	}
	
	
}
