<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../header.jsp"/>



    <c:if test="${not empty msg}">
    <div class="alert alert-${css} alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <strong>${msg}</strong>
    </div>
    </c:if>


    <div class="row">
        <%--<label class="col-sm-12">${post.id}</label>--%>
        <div class="col-sm-12"><h1>${post.title}</h1></div>
    </div>
    <div class="row">
        <%--<label class="col-sm-2"></label>--%>
        <div class="col-sm-2"><em>Автор: <a href="/user/${post.owner}">${post.owner}</a></em></div>
        <div class="col-sm-10"><em>Теги: ${post.tags}</em></div>
    </div>

    <%--    <div class="row">
            <label class="col-sm-2">Title</label>
            <div class="col-sm-10">${post.title}</div>
        </div>--%>

    <div class="row">
        <div class="col-sm-12 text">${post.text}</div>
    </div>

    <%--    <div class="row">
            <label class="col-sm-2">tags</label>

        </div>--%>


    <jsp:include page="../comments/commentform.jsp"/>

    <jsp:include page="../comments/commentlist.jsp"/>


    <jsp:include page="../footer.jsp"/>
