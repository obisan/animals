<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Метки</title>
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
    <h4>Добавить метку</h4>

    <c:url var="addAction" value="/tag/add" ></c:url>

    <form:form action="${addAction}" commandName="tag">
        <table>
            <c:if test="${!empty tag.tag_name}">
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
                    <form:label path="tag_name">
                        <spring:message text="Метка"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="tag_name" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <c:if test="${!empty tag.tag_name}">
                        <input type="submit"
                               value="<spring:message text="Сохранить"/>" />
                    </c:if>
                    <c:if test="${empty tag.tag_name}">
                        <input type="submit"
                               value="<spring:message text="Добавить"/>" />
                    </c:if>
                </td>
            </tr>
        </table>
    </form:form>
</div>

    <table width="70%" align="center">
    <tr>
        <td class="tg">
            <h3>Список меток</h3>
            <c:if test="${!empty listTags}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Метка</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listTags}" var="tag">
                        <tr>
                            <td>${tag.id}</td>
                            <td>${tag.tag_name}</td>
                            <td><a href="<c:url value='/tag/edit/${tag.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/tag/remove/${tag.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
