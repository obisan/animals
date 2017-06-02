<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Журнал витаминов</title>
</head>
<body>

<jsp:include page="menu.jsp" />

<div class="container">
    <h4>Журнал витаминов</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/vitaminization/add"></c:url>
                <form:form action="${addAction}" commandName="vitaminization">
                    <table>
                        <c:if test="${!empty vitaminization.vitaminization.vitaminization_date}">
                            <tr>
                                <td>
                                    <form:label path="vitaminization.id">
                                        <spring:message text="ID"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="vitaminization.id" readonly="true" size="8"  disabled="true" />
                                    <form:hidden path="vitaminization.id" />
                                </td>
                            </tr>
                        </c:if>
                        <tr>
                            <td colspan="5">
                                <table>
                                    <tr>
                                        <td>
                                            <form:label path="object.id">
                                                <spring:message text="Животное"/>
                                            </form:label>
                                        </td>
                                        <td>
                                            <form:select class="combobox" path="object.id">
                                                <option></option>
                                                <c:forEach items="${listObjects}" var="object">
                                                    <form:option value="${object.id}">${object.object_name} (${object.object_count}) (${object.tank.tank_number}) ${object.aquarium.nameBraked}</form:option>
                                                </c:forEach>
                                            </form:select>
                                        </td>
                                        <td align="right">
                                            <form:label path="tank.id">
                                                <spring:message text="Танк"/>
                                            </form:label>
                                        </td>
                                        <td>
                                            <form:select class="combobox" path="tank.id">
                                                <option></option>
                                                <c:forEach items="${listTanks}" var="tank">
                                                    <form:option value="${tank.id}">${tank.tank_number}</form:option>
                                                </c:forEach>
                                            </form:select>
                                        </td>
                                        <td>
                                            <form:label path="aquariums">
                                                <spring:message text="Аквариумы"/>
                                            </form:label>
                                        </td>
                                        <td>
                                            <table>
                                                <c:set var="count2" value="0" scope="page" />
                                                <c:forEach items="${listAquariums}" var="aquarium">
                                                    <c:if test="${count2%16 == 0}"><tr></c:if>
                                                    <c:set var="count2" value="${count2 + 1}" scope="page" />
                                                    <td><form:checkbox class="tagbox" path="aquariums" value="${aquarium.id}" label="${aquarium.aquarium_name}" />  </td>
                                                    <c:if test="${count2%16 == 0}"></tr></c:if>
                                                </c:forEach>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="vitaminization.vitaminization_date">
                                    <spring:message text="Дата витаминизации"/>
                                </form:label>
                            </td>
                            <td>
                                <div class="input-group date" id="vitaminization_date">
                                    <form:input path="vitaminization.vitaminization_date" />
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar" />
                                    </span>
                                </div>

                                <script type="text/javascript">
                                    $(function () {
                                        $('#vitaminization_date').datetimepicker({
                                            language: 'ru',
                                            format: "YYYY-MM-DD HH:mm:ss"
                                        });
                                    });
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="">
                                    <spring:message text="Витамины"/>
                                </form:label>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug1.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug2.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug3.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug4.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug5.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <form:select class="combobox" path="drug6.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug7.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug8.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug9.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <form:select class="combobox" path="drug10.id">
                                    <option></option>
                                    <c:forEach items="${listDrugs}" var="drug">
                                        <form:option value="${drug.id}">${drug.drug_name}</form:option>
                                    </c:forEach>
                                </form:select>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty vitaminization.vitaminization.vitaminization_date}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty vitaminization.vitaminization.vitaminization_date}">
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

<!--
Table
-->

<table width="70%" align="center">
    <tr>
        <td class="tg">
            <c:if test="${!empty listVitaminizations}">
                <table class="table">
                    <tr>
                        <th width="120">Животное</th>
                        <th width="120">Танк</th>
                        <th width="120">Дата витаминизации</th>
                        <th width="120">Витамины</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listVitaminizations}" var="vitaminization">
                        <tr>
                            <td><a href="<c:url value="/object/info/${vitaminization.object.id}"/>" target="_blank">${vitaminization.object.object_name}</a> (${vitaminization.object.object_count})</td>
                            <td>${vitaminization.tank.tank_number} ${vitaminization.aquarium.nameBraked}</td>
                            <td>${vitaminization.vitaminization_date}</td>
                            <td><c:forEach items="${vitaminization.drugs}" var="drug" >${drug.drug_name}<br></c:forEach></td>
                            <td><a href="<c:url value='/vitaminization/edit/${vitaminization.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/vitaminization/remove/${vitaminization.id}' />" >Delete</a></td>
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
