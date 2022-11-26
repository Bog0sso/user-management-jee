package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/login","/logout"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		switch(request.getServletPath()) {
		case "/logout":
			request.getSession().invalidate();
			response.sendRedirect("login");
		break;
		case "/login":
			getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
			
		//vérifier paramètres
		if("admin".equals(login) && "passer".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("isConnected", true);
			response.sendRedirect("users");
		}else {
			request.setAttribute("connexionFailed", true);
			request.setAttribute("login", login);
			request.setAttribute("password", password);
			
			getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
						
	
	}

}
