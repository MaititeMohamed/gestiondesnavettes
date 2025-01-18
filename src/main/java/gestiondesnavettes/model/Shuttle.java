package gestiondesnavettes.model;

import java.util.Date;

public class Shuttle {
    private int shuttleId;
    private int companyId;
    private String departureCity;
    private String arrivalCity;
    private Date startDate;
    private Date endDate;
    private String departureTime;
    private String arrivalTime;
    private int seats;
    private String description;

    // Constructor
    public Shuttle(int shuttleId, int companyId, String departureCity, String arrivalCity, Date startDate, Date endDate,
                   String departureTime, String arrivalTime, int seats, String description) {
        this.shuttleId = shuttleId;
        this.companyId = companyId;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seats = seats;
        this.description = description;
    }

    // Getters and Setters
    public int getShuttleId() {
        return shuttleId;
    }

    public void setShuttleId(int shuttleId) {
        this.shuttleId = shuttleId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
