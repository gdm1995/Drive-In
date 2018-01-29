package GestineCarrello;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import OperazioniDAO.AcquistaDAO;
import OperazioniDAO.DeleteDAO;
import junit.framework.TestCase;

public class AcquistaTest extends TestCase
{
	//dovrei inserire un oggetto chiamando il metodo della classe di test
	// fare una query di select per vedee che realmente Ë stato aggiunti
	// fare una query di eliminazione
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "acquisto";
	
	
private AcquistaDAO acquisto;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		acquisto = new AcquistaDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		acquisto=null;	
	}
	
	

	@Test
	public void testAcquista() throws SQLException
	{
		// creo gli elementi che comporranno l'oggetto
		String user ="Luigi98";
		String codice="B3";
		String colore = "Verde";
		String taglia ="L";
		String data="26/01/2018";
		String disp = "2";
		String indirizzo = "Via Giovanni 2";
		String ordine ="568934";
		
		// ora faccio eseguire la classe da testare
		acquisto.acquista(user, codice, colore, taglia, data, disp, indirizzo, ordine);
		
		// ora faccio la query di select per verificare se effettivamente Ë stato inserito
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " + "FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(query);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
				String tagTest = rs.getString("ProdTag");
				String datatTest = rs.getString("DataAcquisto");
				String quaTest = rs.getString("Quantit‡S");
				String indTest = rs.getString("IndirizzoC");
				String ordTest = rs.getString("CodiceOrdine");
				
				assertEquals(userTest, user);
				assertEquals(codTest, codice);
				assertEquals(colTest, colore);
				assertEquals(tagTest, taglia);
				assertEquals(datatTest, data);
				assertEquals(quaTest, disp);
				assertEquals(indTest, indirizzo);
				assertEquals(ordTest, ordine);	
			}
			String elimina = "DELETE FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
	public void testIndirizzoAssente() throws SQLException
	{
		// creo gli elementi che comporranno l'oggetto
		String user ="Luigi98";
		String codice="B3";
		String colore = "Verde";
		String taglia ="L";
		String data="26/01/2018";
		String disp = "2";
		String indirizzo = "Via Giovanni 2";
		String ordine ="568934";
		
		// ora faccio eseguire la classe da testare
		acquisto.acquista(user, codice, colore, taglia, data, disp, null, ordine);
		
		// ora faccio la query di select per verificare se effettivamente Ë stato inserito
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " + "FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(query);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
				String tagTest = rs.getString("ProdTag");
				String datatTest = rs.getString("DataAcquisto");
				String quaTest = rs.getString("Quantit‡S");
				String indTest = rs.getString("IndirizzoC");
				String ordTest = rs.getString("CodiceOrdine");
				
				assertNotEquals(userTest, user);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(tagTest, taglia);
				assertNotEquals(datatTest, data);
				assertNotEquals(quaTest, disp);
				assertNotEquals(indTest, indirizzo);
				assertNotEquals(ordTest, ordine);	
			}
			String elimina = "DELETE FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
	public void testUsernameAssente() throws SQLException
	{
		// creo gli elementi che comporranno l'oggetto
		String user ="Luigi98";
		String codice="B3";
		String colore = "Verde";
		String taglia ="L";
		String data="26/01/2018";
		String disp = "2";
		String indirizzo = "Via Giovanni 2";
		String ordine ="568934";
		
		// ora faccio eseguire la classe da testare
		acquisto.acquista(null, codice, colore, taglia, data, disp, indirizzo, ordine);
		
		// ora faccio la query di select per verificare se effettivamente Ë stato inserito
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " + "FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(query);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
				String tagTest = rs.getString("ProdTag");
				String datatTest = rs.getString("DataAcquisto");
				String quaTest = rs.getString("Quantit‡S");
				String indTest = rs.getString("IndirizzoC");
				String ordTest = rs.getString("CodiceOrdine");
				
				assertNotEquals(userTest, user);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(tagTest, taglia);
				assertNotEquals(datatTest, data);
				assertNotEquals(quaTest, disp);
				assertNotEquals(indTest, indirizzo);
				assertNotEquals(ordTest, ordine);	
			}
			
			String elimina = "DELETE FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
	public void testCodiceAssente() throws SQLException
	{
		// creo gli elementi che comporranno l'oggetto
		String user ="Luigi98";
		String codice="B3";
		String colore = "Verde";
		String taglia ="L";
		String data="26/01/2018";
		String disp = "2";
		String indirizzo = "Via Giovanni 2";
		String ordine ="568934";
		
		// ora faccio eseguire la classe da testare
		acquisto.acquista(user, null, colore, taglia, data, disp, indirizzo, ordine);
		
		// ora faccio la query di select per verificare se effettivamente Ë stato inserito
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " + "FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(query);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
				String tagTest = rs.getString("ProdTag");
				String datatTest = rs.getString("DataAcquisto");
				String quaTest = rs.getString("Quantit‡S");
				String indTest = rs.getString("IndirizzoC");
				String ordTest = rs.getString("CodiceOrdine");
				
				assertNotEquals(userTest, user);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(tagTest, taglia);
				assertNotEquals(datatTest, data);
				assertNotEquals(quaTest, disp);
				assertNotEquals(indTest, indirizzo);
				assertNotEquals(ordTest, ordine);	
			}
			
			String elimina = "DELETE FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
	public void testCognomeAssente() throws SQLException
	{
		// creo gli elementi che comporranno l'oggetto
		String user ="Luigi98";
		String codice="B3";
		String colore = "Verde";
		String taglia ="L";
		String data="26/01/2018";
		String disp = "2";
		String indirizzo = "Via Giovanni 2";
		String ordine ="568934";
		
		// ora faccio eseguire la classe da testare
		acquisto.acquista(user, codice, null, taglia, data, disp, indirizzo, ordine);
		
		// ora faccio la query di select per verificare se effettivamente Ë stato inserito
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " + "FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(query);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
				String tagTest = rs.getString("ProdTag");
				String datatTest = rs.getString("DataAcquisto");
				String quaTest = rs.getString("Quantit‡S");
				String indTest = rs.getString("IndirizzoC");
				String ordTest = rs.getString("CodiceOrdine");
				
				assertNotEquals(userTest, user);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(tagTest, taglia);
				assertNotEquals(datatTest, data);
				assertNotEquals(quaTest, disp);
				assertNotEquals(indTest, indirizzo);
				assertNotEquals(ordTest, ordine);	
			}
			
			String elimina = "DELETE FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
	public void testTagliaAssente() throws SQLException
	{
		// creo gli elementi che comporranno l'oggetto
		String user ="Luigi98";
		String codice="B3";
		String colore = "Verde";
		String taglia ="L";
		String data="26/01/2018";
		String disp = "2";
		String indirizzo = "Via Giovanni 2";
		String ordine ="568934";
		
		// ora faccio eseguire la classe da testare
		acquisto.acquista(user, codice, colore, null, data, disp, indirizzo, ordine);
		
		// ora faccio la query di select per verificare se effettivamente Ë stato inserito
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " + "FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(query);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
				String tagTest = rs.getString("ProdTag");
				String datatTest = rs.getString("DataAcquisto");
				String quaTest = rs.getString("Quantit‡S");
				String indTest = rs.getString("IndirizzoC");
				String ordTest = rs.getString("CodiceOrdine");
				
				assertNotEquals(userTest, user);
				assertNotEquals(codTest, codice);
				assertNotEquals(colTest, colore);
				assertNotEquals(tagTest, taglia);
				assertNotEquals(datatTest, data);
				assertNotEquals(quaTest, disp);
				assertNotEquals(indTest, indirizzo);
				assertNotEquals(ordTest, ordine);	
			}
			
			String elimina = "DELETE FROM "+ AcquistaTest.TABLE_NAME + " WHERE Username = ? AND Codice = ? AND ProdCol = ? AND ProdTag = ? AND DataAcquisto = ? AND Quantit‡S = ? AND IndirizzoC = ? AND CodiceOrdine = ? ";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, user);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, data);
			prep.setString(6, disp);
			prep.setString(7, indirizzo);
			prep.setString(8, ordine);
			
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
