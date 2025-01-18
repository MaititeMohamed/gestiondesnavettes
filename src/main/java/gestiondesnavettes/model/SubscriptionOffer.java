package gestiondesnavettes.model;

public class SubscriptionOffer {
    private int offerId;
    private int shuttleId;
    private int maxSubscribers;
    private int currentSubscribers;
    private String status;

    // Constructor
    public SubscriptionOffer(int offerId, int shuttleId, int maxSubscribers, int currentSubscribers, String status) {
        this.offerId = offerId;
        this.shuttleId = shuttleId;
        this.maxSubscribers = maxSubscribers;
        this.currentSubscribers = currentSubscribers;
        this.status = status;
    }

    // Getters and Setters
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(int shuttleId) {
        this.shuttleId = shuttleId;
    }

    public int getMaxSubscribers() {
        return maxSubscribers;
    }

    public void setMaxSubscribers(int maxSubscribers) {
        this.maxSubscribers = maxSubscribers;
    }

    public int getCurrentSubscribers() {
        return currentSubscribers;
    }

    public void setCurrentSubscribers(int currentSubscribers) {
        this.currentSubscribers = currentSubscribers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
