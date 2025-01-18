package gestiondesnavettes.controller;

import gestiondesnavettes.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

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
        
        request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            userService.registerUser(name, email, password);
            response.sendRedirect("/WEB-INF/views/login.jsp");
        } catch (IllegalArgumentException | SQLException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }
    }
}
