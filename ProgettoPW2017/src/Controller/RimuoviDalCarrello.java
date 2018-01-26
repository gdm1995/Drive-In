package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OperazioniDAO.DeleteDAO;

/**
 * Servlet implementation to delete an element from the shop bag
 */
@WebServlet("/RimuoviDalCarrello")
public class RimuoviDalCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int res = 0;
	DeleteDAO rimuovi = new DeleteDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("Sono entrato");
		HttpSession session = request.getSession();
		String codice = request.getParameter("codice");
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
		String user = (String) session.getAttribute("user"); 
//		System.out.println("user,codice, colore, taglia, numero"+ user+ codice + colore + taglia + numero); // li prende
		System.out.println("Sono uscito");
		try
		{
			rimuovi.doDelete(codice, colore, taglia, user);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Rimuovi dal carrello");
		}
	}

}