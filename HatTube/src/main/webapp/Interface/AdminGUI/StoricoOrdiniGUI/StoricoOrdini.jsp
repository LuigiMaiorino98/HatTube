<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>STORICO ORDINI</title>
    <%@include file="../AdmHomePage.jsp"%>
</head>


<body>



<c:forEach items="${aquisti}" var="aquisto">
    <p id="CheckoutG">PREZZO ORDINE:  ${aquisto.prezzo}</p>
    <p >CONTENUTO:</p>

    <table>
        <tr>
            <th>MARCA</th>
            <th>CATEGORIA</th>
            <th>MODELLO</th>
            <th>QUANTITA'</th>
            <th>PREZZO</th>
        </tr>
        <c:forEach items="${aquisto.cappelli}" var="cappello">

            <tr >
                <td>${cappello.marca}</td>
                <td>${cappello.categoria}</td>
                <td>${cappello.modello}</td>
                <td>${cappello.quantita}</td>
                <td>€ ${cappello.prezzo}0</td>
            </tr>

        </c:forEach>
    </table>
    <br>
</c:forEach>


</body>
</html>
