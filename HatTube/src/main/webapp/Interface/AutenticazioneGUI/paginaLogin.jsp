<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrati/Accedi HatTube </title>
    <link rel="stylesheet"type="text/css"href="./CSS/Login.css">
</head>
<body>

<style>
    div{
        float: left;
        margin-top: 20px;
    <%--align-items: center ; --%>
        margin-left: 47%;
        position: relative;
    }

    .bottoni{
        color: white;
        background: none;
        width: 90px;
        height: 30px;
        border: white;
        border-width: 5px;
        font-size: medium;
        border: 1px solid;
        transition:color 0.5s, background 0.5s;

    }

    .bottoni:hover{
        background: cadetblue;
        color: white;
        transition:color 0.5s, background 0.5s;
    }

    .textarea{
        background: none;
        color: white;
        border: 1px solid;
        transition:color 0.5s, background 0.5s;

    }
    .textarea:focus{
        background: whitesmoke;
        color: black;
        transition:color 0.5s, background 0.5s;

    }

    #erroreLogin{
        color: red;
    }

</style>

<form action="ValidazioneLoginServlet" method="post">
    <div>
        <h1 id="1" style="color: white" > Login-HatTube® </h1>
        <h3 id="erroreLogin">${errlogin}</h3>
        <label id="2" style="color: white" > EMAIL: </label>
        <input class="textarea" type="text"  placeholder="Inserisci email" name="email" value="${cliente.email}"> <br> <br>
        <label id="3" style="color:white"> PASSWORD: </label>
        <input class="textarea" type="password" placeholder="Inserisci password" name="password" value="${cliente.password}"> <br> <br>
        <button class="bottoni" >Accedi </button> <br> <br>
        <a href="RegistrazioneServlet" STYLE="color: cadetblue">     Non hai un account? Registrati!</a>
    </div>
</form>



</body>
</html>
