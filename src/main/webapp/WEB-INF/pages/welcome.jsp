<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<jsp:include page="header.jsp"/>


<div class="container container-table">
    <div class="row vertical-center-row">

        <h1>Welcome</h1>

        <div><a href="${pageContext.request.contextPath}/signup" title="Sign Up">Регистрация</a></div>

        <div><a href="${pageContext.request.contextPath}/login" title="Login">Вход</a></div>

    </div>
</div>

<jsp:include page="footer.jsp"/>
