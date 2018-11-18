<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
        <title>PMS</title>
    </head>   
    <body>
	<h1>WELCOME TO PMS</h1>

    <%-- modelAttribute userInfo is added to the model in landingView() method from LandingController --%>
    <sf:form method="POST" modelAttribute="userInfo" action="/userPage"> 
     	<sf:errors path="userName" class="error"></sf:errors><br/>   
		<sf:input path="userName" type="text" placeholder="username"/><br/>
		<sf:errors path="password" class="error"></sf:errors><br/>
		<sf:input path="password" type="password" placeholder="password"/><br/>
		<input type="submit" VALUE="Log In"/>		
    </sf:form>

	<p> If you are not registered <a href="/newAccount">CREATE A NEW ACCOUNT HERE</a></p>

</html>