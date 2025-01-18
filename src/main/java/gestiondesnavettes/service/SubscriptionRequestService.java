package gestiondesnavettes.service;

import gestiondesnavettes.model.SubscriptionRequest;
import gestiondesnavettes.repository.SubscriptionRequestRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SubscriptionRequestService {
    private SubscriptionRequestRepository repository;

    public SubscriptionRequestService(Connection connection) {
        this.repository = new SubscriptionRequestRepository(connection);
    }

    // Method to create a new subscription request
    public void createSubscriptionRequest(int userId, int shuttleId, Date requestDate) throws SQLException {
        // Check if a similar request already exists
        SubscriptionRequest existingRequest = repository.findByUserAndShuttle(userId, shuttleId);
        if (existingRequest != null) {
            throw new IllegalArgumentException("You have already requested this subscription.");
        }

        // Create a new request
        SubscriptionRequest request = new SubscriptionRequest(0, userId, shuttleId, requestDate, "pending");
        repository.saveSubscriptionRequest(request);
    }

    // Method to view subscription requests for a shuttle (for the company)
    public List<SubscriptionRequest> getSubscriptionRequestsForShuttle(int shuttleId) throws SQLException {
        return repository.getRequestsForShuttle(shuttleId);
    }
    // Method to view subscription requests for user 
    public List<SubscriptionRequest> getSubscriptionRequestsForUser(int userId) throws SQLException {
        return repository.findByUser(userId);
    }

    // Method to update the status of a subscription request
    public void updateRequestStatus(int requestId, String status) throws SQLException {
        repository.updateRequestStatus(requestId, status);
    }
    
    
}
