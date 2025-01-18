package gestiondesnavettes.service;

import gestiondesnavettes.model.SubscriptionOffer;
import gestiondesnavettes.repository.SubscriptionOfferRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class SubscriptionOfferService {

    private SubscriptionOfferRepository offerRepository;

    public SubscriptionOfferService(Connection connection) {
        this.offerRepository = new SubscriptionOfferRepository(connection);
    }

    public List<SubscriptionOffer> searchOffers(String departureCity, String arrivalCity, Date startDate, Date endDate) throws SQLException {
        return offerRepository.findOffers(departureCity, arrivalCity, startDate, endDate);
    }
}
