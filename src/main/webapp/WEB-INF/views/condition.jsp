<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Условия поступления</title>
</head>
<body>
<h1>
    Добавить условие поступления
</h1>

<c:url var="addAction" value="/condition/add" ></c:url>

<form:form action="${addAction}" commandName="condition">
    <table>
        <c:if test="${!empty condition.condition_name}">
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
                <form:label path="condition_name">
                    <spring:message text="Условие поимки"/>
                </form:label>
            </td>
            <td>
                <form:input path="condition_name" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty condition.condition_name}">
                    <input type="submit"
                           value="<spring:message text="Сохранить"/>" />
                </c:if>
                <c:if test="${empty condition.condition_name}">
                    <input type="submit"
                           value="<spring:message text="Добавить"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

<br>

<h3>Список условий</h3>
<c:if test="${!empty listConditions}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Условие поимки</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listConditions}" var="condition">
            <tr>
                <td>${condition.id}</td>
                <td>${condition.condition_name}</td>
                <td><a href="<c:url value='/condition/edit/${condition.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/condition/remove/${condition.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
