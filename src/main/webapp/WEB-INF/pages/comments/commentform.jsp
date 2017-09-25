<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>


<style type="text/css">
    span.error {
        color: red;
    }
</style>

<br><br><a name="comments"></a>
<h3>Добавить комментарий</h3>

<div class="row">
    <div class="col-xs-6">
        <spring:url value="/comments/save" var="commentActionUrl"/>

        <form:form method="post" commandName="commentForm" modelAttribute="commentForm" action="${commentActionUrl}"
                   acceptCharset="utf-8" class="form-horizontal">

        <fieldset>
                <form:hidden path="postid" name="postid" value="${post.id}"/>


            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


            <div class="control-group  ${status.error ? 'has-error' : ''}">
                <label class="control-label" for="name">Имя:</label>
                <div class="controls">
                    <form:input path="name" id="name" class="form-control" type="text" placeholder=""
                                required="required"/>

                    <form:errors path="name" class="error"/>
                </div>
            </div>

            <div class="control-group  ${status.error ? 'has-error' : ''}">
                <label class="control-label" for="email">E-mail:</label>
                <div class="controls">
                    <form:input path="email" id="email" class="form-control" placeholder=""/>

                    <form:errors path="email" class="error"/>
                </div>
            </div>

            <div class="control-group  ${status.error ? 'has-error' : ''}">
                <label class="control-label" for="text">Комментарий:</label>
                <div class="controls">
                    <form:textarea path="text" id="text" class="form-control" placeholder=""
                                   required="required"/>

                    <form:errors path="text" class="error"/>
                </div>
            </div>


        <!-- Button -->
        <div class="control-group">
            <label class="control-label" for="submit"></label>
            <div class="controls">
                <button id="submit" type="submit" name="submit"
                        class="btn btn-lg btn-success btn-block btn-signin">
                    Добавить
                </button>
            </div>
        </div>
        </fieldset>

        </form:form>

    </div>
</div>
<br><br>