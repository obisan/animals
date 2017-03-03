<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Кормы</title>
</head>
<body>
<jsp:include page="menu.jsp" />

<div class="container">
    <h4>Добавить корм</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/allowance/add"></c:url>

                <form:form action="${addAction}" commandName="allowance">
                    <table>
                        <c:if test="${!empty allowance.allowance_name}">
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
                                <form:label path="allowance_name">
                                    <spring:message text="Наименование корма"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="allowance_name" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty allowance.allowance_name}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty allowance.allowance_name}">
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
            <h4>Список кормов</h4>

            <c:if test="${!empty listAllowances}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Наименование корма</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listAllowances}" var="allowance">
                        <tr>
                            <td>${allowance.id}</td>
                            <td>${allowance.allowance_name}</td>
                            <td><a href="<c:url value='/allowance/edit/${allowance.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/allowance/remove/${allowance.id}' />" >Delete</a></td>
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
