
package Controller;

import java.io.File;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONObject;

import OperazioniDAO.InsertAmmDAO;

@WebServlet("/InserisciAmministratore")
public class InserisciAmministratore extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String tipo = request.getParameter("tipo");
		String nome = request.getParameter("n");
		String Sesso = request.getParameter("sesso");
		String col = request.getParameter("col");
		String nElementi = request.getParameter("nE");
		String codice = request.getParameter("cod");
		String prezzo = request.getParameter("prez");
		String taglia = request.getParameter("tag");
		String photo = request.getParameter("photo");

		// System.out.println("sto ricevendo"+ " "+ tipo +" "+ nome +" " +
		// Sesso+ " " + col+ " "+ nElementi + " "+ codice+ " "+ prezzo +" "+
		// taglia + " "+ photo);
		InsertAmmDAO inser = new InsertAmmDAO();
		try
		{
			inser.doInsert(codice, col, taglia, tipo, nElementi, Sesso, prezzo, nome, photo);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
