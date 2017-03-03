<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Назначение рационов</title>
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
    <h4>Назначить корм</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/journalallowance/add"></c:url>
                <form:form action="${addAction}" commandName="journalAllowanceExtended">
                    <table>
                        <tr>
                            <td>
                                <form:label path="object1_id">
                                    <spring:message text="Животное"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select class="combobox" path="object1_id">
                                    <option></option>
                                    <c:forEach items="${listObjects}" var="object">
                                        <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_name})</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>

                            <td>
                                <form:label path="allowance1_id">
                                    <spring:message text="Корм"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select class="combobox" path="allowance1_id">
                                    <option></option>
                                    <c:forEach items="${listAllowances}" var="allowance">
                                        <form:option value="${allowance.id}">${allowance.allowance_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:label path="weight1">
                                    <spring:message text="Вес (г.)"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="weight1" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="object2_id">
                                    <option></option>
                                    <c:forEach items="${listObjects}" var="object">
                                        <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_name})</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="allowance2_id">
                                    <option></option>
                                    <c:forEach items="${listAllowances}" var="allowance">
                                        <form:option value="${allowance.id}">${allowance.allowance_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:input path="weight2" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="object3_id">
                                    <option></option>
                                    <c:forEach items="${listObjects}" var="object">
                                        <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_name})</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="allowance3_id">
                                    <option></option>
                                    <c:forEach items="${listAllowances}" var="allowance">
                                        <form:option value="${allowance.id}">${allowance.allowance_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:input path="weight3" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="object4_id">
                                    <option></option>
                                    <c:forEach items="${listObjects}" var="object">
                                        <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_name})</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="allowance4_id">
                                    <option></option>
                                    <c:forEach items="${listAllowances}" var="allowance">
                                        <form:option value="${allowance.id}">${allowance.allowance_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:input path="weight4" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="object5_id">
                                    <option></option>
                                    <c:forEach items="${listObjects}" var="object">
                                        <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_name})</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="allowance5_id">
                                    <option></option>
                                    <c:forEach items="${listAllowances}" var="allowance">
                                        <form:option value="${allowance.id}">${allowance.allowance_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td></td>
                            <td>
                                <form:input path="weight5" />
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty object1_id}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty object1_id}">
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
            <h4>Список назначений</h4>

            <c:if test="${!empty listJournalAllowances}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Животное</th>
                        <th width="120">Корм</th>
                        <th width="120">Вес (г.)</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listJournalAllowances}" var="journalallowance">
                        <tr>
                            <td>${journalallowance.id}</td>
                            <td><a href="<c:url value="/object/info/${journalallowance.object_id}"/>" target="_blank">${journalallowance.object.object_name}</a> (${journalallowance.object.object_count}) <a href="<c:url value="/tank/info/${journalallowance.object.tank.id}"/>" target="_blank">(${journalallowance.object.tank.tank_name})</a></td>
                            <td>${journalallowance.allowance.allowance_name}</td>
                            <td>${journalallowance.weight}</td>
                            <td><a href="<c:url value='/journalallowance/edit/${journalallowance.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/journalallowance/remove/${journalallowance.id}' />" >Delete</a></td>
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
