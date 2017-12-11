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
import OperazioniDAO.Controllo_LoginDAO;
import OperazioniDAO.DeleteProdDAO;
import OperazioniDAO.InsertAmmDAO;
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
		
		// CLASSE DA MODIFICARE PER IS	
	
	}


	
}
