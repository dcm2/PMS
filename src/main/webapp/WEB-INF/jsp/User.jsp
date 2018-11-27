<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
        <title>User jsp page</title>
    </head>   
    <body>
    	<h1> Playlists from ${user.userName} </h1>
    
	  	<c:choose>		
		  		<c:when test="${sessionScope.sessionUser != null}">
		  		
		  		
					<c:forEach items="${sessionScope.sessionUser.playlists}" var="playlist"> 
					  <tr>
					    <td><a href= "/playlist/${playlist.title}"> ${playlist.title}</a> <span> created by: </span>
					    	<a href= "/users/${playlist.creator.userName}"> ${playlist.creator.userName}</a><br />
					    	<%--<button type="button">delete!</button>--%>
					    </td>
					  </tr>
					</c:forEach>			
		   		</c:when>	
	      	
	      	<c:otherwise>
	   			
					<c:forEach items="${sessionScope.newUserInfo.playlists}" var="playlist"> 
					  <tr>
					    <td><a href= "/playlist/${playlist.title}"> ${playlist.title}</a>
					     &#8226; 
					     created by ${playlist.creator.userName}  
					    <br/>
					    </td>
					  </tr>
					</c:forEach>


	   		</c:otherwise>
	   	</c:choose>

	</body>

</html>





