<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
    <title>Registrazione ad HatTube</title>
    <link href="./CSS/Registrazione.css" rel="stylesheet" type="text/css"/>
    <script src="JavaScripts/Validazione.js" type="text/javascript"></script>
</head>

<style>
    .errore{
        color: red;
        font-size: 18px;
    }
</style>
<body>
<div>
    <h1 style="color: white"> Registrati ad HatTube®</h1>
    <form action="NuovoUtenteServlet" method="post" onsubmit="return validazioneFormRegistrazione()">

        <label for="nome" style="color: white">     Nome: </label>
        <input class="text" id="nome" name="nome" type="text" value="${cliente.nome}" > <br> <br>

        <label for="cognome" style="color: white">Cognome: </label>
        <input class="text"  id="cognome" name="cognome"type="text" value="${cliente.cognome}" required> <br> <br>

        <label id="7" style="color: white">Indirizzo di fatturazione: </label> <br> <br>

        <label for="citta" style="color: white">Città: </label>
        <input class="text" id="citta" name ="citta" type="text" value="${cliente.citta}" required> <br> <br>

        <label id="9" style="color: white">Via: </label>
        <input class="text" type="text" id="via" name="via" value="${cliente.via}" required> <br> <br>

        <label id="10" style="color: white">CAP: </label>
        <input class="textarea" type="text" id="cap" name="cap" value="${cliente.CAP}" required> <span class="errore"></span>
        <br> <br>

        <label id="11" style="color: white">Metodo di pagamento: </label>
        <br> <br>

        <label id="12" style="color: white">Numero di Carta: </label>
        <input class="textarea" id="numcarta" name="numcarta" type="text" placeholder="xxxx-xxxx-xxxx-xxxx" value="${metodopagamento.numcarta}" required> <br> <br>

        <label id ="data" style="color: white"> Data di Scadenza:</label>
        <label for="AnnoS">Data di Scadenza:</label>
        <label for="AnnoS"></label>
        <select id="MeseS" name="MeseS" required> </select>
        <select id="AnnoS" name="AnnoS" required> </select>


        <br>
        <label id="13" style="color: white"> Nome Intestatario: </label>
        <input class="textarea" type="text" id="nomei" name ="nomei" value ="${metodoPagamento.intestatario}" required><br> <br>

        <label for="cvv" style="color: white">CVV: </label>
        <input class="text" type="text" id="cvv" name="cvv" value="${metodoPagamento.cvv}" required ><br> <br>
        <label for="username" style="color: white">Username: </label>
        <input class="text" type="text" id="username" name="username" value="${cliente.username}" required> <br> <br>

        <label id="5" style="color: white">Email: </label>
        <input class="textarea" type="text" id="email" name="email" value="${cliente.email}" required><br> <br>
        <label id="6" style="color: white">Password: </label>
        <input class="textarea" type="password" id ="password" name="password" value="${cliente.password}" required> <span class="errore">${errorePassword}</span><br> <br> <br>
        <button>Registrati </button>
    </form>
</div>

<script>
    function start() {
        DateGenerator();
    }
    window.onload = start;
</script>

<script src="JavaScripts/Calendario.js" type="text/javascript"></script>

</body>
</html>