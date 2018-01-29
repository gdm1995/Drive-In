
package GestoreUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OperazioniDAO.DatiPersonaliDAO;

/**
 * Permette la modifica dei dati personali passando i dati identificativi di
 * tale persona e i dati che invece devono esssere modificati
 */

@WebServlet("/ModificaDatiUtente")
public class ModificaDatiUtente extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("Username");
		String nome = request.getParameter("Nome");
		String cognome = request.getParameter("Cognome");
		String indirizzo = request.getParameter("Indirizzo");
		String iban = request.getParameter("Iban");
		DatiPersonaliDAO ris = new DatiPersonaliDAO();
		if (nome != null)
		{
			try
			{
				ris.modificaNome(username, nome);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (cognome != null)
		{
			try
			{
				ris.modificaCognome(username, cognome);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(indirizzo!= null)
		{
			try
			{
				ris.modificaIndirizzo(username, indirizzo);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(iban!=null)
		{
			try
			{
				ris.modificaIban(username, iban);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dis = request.getRequestDispatcher("Profile.jsp");
		dis.forward(request, response);
	}

}
