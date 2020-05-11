<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/style/elite1.css" />"
 rel="stylesheet">
</head>
<body background="<c:url value="/resources/images/bg.jpg"/>"/>
<img src="<c:url value="/resources/images/download2.png"/>"/>
<h2 align="center">Elite Customer Relationship Manager</h2>
<hr color="pink" size="3" />


<div style="color: blue" align="center">
Welcome Customer ID: ${eusr.id} User: ${eusr.phoneNo} </div>

<a href="${travelLink}">Travel</a><br> <br><br>
<a href="${leaveLink}">Travel</a>
</body>
</html>