<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Животное</title>
</head>
<body>

    <jsp:include page="../menu.jsp" />

    <div class="container">
        <h4>Паспорт животного</h4>
        <table class="table">
            <tr>
                <td>
                    <form:form action="${addAction}" commandName="object">
                        <table>
                            <tr>
                                <td>
                                    <form:label path="id">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.id}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_name">
                                        <spring:message text="Имя животного"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.object_name}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_count">
                                        <spring:message text="Количество"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.object_count}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_weight">
                                        <spring:message text="Вес"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.object_weight}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_length">
                                        <spring:message text="Длина"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.object_length}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_id">
                                        <spring:message text="Вид" />
                                    </form:label>
                                </td>
                                <td>
                                    <a href="<c:url value="/specie/info/${object.specie.id}" />" target="_blank" >${object.specie.specie_name_lat}</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_id">
                                        <spring:message text="Танк"/>
                                    </form:label>
                                </td>
                                <td>
                                    <a href="<c:url value="/tank/info/${object.tank_id}" />" target="_blank" >${object.tank.tank_name}</a>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="employee_id">
                                        <spring:message text="Сотрудник"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.employee.fullShortNameAndDepartment}" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="label_id">
                                        <spring:message text="Этикетка"/>
                                    </form:label>
                                </td>
                                <td>
                                    <spring:message text="${object.label.labelInfo}" />
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>
                <td>
                    <c:if test="${!empty object.specie.photos}">
                        <h4>Фото вида</h4>
                        <img src="<c:url value="/image/${object.specie.id}" />" />
                    </c:if>
                </td>
            </tr>
        </table>

        <div class="panel-group" id="accordion">
            <!-- 1 панель -->
            <div class="panel panel-default">
                <!-- Заголовок 1 панели -->
                <div class="panel-heading">
                    <h4 class="panel-title">
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Список перемещений</a>
                    </h4>
                </div>
                <div id="collapseOne" class="panel-collapse collapse">
                    <!-- Содержимое 1 панели -->
                    <div class="panel-body">
                        <c:if test="${!empty object.displacements}">
                            <table class="tg">
                                <tr>
                                    <th>ID</th>
                                    <th>Дата прибытия</th>
                                    <th>Дата отбытия</th>
                                    <th>Танк</th>
                                </tr>
                                <c:forEach items="${object.displacements}" var="displacement">
                                    <tr>
                                        <td>${displacement.id}</td>
                                        <td>${displacement.date_arrival}</td>
                                        <td>${displacement.date_departure}</td>
                                        <td>${displacement.tank.tank_name}</td>
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
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">Список карантинов</a>
                    </h4>
                </div>
                <div id="collapseTwo" class="panel-collapse collapse">
                    <!-- Содержимое 2 панели -->
                    <div class="panel-body">
                        <c:if test="${!empty object.quarantines}">
                            <table class="tg" width="100%">
                                <tr>
                                    <th>ID</th>
                                    <th>Начало карантина</th>
                                    <th>Период карантина</th>
                                    <th>Окончание карантина</th>
                                    <th>Примечание</th>
                                </tr>
                                <c:forEach items="${objectQuarantines}" var="quarantine">
                                    <tr>
                                        <td>${quarantine.id}</td>
                                        <td>${quarantine.quarantine_date_start}</td>
                                        <td>${quarantine.quarantine_period}</td>
                                        <td>${quarantine.quarantine_date_end}</td>
                                        <td>${quarantine.quarantine_note}</td>
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
                        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">Список гибелей</a>
                    </h4>
                </div>
                <div id="collapseThree" class="panel-collapse collapse">
                    <!-- Содержимое 3 панели -->
                    <div class="panel-body">
                        <c:if test="${!empty object.deceaseds}">
                            <table class="tg" width="100%">
                                <tr>
                                    <th>ID</th>
                                    <th>Дата гибели</th>
                                    <th>Количество</th>
                                    <th>Примечание</th>
                                </tr>
                                <c:forEach items="${object.deceaseds}" var="deceased">
                                    <tr>
                                        <td>${deceased.id}</td>
                                        <td>${deceased.deceased_date}</td>
                                        <td>${deceased.deceased_count}</td>
                                        <td>${deceased.deceased_note}</td>
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