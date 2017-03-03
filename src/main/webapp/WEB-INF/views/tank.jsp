<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Танк</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить танк</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/tank/add"></c:url>

                    <form:form action="${addAction}" commandName="tank">
                        <table>
                            <c:if test="${!empty tank.tank_name}">
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
                                    <form:label path="tank_name">
                                        <spring:message text="Наименование танка"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_volume">
                                        <spring:message text="Объем танка"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_volume" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="employee_id">
                                        <spring:message text="Сотрудник"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="employee_id">
                                        <c:forEach items="${listEmployees}" var="iemployee">
                                            <form:option value="${iemployee.id}">${iemployee.fullShortName}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <form:label path="building_id">
                                        <spring:message text="Строение"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="building_id">
                                        <c:forEach items="${listBuildings}" var="ibuilding">
                                            <form:option value="${ibuilding.id}">${ibuilding.building_name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty tank.tank_name}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty tank.tank_name}">
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
                <h3>Список танков</h3>
                <c:if test="${!empty listTanks}">
                    <table class="table">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Наименование танка</th>
                            <th width="120">Объем танка</th>
                            <th width="120">Сотрудник</th>
                            <th width="120">Строение</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listTanks}" var="tank">
                            <tr>
                                <td>${tank.id}</td>
                                <td><a href="<c:url value="/tank/info/${tank.id}" />" target="_blank" >${tank.tank_name}</a> </td>
                                <td>${tank.tank_volume}</td>
                                <td>${tank.employee.fullShortName}</td>
                                <td>${tank.building.building_name}</td>
                                <td><a href="<c:url value='/tank/edit/${tank.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/tank/remove/${tank.id}' />" >Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
        </tr>
    </table>

</body>
</html>
