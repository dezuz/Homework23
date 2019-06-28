<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Delete product</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="../../static/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="<c:url value="../../static/css/main.css" />" rel="stylesheet">

</head>

<body class="text-center">
<spring:form class="form-signin" method="post" modelAttribute="product">
    <h1 class="h3 mb-3 font-weight-normal"></h1>

    <c:forEach items="${products}" var="p">
        <div class="row mb-3" >
            <div class="col-md-2 themed-grid-col">${p.id}</div>
            <div class="col-md-5 themed-grid-col">${p.name}</div>
            <div class="col-md-3 themed-grid-col">${p.price}</div>
            <div class="col-md-2 themed-grid-col">${p.producer.getId()}</div>
        </div>
    </c:forEach>

    <label for="id" class="sr-only">Id</label>
    <spring:input path="id" type="text" id="id" class="form-control" placeholder="ID" />

    <button class="btn btn-lg btn-primary btn-block" type="submit">Delete</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
</spring:form>
</body>
</html>