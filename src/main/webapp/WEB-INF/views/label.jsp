<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Этикеточные данные</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить этикетку</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/label/add"></c:url>
                    <form:form action="${addAction}" commandName="label">
                        <table>
                            <c:if test="${!empty label.place_catching}">
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
                                    <form:label path="place_catching">
                                        <spring:message text="Место поимки"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="place_catching" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="date_catching">
                                        <spring:message text="Дата поимки"/>
                                    </form:label>
                                </td>
                                <td>
                                    <div class="input-group date" id="date_catching">
                                        <form:input path="date_catching" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                        </span>
                                    </div>
                                    <script type="text/javascript">
                                        $(function () {
                                            $('#date_catching').datetimepicker({language: 'ru'});
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tool_catching">
                                        <spring:message text="Средство поимки"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tool_catching" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="condition_id">
                                        <spring:message text="Условие поступления"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="condition_id">
                                        <c:forEach items="${listConditions}" var="icondition">
                                            <form:option value="${icondition.id}">${icondition.condition_name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty label.place_catching}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty label.place_catching}">
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
            <h4>Список этикеток</h4>
            <c:if test="${!empty listLabels}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Место поимки</th>
                        <th width="120">Дата поимки</th>
                        <th width="120">Инструмент поимки</th>
                        <th width="120">Условие поступления</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listLabels}" var="label">
                        <tr>
                            <td>${label.id}</td>
                            <td>${label.place_catching}</td>
                            <td>${label.date_catching}</td>
                            <td>${label.tool_catching}</td>
                            <td>${label.condition.condition_name}</td>
                            <td><a href="<c:url value='/label/edit/${label.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/label/remove/${label.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
