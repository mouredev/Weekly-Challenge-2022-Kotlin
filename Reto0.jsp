<%-- 
    Document   : Reto#1
    Created on : 27 dic. 2021, 22:34:53
    Author     : Alberto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reto #0</title>
    </head>
    <body>
        
        <c:forEach var="cadena" begin="1" end="100" step="1">
            
            <c:if test="${cadena%3==0 && cadena%5==0}">
                <c:out value="fizzbuzz"/> <br>
            </c:if> 

            <c:if test="${cadena%3==0}">
                <c:out value="fizz"/> <br>
            </c:if>
                
            <c:if test="${cadena%5==0}">
                <c:out value="buzz"/> <br>
            </c:if>   
                        
        </c:forEach>
        
    </body>
</html>
