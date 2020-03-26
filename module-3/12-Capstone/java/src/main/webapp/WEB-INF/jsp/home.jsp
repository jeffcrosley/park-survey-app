<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<!-- JEFF TODO: FIX THIS AND OTHER JSPS TO DO A DYNAMIC HEADER TITLE VIA THE CONTROLLER -->

<c:forEach var="park" items="${ parks }">

<div class="park-tile">
    <c:url var="parkImg" value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg"/>
    <img src="${ parkImg }" alt="park image">
    <div class="park-info">
        <h3><c:out value="${ park.parkName }"/></h3>
        <p><c:out value="${ park.parkDescription }"/></p>
    </div>
</div>

</c:forEach>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>