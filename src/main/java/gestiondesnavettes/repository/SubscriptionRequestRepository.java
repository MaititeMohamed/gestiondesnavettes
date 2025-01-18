package gestiondesnavettes.repository;

import gestiondesnavettes.model.SubscriptionRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionRequestRepository {
    private Connection connection;

    public SubscriptionRequestRepository(Connection connection) {
        this.connection = connection;
    }

    // Method to save a subscription request
    public void saveSubscriptionRequest(SubscriptionRequest request) throws SQLException {
        String query = "INSERT INTO SubscriptionRequest (user_id, shuttle_id, request_date, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, request.getUserId());
            statement.setInt(2, request.getShuttleId());
            statement.setDate(3, new java.sql.Date(request.getRequestDate().getTime()));
            statement.setString(4, request.getStatus());
            statement.executeUpdate();
        }
    }

    // Method to find subscription requests by user ID and shuttle ID (to avoid duplicates)
    public SubscriptionRequest findByUserAndShuttle(int userId, int shuttleId) throws SQLException {
        String query = "SELECT * FROM SubscriptionRequest WHERE user_id = ? AND shuttle_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, shuttleId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return new SubscriptionRequest(
                        rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getInt("shuttle_id"),
                        rs.getDate("request_date"),
                        rs.getString("status")
                );
            }
        }
        return null; // No matching request found
    }
    // Method to find subscription requests by user ID 
    public List<SubscriptionRequest> findByUser(int userId) throws SQLException {
        List<SubscriptionRequest> requests = new ArrayList<>();
        String query = "SELECT * FROM SubscriptionRequest WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                requests.add(new SubscriptionRequest(
                        rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getInt("shuttle_id"),
                        rs.getDate("request_date"),
                        rs.getString("status")
                ));
            }
        }
        return requests;
    }
    // Method to get all subscription requests for a shuttle (for company view)
    public List<SubscriptionRequest> getRequestsForShuttle(int shuttleId) throws SQLException {
        List<SubscriptionRequest> requests = new ArrayList<>();
        String query = "SELECT * FROM SubscriptionRequest WHERE shuttle_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, shuttleId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                requests.add(new SubscriptionRequest(
                        rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getInt("shuttle_id"),
                        rs.getDate("request_date"),
                        rs.getString("status")
                ));
            }
        }
        return requests;
    }

    // Method to update the status of a subscription request
    public void updateRequestStatus(int requestId, String status) throws SQLException {
        String query = "UPDATE SubscriptionRequest SET status = ? WHERE request_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status);
            statement.setInt(2, requestId);
            statement.executeUpdate();
        }
    }
}
