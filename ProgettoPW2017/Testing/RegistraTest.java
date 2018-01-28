import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import Model.Carta;
import OperazioniDAO.RegistraDAO;
import junit.framework.TestCase;

public class RegistraTest extends TestCase 
{
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "utente";
	
	private RegistraDAO Registra;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		Registra = new RegistraDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		Registra=null;	
	}

	
	@Test
	public void testRegistrazione() throws SQLException
	{
		String username = "Volp96";
		String Password = "Matt98";
		String Nome = "Matteo";
		String cognome = "Volpe";
		String Indirizzo ="via Giglio 12";
		String iban = "ABC123";
		String Cvv = "456";
		String expire = "05-2018";
		
		Carta test = new Carta(iban, Cvv, expire);
		
		Registra.doSave(username, Password, Nome, cognome, Indirizzo, test);
		
		conn= null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query = "SELECT Username,Password,Nome,Cognome,IndirizzoStandard,Iban,Cvv,Expire FROM utente " + "WHERE Username=?";
			prep = conn.prepareStatement(query);
			prep.setString(1, username);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			if(!rs.next())
			{
				System.out.println("Errore");
			}
			else
			{
				String userTest = rs.getString("Username");
				assertEquals(userTest, username);
				prep.close();
			}
			String elimina = "DELETE FROM "+RegistraTest.TABLE_NAME+" WHERE (Username = ?)";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, username);
			prep.executeUpdate();
			conn.commit();
			prep.close();
		}finally
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
