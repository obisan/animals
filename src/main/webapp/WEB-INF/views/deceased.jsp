<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Журнал отходов</title>

</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить запись об отходах</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/deceased/add"></c:url>

                    <form:form action="${addAction}" commandName="deceased">
                        <table>
                            <c:if test="${!empty deceased.deceased_date}">
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
                                    <form:label path="deceased_date">
                                        <spring:message text="Дата гибели"/>
                                    </form:label>
                                </td>
                                <td>
                                    <div class="input-group date" id="deceased_date">
                                        <form:input path="deceased_date" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                        </span>
                                    </div>

                                    <script type="text/javascript">
                                        $(function () {
                                            $('#deceased_date').datetimepicker({language: 'ru'});
                                        });
                                    </script>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="deceased_count">
                                        <spring:message text="Количество"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="deceased_count" />
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <form:label path="deceased_note">
                                        <spring:message text="Примечание"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="deceased_note" />
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
                                    <c:if test="${!empty deceased.deceased_date}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty deceased.deceased_date}">
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
            <h4>Список отходов</h4>
            <c:if test="${!empty listDeceaseds}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Дата отхода</th>
                        <th width="120">Количество погибших животных</th>
                        <th width="120">Примечание</th>
                        <th width="120">Животное</th>
                        <th width="120">Танк</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listDeceaseds}" var="deceased">
                        <tr>
                            <td>${deceased.id}</td>
                            <td>${deceased.deceased_date}</td>
                            <td>${deceased.deceased_count}</td>
                            <td>${deceased.deceased_note}</td>
                            <td><a href="<c:url value='/object/info/${deceased.object.id}' />" target="_blank">${deceased.object.object_name}</a></td>
                            <td><a href="<c:url value='/tank/info/${deceased.tank.id}' />" target="_blank">${deceased.tank.tank_name}</a></td>
                            <td><a href="<c:url value='/deceased/edit/${deceased.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/deceased/remove/${deceased.id}' />" >Delete</a></td>
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
