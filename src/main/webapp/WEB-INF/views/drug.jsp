<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:useBean id="now" class="java.util.Date" />
<jsp:useBean id="drug" scope="request" type="ru.ocean.animals.model.Drug"/>

<html>
<head>
    <title>Список медикаментов</title>
</head>
<body>

<jsp:include page="menu.jsp" />

<div class="container">
    <h4>Список медикаментов</h4>
    <table>
        <tr>
            <td>
                <c:url var="addAction" value="/drug/add"></c:url>

                <form:form action="${addAction}" commandName="drug">
                    <table>
                        <c:if test="${!empty drug.drug_name}">
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
                                <form:label path="drug_medicament">
                                    <spring:message text="Тип"/>
                                </form:label>
                            </td>
                            <td>
                                <form:checkbox path="drug_medicament" label="Лекарство"/>
                                <form:checkbox path="drug_vitamin" label="Витамин"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="drug_name">
                                    <spring:message text="Наименование"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="drug_name" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="drug_measuring">
                                    <spring:message text="Дозировка"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="drug_measuring" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="drug_dim">
                                    <spring:message text="Размерность"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="drug_dim" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="drug_annotation">
                                    <spring:message text="Аннотация"/>
                                </form:label>
                            </td>
                            <td>
                                <form:input path="drug_annotation"/>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <c:if test="${!empty drug.drug_name}">
                                    <input type="submit"
                                           value="<spring:message text="Сохранить"/>" />
                                </c:if>
                                <c:if test="${empty drug.drug_name}">
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
            <c:if test="${!empty listDrugs}">
                <table class="table">
                    <tr>
                        <th width="100">Лекарство</th>
                        <th width="60">Тип</th>
                        <th width="120">Дозировка</th>
                        <td width="60%">Аннотация</td>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listDrugs}" var="drug">
                        <tr>
                            <td>${drug.drug_name}</td>
                            <td>${drug.message}</td>
                            <td>${drug.drug_measuring} ${drug.drug_dim}</td>
                            <td>
                                <button data-toggle="collapse" data-target="#drug_annotation${drug.id}">Развернуть</button>
                                <div id="drug_annotation${drug.id}" class="collapse">${drug.drug_annotation}</div>
                            </td>
                            <td><a href="<c:url value='/drug/edit/${drug.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/drug/remove/${drug.id}' />" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </td>
    </tr>
</table>

</body>
</html>
