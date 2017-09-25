<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../header.jsp"/>


<h1>Профиль пользователя</h1>


<div class="row">
    <label class="col-sm-2">Имя</label>
    <div class="col-sm-10">${user.username}</div>
</div>
<div class="row">
    <label class="col-sm-2">E-mail</label>
    <div class="col-sm-10">${user.email}</div>
</div>

<div class="row">
    <label class="col-sm-2">Количество постов</label>
    <div class="col-sm-10">${postcount}</div>

<jsp:include page="../footer.jsp"/>