<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Справочник шаблонов животных</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>
            Добавить шаблон животного
        </h4>

        <table class="table">
            <tr>
                <td>
                    <c:url var="addAction" value="/animal/add"></c:url>

                    <form:form action="${addAction}" commandName="animal" enctype="multipart/form-data">
                        <table>
                            <c:if test="${!empty animal.animal_name_lat}">
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
                                    <form:label path="animal_name_lat">
                                        <spring:message text="Имя (лат.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="animal_name_lat" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="animal_name_ru">
                                        <spring:message text="Имя (рус.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="animal_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="RBC">
                                        <spring:message text="Красные кровяные тельца"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="RBC" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="nucleus">
                                        <spring:message text="Ядра"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="nucleus" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_id">
                                        <spring:message text="Вид"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select path="specie_id">
                                        <c:forEach items="${listSpecies}" var="ispecie">
                                            <form:option value="${ispecie.id}">${ispecie.specie_name_lat}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>Загрузить фотографию</td>
                                <td>
                                    <input type="file" name="file1" />
                                    <input type="file" name="file2" />
                                    <input type="file" name="file3" />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${!empty animal.animal_name_lat}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty animal.animal_name_lat}">
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

    <table width="90%" align="center">
        <tr>
            <td class="tg">
                <h4>Список шаблонов животных</h4>
                <c:if test="${!empty listAnimals}">
                    <table class="table">
                        <tr>
                            <th width="80">ID</th>
                            <th width="120">Имя (лат.)</th>
                            <th width="120">Имя (рус.)</th>
                            <th width="120">Красные кровянные тельца</th>
                            <th width="120">Ядра</th>
                            <th width="120">Вид</th>
                            <th width="60">Edit</th>
                            <th width="60">Delete</th>
                        </tr>
                        <c:forEach items="${listAnimals}" var="animal">
                            <tr>
                                <td>${animal.id}</td>
                                <td>${animal.animal_name_lat}</td>
                                <td>${animal.animal_name_ru}</td>
                                <td>${animal.RBC}</td>
                                <td>${animal.nucleus}</td>
                                <td>${animal.specie.specie_name_lat}</td>
                                <td><a href="<c:url value='/animal/edit/${animal.id}' />" >Edit</a></td>
                                <td><a href="<c:url value='/animal/remove/${animal.id}' />" >Delete</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
            </td>
        </tr>
    </table>

</body>
</html>
