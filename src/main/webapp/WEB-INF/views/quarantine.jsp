<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="now" class="java.util.Date" />

<html>
<head>
    <title>Журнал карантина</title>
</head>
<body>
    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить запись о карантине</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/quarantine/add"></c:url>

                    <form:form action="${addAction}" commandName="quarantine">
                        <table>
                            <c:if test="${!empty quarantine.quarantine_date_start}">
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
                                    <form:label path="quarantine_date_start">
                                        <spring:message text="Начало карантина"/>
                                    </form:label>
                                </td>
                                <td>
                                    <div class="input-group date" id="quarantine_date_start">
                                        <form:input path="quarantine_date_start" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                        </span>
                                    </div>

                                    <script type="text/javascript">
                                        $(function () {
                                            $('#quarantine_date_start').datetimepicker({language: 'ru'});
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="quarantine_period">
                                        <spring:message text="Период карантина"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="quarantine_period" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="quarantine_note">
                                        <spring:message text="Примечание"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="quarantine_note" />
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
                                    <c:if test="${!empty quarantine.quarantine_date_start}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty quarantine.quarantine_date_start}">
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
            <h3>Список карантинов</h3>
            <c:if test="${!empty listQuarantines}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Начало карантина</th>
                        <th width="120">Период карантина</th>
                        <th width="120">Окончание карантина</th>
                        <th width="120">Примечание</th>
                        <th width="120">Объект</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listQuarantines}" var="quarantine">
                        <tr>
                            <td>${quarantine.id}</td>
                            <td>${quarantine.quarantine_date_start}</td>
                            <td>${quarantine.quarantine_period}</td>
                            <td>${quarantine.quarantine_date_end}</td>
                            <td>${quarantine.quarantine_note}</td>
                            <td><a href="<c:url value='/object/info/${quarantine.object.id}' />" target="_blank" >${quarantine.object.object_name}</a></td>
                            <td><a href="<c:url value='/quarantine/edit/${quarantine.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/quarantine/remove/${quarantine.id}' />" >Delete</a></td>
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
