<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
        <title>User Page</title>
    </head>
    <body>

	<h1>Welcome <c:out value="${sessionScope.newUserInfo.userName}"/></h1>

	<sf:form method="POST" modelAttribute="playlistToCreate" action="/newUserPlaylists">
		<sf:input path="title" type="text" placeholder="title of the playlist"/>
		<input type="submit" VALUE="CREATE"/>
	</sf:form>


   	<c:choose>
   		<%--If the newUserInfo that's on the model as an attribute has playlists--%>
   		<c:when test="${not empty sessionScope.newUserInfo.playlists}">
		
			<c:forEach items="${sessionScope.newUserInfo.playlists}" var="playlist"> 
			  <tr>
			    <td><a href= "/playlist/${playlist.title}"> ${playlist.title}</a> <span> created by: </span>
			    	<a href= "/users/${playlist.creator.userName}"> ${playlist.creator.userName}</a><br />
			    	<%--<button type="button">delete!</button>--%>
			    </td>
			  </tr>
			</c:forEach>
		
		
		
   		</c:when>	
      	<c:otherwise>
   			<p>You have no playlists yet :(</p>
   		</c:otherwise>
   	</c:choose>


    </body>

</html>