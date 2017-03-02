<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Вид</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
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
                        <tr>
                            <td>
                                <form:label path="tag_id">
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
                    <c:if test="${!empty specie.objects}">
                        <table class="table">
                            <tr>
                                <th>ID</th>
                                <th>Животное</th>
                                <th>Танк</th>
                            </tr>
                            <c:forEach items="${specie.objects}" var="object">
                                <tr>
                                    <td>${object.id}</td>
                                    <td><a href="<c:url value="/object/info/${object.id}" />" target="_blank" >${object.object_name}</a></td>
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