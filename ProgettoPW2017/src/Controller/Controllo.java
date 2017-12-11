
package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OperazioniDAO.Controllo_LoginDAO;

/**
 * Classe utilizzata come riscontro dei dati inseriti da un utente durante il Login. Prende in input username e la
 * password passati come parametri della sessione e riporta in output un reindirizzamento all pagina utile di post login
 */
@WebServlet("/Controllo")
public class Controllo extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	int i = 0;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String user = request.getParameter("user");
		// creo l'oggetto sessione
		HttpSession session = request.getSession();
		String Password = request.getParameter("password");
		session.setAttribute("user", user);
		Controllo_LoginDAO presente = new Controllo_LoginDAO();
		try
		{
			i = presente.doControllo(user, Password);
		} catch (SQLException e)
		{
			System.out.println("Problemi durante il riscontro del dei dati d'accesso dell'utente.");
			e.printStackTrace();
		}
		if (i == 1)
		{
			session.setAttribute("user", user);
			RequestDispatcher home = request.getRequestDispatcher("Amministratore.jsp");
			home.forward(request, response);
		}
		if (i == 2)
		{
			session.setAttribute("user", user);
			RequestDispatcher home = request.getRequestDispatcher("Benvenuto.jsp");
			home.forward(request, response);
		} else if (i == 0)
		{
			boolean controllo = true;
			session.setAttribute("presente", controllo);
			response.sendRedirect("login_registrazione.jsp");
		}
	}
}
