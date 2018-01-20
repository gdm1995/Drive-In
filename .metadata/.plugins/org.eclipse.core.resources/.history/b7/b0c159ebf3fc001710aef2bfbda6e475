package Controller;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONObject;

import OperazioniDAO.DeleteDAO;
import OperazioniDAO.DeleteProdDAO;

@WebServlet("/DeleteAmm")
public class DeleteAmm extends HttpServlet
{
	int i = 0 ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException
	{
		// mi prendo gli input passati dall'iterazione json ( solo le chiavi)
		String codice= request.getParameter("codice");
		String colore = request.getParameter("colore");
		String taglia = request.getParameter("taglia");
//			System.out.println(" sto ricevendo i seguenti parametri "+ codice + colore + taglia);
		DeleteProdDAO delete = new DeleteProdDAO();
		try
		{
			delete.doDelete(codice, colore, taglia);
		}catch(SQLException e )
		{
			e.printStackTrace();
		}
	}
}
