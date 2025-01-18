package gestiondesnavettes.model;

import java.util.Date;

public class SubscriptionRequest {
    private int requestId;
    private int userId;
    private int shuttleId;
    private Date requestDate;
    private String status;

    // Constructor
    public SubscriptionRequest(int requestId, int userId, int shuttleId, Date requestDate, String status) {
        this.requestId = requestId;
        this.userId = userId;
        this.shuttleId = shuttleId;
        this.requestDate = requestDate;
        this.status = status;
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(int shuttleId) {
        this.shuttleId = shuttleId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

