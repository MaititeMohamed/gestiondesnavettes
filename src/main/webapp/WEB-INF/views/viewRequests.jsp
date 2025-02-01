<%-- <%@ page import="gestiondesnavettes.model.SubscriptionRequest" %>
<%@ page import="java.util.List" %>
<%@ page language="java" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    // Check if the user is logged in
    if (session.getAttribute("user") == null) {
        // Redirect to the login page
        response.sendRedirect(request.getContextPath() + "/login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Offers</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2>Subscription Requests for Shuttle</h2>
<table>
    <tr>
        <th>User ID</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    <% 
        List<SubscriptionRequest> requests = (List<SubscriptionRequest>) request.getAttribute("requests");
        for (SubscriptionRequest request : requests) {
    %>
    <tr>
        <td><%= request.getUserId() %></td>
        <td><%= request.getStatus() %></td>
        <td>
            <form action="/subscriptionRequest" method="POST">
                <input type="hidden" name="requestId" value="<%= request.getRequestId() %>">
                <button type="submit" name="status" value="accepted">Accept</button>
                <button type="submit" name="status" value="rejected">Reject</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html> --%>