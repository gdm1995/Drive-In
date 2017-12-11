package OperazioniDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connessioni.DriverManagerConnectionPool;

/**
 * Se hai bisogno di verificare che l'user e la password di un utente sia presente o meno all'interno del database
 */
public class Controllo_LoginDAO
{
	private static final String TABLE_NAME = "utente"; 

	public synchronized int doControllo(String user, String pass) throws SQLException
	{
		Connection conn = null; // istanzio una nuova connessione
		PreparedStatement prep = null;
		String controllo = "SELECT * " + "from "+ Controllo_LoginDAO.TABLE_NAME;
		conn = DriverManagerConnectionPool.getConnection();
		prep = conn.prepareStatement(controllo);
		ResultSet res = prep.executeQuery(); //in res salvo la tabella risultato della query
		conn.commit();
		int i = 0; // valore per comprendere chi è l'utente
		try
		{
			while (res.next())
			{
				if (res.getString("Username").equals(user) && res.getString("Password").equals(pass)
						&& res.getString("Amministratore").equals("1"))
				{
					return i = 1; //amministratore
				} else
				{
					if (res.getString("Username").equals(user) && res.getString("Password").equals(pass))
					{
						return i = 2; //utente normale 
					}
				}
			}
		} catch (SQLException e)
		{
			System.out.println("Problemi durante l'esecuzione del codide SQL");
			e.printStackTrace();
		} finally
		{
			conn.close();
		}
		return i;
	}
	
	// Main per provare Controllo_LoginDAO
	
//	public static void main (String[] args) throws SQLException
//	{
//		Controllo_LoginDAO ciao = new Controllo_LoginDAO();
//		int i=0;
//		i=ciao.doControllo("Carlo", "Carlo");
//		System.out.println(i);
//		i=ciao.doControllo("Angela", "Ursi");
//		System.out.println(i);
//		i=ciao.doControllo("Inventato", "Inventato");
//		System.out.println(i);
//	}
}

