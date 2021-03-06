
package GestoreUtente;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Carta;
import Model.User;
import OperazioniDAO.RegistraDAO;

@WebServlet("/Salva")
public class Salva extends HttpServlet
{

	/**
	 * Regostrazione dei dati dell'utente 
	 */
	private static final long serialVersionUID = 1L;

	User bean = new User();

	RegistraDAO registra = new RegistraDAO(); // creo un costruttore

	int res = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// o con i beans o attraverso la sessione o la request ( a secondo
		// dell'occorrenza).
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		String password = (String) session.getAttribute("password");
		String nome = (String) session.getAttribute("nome");
		String cognome = (String) session.getAttribute("cognome");
		String indirizzo = (String) session.getAttribute("indirizzo");
		String iban = "98659865234659875698569";
		Carta carta = new Carta(iban);

		// Qui i dati saranno gia integri, percio devo solo salvarmi sul
		// database ( in quanto ho fatto gia il controllo con javascript)
		try
		{
			registra.doSave(user, password, nome, cognome, indirizzo, carta);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		RequestDispatcher disp = request.getRequestDispatcher("Benvenuto.jsp");
		disp.forward(request, response);

	}

}
