
package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OperazioniDAO.ModificaDAO;

/**
 * Esegue la modifica di un determinata caratteristica di uno specifico prodotto, passando alla DAO gli identifiativi
 * del prodotto ed il nuovo elemento da variare
 */
@WebServlet("/Modifica")
public class Modifica extends HttpServlet
{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String codice = request.getParameter("codice");
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
		String codic = request.getParameter("codic");
		String color = request.getParameter("color");
		String tagli = request.getParameter("tagli");
		String prezz = request.getParameter("prezz");
		String disponibilit = request.getParameter("disponibilit");
		String sess = request.getParameter("sess");
		// System.out.println("Sto ricevendo: "+codice+colore+taglia+codic+color+tagli+disponibilit+sess+prezz);
		ModificaDAO mod = new ModificaDAO();
		if (codic != null)
		{
			try
			{
				mod.Edicodic(codice, colore, taglia, codic);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (color != null)
		{
			try
			{
				mod.Edicolor(codice, colore, taglia, color);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (tagli != null)
		{
			try
			{
				mod.Editagli(codice, colore, taglia, tagli);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (disponibilit != null)
		{
			try
			{
				mod.Edidisponibilit(codice, colore, taglia, disponibilit);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sess != null)
		{
			try
			{
				mod.Edisess(codice, colore, taglia, sess);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		if (prezz != null)
		{
			try
			{
				mod.Ediprezz(codice, colore, taglia, prezz);
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// HttpSession session = request.getSession();
		// session.setAttribute("modificato", "si");
		RequestDispatcher dis = request.getRequestDispatcher("Amministratore.jsp");
		dis.forward(request, response);
	}
}
