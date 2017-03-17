<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Список сотрудников</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Список сотрудников</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/employee/add"></c:url>

                    <form:form action="${addAction}" commandName="employee">
                        <table>
                            <c:if test="${!empty employee.employee_first_name}">
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
                                    <form:label path="employee_last_name">
                                        <spring:message text="Фамилия"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="employee_last_name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="employee_first_name">
                                        <spring:message text="Имя"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="employee_first_name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="employee_middle_name">
                                        <spring:message text="Отчество"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="employee_middle_name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="employee_title">
                                        <spring:message text="Должность"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="employee_title" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="department_id">
                                        <spring:message text="Департамент"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="department_id">
                                        <c:forEach items="${listDepartments}" var="idepartment">
                                            <form:option value="${idepartment.id}">${idepartment.department_name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty employee.employee_first_name}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty employee.employee_first_name}">
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
                <c:if test="${!empty listEmployees}">
                    <table width="90%" align="center" class="tg">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Фамилия</th>
                            <th width="120">Имя</th>
                            <th width="120">Отчество</th>
                            <th width="120">Должность</th>
                            <th width="120">Департамент</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listEmployees}" var="employee">
                            <tr>
                                <td>${employee.id}</td>
                                <td>${employee.employee_last_name}</td>
                                <td>${employee.employee_first_name}</td>
                                <td>${employee.employee_middle_name}</td>
                                <td>${employee.employee_title}</td>
                                <td>${employee.department.department_name}</td>
                                <td><a href="<c:url value='/employee/edit/${employee.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/employee/remove/${employee.id}' />" >Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
        </tr>
    </table>

</body>
</html>
