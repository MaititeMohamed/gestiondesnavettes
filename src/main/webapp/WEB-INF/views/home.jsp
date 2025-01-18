<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
</head>
<body>
    <h1>User Details</h1>

    
    <c:if test="${not empty sessionScope.user}">
      
        <p>User Name: ${sessionScope.user.name}</p> 
        <p>User Email: ${sessionScope.user.email}</p> 
    </c:if>

    <c:if test="${empty sessionScope.user}">
        <p>No user is logged in.</p>
    </c:if>
</body>
</html>
