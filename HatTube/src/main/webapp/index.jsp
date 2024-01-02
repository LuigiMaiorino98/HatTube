<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hat-Tube HomePage</title>
    <script src="https://kit.fontawesome.com/bda5e6e885.js" crossorigin="anonymous"></script>
    <%@include file="Menu/menu.jsp"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>
<style>

    #FotoCatalogo{
        width: 500px;
        height: 500px;
        margin-right: 100px;
        margin-left: 300px;
    }


</style>
<body>

<div id="immagineHome">
    <a href="CatalogoCompletoServlet">
        <img href="CatalogoCompletoServlet" src="images/FotoCatalogo.png" id="FotoCatalogo" >
    </a>
</div>

</body>
</html>