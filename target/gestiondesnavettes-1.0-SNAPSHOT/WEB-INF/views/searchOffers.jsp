<%-- <%@ page import="gestiondesnavettes.model.SubscriptionOffer" %>
<%@ page import="java.util.List" %>
<%@ page language="java" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Offers</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Home</a>
        <div class="ml-auto">
            <c:if test="${not empty sessionScope.user}">
                <span class="navbar-text">
                    ${sessionScope.user.name}
                </span>
            </c:if>
        </div>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar (narrow) -->
            <div class="col-md-2 bg-light" style="height: 100vh; padding-top: 20px;">
                <h5>Navigation</h5>
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a href="#" class="nav-link" id="searchLink">Search Subscription Offers</a>
                    </li>
                </ul>
            </div>

            <!-- Main Content -->
            <div class="col-md-10" style="padding-top: 20px;">
                <div class="container mt-5">
                    <h2 class="mb-4">Search Subscription Offers</h2>

                    <!-- Search Form -->
                    <form action="searchOffers" method="POST" class="mb-5">
                        <div class="form-row">
                            <div class="form-group col-md-3">
                                <label for="departureCity">Departure City</label>
                                <input type="text" id="departureCity" name="departureCity" class="form-control" required>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="arrivalCity">Arrival City</label>
                                <input type="text" id="arrivalCity" name="arrivalCity" class="form-control" required>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="startDate">Start Date</label>
                                <input type="date" id="startDate" name="startDate" class="form-control" required>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="endDate">End Date</label>
                                <input type="date" id="endDate" name="endDate" class="form-control" required>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-primary">Search</button>
                    </form>

                    <!-- Results -->
                    <% if (request.getAttribute("offers") != null) { %>
                        <h3 class="mb-4">Results:</h3>
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th>Departure City</th>
                                    <th>Arrival City</th>
                                    <th>Start Date</th>
                                    <th>End Date</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                    <th>Current / Max Subscribers</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% List<SubscriptionOffer> offers = (List<SubscriptionOffer>) request.getAttribute("offers"); %>
                                <% for (SubscriptionOffer offer : offers) { %>
                                    <tr>
                                        <td><%= offer.getDepartureCity() %></td>
                                        <td><%= offer.getArrivalCity() %></td>
                                        <td><%= offer.getStartDate() %></td>
                                        <td><%= offer.getEndDate() %></td>
                                        <td><%= offer.getDescription() %></td>
                                        <td><%= offer.getStatus() %></td>
                                        <td><%= offer.getCurrentSubscribers() %> / <%= offer.getMaxSubscribers() %></td>
                                        <td>
                                            <!-- Subscribe Button -->
                                           <a href="${pageContext.request.contextPath}/subscriptionRequest?shuttleId=<%= offer.getShuttleId() %>&userId=${sessionScope.user.userId}" class="btn btn-success">Subscribe</a>

                                        </td>
                                    </tr>
                                <% } %>
                            </tbody>
                        </table>
                    <% } else if (request.getAttribute("error") != null) { %>
                        <div class="alert alert-danger"><%= request.getAttribute("error") %></div>
                    <% } %>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
 --%>