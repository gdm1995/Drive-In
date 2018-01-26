
package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import OperazioniDAO.RegistraDAO;

@WebServlet("/Registrazione")
public class Registrazione extends HttpServlet
{

	RegistraDAO registra = new RegistraDAO(); // creo un costruttore

	int res = 0;

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{

		response.setContentType("text/html");
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String indirizzo = request.getParameter("indirizzo");
		HttpSession session = request.getSession();
		String id = session.getId();
		session.setAttribute("id", id);
		session.setAttribute("user", user);
		session.setAttribute("password", password);
		session.setAttribute("cognome", cognome);
		session.setAttribute("nome", nome);
		session.setAttribute("indirizzo", indirizzo);

		// AGGIORNO I BEAN

		User bean = new User();
		bean.setUsername(user);
		bean.setPassword(password);
		bean.setNome(nome);
		bean.setCognome(cognome);
		bean.setIndirizzo(indirizzo);
		session.setAttribute("utente", bean);

		// verifico se i dati immessi sono confermati dal client
		getServletContext().getRequestDispatcher("/Accetta.jsp").forward(request, response);

	}
	// INserire il controllo per nome utente gia presente

}
