<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Favorites" />
</c:import>

<h2>Favorite Parks</h2>

<div>

<%-- 	<c:url var="parkDetailURL" value="/parkDetail?parkCode=${ park.parkCode }"/> --%>
<%--     <c:url var="parkImg" value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg"/> --%>
    <c:url var="parkImg" value="/img/parks/ynp.jpg"/>

    <img src="${ parkImg }" alt="park image">
    <c:set var="parkCode" value="${park.parkCode}"/>
    <h3>Yellowstone National Park</h3>
    <p>5</p>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>