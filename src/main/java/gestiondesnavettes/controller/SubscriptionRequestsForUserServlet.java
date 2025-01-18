package gestiondesnavettes.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestiondesnavettes.model.SubscriptionRequest;
import gestiondesnavettes.model.User;
import gestiondesnavettes.service.SubscriptionRequestService;
@WebServlet("/userSubscriptionList")
public class SubscriptionRequestsForUserServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SubscriptionRequestService subscriptionRequestService;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionDesNavettes", "root", "admin@E11#");
            subscriptionRequestService = new SubscriptionRequestService(connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	User user = (User) session.getAttribute("user");
    	if (user != null) {
    	    
    	

        int userId = user.getUserId();
       
       
        
        try {
        List<SubscriptionRequest>  listubscription  = subscriptionRequestService.getSubscriptionRequestsForUser(userId);
           
        request.setAttribute("listubscription", listubscription);
        request.getRequestDispatcher("/WEB-INF/views/listSubscriptionRequestByUser.jsp").forward(request, response);
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/listSubscriptionRequestByUser.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error geting  subscription request", e);
        }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
