<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>PSM</title>
    </head>   
    <body>
	<h1>WELCOME TO PMS</h1>
	

    <h2>SIGN IN here:</h2>   
    <form action="/home" method="get">
    		<input type="text" name="user" />
    		<input type="text" name="password" />
    		<input type="submit" value="OK" />    
    </form>
      
	<h2>You can SIGN UP here:</h2> 
    <form action="/home" method="get">
    		<input type="text" name="username" />
    		<input type="text" name="email" />
    		<input type="text" name="password" />
    		<input type="submit" value="OK" />    
    </form> 
    </body>
</html>