<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Login</title>
   </head>
   <body>
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Login Page</h3>
      <p style="color: red;">${errorString}</p>
 
 
      <form:form method="POST" action="${pageContext.request.contextPath}/login">
         <table border="0">
            <tr>
               <td><form:label path="userName">User Name</form:label></td>
               <td><form:input type="text" path="userName" value= "${user.userName}" /> </td>
            </tr>
            <tr>
               <td><form:label path="password">Password</form:label></td>
               <td><form:input type="text" path="password" value= "${user.password}" /> </td>
            </tr>
            <tr>
               <td><form:label path="rememberMe">Remember me</form:label></td>
               <td><form:input type="checkbox" path="rememberMe" value= "Y" /> </td>
            </tr>
            <tr>
               <td colspan ="2">
                  <form type="submit" value= "Submit" />
                  <a href="${pageContext.request.contextPath}/">Cancel</a>
               </td>
            </tr>
         </table>
      </form:form>
 
      <p style="color:blue;">User Name: john, password: doe or alice/bob</p>
 
      <jsp:include page="_footer.jsp"></jsp:include>
   </body>
</html>