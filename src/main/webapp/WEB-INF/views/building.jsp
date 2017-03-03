<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Строения</title>
</head>
<body>
<h1>
    Добавить строение
</h1>

<c:url var="addAction" value="/building/add" ></c:url>

<form:form action="${addAction}" commandName="building">
    <table>
        <c:if test="${!empty building.building_name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="building_name">
                    <spring:message text="Строение"/>
                </form:label>
            </td>
            <td>
                <form:input path="building_name" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty building.building_name}">
                    <input type="submit"
                           value="<spring:message text="Сохранить"/>" />
                </c:if>
                <c:if test="${empty building.building_name}">
                    <input type="submit"
                           value="<spring:message text="Добавить"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<br>

<h3>Список строений</h3>
<c:if test="${!empty listBuildings}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Строение</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBuildings}" var="building">
            <tr>
                <td>${building.id}</td>
                <td>${building.building_name}</td>
                <td><a href="<c:url value='/building/edit/${building.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/building/remove/${building.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
