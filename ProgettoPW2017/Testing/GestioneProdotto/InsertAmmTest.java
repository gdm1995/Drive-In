package GestioneProdotto;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import GestineCarrello.AggiungiCarrelloTest;
import OperazioniDAO.AggCarDAO;
import OperazioniDAO.InsertAmmDAO;
import junit.framework.TestCase;

public class InsertAmmTest extends TestCase 
{
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "prodotto";

	private InsertAmmDAO amministratore;
	
	
	protected void setUp() throws Exception
	{
		super.setUp();
		amministratore = new InsertAmmDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		amministratore=null;	
	}
	
	@Test
	public void testInsertProdottiAmm() throws SQLException
	{
		String codice = "A118";
		String colore = "Bianco";
		String taglia = "M";
		
		amministratore.doInsert(codice, colore, taglia, null, null, null, null, null, null );
		conn = null;
		prep= null;
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String query="SELECT * " +"FROM "+ InsertAmmTest.TABLE_NAME + " WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(query);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			if(!rs.next())
			{
				System.out.println("Errore");
			}
			else
			{
				String codiceTest = rs.getString("Codice");
				String coloreTest = rs.getString("ProdCol");
				String tagliaTest = rs.getString("ProdTag");
				
				assertEquals(codiceTest, codice);
				assertEquals(coloreTest, colore);
				assertEquals(tagliaTest, taglia);
			}
			String elimina = "DELETE FROM "+ InsertAmmTest.TABLE_NAME + " WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
