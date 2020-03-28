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
				<form:option value="${ park.parkCode }"><c:out value="${ park.parkName }"/></form:option>
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
		
	<input type="submit" value="submit"/>

</form:form>



<c:import url="/WEB-INF/jsp/common/footer.jsp"/>