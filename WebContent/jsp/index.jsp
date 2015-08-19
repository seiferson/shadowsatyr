<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
		
		<header class="jumbotron primary-color">
			<div class="container">
				<div class="page-header text-center">
					<img src="/img/icon_white.png" class="main-page-image"><br/>
					<h2>Welcome to <strong>Shadow</strong>Satyr!</h2>
				</div>
			</div>
		</header>

		<div class="container">
		
			<div class="row">
				<section class="col-md-8">
					<shiro:authenticated>
					<div class="panel panel-default">
						<div class=panel-body>
							<form id="blogForm" method="POST">
								<div class="form-group">
									<textarea class="form-control" id="blog-content" name="blog-content" rows="2" maxlength="150"></textarea>
								</div>
								<button type="button" class="btn btn-default pull-right" onclick="createEntry( )">Publish</button>
							</form>
						</div>
					</div>
					</shiro:authenticated>
					<div id="latestEntries">
						<c:if test="${ empty bean.latestBlogEntries}">
							<div class="alert alert-success text-center" role="alert">
								<strong> <span class="glyphicon glyphicon-info-sign"></span> zero entries</strong>
							</div>
						</c:if>
						<c:forEach var="entry" items="${bean.latestBlogEntries}">
						<article class="well">
							<div class="row">
								<div class="col-xs-3 col-sm-2 text-center">
									<img src="http://www.gravatar.com/avatar/${entry.author.mailMD5}?s=60&d=retro" class="img-circle" />
								</div>
								<div class="col-xs-9 col-sm-10">
									<p>
										<a href="/shadowsatyr/profile?account=${entry.author.nickname}">${entry.author.nickname}</a>
										<span class="text-success">
											<fmt:formatDate  type="both" dateStyle="short" timeStyle="short" value="${entry.date}" />
										</span> 
									</p>
									<p>
										${entry.content}
									<p>
								</div>
							</div>
						</article>
						</c:forEach>
					</div>
				</section>
				<section class="col-md-4 hidden-xs hidden-sm">
					<div class="col-md-12">
						<c:forEach var="hashtag" items="">
							<span class="label label-primary">Primary</span> <span class="label label-primary">Primary</span>
						</c:forEach>
					</div>
				</section>
			</div>
		</div>