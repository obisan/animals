<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="tank" scope="request" type="ru.ocean.animals.model.Tank"/>

<html>
<head>
    <title>Танк</title>
</head>
<body>

<jsp:include page="../menu.jsp" />

<div class="container">
    <h4>Паспорт танк</h4>
    <table class="table">
        <tr>
            <td>
                <form:form action="${addAction}" commandName="tank">
                    <table>
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${tank.id}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="tank_name">
                                    <spring:message text="Танк"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${tank.tank_name}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="tank_volume">
                                    <spring:message text="Объем"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${tank.tank_volume}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="building_id">
                                    <spring:message text="Строение"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${tank.building.building_name}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="employee_id">
                                    <spring:message text="Сотрудник"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${tank.employee.fullShortNameAndDepartment}" />
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
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Список животных</a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <!-- Содержимое 1 панели -->
                <div class="panel-body">
                    <c:if test="${!empty tank.objects}">
                        <table class="table">
                            <tr>
                                <th>ID</th>
                                <th>Животное</th>
                                <th>Количество</th>
                                <th>Вид</th>
                            </tr>
                            <c:forEach items="${tank.objects}" var="object">
                                <tr>
                                    <td>${object.id}</td>
                                    <td><a href="<c:url value="/object/info/${object.id}" />" target="_blank" >${object.object_name}</a></td>
                                    <td>${object.object_count}</td>
                                    <td><a href="<c:url value="/specie/info/${object.specie.id}" />" target="_blank" >${object.specie.specie_name_lat}</a></td>
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
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Список рационов</a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse">
                <!-- Содержимое 2 панели -->
                <div class="panel-body">
                    <c:if test="${!empty tank.journalAllowances}">
                        <table class="tg" width="100%">
                            <tr>
                                <th>ID</th>
                                <th>Название корма</th>
                                <th>Животное (количество)</th>
                                <th>Вес корма (г.)</th>
                                <th></th>
                            </tr>
                            <c:forEach items="${tank.journalAllowances}" var="journalAllowances">
                                <tr>
                                    <td>${journalAllowances.id}</td>
                                    <td>${journalAllowances.allowance.allowance_name}</td>
                                    <td><a href="/object/info/${journalAllowances.object_id}" target="_blank">${journalAllowances.object.object_name}</a> (${journalAllowances.object.object_count})</td>
                                    <td>${journalAllowances.weight}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
        <!-- 3 панель -->
        <div class="panel panel-default">
            <!-- Заголовок 3 панели -->
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Список отходов</a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse">
                <!-- Содержимое 3 панели -->
                <div class="panel-body">
                    <c:if test="${!empty tank.deceaseds}">
                        <table class="tg" width="100%">
                            <tr>
                                <th>ID</th>
                                <th>Дата</th>
                                <th>Животное</th>
                                <th>Количество</th>
                                <th>Вид</th>
                            </tr>
                            <c:forEach items="${tank.deceaseds}" var="deceased">
                                <tr>
                                    <td>${deceased.id}</td>
                                    <td>${deceased.deceased_date}</td>
                                    <td><a href="<c:url value="/object/info/${deceased.object.id}"/>" target="_blank">${deceased.object.object_name}</a></td>
                                    <td>${deceased.deceased_count}</td>
                                    <td><a href="<c:url value="/specie/info/${deceased.object.specie.id}"/>" target="_blank">${deceased.object.specie.specieFullName}</a></td>
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