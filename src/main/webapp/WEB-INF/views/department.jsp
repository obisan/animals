<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Добавить департамент</title>

    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

</head>
<body>
<h1>
    Добавить департамент
</h1>

<c:url var="addAction" value="/department/add" ></c:url>

<br>


<form:form action="${addAction}" commandName="department">
    <table>
        <c:if test="${!empty department.department_name}">
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
                <form:label path="department_name">
                    <spring:message text="Название департамента"/>
                </form:label>
            </td>
            <td>
                <form:input path="department_name" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty department.department_name}">
                    <input type="submit"
                           value="<spring:message text="Сохранить"/>" />
                </c:if>
                <c:if test="${empty department.department_name}">
                    <input type="submit"
                           value="<spring:message text="Добавить"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>



<h3>Department List</h3>
<c:if test="${!empty listDepartments}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Название департамента</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listDepartments}" var="department">
            <tr>
                <td>${department.id}</td>
                <td>${department.department_name}</td>
                <td><a href="<c:url value='/department/edit/${department.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/department/remove/${department.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
