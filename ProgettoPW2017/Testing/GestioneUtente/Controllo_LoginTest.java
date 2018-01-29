package GestioneUtente;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;



import Connessioni.DriverManagerConnectionPool;
import OperazioniDAO.Controllo_LoginDAO;
import OperazioniDAO.DeleteProdDAO;
import OperazioniDAO.RegistraDAO;
import junit.framework.TestCase;

public class Controllo_LoginTest extends TestCase
{
	private Connection conn;
	private PreparedStatement pstmt;
	private static final String TABLE_NAME = "utente";
	
	// mi creo un'istanza della classe da testare
	private Controllo_LoginDAO loginDao;

	
	protected void setUp() throws Exception
	{
		super.setUp();
		loginDao = new Controllo_LoginDAO();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		loginDao=null;	
	}
	
	
	

	
	@Test
	public void testLogin() throws SQLException
	{
		// i due parametri da passare
		String user= "Matheoss96";
		String password = "teo96";
		String nome = "Matteo";
		String cognome = "Volpe";
		String Indirizzo ="via Napoli 15";
		String iban = "ABC123";
		String Cvv = "456";
		String expire = "05-2018";
		
		
		// creo la connessione
		conn = null;
		pstmt = null;
		
		try
		{
		// provo ad effettuare la connessione con il database
		conn =  DriverManagerConnectionPool.getConnection();
		String register ="INSERT INTO "+ Controllo_LoginTest.TABLE_NAME + "(Username,Password,Nome,Cognome,"
				+ "IndirizzoStandard,Iban,Cvv,Expire) VALUES (?,?,?,?,?,?,?,?)";
		pstmt= conn.prepareStatement(register);
		pstmt.setString(1, user);
		pstmt.setString(2, password);
		pstmt.setString(3, nome);
		pstmt.setString(4, cognome);
		pstmt.setString(5, Indirizzo);
		pstmt.setString(6, iban);
		pstmt.setString(7, Cvv);
		pstmt.setString(8, expire);
		
		
		// eseguo la query
		 pstmt.executeUpdate();
		 conn.commit();
	}finally
	{
		try
		{
			if (pstmt != null)
				pstmt.close();
		} finally {
			if (conn != null)
				conn.close();
		}

		}
		
		// richiamo l'invocazione del metodo login
		// se mi ritorna un valore 2 vuol dire che l'elemento esiste
		// ed è un utente ( gli amministratori li settiamo manualmente)
		int valore = loginDao.doControllo(user, password);
		
		assertEquals(2, valore);
		
		// vado ad eliminare l'oggetto creato per il test
		try
		{
			
		
			conn = null;
			pstmt = null;
			
			conn =  DriverManagerConnectionPool.getConnection();
			String elimina = "DELETE FROM "+Controllo_LoginTest.TABLE_NAME+" WHERE (Username = ?)";
			pstmt = conn.prepareStatement(elimina);
			pstmt.setString(1,user);
			pstmt.executeUpdate();
			conn.commit();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} finally {
				if (conn != null)
					conn.close();
			}

	}

}
	

	@Test
	public void testLoginUsernameScorretto() throws SQLException
	{
		// i due parametri da passare
		String user= "Mattep";
		String password = "teo96";
		String nome = "Matteo";
		String cognome = "Volpe";
		String Indirizzo ="via Napoli 15";
		String iban = "ABC123";
		String Cvv = "456";
		String expire = "05-2018";
		
		
		// creo la connessione
		conn = null;
		pstmt = null;
		
		try
		{
		// provo ad effettuare la connessione con il database
		conn =  DriverManagerConnectionPool.getConnection();
		String register ="INSERT INTO "+ Controllo_LoginTest.TABLE_NAME + "(Username,Password,Nome,Cognome,"
				+ "IndirizzoStandard,Iban,Cvv,Expire) VALUES (?,?,?,?,?,?,?,?)";
		pstmt= conn.prepareStatement(register);
		pstmt.setString(1, user);
		pstmt.setString(2, password);
		pstmt.setString(3, nome);
		pstmt.setString(4, cognome);
		pstmt.setString(5, Indirizzo);
		pstmt.setString(6, iban);
		pstmt.setString(7, Cvv);
		pstmt.setString(8, expire);
		
		
		// eseguo la query
		 pstmt.executeUpdate();
		 conn.commit();
	}finally
	{
		try
		{
			if (pstmt != null)
				pstmt.close();
		} finally {
			if (conn != null)
				conn.close();
		}

		}
		
		// richiamo l'invocazione del metodo login
		// se mi ritorna un valore 2 vuol dire che l'elemento esiste
		// ed è un utente ( gli amministratori li settiamo manualmente)
		int valore = loginDao.doControllo("Mix", password);
		
		assertEquals(0, valore);
		
		// vado ad eliminare l'oggetto creato per il test
		try
		{
			
		
			conn = null;
			pstmt = null;
			
			conn =  DriverManagerConnectionPool.getConnection();
			String elimina = "DELETE FROM "+Controllo_LoginTest.TABLE_NAME+" WHERE (Username = ?)";
			pstmt = conn.prepareStatement(elimina);
			pstmt.setString(1,user);
			pstmt.executeUpdate();
			conn.commit();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} finally {
				if (conn != null)
					conn.close();
			}

	}

}
	
	
	
	
	@Test
	public void testLoginUsernameVuoto() throws SQLException
	{
		// i due parametri da passare
		String user= "Matteo";
		String password = "teo96";
		String nome = "Matteo";
		String cognome = "Volpe";
		String Indirizzo ="via Napoli 15";
		String iban = "ABC123";
		String Cvv = "456";
		String expire = "05-2018";
		
		
		// creo la connessione
		conn = null;
		pstmt = null;
		
		try
		{
		// provo ad effettuare la connessione con il database
		conn =  DriverManagerConnectionPool.getConnection();
		String register ="INSERT INTO "+ Controllo_LoginTest.TABLE_NAME + "(Username,Password,Nome,Cognome,"
				+ "IndirizzoStandard,Iban,Cvv,Expire) VALUES (?,?,?,?,?,?,?,?)";
		pstmt= conn.prepareStatement(register);
		pstmt.setString(1, user);
		pstmt.setString(2, password);
		pstmt.setString(3, nome);
		pstmt.setString(4, cognome);
		pstmt.setString(5, Indirizzo);
		pstmt.setString(6, iban);
		pstmt.setString(7, Cvv);
		pstmt.setString(8, expire);
		
		
		// eseguo la query
		 pstmt.executeUpdate();
		 conn.commit();
	}finally
	{
		try
		{
			if (pstmt != null)
				pstmt.close();
		} finally {
			if (conn != null)
				conn.close();
		}

		}
		
		// richiamo l'invocazione del metodo login
		// se mi ritorna un valore 2 vuol dire che l'elemento esiste
		// ed è un utente ( gli amministratori li settiamo manualmente)
		int valore = loginDao.doControllo(null, password);
		
		assertEquals(0, valore);
		
		// vado ad eliminare l'oggetto creato per il test
		try
		{
			
		
			conn = null;
			pstmt = null;
			
			conn =  DriverManagerConnectionPool.getConnection();
			String elimina = "DELETE FROM "+Controllo_LoginTest.TABLE_NAME+" WHERE (Username = ?)";
			pstmt = conn.prepareStatement(elimina);
			pstmt.setString(1,user);
			pstmt.executeUpdate();
			conn.commit();
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} finally {
				if (conn != null)
					conn.close();
			}

	}

}
	
	@Test
	public void testLoginPasswordVuoto() throws SQLException
	{
		// i due parametri da passare
		String user= "Matheoss96";
		String password = "Ciaoooo";
		String nome = "Matteo";
		String cognome = "Volpe";
		String Indirizzo ="via Napoli 15";
		String iban = "ABC123";
		String Cvv = "456";
		String expire = "05-2018";
		
		
		// creo la connessione
		conn = null;
		pstmt = null;
		
		try
		{
		// provo ad effettuare la connessione con il database
		conn =  DriverManagerConnectionPool.getConnection();
		String register ="INSERT INTO "+ Controllo_LoginTest.TABLE_NAME + "(Username,Password,Nome,Cognome,"
				+ "IndirizzoStandard,Iban,Cvv,Expire) VALUES (?,?,?,?,?,?,?,?)";
		pstmt= conn.prepareStatement(register);
		pstmt.setString(1, user);
		pstmt.setString(2, password);
		pstmt.setString(3, nome);
		pstmt.setString(4, cognome);
		pstmt.setString(5, Indirizzo);
		pstmt.setString(6, iban);
		pstmt.setString(7, Cvv);
		pstmt.setString(8, expire);
		
		
		// eseguo la query
		 pstmt.executeUpdate();
		 conn.commit();
	}finally
	{
		try
		{
			if (pstmt != null)
				pstmt.close();
		} finally {
			if (conn != null)
				conn.close();
		}

		}
		
		// richiamo l'invocazione del metodo login
		// se mi ritorna un valore 2 vuol dire che l'elemento esiste
		// ed è un utente ( gli amministratori li settiamo manualmente)
		int valore = loginDao.doControllo(user, null);
		
		assertEquals(0, valore);
		
		// vado ad eliminare l'oggetto creato per il test
		try
		{
			
		
			conn = null;
			pstmt = null;
			
			conn =  DriverManagerConnectionPool.getConnection();
			String elimina = "DELETE FROM "+Controllo_LoginTest.TABLE_NAME+" WHERE (Username = ?)";
			pstmt = conn.prepareStatement(elimina);
			pstmt.setString(1,user);
			pstmt.executeUpdate();
			conn.commit();
			
		}finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} finally {
				if (conn != null)
					conn.close();
			}

	}
	
}
}

