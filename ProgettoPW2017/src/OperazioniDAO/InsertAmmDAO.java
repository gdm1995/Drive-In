
package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Connessioni.DriverManagerConnectionPool;

/**
 * Inserisce un prodotto all'interno del database da parte di un amministratore
 */
public class InsertAmmDAO
{
	private static final String TABLE_NAME = "prodotto";

	/** Inserimento di un nuovo prodotto da parte di un amministratore
	 * @param codice Codice del prodotto
	 * @param colore Colore del prodotto
	 * @param taglia Taglia del prodotto
	 * @param tipo Tipo del prodotto
	 * @param disp Disponibilità del prodotto
	 * @param sesso Sesso del prodotto M o F
	 * @param prezzo Prezzo del prodotto
	 * @param nome Nominativo del prodotto per la presentazione al pubblico
	 * @param nomeI Nome dell'indirizzo dell'immagine riguardante il prodotto
	 * @throws SQLException Evenutali eccezioni sull'esecuzione del codice SQL
	 */
	public synchronized void doInsert(String codice, String colore, String taglia, String tipo, String disp,
			String sesso, String prezzo, String nome, String nomeI) throws SQLException
	{
		Connection conn = null; // istanzio la connessione
		PreparedStatement prep = null;
		try
		{
			String insert = "INSERT INTO " + InsertAmmDAO.TABLE_NAME
					+ "(Codice,ProdCol,ProdTag,ProdottoTipo,Disp,Sesso,Prezzo,Nome,NomeImmagine) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			conn = DriverManagerConnectionPool.getConnection();
			prep = conn.prepareStatement(insert);
			prep.setString(1, codice);
			prep.setString(2, colore);
			prep.setString(3, taglia);
			prep.setString(4, tipo);
			prep.setString(5, disp);
			prep.setString(6, sesso);
			prep.setString(7, prezzo);
			prep.setString(8, nome);
			prep.setString(9, nomeI);
			prep.executeUpdate();
			conn.commit();
			// " WHERE Codice = ? & ProdCol = ? & ProdTag = ? & ProdottoTipo = ?
			// & #Disp = ? & Sesso = ? & Prezzo = ? & Nome = ? & NomeImmagine =
			// ?"
		} catch (SQLException e)
		{
			e.printStackTrace();
			System.out.println("Problemi durante l'esecuzione del codice SQL");
		} finally
		{
			prep.close();
			DriverManagerConnectionPool.releaseConnection(conn);
		}
	}

// Main per provare InsertAmmDAO
	
//	public static void main (String[] args) throws SQLException
//	{
//		InsertAmmDAO ciao = new InsertAmmDAO();
//		ciao.doInsert("F4","Rosso","46","Scarpa","6","M","68", "La bella scarpa rossa", "NikeInvernoR.jpg");
//	}
}