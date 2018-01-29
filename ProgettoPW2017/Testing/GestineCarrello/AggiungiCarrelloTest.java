package GestineCarrello;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import OperazioniDAO.AggCarDAO;
import OperazioniDAO.DeleteDAO;
import OperazioniDAO.RegistraDAO;
import OperazioniDAO.RisultatoDAO;
import junit.framework.TestCase;

public class AggiungiCarrelloTest extends TestCase 
{
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "selezionato";
	
	private AggCarDAO Aggiungi;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		Aggiungi = new AggCarDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		Aggiungi=null;	
	}
	
	@Test
	public void testAggiungiCarrello() throws SQLException
	{

		String username ="MB";
		String codice="B1";
		String colore="Giallo";
		String taglia ="M";
		String numero = "1";
		
		
		// inserisco un elemento in modo tale che successivamente testo se esso viene eliminato dalla classe sotto test
		 
		Aggiungi.doCarrello(username, codice, colore, taglia, numero);
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " +"FROM "+ AggiungiCarrelloTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			
		
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			if(!rs.next())
			{
				System.out.println("Errore");
			}
			else
			{
				String userTest = rs.getString("Username");
				String codTest = rs.getString("Codice");
				String colTest = rs.getString("ProdCol");
				String taglTest = rs.getString("ProdTag");
				assertEquals(userTest, username);
				assertEquals(codTest, codice);
				assertEquals(colTest, colore);
				assertEquals(taglTest, taglia);
			}
			String elimina = "DELETE FROM "+AggiungiCarrelloTest.TABLE_NAME+" WHERE (Codice = ? and ProdCol = ? and ProdTag = ? and Username=?)";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, username);
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
	
	
	
	
	@Test
	public void testQuantit‡Assente() throws SQLException
	{

		String username ="MB";
		String codice="B1";
		String colore="Giallo";
		String taglia ="M";
		String numero = "1";
		
		
		// inserisco un elemento in modo tale che successivamente testo se esso viene eliminato dalla classe sotto test
		 
		Aggiungi.doCarrello(username, codice, colore, taglia, null);
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " +"FROM "+ AggiungiCarrelloTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			
		
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			if(!rs.next())
			{
				System.out.println("Errore");
			}
			else
			{
				String userTest = rs.getString("Username");
				String codTest = rs.getString("Codice");
				String colTest = rs.getString("ProdCol");
				String taglTest = rs.getString("ProdTag");
				assertNotEquals(userTest, username);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(taglTest, taglia);
			}
			String elimina = "DELETE FROM "+AggiungiCarrelloTest.TABLE_NAME+" WHERE (Codice = ? and ProdCol = ? and ProdTag = ? and Username=?)";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, username);
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
	
	
	
	@Test
	public void testProdottoNonEsistente() throws SQLException
	{

		String username ="MB";
		String codice="B1";
		String colore="Giallo";
		String taglia ="M";
		String numero = "1";
		
		
		// inserisco un elemento in modo tale che successivamente testo se esso viene eliminato dalla classe sotto test
		 
		Aggiungi.doCarrello(username, "F4", "Bianco", "SMALL", numero);
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " +"FROM "+ AggiungiCarrelloTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(query);
			prep.setString(1, username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			
		
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			if(!rs.next())
			{
				System.out.println("Errore");
			}
			else
			{
				String userTest = rs.getString("Username");
				String codTest = rs.getString("Codice");
				String colTest = rs.getString("ProdCol");
				String taglTest = rs.getString("ProdTag");
				assertNotEquals(userTest, username);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(taglTest, taglia);
			}
			String elimina = "DELETE FROM "+AggiungiCarrelloTest.TABLE_NAME+" WHERE (Codice = ? and ProdCol = ? and ProdTag = ? and Username=?)";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, username);
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
