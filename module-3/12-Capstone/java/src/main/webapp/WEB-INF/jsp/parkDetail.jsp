<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Park Details" />
</c:import>


<c:url var="parkImg"
	value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg" />
<img src="${ parkImg }" alt="park image">

<div class="park-info">
	<h3>
		<c:out value="${ park.parkName }" />
	</h3>
	<p>
		<c:out value="${ park.parkDescription }" />
	</p>
	<p>
		<c:out value="${ park.state }" />
	</p>
	<p>
		<c:out value="${ park.acreage }" />
	</p>
	<p>
		<c:out value="${ park.elevationInFeet }" />
	</p>
	<p>
		<c:out value="${ park.milesOfTrail }" />
	</p>
	<p>
		<c:out value="${ park.numberOfCampsites }" />
	</p>
	<p>
		<c:out value="${ park.climate }" />
	</p>
	<p>
		<c:out value="${ park.yearFounded }" />
	</p>
	<p>
		<c:out value="${ park.annualVisitorCount }" />
	</p>
	<p>
		<c:out value="${ park.inspirationalQuote }" />
	</p>
	<p>
		<c:out value="${ park.inspirationalQuoteSource }" />
	</p>
	<p>
		<c:out value="${ park.parkDescription }" />
	</p>
	<p>
		<c:out value="${ park.entryFee }" />
	</p>
	<p>
		<c:out value="${ park.numberOfAnimalSpecies }" />
	</p>
</div>

<div class="weather-info">

<c:forEach var="weather" items="${ fiveDayForecast }">

	<section class="section">
		<div>
			<b>${weather.forecast}</b>
			<span class="weather-detail-img">
				<c:set value="${weather.forecast}" var="forecastPngString" />
				<c:if test="${weather.forecast == 'partly cloudy'}">
					<c:set value="partlyCloudy" var="forecastPngString" />
				</c:if>
				<c:url value="/img/weather/${forecastPngString}.png" var="weatherImgSrc" /> 
				<img src="${weatherImgSrc}" alt="${forecastPngString}" />
			</span>
		</div>
	</section>
</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />