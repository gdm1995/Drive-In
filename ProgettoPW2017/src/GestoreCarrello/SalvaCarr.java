
package GestoreCarrello;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OperazioniDAO.AggCarDAO;

/**
 * Servlet implementation class SalvaCarr
 */
@WebServlet("/SalvaCarr")
public class SalvaCarr extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	int res = 0;
	AggCarDAO aggiungi = new AggCarDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String codice = request.getParameter("codice");
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
		String numero = request.getParameter("numElementi");
		String user = (String) session.getAttribute("user");
		try
		{
			aggiungi.doCarrello(user, codice, colore, taglia, numero);
		} catch (SQLException e)
		{
			System.out.println("Errore durante l'esecuzione del codice SQL in SalvaCarr");
			e.printStackTrace();
		}
	}
}
