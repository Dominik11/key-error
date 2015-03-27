<%-- 
    Document   : addPerson
    Created on : 2014-03-27, 09:04:28
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> 
        <h1>Spring CRM :: <c:choose><c:when test="${not empty param['id']}">Edycja danych osoby</c:when><c:otherwise>Dodawanie osoby</c:otherwise></c:choose></h1>
        
        <form:form commandName="person" method="POST" action="add.htm">
          
            <form:hidden path="id"/>
            <form:input path="name" placeholder="Imię" required="true" /><form:errors path="name"/><br/>
            <form:input path="lastname" placeholder="Nazwisko" required="true"/><form:errors path="lastname"/><br/>
            <form:input path="email" type="email" placeholder="Mail" required="true" /><form:errors path="email"/> <br/>
            <form:input path="discount" placeholder="Rabat" /><form:errors path="discount"/><br/>
            <form:select items="${teams}" path="team.id" itemValue="id" itemLabel="name"></form:select>
            
            <form:button>Zapisz</form:button>
            
        </form:form>
        
    </body>
</html>
