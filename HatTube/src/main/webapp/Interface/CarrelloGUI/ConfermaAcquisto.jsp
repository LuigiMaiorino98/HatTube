<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Acquisto</title>
</head>
<body>

<div id="acquisto">Grazie dell'acquisto <span>${cliente.nome} ${cliente.cognome}</span></div>

<form action="HomepageServlet">
    <button>
        Torna alla HomePage
    </button>
</form>
</script>
</body>
</html>
