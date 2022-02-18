package com.zefiro.provaMaven;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefiro.provaMaven.dao.LibroDao;
import com.zefiro.provaMaven.model.Libro;

/**
 * Servlet implementation class GetLibroController
 */
public class GetLibroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLibroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Prendo parametri dall'oggetto chiamato id(?);
		String index = 	request.getParameter("id");
		
		int id = Integer.parseInt(index);
		LibroDao dao = new LibroDao();
		Libro l = dao.getLibro(id);
		
		request.setAttribute("libro", l);
		
		RequestDispatcher rd = request.getRequestDispatcher("showLibri.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
