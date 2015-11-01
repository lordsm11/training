<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <script src="<c:url value="/resources/js/jquery-1.9.1.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.uniform.min.js"/>"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>"/>
    <script src="<c:url value="/resources/bootstrap/js/bootstrap.js"/>"></script>
</head>

<body>

<section id="forms">
    <div class="row">
        <div class="col-lg-8">

            <h3>Simulation simplifiée de votre impot sur le revenu</h3>
            <form:form method="POST" commandName="impotForm" class="form-horizontal well">

                <fieldset>

                    <div class="control-group">
                        <label class="control-label" for="nbChildren">Situation</label>
                        <div class="controls">
                            <form:select path="onePart" id="onePart" class="form-control">
                                <option value="0">Célibataire</option>
                                <option value="1">Marié</option>
                            </form:select>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="nbChildren">Nombre de vos enfants</label>
                        <div class="controls">
                            <form:select path="nbChildren" id="nbChildren" class="form-control">
                                <option>0</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </form:select>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="amount1" style="padding-bottom: 12px;">Vos revenues</label>
                        <div class="controls">
                            <form:input path="amount1" type="text" class="form-control input-xlarge" id="amount1"/>
                            <form:errors path="amount1" cssClass="help-block error" />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="amount2" style="padding-bottom: 12px;">Revenues du conjoint</label>
                        <div class="controls">
                            <form:input path="amount2" type="text" class="form-control input-xlarge" id="amount2"/>
                            <form:errors path="amount2" cssClass="help-block error" />
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label" for="deductions" style="padding-bottom: 12px;">Déductions</label>
                        <div class="controls">
                            <form:input path="deductions" type="text" class="form-control input-xlarge" id="deductions"/>
                            <form:errors path="deductions" cssClass="help-block error" />
                        </div>
                    </div>

                    <hr>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Simulez votre impot</button>
                    </div>

                </fieldset>
            </form:form>

            </div>
        </div>
    </section>

</body>
</html>