<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Park Details" />
</c:import>


<c:url var="parkImg" value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg"/>
<img src="${ parkImg }" alt="park image">


<c:import url="/WEB-INF/jsp/common/footer.jsp"/>