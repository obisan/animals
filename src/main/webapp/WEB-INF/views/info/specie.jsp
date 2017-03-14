<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="specie" scope="request" type="ru.ocean.animals.model.Specie"/>

<html>
<head>
    <title>Вид</title>
</head>
<body>

<jsp:include page="../menu.jsp" />

<div class="container">
    <h4>Информация по виду</h4>
    <table class="table">
        <tr>
            <td>
                <form:form action="${addAction}" commandName="specie">
                    <table>
                        <tr>
                            <td>
                                <form:label path="id">
                                    <spring:message text="ID"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${specie.id}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="specie_name_lat">
                                    <spring:message text="Вид (лат.)"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${specie.specie_name_lat}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="specie_name_ru">
                                    <spring:message text="Вид (рус.)"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${specie.specie_name_ru}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="specie_rbc">
                                    <spring:message text="Кровянные тельца"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${specie.specie_rbc}" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="specie_nucleus">
                                    <spring:message text="Ядра"/>
                                </form:label>
                            </td>
                            <td>
                                <spring:message text="${specie.specie_nucleus}" />
                            </td>
                        </tr>
                    </table>
                </form:form>
            </td>
            <td>
                <c:if test="${!empty specie.photos}">
                    <h4>Фото вида</h4>
                    <img src="<c:url value="/image/${specie.id}" />" />
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
                                <th>Танк</th>
                            </tr>
                            <c:forEach items="${listObjects}" var="object">
                                <tr>
                                    <td>${object.id}</td>
                                    <td><a href="<c:url value="/object/info/${object.id}" />" target="_blank" >${object.object_name}</a></td>
                                    <td>${object.object_count}</td>
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