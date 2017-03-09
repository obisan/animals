<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="now" class="java.util.Date" />

<html>
<head>
    <title>Журнал перемещений</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить перемещение</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/displacement/add"></c:url>

                    <form:form action="${addAction}" commandName="displacement">
                        <table>
                            <c:if test="${!empty displacement.date_arrival}">
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
                                    <form:label path="date_arrival">
                                        <spring:message text="Дата прибытия"/>
                                    </form:label>
                                </td>
                                <td>
                                    <div class="input-group date" id="date_arrival">
                                        <form:input path="date_arrival" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                        </span>
                                    </div>

                                    <script type="text/javascript">
                                        $(function () {
                                            $('#date_arrival').datetimepicker({language: 'ru'});
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="date_departure">
                                        <spring:message text="Дата отбытия"/>
                                    </form:label>
                                </td>
                                <td>
                                    <div class="input-group date" id="date_departure">
                                        <form:input path="date_departure" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                        </span>
                                    </div>

                                    <script type="text/javascript">
                                        $(function () {
                                            $('#date_departure').datetimepicker({language: 'ru'});
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="displacement_count">
                                        <spring:message text="Количество"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="displacement_count" />
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
                                    <form:label path="object_id">
                                        <spring:message text="Животное"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="object_id">
                                        <option></option>
                                        <c:forEach items="${listObjects}" var="object">
                                            <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_name})</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty displacement.date_arrival}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty displacement.date_arrival}">
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
                <h4>Список перемещений</h4>
                <c:if test="${!empty listDisplacements}">
                    <table class="table">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Дата перевода (прибытие)</th>
                            <th width="120">Дата перевода (отбытие)</th>
                            <th width="120">Количество</th>
                            <th width="120">Название Танка</th>
                            <th width="120">Имя объекта</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listDisplacements}" var="displacement">
                            <tr>
                                <td>${displacement.id}</td>
                                <td>${displacement.date_arrival}</td>
                                <td>${displacement.date_departure}</td>
                                <td>${displacement.displacement_count}</td>
                                <td><a href="<c:url value="/tank/info/${displacement.tank_id}"/>" target="_blank">${displacement.tank.tank_name}</a></td>
                                <td><a href="<c:url value="/object/info/${displacement.object.id}"/>" target="_blank">${displacement.object.object_name}</a></td>
                                <td><a href="<c:url value='/displacement/edit/${displacement.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/displacement/remove/${displacement.id}' />" >Delete</a></td>
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
