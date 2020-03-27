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
	
	<div class="form-group">
		<form:label path="emailAddress">Email</form:label>
		<form:input path="emailAddress"/>
		<form:errors path="emailAddress"/>
	</div>
	
	<div class="form-group">
		<form:label path="state">State</form:label>
		<form:select path="state">
			<c:forEach var="state" items="${ states }">
				<form:option value="${ state }"><c:out value="${ state }"/></form:option>
			</c:forEach>
		</form:select>
		<form:errors path="state"/>
	</div>
	
	<div class="form-group">
		<form:label path="activityLevel">Activity Level</form:label>
		<c:forEach var="button" items="${ buttons }">
			<form:radiobutton path="activityLevel" value="${ button }" label="${ button }"/>
		</c:forEach>
		<form:errors path="activityLevel"/>
	</div>
	
	
	
<%--    <td><form:label path = "gender">Gender</form:label></td> --%>
<!--     <td> -->
<%--    <form:radiobutton path = "gender" value = "M" label = "Male" /> --%>
<%--    <form:radiobutton path = "gender" value = "F" label = "Female" /> --%>

<%-- 		<form:label for="1" path="activityLevel">1</form:label> --%>
<%-- 		<form:input type="radio" id="1" value="1" path="activityLevel"/> --%>
<%-- 		<form:label for="1" path="activityLevel">2</form:label> --%>
<%-- 		<form:input type="radio" id="1" value="1" path="activityLevel"/> --%>
<%-- 		<form:label for="1" path="activityLevel">3</form:label> --%>
<%-- 		<form:input type="radio" id="1" value="1" path="activityLevel"/> --%>
<%-- 		<form:errors path="activityLevel"/> --%>
<!-- 	</div> -->
	
	
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