<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="employee" scope="request" type="ru.ocean.animals.model.Employee"/>

<html>
<head>
    <title>Сотрудник</title>
</head>
<body>

<jsp:include page="../menu.jsp" />

<div class="container">
    <h4>Паспорт сотрудник</h4>
    <table class="table">
        <tr>
            <td>
                <form:form action="${addAction}" commandName="employee">
                    <table>
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${employee.id}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="employee_last_name">
                                    <spring:message text="Фамилия"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${employee.employee_last_name}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="employee_first_name">
                                    <spring:message text="Имя"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${employee.employee_first_name}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="employee_middle_name">
                                    <spring:message text="Отчество"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${employee.employee_middle_name}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="employee_title">
                                    <spring:message text="Должность"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${employee.employee_title}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="department_id">
                                    <spring:message text="Отдел"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${employee.department.department_name}" />
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
                    <c:if test="${!empty listObjects}">
                        <table class="table">
                            <tr>
                                <th>ID</th>
                                <th>Животное</th>
                                <th>Количество</th>
                                <th>Вид</th>
                                <th>Танк</th>
                            </tr>
                            <c:forEach items="${listObjects}" var="object">
                                <tr>
                                    <td>${object.id}</td>
                                    <td><a href="<c:url value="/object/info/${object.id}" />" target="_blank" >${object.object_name}</a></td>
                                    <td>${object.object_count}</td>
                                    <td><a href="<c:url value="/specie/info/${object.specie.id}" />" target="_blank" >${object.specie.specie_name_lat}</a></td>
                                    <td><a href="<c:url value="/tank/info/${object.tank.id}" />" target="_blank" >${object.tank.tank_name}</a></td>
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