package gestiondesnavettes.model;

import java.sql.Date;
import java.sql.Time;

public class SubscriptionOffer {
    private int offerId;
    private int shuttleId;
    private int maxSubscribers;
    private int currentSubscribers;
    private String status;
    private String departureCity;
    private String arrivalCity;
    private Date startDate;
    private Date endDate;
    private Time departureTime;
    private Time arrivalTime;
    private String description;

    // Constructors
    public SubscriptionOffer() {}

    public SubscriptionOffer(int offerId, int shuttleId, int maxSubscribers, int currentSubscribers, String status,
                             String departureCity, String arrivalCity, Date startDate, Date endDate,
                             Time departureTime, Time arrivalTime, String description) {
        this.offerId = offerId;
        this.shuttleId = shuttleId;
        this.maxSubscribers = maxSubscribers;
        this.currentSubscribers = currentSubscribers;
        this.status = status;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.description = description;
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

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
