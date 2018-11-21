<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
    	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
        <title>User Page</title>
    </head>
    <body>

	<h1>Welcome ${userInfo.userName}</h1>

   	<c:choose>
   		<c:when test="${not empty userInfo.playlists}">
   			<p>your playlists are: ${userInfo.userName}</p>
   		</c:when>	
      	<c:otherwise>
   			<p>you have no playlists yet :(. Look: ${userInfo.playlists}, see? I told you</p>
   		</c:otherwise>
   	</c:choose>


    </body>

</html>