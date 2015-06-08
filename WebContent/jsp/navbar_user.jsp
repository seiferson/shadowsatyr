<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
		<nav class="navbar navbar-inverse navbar-nomargin">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbarx">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="http://seifernet.com">SeiferNet</a>
				</div>
				<div class="collapse navbar-collapse" id="navbarx">
					<tiles:insertDefinition name="navbar_menu" />
				</div>
			</div>
		</nav>