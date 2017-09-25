<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>

<jsp:include page="header.jsp"/>


<div class="container">
    <div class="card card-container">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <%--<c:if test="${not empty error}">
            <div class="alert alert-error" style="border:2px solid #e9322d;background: #eed3d7;">
                    ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>--%>

        <img id="profile-img" class="profile-img-card" src="/resources/images/avatar.png"/>

        <form name='loginForm' action="<c:url value='/j_spring_security_check' />" method='POST'
              class="form-signin">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <input type='text' name='username' type="text" class="form-control" placeholder="Логин" value="test"
                   required="required" autofocus="autofocus">

            <input type='password' name='password' value="test" class="form-control" placeholder="Пароль"
                   equired="required"/>


            <button class="btn btn-lg btn-success btn-block btn-signin" type="submit" name="submit" value="submit">
                Войти
            </button>
        </form><!-- /form -->
        <a class="text-center" href="<c:url value='/signup' />" class="forgot-password">
            Регистрация
        </a>
    </div><!-- /card-container -->
</div>
<!-- /container -->

<jsp:include page="footer.jsp"/>