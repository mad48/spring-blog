<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no, minimal-ui">
    <spring:url value="/resources/css/style.css" var="coreCss"/>
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <!-- Mimetype needed for tomcat to serve favicon images -->
    <link rel="shortcut icon" type="image/x-icon" href="/resources/favicon.ico"/>
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css" />

</head>
<body>

<spring:url value="/" var="urlHome"/>
<spring:url value="/login" var="urlLogin"/>
<spring:url value="/posts/add" var="urlAddPost"/>
<spring:url value="/posts" var="urlListPosts"/>

<div class="container container-table">

    <nav class="navbar navbar-inverse ">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="${urlHome}">Главная</a>
            </div>

            <sec:authorize access="hasRole('ROLE_USER')">
                <div class="navbar-header">
                    <a class="navbar-brand" href="${urlListPosts}">Посты</a>
                </div>
            </sec:authorize>

            <div id="navbar">
                <ul class="nav navbar-nav navbar-right">

                    <c:if test="${pageContext.request.userPrincipal.name == null}">

                        <li><a href="/signup">Регистрация</a></li>
                        <li><a href="${urlLogin}">Войти</a></li>
                    </c:if>

                    <sec:authorize access="hasRole('ROLE_USER')">
                        <!-- For login user -->
                        <c:url value="/j_spring_security_logout" var="logoutUrl"/>
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                        <script>
                            function formSubmit() {
                                document.getElementById("logoutForm").submit();
                            }
                        </script>

                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li>
                                <a>${pageContext.request.userPrincipal.name}</a>
                            </li>
                            <li>
                                <a href="javascript:formSubmit()">Выйти</a>
                            </li
                        </c:if>


                    </sec:authorize>


                </ul>
            </div>
        </div>
    </nav>