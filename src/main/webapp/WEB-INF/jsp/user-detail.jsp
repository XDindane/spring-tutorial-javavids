<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../layout/taglib.jsp" %>

<h1>${user.name}</h1>

<c:forEach var="blog" items="${user.blogs}">

    <h2>${blog.name}</h2>
    <p>${blog.url}</p>

    <table class="table table-bordered table-hover table-striped">
        <thead>
            <tr>
                <th>Title</th>
                <th>Link</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${blog.items}">
                <tr>
                    <td>${item.title}</td>
                    <td>${item.link}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</c:forEach>