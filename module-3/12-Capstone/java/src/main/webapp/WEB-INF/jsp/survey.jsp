<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Survey" />
</c:import>

<c:url value="/survey" var="surveyURL"/>

<form:form modelAttribute="survey" action="${ surveyURL }" method="POST" >

	<div class="form-group">
		<form:label path="parkCode">Favorite National Park</form:label>
		<form:select path="parkCode">
			<c:forEach var="park" items="${ parks }">
				<form:option value="${ park.parkName }"><c:out value="${ park.parkName }"/></form:option>
			</c:forEach>
		</form:select>
		<form:errors path="parkCode"/>
	</div>
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="lastName">Last Name</form:label> --%>
<%-- 		<form:input path="lastName"/> --%>
<%-- 		<form:errors path="lastName"/> --%>
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="email">Email</form:label> --%>
<%-- 		<form:input path="email"/> --%>
<%-- 		<form:errors path="email"/> --%>
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="confirmEmail">Confirm Email</form:label> --%>
<%-- 		<form:input path="confirmEmail"/> --%>
<%-- 		<form:errors path="emailMatching"/> --%>
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="password">Password</form:label> --%>
<%-- 		<form:input path="password"/> --%>
<%-- 		<form:errors path="password"/> --%>
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="confirmPassword">Confirm Password</form:label> --%>
<%-- 		<form:input path="confirmPassword"/> --%>
<%-- 		<form:errors path="passwordMatching"/> --%>
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="birthDate">Birth Date (YYYY-MM-DD format)</form:label> --%>
<%-- 		<form:input path="birthDate"/> --%>
<%-- 		<form:errors path="birthDate"/> --%>
<!-- 	</div> -->
	
<!-- 	<div class="form-group"> -->
<%-- 		<form:label path="numOfTickets">Number of Tickets</form:label> --%>
<%-- 		<form:input type="number" path="numOfTickets"/> --%>
<%-- 		<form:errors path="numOfTickets"/> --%>
<!-- 	</div> -->
	
	<input type="submit" value="submit"/>

</form:form>



<c:import url="/WEB-INF/jsp/common/footer.jsp"/>