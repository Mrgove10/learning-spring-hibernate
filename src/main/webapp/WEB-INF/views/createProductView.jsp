<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>

<h3>Create Product</h3>

<p style="color: red;">${errorString}</p>

<%--@elvariable id="Product" type="org.epsi.b3.simplewebapp.products.Product"--%>
<form:form method="POST" action="${pageContext.request.contextPath}/createProduct" modelAttribute="Product">
    <table border="0">
        <tr>
            <td><form:label path="code">Code</form:label></td>
            <td><form:input type="text" name="code" value="${product.code}" path="code"/></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input type="text" name="name" value="${product.name}" path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="price">Price</form:label></td>
            <td><form:input type="text" name="price" value="${product.price}" path="price"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
                <a href="productList">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>