<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="now" class="java.util.Date" />

<html>
<head>
    <title>Журнал лечений</title>
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
    <h4>Добавить лечение</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/medication/add"></c:url>

                <form:form action="${addAction}" commandName="medication">
                    <table>
                        <c:if test="${!empty medication.medication_start_date}">
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
                                <form:label path="medication_start_date">
                                    <spring:message text="Дата начала"/>
                                </form:label>
                            </td>
                            <td>
                                <div class="input-group date" id="medication_start_date">
                                    <form:input path="medication_start_date" />
                                    <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                    </span>
                                </div>

                                <script type="text/javascript">
                                    $(function () {
                                        $('#medication_start_date').datetimepicker({language: 'ru'});
                                    });
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="medication_end_date">
                                    <spring:message text="Дата окончания"/>
                                </form:label>
                            </td>
                            <td>
                                <div class="input-group date" id="medication_end_date">
                                    <form:input path="medication_end_date" />
                                    <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar" />
                                    </span>
                                </div>

                                <script type="text/javascript">
                                    $(function () {
                                        $('#medication_end_date').datetimepicker({language: 'ru'});
                                    });
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="medication_reaction">
                                    <spring:message text="Реакция"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="medication_reaction" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="medication_diagnostic">
                                    <spring:message text="Диагноз"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="medication_diagnostic" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="medication_bath">
                                    <spring:message text="Ванна"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="medication_bath" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="medication_note">
                                    <spring:message text="Примечание"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="medication_note" />
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
                            <td>
                                <form:label path="drug_id">
                                    <spring:message text="Лекарство"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug_id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="idrug">
                                        <form:option value="${idrug.id}">${idrug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty medication.medication_start_date}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty medication.medication_start_date}">
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
            <h4>Журнал лечений</h4>
            <c:if test="${!empty listMedications}">
                <table class="table">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Животное</th>
                        <th width="120">Дата начала</th>
                        <th width="120">Дата окончания</th>
                        <th width="120">Реакция</th>
                        <th width="120">Диагноз</th>
                        <th width="120">Ванна</th>
                        <th width="120">Примечание</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listMedications}" var="medication">
                        <tr>
                            <td>${medication.id}</td>
                            <td>${medication.object.object_name} (${medication.object.object_count}) (${medication.object.tank.tank_name})</td>
                            <td>${medication.medication_start_date}</td>
                            <td>${medication.medication_end_date}</td>
                            <td>${medication.medication_reaction}</td>
                            <td>${medication.medication_diagnostic}</td>
                            <td>${medication.medication_bath}</td>
                            <td>${medication.medication_note}</td>
                            <td><a href="<c:url value='/medication/edit/${medication.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/medication/remove/${medication.id}' />" >Delete</a></td>
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
