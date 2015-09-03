<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

		<header class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<h1>Shadowsatyr</h1>
				</div>
			</div>
		</header>
		
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<c:forEach var="entry" items="${bean.latestBlogEntries}">
						<article class="panel panel-default">
							<div class="panel-body">
								<div class="col-xs-3 col-sm-2 text-center">
									<img src="http://www.gravatar.com/avatar/${entry.author.mailMD5}?s=30&d=retro" class="img-circle" />
								</div>
								<div class="col-xs-9 col-sm-10">
									<p>
										<a href="/shadowsatyr/profile?account=${entry.author.nickname}">${entry.author.nickname}</a>
										<span class="text-info">
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
			</div>
		</div>
