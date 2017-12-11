package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.User;
import OperazioniDAO.ModificaDAO;

/**
 * Classe di controllo per interagire col database al fine di segnare come acquistato un prodotto. Deselezionandolo dagli acquistati e riducendo la quantità residuea
 */
@WebServlet("/Acquistato")
public class Acquistato extends HttpServlet {
	private static final long serialVersionUID = 1L;
 int r =0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		Controllo_LoginDao logo = new Controllo_LoginDao();
		
		InsertAmmDao acquista = new InsertAmmDao();
		DeleteDAO rimuovi = new DeleteDAO();
		// mi prendo i parametri
		String user =(String) session.getAttribute("user");
//		System.out.println("nume utente"+user);
		String dip= request.getParameter("Dispo");
		String codice = request.getParameter("Codice");
		String colore = request.getParameter("Colore");
		String taglia = request.getParameter("Taglia");
		String data = request.getParameter("Data");
		String quantita = request.getParameter("Quantita");
		String indirizzo= null;
		ModificaDAO od = new ModificaDAO();
		// mi prelevo l'indirizzo
		try {
			 indirizzo =logo.doindirizzo(user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
//		System.out.println("Indirizzo"+ indirizzo);
		
		// vado a salvarlo nel db
		
		try {
			r = acquista.acquista(user,codice,colore, taglia, data,quantita,indirizzo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(r != 0)
		{
//			System.out.println("ho modificato"+ r);
			response.getWriter().write("Okei, acquistato e inviato all'indirizzo "+indirizzo);
		}
//		
//		if(r == 0)
//		{
//			System.out.println("ho modificato"+ r);
//			response.getWriter().write("errore ");
//		}
		int elimino=0;
		try {
			 elimino=rimuovi.cancellaSelezionati(user, codice, colore, taglia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if (elimino != 0)
//		{
//			System.out.println("elimato"+1);
//		}
//		else
//		{
//			System.out.println("non eliminato");
//		}
		try
		{
			r= od.Edidisponibilit(codice, colore, taglia, dip);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(r !=0)
		{
			System.out.println("oki");
		}
		
		
		
	
	}


	
}
