<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Список сертификатов</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Список сертификатов</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/certificate/add"></c:url>

                    <form:form action="${addAction}" commandName="certificate">
                        <table>
                            <c:if test="${!empty certificate.certificate_number}">
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
                                    <form:label path="certificate_number">
                                        <spring:message text="Номер сертификата"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="certificate_number" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="certificate_date">
                                        <spring:message text="Дата поимки"/>
                                    </form:label>
                                </td>
                                <td>
                                    <div class="input-group date" id="certificate_date">
                                        <form:input path="certificate_date" />
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" ></span>
                                        </span>
                                    </div>

                                    <script type="text/javascript">
                                        $(function () {
                                            $('#certificate_date').datetimepicker({
                                                language: 'ru',
                                                format: "YYYY-MM-DD HH:mm:ss"
                                            });
                                        });
                                    </script>
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
                                    <c:if test="${!empty certificate.certificate_number}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty certificate.certificate_number}">
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
            <c:if test="${!empty listCertificates}">
                <table class="table">
                    <tr>
                        <th width="120">Номер сертификата</th>
                        <th width="120">Дата сертификата</th>
                        <th width="120">Имя объекта</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listCertificates}" var="certificate">
                        <tr>
                            <td>${certificate.certificate_number}</td>
                            <td>${certificate.certificate_date}</td>
                            <td><a href="<c:url value="/object/info/${certificate.object.id}" />" target="_blank">${certificate.object.object_name}</a></td>
                            <td><a href="<c:url value='/certificate/edit/${certificate.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/certificate/remove/${certificate.id}' />" >Delete</a></td>
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
