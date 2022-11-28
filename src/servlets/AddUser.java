package servlets;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Utilisateur;
import dao.UtilisateurDao;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/Add")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateur.jsp";
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);	;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom =request.getParameter("nom");
		String prenom =request.getParameter("prenom");
		String login =request.getParameter("login");
		String password =request.getParameter("password");
		Utilisateur utilisateur=new Utilisateur(nom,prenom, login, password);
		
		UtilisateurDao utilisateurDao=new UtilisateurDao();
		
		utilisateurDao.ajouter(utilisateur);
		response.sendRedirect("List");
	}

}
