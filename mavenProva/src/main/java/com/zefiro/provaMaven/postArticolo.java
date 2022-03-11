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
 * Servlet implementation class postArticolo
 */
public class postArticolo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postArticolo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		LibroDao dao = new LibroDao();
		String titolo = request.getParameter("titolo");
		
		
		Libro articolo = dao.GetTitolo(titolo);
		
		if(articolo == null) {
			
			Libro a = new Libro();
			
			a.setTitolo(titolo);
			a.setAutore(request.getParameter("autore"));
			a.setGenere(request.getParameter("genere"));
			a.setAnno(request.getParameter("anno"));
			a.setIsLibroOrCd(Integer.parseInt(request.getParameter("isLibroOrCd")));
			a.setQuantita(Integer.parseInt(request.getParameter("quantita")));
			
			dao.insert(a);
			
			
		} else {
			
			articolo.setTitolo(titolo);
			articolo.setAutore(request.getParameter("autore"));
			articolo.setGenere(request.getParameter("genere"));
			articolo.setAnno(request.getParameter("anno"));
			articolo.setIsLibroOrCd(Integer.parseInt(request.getParameter("isLibroOrCd")));
			articolo.setQuantita(Integer.parseInt(request.getParameter("quantita")));
			
			dao.update(articolo);
			
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("modifica.jsp");
		rd.forward(request, response);
		
//		doGet(request, response);
	}

}
