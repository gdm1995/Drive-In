
package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connessioni.DriverManagerConnectionPool;

/** Modifica degli elementi di un prodotto */
public class ModificaDAO
{
	private static final String TABLE_NAME = "prodotto";
	int i = 0;
	String modifica = "";

	/**
	 * Modifica del codice del prodotto, cambiandolo con uno nuovo
	 * 
	 * @param codice Codice del prodotto prima della modifica
	 * @param colore Colore del prodotto
	 * @param taglia Taglia del prodotto 
	 * @param codic Codice del prodotto dopo la modifica
	 * @throws SQLException Nel caso di errore del codice SQL
	 */
	public synchronized void Edicodic(String codice, String colore, String taglia, String codic) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME
					+ " SET Codice=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, codic);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Errore nell'esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

	// Main per provare Edicodic

//	public static void main (String[] args) throws SQLException
//	{
//		ModificaDAO ciao = new ModificaDAO();
//		ciao.Edicodic("F4", "Rosso", "46", "F5");
//	}

	/**
	 * Modifica del colore del prodotto, cambiandolo con uno nuoco
	 * 
	 * @param codice Codice del prodotto 
	 * @param colore Colore del prodotto prima della modifica
	 * @param taglia Taglia del prodotto 
	 * @param codic Colore del prodotto dopo la modifica
	 * @throws SQLException Nel caso di errore del codice SQL
	 */
	public synchronized void Edicolor(String codice, String colore, String taglia, String color) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME
					+ " SET ProdCol=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, color);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Errore nell'esecuzione del codice SQL");

		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
	// Main per provare Edicolor

//	public static void main (String[] args) throws SQLException
//	{
//		ModificaDAO ciao = new ModificaDAO();
//		ciao.Edicolor("F5", "Rosso", "46", "Verde");
//	}

	/**
	 * Modifica della taglia del prodotto, cambiandolo con uno nuoco
	 * 
	 * @param codice Codice del prodotto 
	 * @param colore Colore del prodotto prima della modifica
	 * @param taglia Taglia del prodotto 
	 * @param codic Taglia del prodotto dopo la modifica
	 * @throws SQLException Nel caso di errore del codice SQL
	 */
	public synchronized void Editagli(String codice, String colore, String taglia, String tagli) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME
					+ " SET ProdTag=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";// 
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, tagli);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch(SQLException e)
		{ 
			e.printStackTrace();
			System.out.println("Problema con l'esecuzione del codice SQL");
		}finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

	// Main per provare Editagli

//		public static void main (String[] args) throws SQLException
//		{
//			ModificaDAO ciao = new ModificaDAO();
//			ciao.Editagli("F5", "Verde", "46", "45");
//		}

	/** Modifica della disponibilità di un prodotto
	 * @param codice Codice del prodotto prima della modifica
	 * @param colore Colore del prootto prima della modifica
	 * @param taglia Taglia del prodotto prima della modifica
	 * @param disponibilità Disponibilità del prodotto dopo la modifica
	 * @throws SQLException Problema durante l'esecuzione del codice SQL
	 */
	public synchronized void Edidisponibilit(String codice, String colore, String taglia, String disponibilit)
			throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME + " SET Disp=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, disponibilit);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problema durante l'esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

	// Main per provare Edidisponibilit

//	public static void main (String[] args) throws SQLException
//	{
//		ModificaDAO ciao = new ModificaDAO();
//		ciao.Edidisponibilit("F5", "Verde", "45", "3");
//	}

	/** Modifica del sesso indicato per un determinato prodotto
	 * @param codice Codice del prodotto
	 * @param colore Colore del prodotto
	 * @param taglia Taglia del prodotto
	 * @param sess Sesso nuovo del prodotto dopo la modifica
	 * @throws SQLException In caso di errori durante l'esecuzione del codice SQL
	 */
	public synchronized void Edisess(String codice, String colore, String taglia, String sess) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME
					+ " SET Sesso=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, sess);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi durante l'esecuzione del codice SQL");
		}
		finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

	// Main per provare Edisess

//		public static void main (String[] args) throws SQLException
//		{
//			ModificaDAO ciao = new ModificaDAO();
//			ciao.Edisess("F5", "Verde", "45", "M");
//		}

	/** Modifica del prezzo indicato per un determinato prodotto
	 * @param codice Codice del prodotto
	 * @param colore Colore del prodotto
	 * @param taglia Taglia del prodotto
	 * @param prezz Prezzo del prodotto dopo la modifica
	 * @throws SQLException In caso di problemi di esecuzione del codice SQL
	 */
	public synchronized void Ediprezz(String codice, String colore, String taglia, String prezz) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME
					+ " SET Prezzo=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, prezz);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch(SQLException e)
		{ e.printStackTrace();
		System.out.println("Problemi durante l'esecuzione del codice SQL");
		}
		finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

	// Main per provare Ediprezz

//	public static void main (String[] args) throws SQLException
//	{
//		ModificaDAO ciao = new ModificaDAO();
//		ciao.Ediprezz("F5", "Verde", "45", "134");
//	}

	/** Modidica il nome di un determinato prodotto
	 * @param codice Codice del prodotto da modificare
	 * @param colore Colore del prodotto da modificare
	 * @param taglia Taglia del prodotto da modificare
	 * @param nom Nuovo nome del prodotto
	 * @throws SQLException In caso di problemi nell'esecuzione del codice SQL
	 */

	public synchronized void Edinom(String codice, String colore, String taglia, String nom) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME + " SET Nome=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, nom);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi di esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

	// Main per provare Edinom

//		public static void main (String[] args) throws SQLException
//		{
//			ModificaDAO ciao = new ModificaDAO();
//			ciao.Edinom("F5", "Verde", "45", "Tanta Roba Ste Scarpe");
//		}
	
	
	/** Per la modifia dell'indirizzo di un immagine
	 * @param codice Codice del prodotto
	 * @param colore Colore del prodoto
	 * @param taglia Taglia del prodotto
	 * @param nomI Nuovo indirizzo dell'immagine 
	 * @throws SQLException In caso di eccezzioni sollevate dal codice SQL
	 */
	public synchronized void EdinomI(String codice, String colore, String taglia, String nomI) throws SQLException
	{
		Connection conn = null;
		PreparedStatement prep = null;
		try
		{
			String modifica = "UPDATE " + TABLE_NAME + " SET NomeImmagine=? WHERE (Codice = ? and ProdCol = ? and ProdTag = ?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(modifica);
			prep.setString(1, nomI);
			prep.setString(2, codice);
			prep.setString(3, colore);
			prep.setString(4, taglia);
			prep.executeUpdate();
			conn.commit();
		} catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi di esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}
	
	// Main per provare EdinomI

//	public static void main (String[] args) throws SQLException
//	{
//		ModificaDAO ciao = new ModificaDAO();
//		ciao.EdinomI("F5", "Verde", "45", "EasyGreenBag.jpg");
//	}
}
