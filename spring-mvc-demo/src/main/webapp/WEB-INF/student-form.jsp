<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>

<form:form action="processForm" modelAttribute="student">

    First name: <form:input path="firstName"/> <!-- Вызывается сеттер и присваивается значение -->

    <br><br>

    Last name: <form:input path="lastName"/>

    <br><br>

    Country: <form:select path="country">
    <form:options items="${student.countryOptions}"/>
</form:select>

    <br><br>

    Favorite Language:
    Java <form:radiobutton path="favoriteLanguage" value="Java" />
    C# <form:radiobutton path="favoriteLanguage" value="C#" />
    PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
    Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

    <br><br>

    Operating systems:
    MacOS <form:checkbox path="operatingSystems" value="MacOS" />
    Linux <form:checkbox path="operatingSystems" value="Linux" />
    Microsoft Windows <form:checkbox path="operatingSystems" value="Microsoft Windows" />

    <br><br>

    <input type="submit" value="Submit"/>

</form:form>


</body>
</html>
