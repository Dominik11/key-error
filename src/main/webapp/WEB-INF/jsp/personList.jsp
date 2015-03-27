<%-- 
    Document   : personList
    Created on : 2014-03-27, 09:32:11
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Spring CRM :: Lista osób</h1>
        
        <table border="1">
            <th>ID</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Mail</th>
            <c:forEach items="${persons}" var="person">
                <tr>
                    <td> <a href="<c:url value="/person/edit.htm"/>?id=${person.id}">${person.id}</a></td>
                    <td>${person.name}</td>
                    <td>${person.lastname}</td>
                    <td>${person.email}</td>
                </tr>
            </c:forEach>
        </table>
            
            
    </body>
</html>
