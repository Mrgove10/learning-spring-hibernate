<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Edit Product</h3>

<p style="color: red;">${errorString}</p>

<c:if test="${not empty product}">
    <form:form method="POST" action="${pageContext.request.contextPath}/editProduct">
        <form:input type="hidden" path="code" value="${product.code}"/>
        <table border="0">
            <tr>
                <td><form:label path="code">Code</form:label></td>
                <td style="color:red;">${product.code}</td>
            </tr>
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input type="text" path="name" value="${product.name}"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Price</form:label></td>
                <td><form:input type="text" path="price" value="${product.price}"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <form type="submit" value="Submit"/>
                    <a href="${pageContext.request.contextPath}/productList">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>
</c:if>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>