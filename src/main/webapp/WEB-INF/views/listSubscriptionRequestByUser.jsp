<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Subscription Requests</title>
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
                        <a href="<%=request.getContextPath()%>/searchOffers" class="nav-link" id="searchLink">Search Subscription Offers</a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/userSubscriptionList" class="nav-link" id="searchLink2">User Subscription Requests</a>
                    </li>
                </ul>
            </div>

            <!-- Main Content -->
            	<div class="col-md-10" style="padding-top: 20px;">
				<div class="container mt-5">
                <h2 class="mb-4">Your Subscription Requests</h2>

                <!-- Display error message, if any -->
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">
                        ${error}
                    </div>
                </c:if>

                <!-- Display subscription requests -->
                <c:if test="${not empty listubscription}">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Shuttle ID</th>
                                <th>Request Date</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="request" items="${listubscription}">
                                <tr>
                                    <td>${request.shuttleId}</td>
                                    <td>${request.requestDate}</td>
                                    <td>${request.status}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <!-- Display message if no subscriptions found -->
                <c:if test="${empty listubscription}">
                    <div class="alert alert-info" role="alert">
                        You have no subscription requests at the moment.
                    </div>
                </c:if>
            </div>
            </div>
        </div>
    </div>
</body>
</html>
