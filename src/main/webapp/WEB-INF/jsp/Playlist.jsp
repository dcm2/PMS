<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    	<link rel="stylesheet" href="<c:url value="/css/main.css" />">
        <title>Playlist page</title>
    </head>
    <body>

	<h1><c:out value="${sessionScope.playlist.title}"/></h1>
	<p>created by: <c:out value="${sessionScope.playlist.creator.userName}"/></p>

	<sf:form method="POST" modelAttribute="songInfoToAdd">
		<sf:input path="songToSearch" type="text" placeholder="search a song"/>
		<input type="submit" VALUE="ADD"/>
	</sf:form>

<hr>
   	<c:choose>		
  		<c:when test="${not empty sessionScope.playlist.songList}">
		
			<c:forEach items="${sessionScope.playlist.songList}" var="song"> 
			  <tr>
			    <td>${song.title} by
			    ${song.songInfo.artist} &#8226; 
			    ${song.votes} votes
			    <button type="button">Upvote</button><button type="button">Downvote</button><br/></td>
			  </tr>
			</c:forEach>
		
   		</c:when>	
      	<c:otherwise>
   			<p>You have no songs yet :( </p>
   		</c:otherwise>
   	</c:choose>

   	<c:choose>		
  		<c:when test="${sessionScope.sessionUser != null}">
			<a href="/userPlaylists">return</a>	
   		</c:when>	
      	<c:otherwise>
   			<a href="/newUserPlaylists">return</a>
   		</c:otherwise>
   	</c:choose>



	

    </body>

</html>