package gestiondesnavettes.repository;

import gestiondesnavettes.model.SubscriptionOffer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionOfferRepository {

    private Connection connection;

    public SubscriptionOfferRepository(Connection connection) {
        this.connection = connection;
    }

    public List<SubscriptionOffer> findOffers(String departureCity, String arrivalCity, Date startDate, Date endDate) throws SQLException {
        List<SubscriptionOffer> offers = new ArrayList<>();

        String query = "SELECT o.offer_id, o.status, o.max_subscribers, o.current_subscribers, s.departure_city, " +
                       "s.arrival_city, s.start_date, s.end_date, s.departure_time, s.arrival_time, s.description " +
                       "FROM SubscriptionOffer o " +
                       "JOIN Shuttle s ON o.shuttle_id = s.shuttle_id " +
                       "WHERE s.departure_city = ? AND s.arrival_city = ? AND s.start_date >= ? AND s.end_date <= ? AND o.status = 'open'";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, departureCity);
            statement.setString(2, arrivalCity);
            statement.setDate(3, startDate);
            statement.setDate(4, endDate);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                SubscriptionOffer offer = new SubscriptionOffer();
                offer.setOfferId(rs.getInt("offer_id"));
                offer.setStatus(rs.getString("status"));
                offer.setMaxSubscribers(rs.getInt("max_subscribers"));
                offer.setCurrentSubscribers(rs.getInt("current_subscribers"));
                offer.setDepartureCity(rs.getString("departure_city"));
                offer.setArrivalCity(rs.getString("arrival_city"));
                offer.setStartDate(rs.getDate("start_date"));
                offer.setEndDate(rs.getDate("end_date"));
                offer.setDepartureTime(rs.getTime("departure_time"));
                offer.setArrivalTime(rs.getTime("arrival_time"));
                offer.setDescription(rs.getString("description"));

                offers.add(offer);
            }
        }

        return offers;
    }
}
