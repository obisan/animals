<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Группы кормов</title>
</head>
<body>
<jsp:include page="menu.jsp" />

<div class="container">
    <h4>Создать группу кормов</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/groupallowance/add"></c:url>
                <form:form action="${addAction}" commandName="groupallowance">
                    <table>
                        <c:if test="${!empty groupallowance.group_name}">
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
                                <form:label path="group_name">
                                    <spring:message text="Группа кормов"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="group_name" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty groupallowance.group_name}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty groupallowance.group_name}">
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
            <c:if test="${!empty listGroupAllowances}">
                <table class="table">
                    <tr>
                        <th width="120">Животное</th>
                        <th width="120">Корм</th>
                        <th width="120">Вес (г.)</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listGroupAllowances}" var="journalallowance">
                        <tr>
                            <td><a href="<c:url value="/object/info/${journalallowance.object_id}"/>" target="_blank">${journalallowance.object.object_name}</a> (${journalallowance.object.object_count}) <a href="<c:url value="/tank/info/${journalallowance.object.tank.id}"/>" target="_blank">(${journalallowance.object.tank.tank_number})</a></td>
                            <td>${journalallowance.allowance.allowance_name}</td>
                            <td>${journalallowance.weight}</td>
                            <td><a href="<c:url value='/journalallowance/edit/${journalallowance.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/journalallowance/remove/${journalallowance.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </td>
    </tr>
</table>

<script type="text/javascript">
    $(document).ready(function(){
        $('.combobox').combobox();
    });
</script>

</body>
</html>
