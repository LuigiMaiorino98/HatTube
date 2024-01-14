<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Aggiungi Articolo - HatTube</title>
</head>

<style>
    .errore{
        color: red;
        font-size: 18px;
    }
</style>

<body>
<h1>Inserisci nuovo articolo</h1>

<form action="AdmInserisciCappelloServlet" method="post">

    <label id="2">Inserisci descrizione prodotto</label>
    <input class="text" type="text" value="${cappello1.descrizione}" name="descrizione"> <br> <br>

    <label id="3">Inserisci prezzo prodotto</label>
    <input class="text" type="text" value="${cappello1.prezzo}" name="prezzo"><span class="errore">${errorePrezzo}</span> <br> <br>

    <label id="5">Inserisci tipo prodotto</label>
    <select id="tipiCap" name="tipo">
        <option>Lana</option>
        <option>Baseball</option>
        <option>Pesca</option>
    </select>   <br> <br>

    <label id="4">Inserisci marca prodotto</label>
    <input class="text" type="text" value="${cappello1.marca}" name="marca"> <br> <br>

    <label id="6">Inserisci modello prodotto</label>
    <input class="text" type="text" value="${cappello1.modello}" name="modello"> <br> <br>

    <label id="7">Inserisci quantità prodotto</label>
    <input class="text" type="text" value="${cappello1.quantita}" name="quantita"><span class="errore">${erroreQuantita}</span> <br> <br>

    <label id="8">Inserisci percorso immagine prodotto</label>
    <input class="text" type="text" value="${cappello1.immagine}" name="immagine"> <br> <br>

    <button> Inserisci </button>
</form>

</body>
</html>
