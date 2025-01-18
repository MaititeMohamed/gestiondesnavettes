package gestiondesnavettes.controller;

import gestiondesnavettes.model.SubscriptionOffer;
import gestiondesnavettes.service.SubscriptionOfferService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/searchOffers")
public class SearchOffersServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SubscriptionOfferService offerService;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionDesNavettes", "root", "admin@E11#");
            offerService = new SubscriptionOfferService(connection);
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException("Database connection error", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/searchOffers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String departureCity = request.getParameter("departureCity");
        String arrivalCity = request.getParameter("arrivalCity");
        Date startDate = Date.valueOf(request.getParameter("startDate"));
        Date endDate = Date.valueOf(request.getParameter("endDate"));

        try {
            List<SubscriptionOffer> offers = offerService.searchOffers(departureCity, arrivalCity, startDate, endDate);
            request.setAttribute("offers", offers);
            request.getRequestDispatcher("/WEB-INF/views/searchOffers.jsp").forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", "Error fetching offers.");
            request.getRequestDispatcher("/WEB-INF/views/searchOffers.jsp").forward(request, response);
        }
    }
}

