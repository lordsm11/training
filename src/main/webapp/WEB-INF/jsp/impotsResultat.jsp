<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link href='http://fonts.googleapis.com/css?family=Engagement' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>"/>
    <script src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.uniform.min.js"/>"></script>
</head>

<body>
    <h1>Résultat de votre simulation</h1>
    <form><ul>
        <li>
            <label class="complet">Montant avec déductions : <B>${simulationImpot.amount}</B></label>
        </li>
        <li>
            <label class="complet">Situation : <B>${simulationImpot.situation}</B></label>
        </li>
        <li>
            <label class="complet">Nombre de parts : <B>${simulationImpot.nbParts}</B></label>
        </li>
        <li>
            <label class="complet">Montant A payer : <B>${simulationImpot.impot}</B></label>
        </li>
        <li>
            <label class="complet">Taux moyen : <B>${simulationImpot.taux}</B></label>
        </li>
    </ul></form>

    <footer>
        <p>MAD engineering Copyright 2015 <a href="http://www.webdezign.co.uk">CSS from</a></p>
    </footer>

</body>
</html>