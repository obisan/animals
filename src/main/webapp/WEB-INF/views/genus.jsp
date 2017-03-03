<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Род</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Добавить род</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/genus/add"></c:url>

                    <form:form action="${addAction}" commandName="genus">
                        <table>
                            <c:if test="${!empty genus.genus_name_lat}">
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
                                    <form:label path="genus_name_lat">
                                        <spring:message text="Род (лат.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="genus_name_lat" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="genus_name_ru">
                                        <spring:message text="Род (рус.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="genus_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="family_id">
                                        <spring:message text="Семейство"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="family_id">
                                        <option></option>
                                        <c:forEach items="${listFamilies}" var="ifamily">
                                            <form:option value="${ifamily.id}">${ifamily.familyFullName}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty genus.genus_name_lat}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty genus.genus_name_lat}">
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
            <h4>Список родов</h4>

            <c:if test="${!empty listGenera}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Род (лат.)</th>
                        <th width="120">Род (рус.)</th>
                        <th width="120">Семейство</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listGenera}" var="genus">
                        <tr>
                            <td>${genus.id}</td>
                            <td>${genus.genus_name_lat}</td>
                            <td>${genus.genus_name_ru}</td>
                            <td>${genus.family.family_name_lat}</td>
                            <td><a href="<c:url value='/genus/edit/${genus.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/genus/remove/${genus.id}' />" >Delete</a></td>
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
