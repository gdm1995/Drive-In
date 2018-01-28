package GestioneProdotto;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.Test;

import Connessioni.DriverManagerConnectionPool;
import Controller.Prodotto;
import GestineCarrello.SelezionatiTest;
import Model.Prodotti;
import OperazioniDAO.RisultatoDAO;
import OperazioniDAO.SelezionatiDAO;
import junit.framework.TestCase;

public class RisultatoTest extends TestCase 
{
	private Connection conn;
	private PreparedStatement prep;
	private static final String TABLE_NAME = "prodotto";

	RisultatoDAO risultato;
	
	
	protected void setUp() throws Exception
	{
		super.setUp();
		risultato = new RisultatoDAO();
	}
	
	protected void tearDown() throws Exception
	{
		super.tearDown();
		risultato=null;	
	}
	
	@Test
	public void testRicerca()  throws SQLException
	{
		// il testo consistera nel inserire un elemento
		// con una determinata specifica
		// successivamente andando a testare la classe, verifico
		// se esso vienre ritornato
		
		String codice="H89";
		String colore = "Ciano";
		String taglia = "XL";
		String tipo="Borsa";
		String sesso="D";
		
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String inser = "INSERT INTO "+ RisultatoTest.TABLE_NAME+ "( Codice, ProdCol, ProdTag, Sesso, ProdottoTipo) VALUES (?,?,?,?,?)";
			prep= conn.prepareStatement(inser);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, tipo);
			prep.setString(5, sesso);
			
			prep.executeUpdate();
			conn.commit();
			
			Collection<Prodotti> prodotto = new LinkedList<Prodotti>(); // arrayList di tipo prodotto
			
			prodotto =risultato.doRicerca(tipo, sesso);
			for(int i=0; i<prodotto.size(); i++)
			{
				if(prodotto.iterator().next().getCodice().equals(codice))
				{
					assertEquals(codice, prodotto.iterator().next().getCodice());
					assertEquals(colore, prodotto.iterator().next().getProdCol());
					assertEquals(taglia, prodotto.iterator().next().getProdTag());
				}
				
			}
			String elimina = "DELETE FROM "+ RisultatoTest.TABLE_NAME + " WHERE Codice = ? AND ProdCol =? AND ProdTag =?";
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
	
	

	@Test
	public void testFindIt()  throws SQLException
	{
		// il testo consistera nel inserire un elemento
		// con una determinata specifica
		// successivamente andando a testare la classe, verifico
		// se esso vienre ritornato
		
		String codice="H89";
		String colore = "Ciano";
		String taglia = "XL";
		
		
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String inser = "INSERT INTO "+ RisultatoTest.TABLE_NAME+ "( Codice, ProdCol, ProdTag) VALUES (?,?,?)";
			prep= conn.prepareStatement(inser);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
		
			
			prep.executeUpdate();
			conn.commit();
			
			Prodotti prodotto = new Prodotti();
			
			prodotto =risultato.FindIt(codice, colore, taglia);
			
			assertEquals(codice, prodotto.getCodice());
			assertEquals(colore, prodotto.getProdCol());
			assertEquals(taglia, prodotto.getProdTag());
			
			String elimina = "DELETE FROM "+ RisultatoTest.TABLE_NAME + " WHERE Codice = ? AND ProdCol =? AND ProdTag =?";
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
	
	@Test
	public void testFindSesso()  throws SQLException
	{
		// il testo consistera nel inserire un elemento
		// con una determinata specifica
		// successivamente andando a testare la classe, verifico
		// se esso vienre ritornato
		
		String codice="H89";
		String colore = "Ciano";
		String taglia = "XL";
		String sesso = "M";
		
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String inser = "INSERT INTO "+ RisultatoTest.TABLE_NAME+ "( Codice, ProdCol, ProdTag, Sesso) VALUES (?,?,?,?)";
			prep= conn.prepareStatement(inser);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, sesso);
		
			
			prep.executeUpdate();
			conn.commit();
			
			Collection<Prodotti> prodotto = new LinkedList<Prodotti>(); // arrayList di tipo prodotto
			
			prodotto =risultato.doAll(sesso);
			for(int i=0; i<prodotto.size(); i++)
			{
				if(prodotto.iterator().next().getCodice().equals(codice))
				{
					assertEquals(codice, prodotto.iterator().next().getCodice());
					assertEquals(colore, prodotto.iterator().next().getProdCol());
					assertEquals(taglia, prodotto.iterator().next().getProdTag());
				}
			}
			
			String elimina = "DELETE FROM "+ RisultatoTest.TABLE_NAME + " WHERE Codice = ? AND ProdCol =? AND ProdTag =?";
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
	
	@Test
	public void testjustAll()  throws SQLException
	{
		// il testo consistera nel inserire un elemento
		// con una determinata specifica
		// successivamente andando a testare la classe, verifico
		// se esso vienre ritornato
		
		String codice="H89";
		String colore = "Ciano";
		String taglia = "XL";
		
		
		conn = null;
		prep = null;
		
		try
		{
			conn = DriverManagerConnectionPool.getConnection();
			String inser = "INSERT INTO "+ RisultatoTest.TABLE_NAME+ "( Codice, ProdCol, ProdTag) VALUES (?,?,?)";
			prep= conn.prepareStatement(inser);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
		
			
			prep.executeUpdate();
			conn.commit();
			
			ArrayList<Prodotti> prodotto = new ArrayList<Prodotti>(); // arrayList di tipo prodotto
			
			prodotto =risultato.justAll();
			for(int i=0; i<prodotto.size(); i++)
			{
				
				if(prodotto.get(i).getCodice().equals(codice))
				{
					assertEquals(codice, prodotto.get(i).getCodice());
					assertEquals(colore, prodotto.get(i).getProdCol());
					assertEquals(taglia, prodotto.get(i).getProdTag());
				}
			}
			
			String elimina = "DELETE FROM "+ RisultatoTest.TABLE_NAME + " WHERE Codice = ? AND ProdCol =? AND ProdTag =?";
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
