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
   			<%--Create a table for the Postit Notes--%>
            <table class="playlists">

                <%--For each playlist, that's in the newUserInfo that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--var="playlist" refers to a singular item out of the list `playlists`--%>
                <c:forEach var="newUserInfo" items="${sessionScope.newUserInfo.playlists}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>
                        <%--Create a link based on the name attribute value--%>
                        <td><a href="/playlist/${sessionScope.newUserInfo.playlists}">${sessionScope.newUserInfo.playlists}</a></td>
                    </tr>
                </c:forEach>
            </table>			
   		</c:when>	
      	<c:otherwise>
   			<p>You have no playlists yet :(</p>
   		</c:otherwise>
   	</c:choose>


    </body>

</html>