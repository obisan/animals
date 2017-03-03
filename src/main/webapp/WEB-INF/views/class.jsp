<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Классы</title>
</head>
<body>
    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить класс</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/class/add"></c:url>

                    <form:form action="${addAction}" commandName="aclass">
                        <table>
                            <c:if test="${!empty aclass.class_name_ru}">
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
                                    <form:label path="class_name_lat">
                                        <spring:message text="Класс (лат.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="class_name_lat" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="class_name_ru">
                                        <spring:message text="Класс (рус.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="class_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty aclass.class_name_ru}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty aclass.class_name_ru}">
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
                <h4>Список класов</h4>

                <c:if test="${!empty listClasses}">
                    <table class="table">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Класс (лат.)</th>
                            <th width="120">Класс (рус.)</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listClasses}" var="aclass">
                            <tr>
                                <td>${aclass.id}</td>
                                <td>${aclass.class_name_lat}</td>
                                <td>${aclass.class_name_ru}</td>
                                <td><a href="<c:url value='/class/edit/${aclass.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/class/remove/${aclass.id}' />" >Delete</a></td>
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
