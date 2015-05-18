<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<div class="space"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<c:forEach var="entry" items="${Bean.blogEntries}">
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
										${entry.message}
									<p>
								</div>
							</div>
						</article>
						</c:forEach>
				</div>
				<div class="col-md-3">
					<div class="text-center space-down">
						<img src="http://www.gravatar.com/avatar/${Bean.profile.mailMD5}?s=200&d=retro" class="img-thumbnail">
					</div>
					<h3 class="text-center"> <span class="label label-primary"> ${Bean.profile.nickname} </span> </h3>
				</div>
			</div>
		</div>