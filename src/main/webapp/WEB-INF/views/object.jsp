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

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить животное</h4>
        <table class="table">
            <tr>
                <td>
                    <c:url var="addAction" value="/object/add"></c:url>
                    <form:form action="${addAction}" commandName="object">
                        <table>
                            <c:if test="${!empty object.object_name}">
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
                                    <form:label path="object_name">
                                        <spring:message text="Имя животного"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object_name" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_count">
                                        <spring:message text="Количество"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object_count"  />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_weight">
                                        <spring:message text="Вес"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object_weight" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object_length">
                                        <spring:message text="Длина"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object_length" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_id">
                                        <spring:message text="Вид"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="specie_id">
                                        <option></option>
                                        <c:forEach items="${listSpecies}" var="specie">
                                            <form:option value="${specie.id}">${specie.specieFullName}</form:option>
                                        </c:forEach>
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
                                    <form:select class="combobox" path="employee_id">
                                        <option></option>
                                        <c:forEach items="${listEmployees}" var="employee">
                                            <form:option value="${employee.id}">${employee.fullShortNameAndDepartment}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tank_id">
                                        <spring:message text="Танк"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="tank_id">
                                        <option></option>
                                        <c:forEach items="${listTanks}" var="tank">
                                            <form:option value="${tank.id}">${tank.tank_name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="label_id">
                                        <spring:message text="Этикетка"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="label_id">
                                        <option value=""></option>
                                        <c:forEach items="${listLabels}" var="label">
                                            <form:option value="${label.id}">${label.labelInfo}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty object.object_name}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty object.object_name}">
                                        <input type="submit"
                                               value="<spring:message text="Добавить"/>" />
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </form:form>
                </td>

                <td>
                    <h4>Фильтрация по виду</h4>
                    <form action="/objects">
                        <select class="combobox" name="specie">
                            <option></option>
                            <c:forEach items="${listSpecies}" var="ispecie">
                                <option value="${ispecie.id}">${ispecie.specieFullName}</option>
                            </c:forEach>
                        </select>
                        <input type="submit"
                               value="<spring:message text="search"/>" />
                    </form>
                </td>

            </tr>
        </table>
    </div>

    <table width="70%" align="center">
        <tr>
            <td class="tg">
                <h4>Список животных</h4>
                <c:if test="${!empty listObjects}">
                    <table class="table">
                        <tr>
                            <th width="50">ID</th>
                            <th width="120">Животное</th>
                            <th width="80">Количество</th>
                            <th width="80">Вес</th>
                            <th width="80">Длина</th>
                            <th width="120">Вид</th>
                            <th width="120">Сотрудник</th>
                            <th width="60">Танк</th>
                            <th width="120">Этикетка</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listObjects}" var="object">
                            <tr>
                                <td>${object.id}</td>
                                <td><a href="<c:url value='/object/info/${object.id}' />" target="_blank">${object.object_name}</a></td>
                                <td>${object.object_count}</td>
                                <td>${object.object_weight}</td>
                                <td>${object.object_length}</td>
                                <td><a href="<c:url value="/specie/info/${object.specie.id}" />" target="_blank" >${object.specie.specie_name_lat}</a></td>
                                <td>${object.employee.fullShortName} (<a href="<c:url value="/department/info/${object.employee.department.id}" />  ">${object.employee.department.department_name}</a>)</td>
                                <td><a href="<c:url value="/tank/info/${object.tank.id}" />" target="_blank">${object.tank.tank_name}</a></td>
                                <td>${object.label.place_catching} / ${object.label.date_catching} / ${object.label.condition.condition_name}</td>
                                <td><a href="<c:url value='/object/edit/${object.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/object/remove/${object.id}' />" >Delete</a></td>
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
