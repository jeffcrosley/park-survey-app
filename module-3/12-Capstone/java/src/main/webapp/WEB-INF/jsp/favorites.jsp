<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Favorites" />
</c:import>

<h2>Favorite Parks</h2>

<div>
	<c:forEach var="park" items="${ parks }">
		<c:url var="parkImg" value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg"/>
	    <img src="${ parkImg }" alt="park image">    
 
   		<h3><c:out value="${ park.parkName }"/></h3>
    	<p><c:out value="${ park.numberOfSurveys }"/></p>
    </c:forEach>
    


</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>