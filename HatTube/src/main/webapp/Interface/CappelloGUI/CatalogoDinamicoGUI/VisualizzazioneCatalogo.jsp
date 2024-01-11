
<!DOCTYPE html>
<html>
<head>
    <title>Hat-Tube Catalogo Completo</title>
    <script src="https://kit.fontawesome.com/bda5e6e885.js" crossorigin="anonymous"></script>
   <%@include file="/Menu/menu.jsp"%>
    <link href="./CSS/BackgroundCatalogo.css" rel="stylesheet" type="text/css"/>
    <link href="./CSS/hatCards.css" rel="stylesheet" type="text/css"/>

</head>

<style>
    #soldOut{
        color: black;
        text-align: center;
        margin-top: -10px;
    }

    .card:hover{
        border: 2px solid red;
        color: red;
        transition: border 0.5s,color 0.5s;
    }
</style>
<body>


<ul>
    <br>
    <br>
    <c:forEach items="${cappelli}" var="cappello">


    <c:choose>
        <c:when test="${cappello.quantita <=0}">    <%--Controlla se l'item esaminato è disponibile ,se non lo fosse rende il prodotto non selezionabile--%>
        </c:when>
            <c:otherwise>
            <form action="hatPageServlet" method="post">

            </c:otherwise>
       </c:choose>
            <li id="cappelli">
                <button id="prodotto">
                    <input type="hidden" name="cappelloID" value="${cappello.codice}">    <%--Contiene un id ad ogni cappello che verrà mandato alla servlet per aprire il singolo cappello--%>
                    <div class="card">
                        <h1>${cappello.marca}</h1>
                        <img src="${cappello.immagine} " style="width:150px" height="150px" id="Cappello">
                        <h1>${cappello.modello}</h1>
                        <p class="price">€ ${cappello.prezzo}</p>
                        <c:if test="${cappello.quantita <=0}">
                            <div id="soldOut">
                                SOLD OUT
                            </div>
                        </c:if>
                </button>
            </li>

        </form>
    </c:forEach>

</ul>



</body>
</html>
