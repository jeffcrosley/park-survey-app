<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
		<title>National Park Geek</title>
		<c:url var="stylesheetHref" value="/css/style.css" />
		<link rel="stylesheet" href="${stylesheetHref}" type="text/css">
	</head>
	<body>
		<header>
			<c:url var="headerImgURL" value="/img/logo.png"/>
			<img src="${ headerImgURL }">
		</header>
		<main>