<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../header.jsp"/>


<h1>Список постов</h1>


<c:if test="${not empty error}">
</c:if>

<spring:url value="/posts/add" var="addUrl"/>
<button class="btn btn-info" onclick="location.href='${addUrl}'">Добавить</button>

<div class="table-responsive">
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Автор</th>
            <th>Заголовок</th>
            <%-- <th>Текст</th>--%>
            <th>Теги</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty posts}">
            <c:forEach items="${posts}" var="post">
                <tr>
                    <spring:url value="/user/${post.owner}" var="profileUrl"/>
                    <spring:url value="/posts/${post.id}" var="getUrl"/>
                    <spring:url value="/posts/${post.id}/update" var="updateUrl"/>
                    <spring:url value="/posts/${post.id}/delete" var="deleteUrl"/>

                    <td>${post.id}</td>
                    <td><a href="${profileUrl}">${post.owner}</a></td>
                    <td><a href="${getUrl}">${post.title}</a></td>
                        <%--<td>${post.text}</td>--%>
                    <td>${post.tags}</td>
                    <td>


                        <%--<button class="btn btn-info" onclick="location.href='${userUrl}'">Просмотр</button>--%>


                        <sec:authorize var="loggedIn" access="isAuthenticated()">

                            <sec:authentication property="principal.username" var="username"/>

                            <c:if test="${username == post.owner}">
                                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Edit</button>
                                <%--<button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>--%>
                                <button class="btn btn-danger del"
                                        onclick="if (confirm('Do you want to delete?')) location.href='${deleteUrl}' ">
                                    Delete
                                </button>
                            </c:if>

                        </sec:authorize>


                    </td>
                </tr>
            </c:forEach>
        </c:if>

        </tbody>
    </table>


    <jsp:include page="../footer.jsp"/>


    <%--
    <sec:authentication property="principal" var="user" scope="request"/>
    <c:choose>
        <c:when test="${!empty user && user != 'roleAnonymous'}">
            Logged in as: ${user.username}
        </c:when>
        <c:otherwise>
            <a href="/login.jsp">Log In</a>
        </c:otherwise>
    </c:choose>

    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
    </sec:authorize>


    <sec:authorize ifAnyGranted="ROLE_USER">
        ifAnyGranted="ROLE_USER"
    </sec:authorize>



    <sec:authentication property="principal.authorities" var="authorities" />
    <c:forEach items="${authorities}" var="authority" varStatus="vs">
    <p>${authority.authority}</p>
    </c:forEach>

    <security:authentication property="principal" var="user" scope="request"/>
    <c:choose>
       <c:when test="${!empty user && user != 'roleAnonymous'}">
          Logged in as: ${user.username}
       </c:when>
       <c:otherwise>
          <a href="/login.jsp">Log In</a>
       </c:otherwise>
    </c:choose>

                            <c:set var="authentication" value="${sessionScope['SPRING_SECURITY_CONTEXT'].authentication}"/>
                            <c:set var="userName" value="${authentication}"/>

                              out<c:out value="${nme}"/>
    --%>
