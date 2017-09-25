<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp"/>

<div class="container">
    <div class="card card-container">
        <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
        <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"/>
        <p id="profile-name" class="profile-name-card"></p>
        <form:form method="post" commandName="loginForm" class="form-signin">
            <span id="reauth-email" class="reauth-email"></span>
            <form:input path="login" id="login" type="text" class="form-control" placeholder="Логин"
                        required="required"
                        autofocus="autofocus"/>
            <form:errors
                    path="login"/>
            <form:input path="password" type="password" id="password" class="form-control" placeholder="Пароль"
                        equired="required"/>
            <%--            <div id="remember" class="checkbox">
                            <label>
                                <input type="checkbox" value="remember-me"> Recordarme
                            </label>
                        </div>--%>
            <button class="btn btn-lg btn-success btn-block btn-signin" type="submit">Войти</button>
        </form:form><!-- /form -->
        <a href="/signup" class="forgot-password">
            Регистрация
        </a>
    </div><!-- /card-container -->
</div>
<!-- /container -->

<%--<h3>Login Form</h3>
<FONT color="blue">
    User Name="UserName" and password="password"
</FONT>
<form:form method="post" commandName="loginForm">
    <table>
        <tr>
            <td>User Name:<FONT color="red"><form:errors
                    path="login"/></FONT></td>
        </tr>
        <tr>
            <td><form:input path="login"/></td>
        </tr>
        <tr>
            <td>Password:<FONT color="red"><form:errors
                    path="password"/></FONT></td>
        </tr>
        <tr>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>--%>


<jsp:include page="footer.jsp"/>