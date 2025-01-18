package gestiondesnavettes.controller;

import gestiondesnavettes.service.SubscriptionRequestService;

import gestiondesnavettes.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;


@WebServlet("/subscriptionRequest")
public class SubscriptionRequestServlet extends HttpServlet {

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
        int shuttleId = Integer.parseInt(request.getParameter("shuttleId"));
        Date requestDate = new Date(); 
        
        try {
            subscriptionRequestService.createSubscriptionRequest(userId, shuttleId, requestDate);
            // Set a success message
            request.setAttribute("successMessage", "Your subscription request has been successfully submitted.");
            // Forward back to the searchOffers.jsp
            request.getRequestDispatcher("/WEB-INF/views/searchOffers.jsp").forward(request, response);

        } catch (IllegalArgumentException e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/searchOffers.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error creating subscription request", e);
        }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
