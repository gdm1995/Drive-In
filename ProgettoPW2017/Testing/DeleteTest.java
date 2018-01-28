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
import junit.framework.TestCase;

public class DeleteTest extends TestCase
{
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "selezionato";

	private DeleteDAO elimina;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		elimina = new DeleteDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		elimina=null;	
	}
	
	@Test
	public void testEliminaProdottoSelezionato() throws SQLException
	{
		String username ="Angela";
		String codice="B1";
		String colore="Giallo";
		String taglia ="M";
		int quantita =3;
		
		// inserisco un elemento in modo tale che successivamente testo se esso viene eliminato dalla classe sotto test
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String inser = "INSERT INTO "+ DeleteTest.TABLE_NAME+ "(Username, Codice, ProdCol, ProdTag, Quantità) VALUES (?,?,?,?,?)";
			prep = conn.prepareStatement(inser);
			prep.setString(1, username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setInt(5, quantita);
			
			prep.executeUpdate();
			conn.commit();
			
			// effettuo il testing sull'eliminazione
			elimina.doDelete(codice, colore, taglia, username);
			
			// verifico se è stato eliminato il prodotto facendo na query di ricerca
			String seleziona ="SELECT Username, Codice, ProdCol, ProdTag  FROM selezionato";//+ "WHERE Codice = ? and ProdCol = ? and ProdTag = ? and Username=?";
			prep = conn.prepareStatement(seleziona);
			/*
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, username);
			*/
			ResultSet rs = prep.executeQuery();
			conn.commit();
			while(rs.next())
			{
				String user =rs.getString("Username");
				String cod=  rs.getString("Codice");
				String col= rs.getString("ProdCol");
				String tag = rs.getString("ProdTag");
				
				try
				{
					assertNotEquals(user, username);
					assertNotEquals(cod, codice);
					assertNotEquals(col, colore);
					assertNotEquals(tag, taglia);
				}catch(Exception e)
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
