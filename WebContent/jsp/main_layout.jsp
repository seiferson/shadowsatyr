<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>ShadowSatyr</title>
		<link rel="shortcut icon" href="/img/favicon.ico" />
		<link href="/css/bootstrap.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<tiles:insertAttribute name="navbar" />
		
		<header class="jumbotron primary-color">
			<div class="container">
				<h1>ShadowSatyr!</h1>
				<p>
					seifernet.com CMS
				</p>
			</div>
		</header>
		
		<tiles:insertAttribute name="body" />
		
		<footer>
			<div class="end-space"></div>
		</footer>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="/js/bootstrap.min.js"></script>
		<tiles:insertAttribute name="js_includes" />
	</body>
</html>