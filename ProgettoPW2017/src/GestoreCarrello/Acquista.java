
package GestoreCarrello;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import OperazioniDAO.AcquistaDAO;
import OperazioniDAO.ModificaDAO;

/**
 * Servlet implementation class Acquistato, che modifica anche la quantità residua di un prodotto
 */
@WebServlet("/Acquista")
public class Acquista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		HttpSession session = request.getSession();
		AcquistaDAO acquista = new AcquistaDAO();
		ModificaDAO modDisp = new ModificaDAO();

		// mi prendo i parametri
		String user = (String) session.getAttribute("user");
		// System.out.println("nume utente"+user);
		String nOrdine = request.getParameter("nOrdine");
		String disp = request.getParameter("dispo");
		String codice = request.getParameter("codice");
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
		String data = request.getParameter("data");
		String quantita = request.getParameter("quantita");
		String indirizzo = request.getParameter("indirizzo");
		int valore1, valore2, risultato;
		String risultatopermetodo=null;
		valore1 = Integer.parseInt(disp);
		valore2 = Integer.parseInt(quantita);
		risultato = valore1 - valore2;
		risultatopermetodo = ("" + risultato);
		try {
			acquista.acquista(user, codice, colore, taglia, data, quantita, indirizzo,nOrdine);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			modDisp.Edidisponibilit(codice, colore, taglia,risultatopermetodo) ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
