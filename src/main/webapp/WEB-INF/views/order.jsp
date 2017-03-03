<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Отряды</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить отряд</h4>

        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/order/add"></c:url>

                    <form:form action="${addAction}" commandName="order">
                        <table>
                            <c:if test="${!empty order.order_name_ru}">
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
                                    <form:label path="order_name_lat">
                                        <spring:message text="Отряд (лат.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="order_name_lat" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="order_name_ru">
                                        <spring:message text="Отряд (рус.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="order_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="class_id">
                                        <spring:message text="Класс"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="class_id">
                                        <option></option>
                                        <c:forEach items="${listClasses}" var="iclass">
                                            <form:option value="${iclass.id}">${iclass.classFullName}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty order.order_name_ru}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty order.order_name_ru}">
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
                <h3>Список отрядов</h3>

                <c:if test="${!empty listOrders}">
                    <table class="table">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Отряд (лат.)</th>
                            <th width="120">Отряд (рус.)</th>
                            <th width="120">Класс</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listOrders}" var="order">
                            <tr>
                                <td>${order.id}</td>
                                <td>${order.order_name_lat}</td>
                                <td>${order.order_name_ru}</td>
                                <td>${order.aClass.class_name_lat}</td>
                                <td><a href="<c:url value='/order/edit/${order.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/order/remove/${order.id}' />" >Delete</a></td>
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
