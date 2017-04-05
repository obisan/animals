<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Список танков</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Список танков</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/tank/add"></c:url>

                    <form:form action="${addAction}" commandName="tank">
                        <table>
                            <c:if test="${!empty tank.tank_number}">
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
                                    <form:label path="tank_number">
                                        <spring:message text="Номер"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_number" />
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="tank_number" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_volume">
                                        <spring:message text="Объем танка"/>, м<sup>3</sup>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_volume" />
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="tank_volume"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_temperature">
                                        <spring:message text="Температура"/>, <sup>o</sup>C
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_temperature" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_ph">
                                        <spring:message text="pH"/> (-lg [H<sup>+</sup>])
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_ph" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_orp">
                                        <spring:message text="ORP"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="tank_orp" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_salineness">
                                        <spring:message text="Соленость"/>, PPM
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="tank_salineness">
                                        <form:option value=">30">&gt;30</form:option>
                                        <form:option value="12-15">12-15</form:option>
                                        <form:option value="<5">&lt;5</form:option>
                                    </form:select>
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
                                        <spring:message text="Корпус"/>
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
                                    <c:if test="${!empty tank.tank_number}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty tank.tank_number}">
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
                <c:if test="${!empty listTanks}">
                    <table class="table">
                        <tr>
                            <th width="120">Номер</th>
                            <th width="120">Объем, м<sup>3</sup></th>
                            <th width="120">Температура, <sup>o</sup>C</th>
                            <th width="120">pH (-lg [H<sup>+</sup>])</th>
                            <th width="120">ORP</th>
                            <th width="120">Соленость, PPM</th>
                            <th width="140">Сотрудник</th>
                            <th width="80">Корпус</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listTanks}" var="tank">
                            <tr>
                                <td><a href="<c:url value="/tank/info/${tank.id}" />" target="_blank" >${tank.tank_number}</a> </td>
                                <td>${tank.tank_volume}</td>
                                <td>${tank.tank_temperature}</td>
                                <td>${tank.tank_ph}</td>
                                <td>${tank.tank_orp}</td>
                                <td>${tank.tank_salineness}</td>
                                <td><a href="<c:url value="/employee/info/${tank.employee.id}"/>" target="_blank">${tank.employee.fullShortName}</a> (<a href="<c:url value="/department/info/${tank.employee.department.id}"/>" target="_blank">${tank.employee.department.department_name}</a>)</td>
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
