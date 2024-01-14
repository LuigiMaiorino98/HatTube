<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
  <title>Hat-Tube SELEZIONE CAPPELLO DA ELIMINARE</title>
  <link href="./CSS/hatCards.css" rel="stylesheet" type="text/css"/>
  <script src="https://kit.fontawesome.com/bda5e6e885.js" crossorigin="anonymous"></script>
  <%@include file="../AdmHomePage.jsp"%>
  <link href="./CSS/AdminHome.css" rel="stylesheet" type="text/css"/>
</head>

<style>

  .card:hover{
    border: 2px solid red;
    color: red;
    transition: border 0.5s,color 0.5s;
  }
</style>
<body>

<!--Catalogo che verrà visualizzato quando decidiamo di Eliminare un prodotto lato admin -->

<ul>
  <br>
  <br>
  <c:forEach items="${cappelli}" var="cappello">
    <form action="confermaEliminaServlet" method="post">
      <li id="cappelli">
        <button id="prodotto" >
          <input type="hidden" name="cappelloID" value="${cappello.codice}">
          <div class="card">
            <h1>${cappello.marca}</h1>
            <img src="${cappello.immagine} " style="width:150px" height="150px" id="Cappello">
            <h1>${cappello.modello}</h1>
            <p class="price">€ ${cappello.prezzo}</p>
          </div>
        </button>
        <div>
          <button id="infop">
            ELIMINA
          </button>
        </div>
      </li>

    </form>
  </c:forEach>

</ul>



</body>
</html>