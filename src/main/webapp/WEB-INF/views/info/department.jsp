<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Отдел</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

<jsp:include page="../menu.jsp" />

<div class="container">
    <h4>Информация по отделу</h4>
    <table class="table">
        <tr>
            <td>
                <form:form action="${addAction}" commandName="department">
                    <table>
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${department.id}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="department_name">
                                    <spring:message text="Отдел"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${department.department_name}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="">
                                    <spring:message text="Количество сотрудников"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${department.employees.size()}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="">
                                    <spring:message text="Количество видов"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${department.objects.size()}" />
                            </td>
                        </tr>
                    </table>
                </form:form>
            </td>
        </tr>
    </table>

    <div class="panel-group" id="accordion">
        <!-- 1 панель -->
        <div class="panel panel-default">
            <!-- Заголовок 1 панели -->
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Список сотрудников</a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <!-- Содержимое 1 панели -->
                <div class="panel-body">
                    <c:if test="${!empty department.employees}">
                        <table class="tg">
                            <tr>
                                <th>ФИО</th>
                                <th>Должность</th>
                            </tr>
                            <c:forEach items="${department.employees}" var="employee">
                                <tr>
                                    <td>${employee.fullShortName}</td>
                                    <td>${employee.employee_title}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
        <!-- 2 панель -->
        <div class="panel panel-default">
            <!-- Заголовок 2 панели -->
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Список животных</a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <!-- Содержимое 2 панели -->
                <div class="panel-body">
                    <c:if test="${!empty department.objects}">
                        <table class="tg" width="100%">
                            <tr>
                                <th>Животное</th>
                                <th>Количество</th>
                                <th>Вид</th>
                                <th>Танк</th>
                                <th>Сотрудник</th>
                            </tr>
                            <c:forEach items="${department.objects}" var="object">
                                <tr>
                                    <td><a href="<c:url value="/object/info/${object.id}"/>" target="_blank">${object.object_name}</a></td>
                                    <td>${object.object_count}</td>
                                    <td><a href="<c:url value="/specie/info/${object.specie.id}"/>" target="_blank">${object.specie.specieFullName}</a></td>
                                    <td><a href="<c:url value="/tank/info/${object.tank.id}" />" target="_blank">${object.tank.tank_name}</a></td>
                                    <td>${object.employee.fullShortNameAndTitle}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>