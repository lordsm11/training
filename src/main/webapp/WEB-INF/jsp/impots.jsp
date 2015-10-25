<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="../css/styles.css"/>"/>
</head>

<body>
<h2>Simulation simplifiée de votre impot sur le revenu</h2>

<form:form method="POST" commandName="impotForm">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <th>Montant de vos revenues :</th>
            <td><form:input path="amount1" /></td>
            <td><form:errors path="amount1" cssClass="error" /></td>
        </tr>
        <tr>
            <th>Montant des revenues de votre conjoint :</th>
            <td><form:input path="amount2" /></td>
            <td><form:errors path="amount2" cssClass="error" /></td>
        </tr>
        <tr>
            <th>Montant des déductions :</th>
            <td><form:input path="deductions" /></td>
            <td><form:errors path="deductions" cssClass="error" /></td>
        </tr>
        <tr>
            <th>Etes-vous célibataire :</th>
            <td><form:checkbox path="onePart"/></td>
            <td><form:errors path="onePart" cssClass="error" />
            </td>
        </tr>
        <tr>
            <th>Nombre de vos enfants :</th>
            <td><form:input path="nbChildren" /></td>
            <td><form:errors path="nbChildren" cssClass="error" /></td>
        </tr>
        <tr>
            <td colspan="3"><input type="submit" value="simulez" /></td>
        </tr>
    </table>
</form:form>

<table>
    <tr>
        <th style="text-align: left">Le Montant de vos revenues avec deductions + charges forfaitaires 10%:</th>
        <td><c:out value="${simulationImpot.amount}" /></td>
    </tr>
    <tr>
        <th style="text-align: left">Le nombre de parts :</th>
        <td><c:out value="${simulationImpot.nbParts}" /></td>
    </tr>
    <tr>
        <th style="text-align: left">Le montant de votre impot sur le revenu :</th>
        <td><c:out value="${simulationImpot.impot}" /></td>
    </tr>
    <tr>
        <th style="text-align: left">Le taux moyen est de :</th>
        <td><c:out value="${simulationImpot.taux}" /></td>
    </tr>
</table>

</body>
</html>