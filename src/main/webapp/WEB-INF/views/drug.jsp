<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="now" class="java.util.Date" />

<html>
<head>
    <title>Список лекарств</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<jsp:include page="menu.jsp" />

<div class="container">
    <h4>Добавить лекарство</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/drug/add"></c:url>

                <form:form action="${addAction}" commandName="drug">
                    <table>
                        <c:if test="${!empty drug.drug_name}">
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
                                <form:label path="drug_name">
                                    <spring:message text="Лекарство"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="drug_name" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty drug.drug_name}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty drug.drug_name}">
                                    <input type="submit"
                                           value="<spring:message text="Добавить"/>" />
                                </c:if>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </td>
        </tr>
    </table>
</div>

<table width="70%" align="center">
    <tr>
        <td class="tg">
            <h4>Список лекарств</h4>
            <c:if test="${!empty listDrugs}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Лекарство</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listDrugs}" var="drug">
                        <tr>
                            <td>${drug.id}</td>
                            <td>${drug.drug_name}</td>
                            <td><a href="<c:url value='/drug/edit/${drug.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/drug/remove/${drug.drug_name}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
