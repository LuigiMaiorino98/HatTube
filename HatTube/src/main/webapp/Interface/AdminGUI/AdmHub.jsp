<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>${admin.nome} ${admin.cognome}-Admin-HatTube</title>
    <%@include file="../AdminGUI/AdmHomePage.jsp"%>
</head>

<body>
<h1>Admin - HatTube</h1>
<h2> Scegli cosa vuoi fare</h2> <br>


<form action="AdmAddServlet">
    <button>AGGIUNGI CAPPELLO</button>
</form>

<form action="AdmCatalogoServlet">
    <button>MODIFICA CAPPELLO</button>
</form>

<form action="PaginaEliminaServlet" method="post">
    <button>ELIMINA CAPPELLO </button>
</form>


</body>
</html>
