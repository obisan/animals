<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Список видов</title>
</head>
<body>

    <jsp:include page="menu.jsp" />

    <div class="container">
        <h4>Список видов</h4>
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
                                <td>
                                    <form:errors cssClass="error" path="specie_name_lat" />
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
                                <td>
                                    <form:errors cssClass="error" path="specie_name_ru" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form:label path="specie_author">
                                        <spring:message text="Автор, год"/>
                                    </form:label>
                                </td>
                                <td>
                                    <form:input path="specie_author" />
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
                                    <form:label path="tags2">
                                        <spring:message text="Метки" />
                                    </form:label>
                                </td>
                                <td>
                                    <table>
                                        <c:set var="count2" value="0" scope="page" />
                                        <c:forEach items="${listTags}" var="tag">
                                            <c:if test="${count2%4 == 0}"><tr title="ss"></c:if>
                                            <c:set var="count2" value="${count2 + 1}" scope="page" />
                                            <td><form:checkbox class="tagbox" path="tags2" value="${tag.id}" label="${tag.tag_name}" /></td>
                                            <c:if test="${count2%4 == 0}"></tr></c:if>
                                        </c:forEach>
                                    </table>
                                    <script type="text/javascript">
                                        var tagArr = [], tagObj;
                                        <c:forEach items="${listCheckedTags}" var="tag">
                                            tagObj = { id: '${tag.id}' };
                                            tagArr.push(tagObj);
                                        </c:forEach>

                                        //Populate the corresponding javascript object.
                                        var data = {
                                            tags: tagArr
                                        };

                                        var all = document.getElementsByClassName("tagbox")
                                        for (var i=0; i < all.length; i++) {
                                            if (all[i].type == 'checkbox') {
                                                for(var j=0; j < data.tags.length; j++) {
                                                    if(data.tags[j].id == all[i].value) {
                                                        all[i].checked = true;
                                                        break;
                                                    }
                                                }
                                            }
                                        }

                                    </script>
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
            <c:if test="${!empty listSpecies}">
                <table class="tg">
                    <tr>
                        <th width="120">Вид (лат.)</th>
                        <th width="120">Вид (рус.)</th>
                        <th width="80">Кровянные тельца</th>
                        <th width="80">Ядра</th>
                        <th width="80">Метка</th>
                        <th width="60">Edit</th>
                        <th width="60">Delete</th>
                    </tr>
                    <c:forEach items="${listSpecies}" var="specie">
                        <c:set var="count" value="0" scope="page" />
                        <tr>
                            <td><a href="<c:url value="/specie/info/${specie.id}"/>" target="_blank">${specie.specie_name_lat}</a> ${specie.message}</td>
                            <td>${specie.specie_name_ru}</td>
                            <td>${specie.specie_rbc}</td>
                            <td>${specie.specie_nucleus}</td>
                            <td><c:forEach items="${specie.tags}" var="tag"><c:set var="count" value="${count + 1}" scope="page" />${tag.tag_name}   <c:if test="${count%4 == 0}"><br /></c:if></c:forEach></td>
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
