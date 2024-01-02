<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
  <title>Hat-Tube HomePage</title>
  <link href="./CSS/Homepage.css" rel="stylesheet" type="text/css"/>
  <script src="https://kit.fontawesome.com/bda5e6e885.js" crossorigin="anonymous"></script>
</head>

<style>

  @media screen and (max-width:620px){
    .buttoneMenu{
      width: 100%;
      float: none;
    }

    .divSotto{
      width: 100%;
      font-size: 30px;
      margin-top: 30px;
    }
    #imgLogo{
      width: 200px

    }

    #immagineDiv{
      width: 70%;

    }
  }
</style>
<body>


<ul id="sopra">
  <li class="left">
    <a href="AboutUsServlet"><button class="buttoneMenu" style="font-size:24px">About us..<i class="fa-solid fa-people-group"></i>
    </button> </a>
  </li>



  <li class ="left" id="Login"><a href="LoginServlet">
    <button class="buttoneMenu" style='font-size:24px'>Login <i class='fas fa-user-alt'></i>
    </button></a>
  </li>



  <li class ="left" id="Logged" >
    <a href="PaginaClienteServlet">
      <button class="buttoneMenu" style='font-size:24px'>${cliente.nome}
        <i class='fas fa-user-alt'></i>
      </button></a>
  </li>



  <li class="left"><a href="CarrelloServlet">
    <button class="buttoneMenu" style='font-size:24px'>Carrello<i class='fas fa-shopping-cart'></i>
    </button></a>
  </li>


  <li class ="left" id="centro">
    <div id="immagineDiv">
    <a id="logo" href="HomepageServlet"><img id="imgLogo" src="images/ritaglio.png" width="300px" height="50px" style="position: center">
    </a>
    </div>
  </li>

</ul>



<ul id ="sotto">
  <li class="sottoSx" id ="tutti">
    <div class="divSotto">
    <a  href="CatalogoCompletoServlet">Tutti gli articoli</a>
    </div>
  </li>
  <li class="sottoSx"><div class="divSotto"><a href="CatalogoLanaServlet">Cappellini di lana</a></div></li>
  <li class="sottoSx"><div class="divSotto"><a href="CatalogoPescaServlet">Cappellini da pesca</a></div></li>
  <li class="sottoSx"><div class="divSotto" ><a href="CatalogoBaseballServlet">Cappellini da baseball</a></div></li>
</ul>

<script>
  function controlloLoginUtente(){
    if("${cliente.nome}".length >= 3) {
      const login = document.getElementById("Login");
      login.remove();
      const logged = document.getElementById("Logged");
      const sopra = document.getElementById("sopra");
      sopra.append(logged);
    }
      else{
      const login = document.getElementById("Login");
      const logged = document.getElementById("Logged");
      const sopra = document.getElementById("sopra");
      logged.remove();
      sopra.append(login)
    }
  }
  window.onload= controlloLoginUtente;
</script>

</body>

</html>
