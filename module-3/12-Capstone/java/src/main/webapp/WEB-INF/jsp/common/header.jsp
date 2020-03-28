<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
		<title>National Park Geek</title>
		<c:url var="stylesheetHref" value="/css/style.css" />
		<link rel="stylesheet" href="${stylesheetHref}" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap" rel="stylesheet">
	</head>
	<body>
		<header>
			<div>
				<c:url var="headerImgURL" value="/img/logo.png"/>
				<img src="${ headerImgURL }" alt="header image">
			</div>
			<nav>
				<ul>
					<c:url var="homeURL" value="/home"/>
					<c:url var="surveyURL" value="/survey"/>
					<c:url var="favoritesURL" value="/favorites"/>
					<li><a href="${ homeURL }">Home</a></li>
					<li><a href="${ surveyURL }">Survey</a></li>
<%-- 					<li><a href="${ favoritesURL }">Favorites</a></li> --%>
				</ul>
			</nav>
		</header>
		<main>