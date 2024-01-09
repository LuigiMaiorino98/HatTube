<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page import="LogicTier.Oggetti.Utente" %>
<%@ page import="LogicTier.Oggetti.Cliente" %>
<!DOCTYPE html>
<html>
<head>
  <title>${cliente.nome} Carrello-HatTube</title>
  <%@include file="../../../Menu/menu.jsp"%>
  <link href="./CSS/Carrello.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<br>
<h1>Il tuo Ordine:</h1>
<table>
  <tr>
    <th>Marca</th>
    <th>Modello</th>
    <th>Tipo</th>
    <th>Quantità</th>
    <th>Prezzo</th>
  </tr>

  <%int pos=0;%>
  <c:forEach items="${prodotti}" var="capello">

    <form action="RimuoviCappello" method="post">
      <tr>
        <td >${capello.marca}</td>
        <td>${capello.modello}</td>
        <td>${capello.tipo}</td>
        <td>${capello.quantita}</td>
        <td>€${capello.prezzo}0</td>

        <td>

          <input type="hidden" name="id" value="<%=pos%>">
          <button class="RemoveBtn">RIMUOVI</button>
    </form>
    </td>
    </tr>
    <%pos+=1;%>


  </c:forEach>

</table>
<div>Numero Elementi: ${carrello.numeroElementi}</div>
<span>Totale: ${carrello.totaleTemporaneo}</span>

<form action="SvuotaCarrelloServlet" method="post">
  <button>SVUOTA CARRELLO</button>
</form>



<%--Controlla che l'user sia collegato altrimenti stampa il messaggio "Login necessario"--%>

<% HttpSession s=request.getSession();
  Cliente cliente= (Cliente) session.getAttribute("cliente");
  if(cliente==null){%>
<td>
  <span>Login Necessario</span>
</td>
<%}
else {%>


<form action="ConfermaAcquistoServlet" method="post">
  <button>ORDINA</button>
</form>


<% }%>


</body>
</html>
