<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
  <title>${cappello.marca} ${cappello.modello}</title>
  <link href="./CSS/BackgroundCatalogo.css" rel="stylesheet" type="text/css"/>
  <link href="./CSS/hatPageStyle.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="divImg">
  <img id="imgItem" src="${cappello.immagine}" height="500" width="500">
</div>
<form action="AggiungiCarrelloServlet" method="post">
  <h1>${cappello.marca} ${cappello.modello} </h1>
  <p id="prezzo" >€ ${cappello.prezzo}</p> <br>
  <input type="hidden" value="${cappello.codice}" name="cappelloID">
  <input type="number" value="1" min="1" max="${cappello.quantita}" name="quantita"> <button id="bottoneAddCarrello">Aggiungi al Carrello</button>
</form>
  <p>${cappello.descrizione}</p>

</div>
</body>
</html>
