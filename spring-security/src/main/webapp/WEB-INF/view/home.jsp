<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>Home Page - Hi Friend</h2>
<hr>
<p>
    Welcome to my home page friend!
</p>

<hr>
<!-- Display Username and role-->
<p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role (s): <security:authentication property="principal.authorities"/>
</p>
<hr>

<security:authorize access="hasRole('MANAGER')">
<!-- Add a link to point to / leaders ... this is for the managers -->
<p>
    <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
    (Only for Manager peeps)
</p>
</security:authorize>


<security:authorize access="hasRole('ADMIN')">
<!-- Add a link to point to / systems ... this is for the admins -->
<p>
    <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
    (Only for Admins peeps)
</p>
</security:authorize>



<!-- Add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout"
           method="post">

    <input type="submit" value="Logout"/>

</form:form>

</body>
</html>
