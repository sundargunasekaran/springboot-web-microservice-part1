<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Customer List</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%-- <jsp:include page="menu.jsp" /> --%>
 <div class="container">
  <h2>Customer List</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Customer Id</th>
     <th scope="row">Customer Name</th>
     <th scope="row">Email</th>
     <th scope="row">Role</th>
     <th scope="row">Policy</th>
     <th scope="row">Edit</th>
     <th scope="row">Delete</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${customers }" var="customer" >
    <c:set var="myVar" value="" />
     <tr>
      <td>${customer.customerId }</td>
      <td>${customer.username }</td>
      <td>${customer.emailId }</td>
      <td>${customer.role }</td>
       <c:forEach items="${customer.policyModelList }" var="policy" >
       	<c:set var="myVar" value="${myVar}${empty myVar ? '' : ','}${policy.policyName}" />
       </c:forEach>
      <td>${myVar}</td>
      <td>
       <spring:url value="/update/1" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
      </td>
      <td>
       <spring:url value="/delete/1" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Add New Customer</a>
 </div>
</body>
</html>