<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>User Page</title>
    </head>
    <body>

    <h1>User Page</h1>
    <p>Here goes information about the user</p>
    

  	 <c:choose>
   		<c:when test="${not empty userInfo}">
   			<p>Welcome ${userInfo.userName}</p>
   		</c:when>	
      	<c:otherwise>
   			<p>Welcome ${newUserInfo.userName}</p>
   		</c:otherwise>
   	</c:choose>

    <table border="1px gray">
        <thead>
            <tr style="font-weight: 600;">
                <td>Your Playlists</td>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td></td>
            </tr>
        </tbody>
    </table>


    </body>

</html>