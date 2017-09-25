<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page session="false" %>


<jsp:include page="../header.jsp"/>


<h1>
    <c:if test="${empty id}">Добавить</c:if>
    <c:if test="${not empty id}">Редактировать</c:if>
    пост</h1>

<spring:url value="/posts/save" var="postActionUrl"/>

<form:form method="post" commandName="postForm" modelAttribute="postForm" action="${postActionUrl}"
           acceptCharset="utf-8" class="form-horizontal">

    <fieldset>
        <form:hidden path="id"/>


        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>


        <div class="control-group  ${status.error ? 'has-error' : ''}">
            <label class="control-label" for="title">Заголовок:</label>
            <div class="controls">
                <form:input path="title" class="form-control" type="text" placeholder=""
                            required="required"/>

                <form:errors path="title" class="error"/>
            </div>
        </div>

        <div class="control-group  ${status.error ? 'has-error' : ''}">
            <label class="control-label" for="text">Тело поста:</label>
            <div class="controls">
                <form:textarea path="text" class="form-control" placeholder=""
                               required="required" rows="15"/>

                <form:errors path="text" class="error"/>
            </div>
        </div>

        <div class="control-group  ${status.error ? 'has-error' : ''}">
            <label class="control-label" for="tags">Теги:</label>
            <div class="controls">
                <form:input path="tags" class="form-control" placeholder=""/>

                <form:errors path="tags" class="error"/>
            </div>
        </div>

        <!-- Button -->
        <div class="control-group">
            <label class="control-label" for="submit"></label>
            <div class="controls">
                <button id="submit" type="submit" name="submit" class="btn btn-lg btn-success btn-block btn-signin">
                    Сохранить
                </button>
            </div>
        </div>
    </fieldset>


    <%-- <table>
         <tr>
             <td>Заголовок:</td>
             <td><form:input path="title"/></td>
             <td><span class="error"><form:errors path="title"/></span></td>
         </tr>

         <tr>
             <td>Содержание:</td>
             <td><form:textarea path="text"/></td>
             <td><span class="error"><form:errors path="text"/></span></td>
         </tr>

         <tr>
             <td>Теги:</td>
             <td><form:input path="tags"/></td>
             <td><span class="error"><form:errors path="tags"/></span></td>
         </tr>

         <tr>
             <td colspan="3"><input type="submit" value="Submit"/></td>
         </tr>
     </table>--%>
</form:form>


<jsp:include page="../footer.jsp"/>
