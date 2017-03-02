<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Отчет о погибших животных</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:5px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    </style>
</head>
<body>

<jsp:include page="../menu.jsp" />

<div class="container">

    <form:form method="get" modelAttribute="deceasedCriteria">
        <fieldset>
            <table>
                <tr>
                    <td>
                        <form:label path="date_from">
                            <spring:message text="Дата (от)"/>
                        </form:label>
                    </td>
                    <td>
                        <div class="input-group date" id="date_from">
                            <form:input path="date_from" />
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar" ></span>
                            </span>
                        </div>

                        <script type="text/javascript">
                            $(function () {
                                $('#date_from').datetimepicker({language: 'ru'});
                            });
                        </script>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="date_to">
                            <spring:message text="Дата (до)"/>
                        </form:label>
                    </td>
                    <td>
                        <div class="input-group date" id="date_to">
                            <form:input path="date_to" />
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar" ></span>
                            </span>
                        </div>

                        <script type="text/javascript">
                            $(function () {
                                $('#date_to').datetimepicker({language: 'ru'});
                            });
                        </script>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="specie_id">
                            <spring:message text="Вид"/>
                        </form:label>
                    </td>
                    <td>
                        <select class="combobox" name="specie_id">
                            <option></option>
                            <c:forEach items="${listSpecies}" var="specie">
                                <option value="${specie.id}">${specie.specieFullName}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
        </fieldset>
        <button id="search"><spring:message text="Поиск"/> </button>
    </form:form>

    <h4>Список погибших животных</h4>
    <c:if test="${!empty listDeceaseds}">
        <table class="tg">
            <tr>
                <th width="80">ID</th>
                <th width="120">Имя объекта</th>
                <th width="80">Количество</th>
                <th width="80">Дата</th>
                <th width="80">Примечание</th>
                <th width="120">Вид</th>
                <th width="120">Сотрудник</th>
            </tr>
            <c:forEach items="${listDeceaseds}" var="deceased">
                <tr>
                    <td>${deceased.id}</td>
                    <td><a href="<c:url value='/object/info/${deceased.object.id}' />" target="_blank">${deceased.object.object_name}</a></td>
                    <td>${deceased.deceased_count}</td>
                    <td>${deceased.deceased_date}</td>
                    <td>${deceased.deceased_note}</td>
                    <td><a href="<c:url value='/specie/info/${deceased.object.specie.id}'/>" target="_blank">${deceased.object.specie.specieFullName}</a></td>
                    <td>${deceased.object.employee.fullShortName} (${object.employee.department.department_name})</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>

<script type="text/javascript">
    $(document).ready(function(){
        $('.combobox').combobox();
    });
</script>

</body>
</html>
