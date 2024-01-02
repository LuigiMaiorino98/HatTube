
<html>
<head>
  <title>About Us</title>
  <script src=https://kit.fontawesome.com/bda5e6e885.js" crossorigin="anonymous"></script>
  <link href="./CSS/Homepage.css" rel="stylesheet" type="text/css"/>
  <%@include file="../Menu/menu.jsp"%>

</head>


<style>

  #FotoBkg{
    height: 470px;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
    position: relative;
    display: block;
    margin-left: auto;
    margin-right: auto;
    border-radius: 10%;
  }
  #Testo{
    font-family: "Lucida Console", "Courier New", monospace;
    text-align: center;
    font-size: 40px;
    color: goldenrod;
  }
  #Testo1{
    font-size: 20px;
    text-align: center;
    font-family: "Lucida Console", "Courier New", monospace;
  }
  #bloccotesto{
    margin-left: 15%;
  <%-- margin-right: 10% --%>;
    width: 70%;
  }
</style>
<body>

<%--
<ul id="sopra">

  <li class ="left"><a href="LoginServlet"><button  id="Login"style='font-size:24px'>Login <i class='fas fa-user-alt'></i></button></a></li>
  <li class="left"><a href="carrelloServlet"><button style='font-size:24px'>Carrello<i class='fas fa-shopping-cart'></i></button></a></li>
  <li class ="left" id="centro"><a id="logo" href="HomepageServlet"><img src="images/ritaglio.png" width="300px" height="50px" style="position: center"></a></li>
</ul>
--%>

<img src="images/aboutUsfoto.png" id="FotoBkg">
<br>
<h1 id ="Testo">⇀ About us : HatTube® ↼</h1>
<br>
<div id ="bloccotesto">
  <label id="Testo1">HatTube è una startup e-commerce creata nel 2023 specializzata nella vendita di cappelli di ogni tipo , di ogni marca, di ogni colore e per ogni gusto.
    Quando si tratta di qualità dei prodotti siamo rigorosissimi: ecco perché vendiamo solo cappellini originali e autorizzati. Per noi è normale che sia così. Abbiamo un’ampia scelta di molte tra le marche più importanti al mondo ma trattiamo anche aziende più piccole, così da creare una gamma di prodotti esclusiva. Insieme ai nostri fornitori, riusciamo a offrire cappellini e cappelli esclusivi che possono essere acquistati solo qui su HatTube. In altre parole, cappellini per i quali siamo rivenditori esclusivi. Con migliaia di cappellini in stock, siamo in grado di offrire la spedizione il giorno stesso a prescindere dal modello acquistato!</label>
</div>
</body>
</html>