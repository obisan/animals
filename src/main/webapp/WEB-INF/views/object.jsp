<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Журнал животных</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css" />

</head>
<body>
    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Журнал животных</h4>
        <table class="table">
            <tr>
                <td>
                    <c:url var="addAction" value="/object/add"></c:url>
                    <form:form action="${addAction}" commandName="object">
                        <table>
                            <c:if test="${!empty object.object.object_name}">
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
                                    <form:label path="object.object_name">
                                        <spring:message text="Имя животного"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object.object_name" />
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="object.object_name" />
                                </td>
                                <td rowspan="9" align="center" bgcolor="#f0f8ff">
                                    <h4>Этикеточные данные</h4>
                                    <table>
                                        <tr>
                                            <td>
                                                <form:label path="label.place_catching">
                                                    <spring:message text="Место поимки" />
                                                </form:label>
                                            </td>
                                            <td>
                                                <form:input path="label.place_catching" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="label.date_catching">
                                                    <spring:message text="Дата поимки" />
                                                </form:label>
                                            </td>
                                            <td>
                                                <div class="input-group date" id="date_catching">
                                                    <form:input path="label.date_catching" />
                                                    <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" /></span>
                                                </div>
                                                <script type="text/javascript">
                                                    $(function () {
                                                        $('#date_catching').datetimepicker({
                                                            language: 'ru',
                                                            format: "YYYY-MM-DD HH:mm:ss"
                                                        });
                                                    });
                                                </script>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="label.weight">
                                                    <spring:message text="Вес (исходный)" />
                                                </form:label>
                                            </td>
                                            <td>
                                                <form:input path="label.weight" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="label.length">
                                                    <spring:message text="Длина (исходный)" />
                                                </form:label>
                                            </td>
                                            <td>
                                                <form:input path="label.length" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="label.tool_catching">
                                                    <spring:message text="Средство поимки" />
                                                </form:label>
                                            </td>
                                            <td>
                                                <form:input path="label.tool_catching" />
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <form:label path="label.condition_id">
                                                    <spring:message text="Условие поступления" />
                                                </form:label>
                                            </td>
                                            <td>
                                                <form:select path="label.condition_id">
                                                    <c:forEach items="${listConditions}" var="icondition">
                                                        <form:option value="${icondition.id}">${icondition.condition_name}</form:option>
                                                    </c:forEach>
                                                </form:select>
                                            </td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.object_count">
                                        <spring:message text="Количество (экз.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object.object_count"  />
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="object.object_count" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.object_weight">
                                        <spring:message text="Вес"/> (кг.)
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object.object_weight" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.object_length">
                                        <spring:message text="Длина"/> (м.)
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="object.object_length" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.specie_id">
                                        <spring:message text="Вид"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="object.specie_id">
                                        <option></option>
                                        <c:forEach items="${listSpecies}" var="specie">
                                            <form:option value="${specie.id}">${specie.specieFullName}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="object.specie_id" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.employee_id">
                                        <spring:message text="Сотрудник"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="object.employee_id">
                                        <option></option>
                                        <c:forEach items="${listEmployees}" var="employee">
                                            <form:option value="${employee.id}">${employee.fullShortNameAndDepartment}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="object.employee_id" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.tank_id">
                                        <spring:message text="Танк"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="object.tank_id">
                                        <option></option>
                                        <c:forEach items="${listTanks}" var="tank">
                                            <form:option value="${tank.id}">${tank.tank_number}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                                <td>
                                    <form:errors cssClass="error" path="object.tank_id" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="object.aquarium_id">
                                        <spring:message text="Аквариум"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="object.aquarium_id">
                                        <option></option>
                                        <c:forEach items="${listAquariums}" var="aquarium">
                                            <form:option value="${aquarium.id}">${aquarium.aquarium_name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty object.object.object_name}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty object.object.object_name}">
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
                    <c:url var="searchAction" value="/objects"></c:url>
                    <form action="${searchAction}">
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
                <c:if test="${!empty listObjects}">
                    <table class="table">
                        <tr>
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
                                <td><a href="<c:url value='/object/info/${object.id}' />" target="_blank">${object.object_name}</a></td>
                                <td>${object.object_count}</td>
                                <td>${object.object_weight}</td>
                                <td>${object.object_length}</td>
                                <td><a href="<c:url value="/specie/info/${object.specie.id}" />" target="_blank" >${object.specie.specie_name_lat}</a></td>
                                <td><a href="<c:url value="/employee/info/${object.employee.id}"/>" target="_blank">${object.employee.fullShortName}</a> (<a href="<c:url value="/department/info/${object.employee.department.id}" />  ">${object.employee.department.department_name}</a>)</td>
                                <td><a href="<c:url value="/tank/info/${object.tank.id}" />" target="_blank">${object.tank.tank_number}</a> ${object.aquarium.nameBraked}</td>
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
