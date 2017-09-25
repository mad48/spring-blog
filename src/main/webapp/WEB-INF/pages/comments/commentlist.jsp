<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div>

    <c:if test="${not empty comments}">

        <br><br>
        <h3>Комментарии</h3>

        <c:forEach items="${comments}" var="comment">

            <div class="media-block">
                <a class="media-left" href="#"><img class="img-circle img-sm" alt="Профиль пользователя"
                                                    src="http://bootstraptema.ru/snippets/icons/2016/mia/2.png"></a>
                <div class="media-body">
                    <div class="mar-btm">
                        <a href="#" class="btn-link text-semibold media-heading box-inline">${comment.name}</a>
                            <%-- ${comment.id}
                                         ${comment.owner}--%>

                        <p class="text-muted text-sm"><i class="fa faemail fa-lg"></i>${comment.email}</p>
                    </div>
                    <p>${comment.text}</p>

                    <div class="pad-ver">
                        <%--<div class="btn-group">
                            <a class="btn btn-sm btn-default btn-hover-success active" href="#"><i
                                    class="fa fa-thumbs-up"></i>
                                Нравится</a>
                            <a class="btn btn-sm btn-default btn-hover-danger" href="#"><i
                                    class="fa fa-thumbs-down"></i></a>
                        </div>
                        <a class="btn btn-sm btn-default btn-hover-primary" href="#">Ответить</a>
--%>
                        <div>
                            <sec:authorize var="loggedIn" access="isAuthenticated()">

                                <spring:url value="/comments/${comment.id}/delete" var="deleteUrl"/>

                                <sec:authentication property="principal.username" var="username"/>

                                <c:if test="${loggedIn && username == post.owner}">
                                    <button class="btn btn-danger del"
                                            onclick="if (confirm('Do you want to delete?')) location.href='${deleteUrl}' ">
                                        Удалить
                                    </button>
                                </c:if>

                            </sec:authorize>
                        </div>

                    </div>
                    <hr>
                </div>
            </div>

        </c:forEach>
    </c:if>

</div>