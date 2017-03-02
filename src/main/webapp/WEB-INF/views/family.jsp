<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Семейство</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить семейство</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/family/add"></c:url>

                    <form:form action="${addAction}" commandName="family">
                        <table>
                            <c:if test="${!empty family.family_name_ru}">
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
                                    <form:label path="family_name_lat">
                                        <spring:message text="Семейство (лат.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="family_name_lat" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="family_name_ru">
                                        <spring:message text="Семейство (рус.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="family_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="order_id">
                                        <spring:message text="Отряд"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="order_id">
                                        <option></option>
                                        <c:forEach items="${listOrders}" var="iorder">
                                            <form:option value="${iorder.id}">${iorder.orderFullName}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty family.family_name_lat}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty family.family_name_lat}">
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
                <h3>Список семейств</h3>

                <c:if test="${!empty listFamilies}">
                    <table class="table">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Семейство (лат.)</th>
                            <th width="120">Семейство (рус.)</th>
                            <th width="120">Отряд</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listFamilies}" var="family">
                            <tr>
                                <td>${family.id}</td>
                                <td>${family.family_name_lat}</td>
                                <td>${family.family_name_ru}</td>
                                <td>${family.order.order_name_lat}</td>
                                <td><a href="<c:url value='/family/edit/${family.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/family/remove/${family.id}' />" >Delete</a></td>
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
