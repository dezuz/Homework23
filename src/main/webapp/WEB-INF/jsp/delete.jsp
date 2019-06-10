<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Delete user</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="../../static/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="../../static/css/update.css" />" rel="stylesheet">
</head>

<body class="text-center">
<spring:form class="form-signin" method="post" modelAttribute="userDeleted">
    <h1 class="h3 mb-3 font-weight-normal">Write user ID</h1>

    <spring:select path="id" name="users" class="select" >
        <c:forEach items="${users}" var="u">
            <option value="${u.id}">${u.id}</option>
        </c:forEach>
    </spring:select>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
</spring:form>
</body>
</html>