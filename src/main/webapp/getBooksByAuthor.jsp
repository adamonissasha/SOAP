<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">
    <title>Books by author</title>
</head>
<body>

<table>
    <tr>
        <td><c:out value="ID"/></td>
        <td><c:out value="NAME"/></td>
        <td><c:out value="AUTHOR"/></td>
        <td><c:out value="GENRE"/></td>
    </tr>
    <jsp:useBean id="books" scope="request" type="java.util.List<org.example.entity.Book>"/>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>${book.genre.prefix}</td>
        </tr>
    </c:forEach>
</table>
<button><a href="/SOAP">To main page</a></button>
</body>
</html>
