<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<jsp:include page="header.jsp"/>


<h1>Регистрация</h1>

<div id="signup" class="col-sm-5">
    <form:form method="post" commandName="signupForm" class="form-horizontal">
        <fieldset>


            <!-- login input-->
            <div class="control-group  ${status.error ? 'has-error' : ''}">
                <label class="control-label" for="username">Логин:</label>
                <div class="controls">
                    <form:input path="username" id="username" name="username" class="form-control input-large"
                                type="text"
                                placeholder=""
                                required="" value=""/>

                    <form:errors path="username" class="error"/>
                </div>
            </div>

            <!-- Password input-->
            <div class="control-group">
                <label class="control-label" for="password">Пароль:</label>
                <div class="controls">
                    <form:password path="password" id="password" name="password" class="form-control input-large"
                                   placeholder=""
                                   required="" value=""/>
                    <form:errors path="password" class="error"/>
                        <%--  <em>1-8 Characters</em>--%>
                </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
                <label class="control-label" for="reenterpassword">Подтверждение пароля:</label>
                <div class="controls">
                    <form:password path="confirmPassword" id="reenterpassword" class="form-control"
                                   name="reenterpassword"
                                   placeholder="" required="" value=""/>
                    <form:errors path="confirmPassword" class="error"/>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="Email">E-mail:</label>
                <div class="controls">
                    <form:input path="email" id="Email" name="Email" class="form-control" type="email"
                                placeholder="" value=""/>
                    <form:errors path="email" cssClass="alert alert-error" element="div"/>
                    <form:errors path="email" class="error"/>

                </div>
            </div>

            <!-- Button -->
            <div class="control-group">
                <label class="control-label" for="confirmsignup"></label>
                <div class="controls">
                    <button id="confirmsignup" name="confirmsignup" class="btn btn-success">Зарегистрироваться
                    </button>
                </div>
            </div>
        </fieldset>
    </form:form>
</div>

<%--    <form:form method="post" commandName="signupForm">
    <table>
        <tr>
            <td>Username:</td>
            <td><form:input path="username"/></td>
            <td><span class="error"><form:errors path="username"/></span></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:password path="password"/></td>
            <td><span class="error"><form:errors path="password"/></span></td>
        </tr>

        <tr>
            <td>Confirm Password:</td>
            <td><form:password path="confirmPassword"/></td>
            <td><span class="error"><form:errors
                    path="confirmPassword"/></span></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
            <td><span class="error"><form:errors path="email"/></span></td>
        </tr>

        <tr>
            <td colspan="3"><input type="submit" value="Submit"/></td>
        </tr>
    </table>
    </form:form>

    <a href="${pageContext.request.contextPath}/" title="Home">Home</a>--%>

<jsp:include page="footer.jsp"/>
