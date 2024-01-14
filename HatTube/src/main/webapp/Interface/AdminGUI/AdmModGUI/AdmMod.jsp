
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Modifica Articolo - HatTube</title>
</head>

<style>
</style>
<body>

<form action="AdmEffettuaModificheServlet" method="post">
<label id="2">Modifica descrizione prodotto</label><br><br>
<input class="text" id="desc"  rows="5" cols="50" type="text" value="${cappello.descrizione}" name="descrizione"><br> <br>

<label id="3">Modifica prezzo prodotto</label>
<input class="text" type="text" value="${cappello.prezzo}" name="prezzo"> <br> <br>

<label id="5">Modifica tipo prodotto</label>
<select id="tipiCap"  name="tipo">
    <option>Lana</option>
    <option>Baseball</option>
    <option>Pesca</option>
</select>   <br> <br>

<label id="4">Modifica marca prodotto</label>
<input class="text" type="text" value="${cappello.marca}" name="marca"> <br> <br>

<label id="6">Modifica modello prodotto</label>
<input class="text" type="text" value="${cappello.modello}" name="modello"> <br> <br>

<label id="7">Modifica quantità prodotto</label>
<input class="text" type="text" value="${cappello.quantita}" name="quantita"> <br> <br>

<input type="hidden" name="codice" value="${cappello.codice}" name="codice">
    <button> Effettua Modifiche</button>

</form>

<%-- modifica prodotto --%>


</body>
</html>