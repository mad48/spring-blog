<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<jsp:include page="header.jsp"/>


<h1>Posts List</h1>

<table>
    <tr>
        <td>id</td>
        <td>Заголовок</td>
        <td>Текст</td>
        <td>Теги</td>
    </tr>
    <c:if test="${not empty posts}">
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.id}</td>
                <td>${post.title}</td>
                <td>${post.text}</td>
                <td>${post.tags}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>

<jsp:include page="footer.jsp"/>
