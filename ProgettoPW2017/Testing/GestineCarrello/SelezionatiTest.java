package GestineCarrello;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import Model.Selezionati;
import OperazioniDAO.AggCarDAO;
import OperazioniDAO.RegistraDAO;
import OperazioniDAO.SelezionatiDAO;
import junit.framework.TestCase;

public class SelezionatiTest extends TestCase 
{
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "selezionato";
	
	private SelezionatiDAO selezionati;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		selezionati = new SelezionatiDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		selezionati=null;	
	}
	
	
			
	@Test
	public void testValido() throws SQLException
	{
		String Username = "MB";
		String codice = "K2";
		String colore = "Azzurro";
		String taglia = "34";
		String numero = "2";
		
		// effettuo l'inserimento e successivamente
		// verifico tramite la classe se è contenuto nella 
		// lista di prodotti di un determinato user
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String inser = "INSERT INTO "+ SelezionatiTest.TABLE_NAME+ "(Username, Codice, ProdCol, ProdTag,Quantità) VALUES (?,?,?,?,?)";
			prep = conn.prepareStatement(inser);
			prep.setString(1, Username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.setString(5, numero);
			
			prep.executeUpdate();
			conn.commit();
			
			// effettuo la query
			ArrayList<Selezionati> sel = new ArrayList<Selezionati>(); // arrayList di tipo prodotto
			
			sel = selezionati.doRicerca(Username);
			
			for(int i=0; i<sel.size(); i++)
			{
				assertEquals(codice,sel.get(i).getCodice());
				assertEquals(colore, sel.get(i).getProdCol());
				assertEquals(taglia, sel.get(i).getProdTag());
			}
			
			String elimina = "DELETE FROM "+ SelezionatiTest.TABLE_NAME + " WHERE Username = ?  AND Codice = ? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, Username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
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
public void testNessunProdottoSelezionato() throws SQLException
{
	String Username = "MB";
	String codice = "K2";
	String colore = "Azzurro";
	String taglia = "34";
	String numero = "2";
	
	// effettuo l'inserimento e successivamente
	// verifico tramite la classe se è contenuto nella 
	// lista di prodotti di un determinato user
	
	conn = null;
	prep = null;
	
	try
	{
		
		// effettuo la query
		ArrayList<Selezionati> sel = new ArrayList<Selezionati>(); // arrayList di tipo prodotto
		
		sel = selezionati.doRicerca(Username);
		assertEquals(true, sel.isEmpty());
		/*
		for(int i=0; i<sel.size(); i++)
		{
			assertEquals(codice,sel.get(i).getCodice());
			assertEquals(colore, sel.get(i).getProdCol());
			assertEquals(taglia, sel.get(i).getProdTag());
		}
*/
		
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
			
			
			
			
			
			
			
			
			/*
			
			// faccio la query di select
			String Sql ="SELECT *"+ "FROM " + SelezionatiTest.TABLE_NAME + " WHERE Username = ?  AND Codice = ? AND ProdCol =? AND ProdTag =?";
			
			prep = conn.prepareStatement(Sql);
			prep.setString(1, Username);
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
				assertEquals(codice, rs.getString("Codice"));
				assertEquals(colore, rs.getString("ProdCol"));
				assertEquals(taglia, rs.getString("ProdTag"));
				
			}
			String elimina = "DELETE FROM "+ SelezionatiTest.TABLE_NAME + " WHERE Username = ?  AND Codice = ? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(elimina);
			prep.setString(1, Username);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
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
	*/

}
