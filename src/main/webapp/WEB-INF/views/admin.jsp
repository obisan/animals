<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Admin Page ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>
    </c:if>

    <menu>
        <li><a href="${contextPath}/kingdoms"       target="_blank">Список царств</a></li>
        <li><a href="${contextPath}/phylums"        target="_blank">Список типов</a></li>
        <li><a href="${contextPath}/classes"        target="_blank">Список классов</a></li>
        <li><a href="${contextPath}/orders"         target="_blank">Список отрядов</a></li>
        <li><a href="${contextPath}/families"       target="_blank">Список семейств</a></li>
        <li><a href="${contextPath}/genera"         target="_blank">Список родов</a></li>
        <li><a href="${contextPath}/species"        target="_blank">Список видов</a></li>
        <br/>
        <li><a href="${contextPath}/tags"           target="_blank">Список меток</a></li>
        <li><a href="${contextPath}/animals"       target="_blank">Справочник шаблонов</a></li>
        <hr>
        <li><a href="${contextPath}/displacements"  target="_blank">Журнал перемещений</a></li>
        <li><a href="${contextPath}/quarantines"    target="_blank">Журнал карантинов</a></li>
        <li><a href="${contextPath}/deceaseds"      target="_blank">Журнал смертей</a></li>
        <hr>
        <li><a href="${contextPath}/employees"      target="_blank">Список сотрудников</a></li>
        <li><a href="${contextPath}/departments"    target="_blank">Список департаментов</a></li>
        <hr>
        <li><a href="${contextPath}/objects"        target="_blank">Список объектов</a></li>
        <li><a href="${contextPath}/certificates"   target="_blank">Список сертификатов</a></li>
        <li><a href="${contextPath}/labels"         target="_blank">Список этикеточных данных</a></li>
        <li><a href="${contextPath}/conditions"     target="_blank">Список условий поимки</a></li>
        <hr>
        <li><a href="${contextPath}/tanks"          target="_blank">Список танков</a></li>
        <li><a href="${contextPath}/allowances"     target="_blank">Список рационов</a></li>
        <li><a href="${contextPath}/buildings"      target="_blank">Список строений</a></li>
    </menu>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>