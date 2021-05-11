<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  <!-- позволяет писать теги spring -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Customer Confirmation</title>
</head>

<body>

The Customer is confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free passes : ${customer.freePasses}

<br><br>

Postal code : ${customer.postalCode}

</body>
</html>
