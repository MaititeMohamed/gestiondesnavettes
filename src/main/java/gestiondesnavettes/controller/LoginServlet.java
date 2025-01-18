package gestiondesnavettes.controller;

import gestiondesnavettes.service.UserService;
import gestiondesnavettes.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService;

    @Override
    public void init() throws ServletException {
    	try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionDesNavettes", "root", "admin@E11#");
    	    userService = new UserService(connection);
    	} catch (SQLException e) {
    	    throw new ServletException("Database connection error", e);
    	} catch (ClassNotFoundException e) {
    	    throw new ServletException("MySQL Driver not found", e);
    	}

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userService.loginUser(email, password);
            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                request.getRequestDispatcher("/WEB-INF/views/searchOffers.jsp").forward(request, response);
              
            } else {
                request.setAttribute("error", "Invalid email or password.");
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            request.setAttribute("error", "Login error.");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }

}
