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

    <li class ="left"  ><a href="StoricoOrdiniServlet"><button class="buttoneMenu" style='font-size:24px'>STORICO ORDINI<i class='fas fa-user-alt'></i></button></a></li>

    <li class ="left" id="Logged" ><a href="PaginaAdminServlet"><button class="buttoneMenu" style='font-size:24px'>${admin.nome} <i class='fas fa-user-alt'></i></button></a></li>



    <li class ="left" id="centro">
        <div id="immagineDiv">
            <a id="logo" href="AdmHubServlet"><img id="imgLogo" src="images/ritaglio.png" width="300px" height="50px" style="position: center">
            </a>
        </div>
    </li>
</ul>


<script>
    function controlloLoginUtente(){
        if("${admin.nome}".length >= 3) {
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
