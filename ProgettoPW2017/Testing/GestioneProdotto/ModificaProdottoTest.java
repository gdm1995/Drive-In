package GestioneProdotto;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import OperazioniDAO.DatiPersonaliDAO;
import OperazioniDAO.ModificaDAO;
import junit.framework.TestCase;

public class ModificaProdottoTest extends TestCase
{
	private Connection conn;
	private PreparedStatement prep;
	
	private ModificaDAO modifica;
	
	
	private static final String TABLE_NAME = "prodotto";

	protected void setUp() throws Exception
	{
		super.setUp();
		modifica = new ModificaDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		modifica=null;	
	}
	
	@Test
	public void testModificaCodice() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag)" + "VALUES(?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String codiceNuovo = "HB98";
			modifica.Edicodic(codice, colore, taglia, codiceNuovo);
			
			String modifica = "SELECT Codice FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codiceNuovo);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(codiceNuovo, rs.getString("Codice"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codiceNuovo);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
	public void testModificaColore() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag)" + "VALUES(?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String coloreNuovo = "Arancione";
			modifica.Edicolor(codice, colore, taglia, coloreNuovo);
			
			String modifica = "SELECT ProdCol FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, coloreNuovo);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(coloreNuovo, rs.getString("ProdCol"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, coloreNuovo);
			prep.setString(3, taglia);
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
	public void testModificaTaglia() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag)" + "VALUES(?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String tagliaNuova = "45";
			modifica.Editagli(codice, colore, taglia, tagliaNuova);
			
			String modifica = "SELECT ProdTag FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, tagliaNuova);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(tagliaNuova, rs.getString("ProdTag"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, tagliaNuova);
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
	public void testModificaQuantita() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		String quantita = "1";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag, Disp)" + "VALUES(?,?,?, ?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, quantita);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String numero = "45";
			modifica.Edidisponibilit(codice, colore, taglia, numero);
			
			String modifica = "SELECT Disp FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(numero, rs.getString("Disp"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
	public void testModificaSesso() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		String sesso = "M";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag, Sesso)" + "VALUES(?,?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, sesso);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String sess = "F";
			modifica.Edisess(codice, colore, taglia, sess);
			
			String modifica = "SELECT Sesso FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(sess, rs.getString("Sesso"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
	public void testModificaPrezzo() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		String prezzo = "20.00";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag, Prezzo)" + "VALUES(?,?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, prezzo);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String prezzNuovo = "10.00";
			modifica.Ediprezz(codice, colore, taglia, prezzNuovo);
			
			String modifica = "SELECT Prezzo FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(prezzNuovo, rs.getString("Prezzo"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
	public void testModificaNomeProdotto() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		String nomeprodotto = "Nike Giallo";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag, Nome)" + "VALUES(?,?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, nomeprodotto);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String nomeP = "Puma";
			modifica.Edinom(codice, colore, taglia, nomeP);
			
			String modifica = "SELECT Nome FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(nomeP, rs.getString("Nome"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
	public void testModificaIndirizzoImmagine() throws SQLException
	{
		//Inserisco un nuovo prodotto e successivamente
		// testo la classe effettuando la modifica
		// verifico se effettivamente è stato modificato
		
		String codice = "P987";
		String colore = "AcquaMarina";
		String taglia = "35";
		String indirizzo = "Nike.jpg";
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String Insert = "INSERT INTO "+ ModificaProdottoTest.TABLE_NAME + "(Codice, ProdCol, ProdTag, NomeImmagine)" + "VALUES(?,?,?,?)";
			
			prep = conn.prepareStatement(Insert);
			
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, indirizzo);
			
			prep.executeUpdate();
			conn.commit();
			
			// una volta inserito, lo porovo a modificare con 
			// la classe di test
			
			String nuovoIndirizzo = "Puma.jpg";
			modifica.EdinomI(codice, colore, taglia, nuovoIndirizzo);
			
			String modifica = "SELECT NomeImmagine FROM prodotto WHERE Codice =? AND ProdCol =? AND ProdTag =?";
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			
			ResultSet rs = prep.executeQuery();
			conn.commit();
			
			while(rs.next())
			{
				try
				{
					assertEquals(nuovoIndirizzo, rs.getString("NomeImmagine"));
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			// elimino il prodotto
			
			String delete = "DELETE FROM prodotto WHERE Codice = ? AND ProdCol = ? AND ProdTag = ?";
			prep = conn.prepareStatement(delete);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
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
