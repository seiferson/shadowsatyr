<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Shadowsatyr</title>
		<link href="/css/simple.css" rel="stylesheet">
		<link href="/css/bootstrap.css" rel="stylesheet">
	</head>
	<body>
		
		<tiles:insertAttribute name="navbar" />
		
		<tiles:insertAttribute name="body" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	</body>
</html>