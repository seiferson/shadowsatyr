<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

		<div class="container">
			<div class="row">
				<section class="col-md-8">
					<c:if test="${ empty bean.blogEntries}">
					<div class="alert alert-danger text-center" role="alert">
						<strong>:( There's no entries to show</strong>
					</div>
					</c:if>
					<c:forEach var="entry" items="${bean.blogEntries}">
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
				</section>
			</div>
		</div>