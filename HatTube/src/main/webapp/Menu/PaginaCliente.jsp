<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Ciao,${cliente.nome}</title>
    <%@include file="../Menu/menu.jsp"%>
    <link href="./CSS/BackgroundCatalogo.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<br>
<h1>Ciao,${cliente.nome}</h1>

<h2>Info Profilo: </h2> <br>
<div class="Generiche">
    nome: ${cliente.nome}
</div>
<div class="Generiche">
   cognome: ${cliente.cognome}
</div>
<div class="Generiche">
    ${cliente.email}
</div>


<h3>Vuoi effettuare il log-out?</h3>
<form action="LogoutServlet">
<button>LOG OUT</button>
</form>
</body>
</html>
