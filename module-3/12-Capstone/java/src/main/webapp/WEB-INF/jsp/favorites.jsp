<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Favorites" />
</c:import>

<h2>Favorite Parks</h2>
<h3>Thanks for filling out our survey! Here are the results:</h3>

<div class="favorites">
	<c:forEach var="park" items="${ parks }">
	
		<div class="favorite-tile">
			<c:url var="parkImg" value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg"/>
		    <img src="${ parkImg }" alt="park image">    
	 
	   		<h3><c:out value="${ park.parkName }"/></h3>
	    	<p>Votes<br><c:out value="${ park.numberOfSurveys }"/></p>
		</div>
		
	</c:forEach>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>