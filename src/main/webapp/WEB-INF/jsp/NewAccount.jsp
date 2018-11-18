<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
    	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
        <title>PSM</title>
    </head>   
    <body>
	<h1>Create a new account</h1>

	<%-- modelAttribute newUserInfo is added to the model in newAccountView() method from NewAccountController --%>
    <sf:form method="POST" modelAttribute="newUserInfo" action="/newUserPage">
		<sf:input path="userName" type="text" placeholder="username"/><br/><sf:errors path="userName" class="error"> </sf:errors>
		<sf:input path="password" type="text" placeholder="password"/>
		<sf:input path="email" type="text" placeholder="email"/>
		<input type="submit" VALUE="Sign Up"/>
    </sf:form>

</html>