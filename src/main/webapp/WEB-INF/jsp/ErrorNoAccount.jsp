<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html lang="en">

    <head>
    	<link rel="stylesheet" href="<c:url value="/css/errorNoAccount.css" />">
        <title>AccountCreated</title>
    </head>   
    <body>
		<p> No user registered with that username OR username and password doesn't match</p>
		<p> If you are not registered, please go <a href="/newAccount"> HERE</a> to create a new account</p>
	</body>

</html>









