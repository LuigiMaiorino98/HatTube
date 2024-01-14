<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Ciao,${admin.nome}</title>
    <%@include file="../AdminGUI/AdmHomePage.jsp"%>
    <link href="./CSS/BackgroundCatalogo.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<br>
<h1>Ciao,${admin.nome}</h1>

<h2>Info Profilo: </h2> <br>
<div class="Generiche">
    nome: ${admin.nome}
</div>
<div class="Generiche">
   cognome: ${admin.cognome}
</div>
<div class="Generiche">
    ${admin.email}
</div>


<h3>Vuoi effettuare il log-out?</h3>
<form action="LogoutServlet">
<button>LOG OUT</button>
</form>
</body>
</html>
