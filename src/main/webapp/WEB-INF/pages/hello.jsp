<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"/>


<div class="container container-table">
    <div class="row vertical-center-row">


        <h1>${title}</h1>
        <h1>
            ${message}<sec:authorize access="isAuthenticated()">, <sec:authentication property="principal.username"/></sec:authorize>!
        </h1>

        <sec:authorize access="! isAuthenticated()">
            <div><a href="${pageContext.request.contextPath}/signup" title="Sign Up">Регистрация</a></div>

            <div><a href="${pageContext.request.contextPath}/login" title="Login">Вход</a></div>
        </sec:authorize>

    </div>
</div>

<jsp:include page="footer.jsp"/>