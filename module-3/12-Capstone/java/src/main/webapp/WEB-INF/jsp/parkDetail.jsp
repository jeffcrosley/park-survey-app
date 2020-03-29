<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>



<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Park Details" />
</c:import>

<div class="park-detail">
	<c:url var="parkImg"
		value="/img/parks/${ fn:toLowerCase(park.parkCode) }.jpg" />
	<img class="park-detail-img" src="${ parkImg }" alt="park image">
	
	<div class="park-detail-info">
		<h2><c:out value="${ park.parkName }" /></h2>
		<p><c:out value="${ park.parkDescription }" /></p>
		<p><c:out value="State: ${ park.state }" /></p>
		<p><c:out value="Acres: ${ park.acreage }" /></p>
		<p><c:out value="Elevation: ${ park.elevationInFeet }ft" /></p>
		<p><c:out value="Miles of Trail: ${ park.milesOfTrail }" /></p>
		<p><c:out value="Campsites: ${ park.numberOfCampsites }" /></p>
		<p><c:out value="Climate: ${ park.climate }" /></p>
		<p><c:out value="Year Founded: ${ park.yearFounded }" /></p>
		<p><c:out value="Annual Visitors: ${ park.annualVisitorCount }" /></p>
		<p><c:out value="${ park.inspirationalQuote }" /></p>
		<p><c:out value="- ${ park.inspirationalQuoteSource }" /></p>
		<p><c:out value="Known Species of Animals: ${ park.numberOfAnimalSpecies }" /></p>
		<p><c:out value="Entry fee: $ ${ park.entryFee }" /></p>
	</div>
</div>

<div class="weather-info">

	<h3>5-day forecast</h3>

	<p>Check the weather for the next 5 days.</p>
	
	<c:url var="parkDetailURL" value="/parkDetail?parkCode=${ park.parkCode }"/>
	<form:form action="${ parkDetailURL }" method="POST" >
		<input class="temp-switch" type="submit" value="Change Degrees F/C"/>
	</form:form>
		
	<div class="weather">
		
		<c:forEach var="weather" items="${ fiveDayForecast }">
		
			<c:set var="tomorrow" value=""/>
			<c:if test="${ weather.fiveDayForecastValue == 1 }">
				<c:set var="tomorrow" value="tomorrow"/>
			</c:if>
			
			<div class="weather-tile ${ tomorrow }">
		    	<c:set value="${weather.forecast}" var="forecastPngString" />
		    	<c:if test="${weather.forecast == 'partly cloudy'}">
		    		<c:set value="partlyCloudy" var="forecastPngString" />
		    	</c:if>
		    	<c:url value="/img/weather/${forecastPngString}.png" var="weatherImgSrc" />
		    	<img class="weather-img" src="${weatherImgSrc}" alt="${forecastPngString}" />
		    	<h3><b>${weather.forecast}</b></h3>
		    	
				
				<p>Temp in : ${degrees}</p>
				<c:choose>
					<c:when test="${ degrees == 'F' }">
						<p>High: <fmt:formatNumber type = "number" maxFractionDigits  = "2" value = "${weather.fahrenheitHigh}" /></p>
						<p>Low: <fmt:formatNumber type = "number" maxFractionDigits  = "2" value = "${weather.fahrenheitLow}" /></p>
					</c:when>
					<c:otherwise>
						<p>High: <fmt:formatNumber type = "number" maxFractionDigits  = "2" value = "${weather.celsiusHigh}" /></p>
						<p>Low: <fmt:formatNumber type = "number" maxFractionDigits  = "2" value = "${weather.celsiusLow}"/></p>
					</c:otherwise>
				</c:choose>
				
				 <c:if test="${(weather.fahrenheitHigh - weather.fahrenheitLow) > 20}">
	    			<p>Please wear breathable layers!</p>
    			</c:if>
				
				<c:choose>
					<c:when test="${ weather.forecast == 'snow' }">
						<p>Please pack snowshoes!</p>
					</c:when>
					<c:when test="${ weather.forecast == 'rain' }">
						<p>Please pack rain gear and wear waterproof shoes!</p>
					</c:when>
					<c:when test="${ weather.forecast == 'thunderstorms' }">
						<p>Please seek shelter and avoid hiking on exposed ridges!</p>
					</c:when>
					<c:when test="${ weather.forecast == 'sun' }">
						<p>Please pack sunblock!</p>
						<c:if test="${weather.fahrenheitHigh >= 75}">
			    			<p>Please bring an extra gallon of water!</p>
		    			</c:if>
					</c:when>
				</c:choose>	
				
			</div>		
		</c:forEach>
		
	</div>

</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />