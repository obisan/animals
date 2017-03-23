<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-combobox.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources/css/mycss.css" />

    <script type="text/javascript" src="${contextPath}/resources/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources/js/bootstrap-datetimepicker.min.js"></script>

    <script type="text/javascript" src="${contextPath}/resources/js/bootstrap-combobox.js"></script>
</head>

<body>
    <div class="container">
        <nav class="navbar navbar-default navbar-static">
            <div class="container-fluid">
                <div class="collapse navbar-collapse js-navbar">
                    <ul class="nav navbar-nav">
                        <li><a href="${contextPath}/index">Главная</a></li>
                        <li class="dropdown">
                            <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Журналы
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${contextPath}/objects"        >Журнал животных</a></li>
                                <li><a href="${contextPath}/displacements"  >Журнал перемещений</a></li>
                                <li><a href="${contextPath}/medications"    >Журнал лечений</a></li>
                                <li><a href="${contextPath}/vitaminizations" >Журнал витаминов</a></li>
                                <li><a href="${contextPath}/quarantines"    >Журнал карантинов</a></li>
                                <li><a href="${contextPath}/deceaseds"      >Журнал убытий</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Справочники
                                <span class="caret" />
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${contextPath}/species"    >Список видов</a></li>
                                <li class="divider"></li>
                                <li><a href="${contextPath}/tanks"      >Список танков</a></li>
                                <li class="divider"></li>
                                <li><a href="${contextPath}/tags"       >Список меток</a></li>
                                <li class="divider"></li>
                                <li><a href="${contextPath}/labels"     >Список этикеточных данных</a></li>
                                <li><a href="${contextPath}/certificates">Список сертификатов</a></li>
                                <li class="divider"></li>
                                <li><a href="${contextPath}/drugs"      >Список медикаментов</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Отчеты
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${contextPath}/report/deads">Отчет о гибелях</a></li>
                                <li><a href="#">Отчет о</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Отчет о</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Кормокухня
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${contextPath}/allowances"         >Список кормов</a></li>
                                <li><a href="${contextPath}/journalallowances"  >Назначение кормов</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a id="drop1" href="#" class="dropdown-toggle" data-toggle="dropdown">
                                Сотрудники
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${contextPath}/employees" >Список сотрудников</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</body>