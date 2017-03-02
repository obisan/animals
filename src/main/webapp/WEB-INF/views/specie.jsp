<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Вид</title>
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
        <h4>Добавить вид</h4>
        <table>
            <tr>
                <td>
                    <c:url var="addAction" value="/specie/add"></c:url>

                    <form:form action="${addAction}" commandName="specie" enctype="multipart/form-data">
                        <table>
                            <c:if test="${!empty specie.specie_name_lat}">
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
                                    <form:label path="specie_name_lat">
                                        <spring:message text="Вид (лат.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="specie_name_lat" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_name_ru">
                                        <spring:message text="Вид (рус.)"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="specie_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_rbc">
                                        <spring:message text="Кровянные тельца"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="specie_rbc" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_nucleus">
                                        <spring:message text="Ядра"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="specie_nucleus" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="tag_id">
                                        <spring:message text="Метка"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="tag_id">
                                        <option></option>
                                        <c:forEach items="${listTags}" var="tag">
                                            <form:option value="${tag.id}">${tag.tag_name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="genus_id">
                                        <spring:message text="Род"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:select class="combobox" path="genus_id">
                                        <option></option>
                                        <c:forEach items="${listGenera}" var="igenus">
                                            <form:option value="${igenus.id}">${igenus.genusFullName}</form:option>
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
                                    <c:if test="${!empty specie.specie_name_lat}">
                                        <input type="submit"
                                               value="<spring:message text="Сохранить"/>" />
                                    </c:if>
                                    <c:if test="${empty specie.specie_name_lat}">
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
        <td>
            <h4>Список видов</h4>

            <c:if test="${!empty listSpecies}">
                <table class="tg">
                    <tr>
                        <th width="80">ID</th>
                        <th width="120">Вид (лат.)</th>
                        <th width="120">Вид (рус.)</th>
                        <th width="80">Кровянные тельца</th>
                        <th width="80">Ядра</th>
                        <th width="120">Род</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listSpecies}" var="specie">
                        <tr>
                            <td>${specie.id}</td>
                            <td>${specie.specie_name_lat}</td>
                            <td>${specie.specie_name_ru}</td>
                            <td>${specie.specie_rbc}</td>
                            <td>${specie.specie_nucleus}</td>
                            <td>${specie.genus.genus_name_lat}</td>
                            <td><a href="<c:url value='/specie/edit/${specie.id}' />" >Edit</a></td>
                            <td><a href="<c:url value='/specie/remove/${specie.id}' />" >Delete</a></td>
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
