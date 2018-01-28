package GestioneProdotto;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import OperazioniDAO.DeleteDAO;
import OperazioniDAO.DeleteProdDAO;
import OperazioniDAO.InsertAmmDAO;
import junit.framework.TestCase;

public class DeleteProdottoTest extends TestCase
{
	private Connection conn;
	private PreparedStatement prep;
	
	private static final String TABLE_NAME = "prodotto";
	private DeleteProdDAO eliminaProdotto;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		eliminaProdotto = new DeleteProdDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		eliminaProdotto=null;	
	}
	
	@Test
	public void testEliminaProdottoCatalogo() throws SQLException
	{
		String codice="A118";
		String colore="Azzurro";
		String taglia="46";
		
		
		
		
		conn = null;
		prep = null;
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String insert = "INSERT INTO " + DeleteProdottoTest.TABLE_NAME
					+ "(Codice,ProdCol,ProdTag) "
					+ "VALUES (?,?,?)";
			prep = conn.prepareStatement(insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			prep.executeUpdate();
			conn.commit();
			
			// effettuo la prova di eliminazione
			eliminaProdotto.doDelete(codice, colore, taglia);
			
			// verifico se è stata eliminata 
			
			String selezione = "SELECT Codice, ProdCol, ProdTag FROM prodotto";
			
			prep = conn.prepareStatement(selezione);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			
			while(rs.next())
			{
				String cod = rs.getString("Codice");
				String col = rs.getString("ProdCol");
				String tagl = rs.getString("ProdTag");
				
				try
				{
					assertNotEquals(cod, codice);
					assertNotEquals(col, colore);
					assertNotEquals(col, taglia);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
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

