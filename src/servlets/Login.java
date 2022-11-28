package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Utilisateur;
import dao.UtilisateurDao;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_LOGIN="/WEB-INF/login.jsp";
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login= request.getParameter("login");
		String password= request.getParameter("password");
		
         UtilisateurDao utilisateurDao=new UtilisateurDao();
		
	Utilisateur utilisateur=	utilisateurDao.login(login,password);
		if (utilisateur.getId()>0) {
			
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);
			response.sendRedirect("List");
			
		}
		
		else {
			request.setAttribute("connexionfaild", true);
			request.setAttribute("login", login);
			getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}

	}

}
