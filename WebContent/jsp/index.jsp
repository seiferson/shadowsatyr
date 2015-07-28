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
				<section class="col-md-8 col-md-offset-2 text-justify hidden-xs">
					<p>
						Welcome to <strong>shadowsatyr</strong>,
						a <strong>content manager service</strong> project
						developed and maintained by seifer
						( Cuauhtemoc Herrera Muñoz ) you can
						follow the development process or
						fork your own copy at
						<a href="http://github.com/seiferxx/shadowsatyr">github</a>.
					</p>
					<p>
						The main idea behind the project is
						provide an easy, configurable
						and user friendly cms on Java, using
						other frameworks and technologies such
						as <strong>Hibernate</strong>, <strong>Apache Shiro</strong>,
						<strong>Apache Tiles</strong> and my own
						web framework called <strong>SeiferNet web framework</strong>.
					</p>
					<div class="space-20"></div>
				</section>
			</div>
			
			<div class="row">
				<div class="col-sm-12">
					<h3 class="text-center"><strong>Featured article<span class="hidden-xs">s</span></strong></h3>
				</div>
				<div class="col-sm-4 hidden-xs">
					<div class="col-md-12">
						<img src="/img/test.jpg" alt="Dragon image" class="img-thumbnail article-preview">
					</div>
					<div class="col-md-12">
						<h3 class="text-center">Article</h3>
						<p>
							Donec id elit non mi porta gravida at 
							eget metus. Fusce dapibus, tellus ac 
							cursus commodo, tortor mauris condimentum 
							nibh, ut fermentum massa justo sit amet 
							risus. Etiam porta sem malesuada magna 
							mollis euismod. Donec sed odio dui.
						</p>
						<div class="pull-right">
							<button class="btn btn-primary">See more</button>
						</div>
						<div class="cleaner"></div>
					</div>
					<div class="col-md-12">
						<div class="space-20"></div>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="col-md-12">
						<img src="/img/test.jpg" alt="Dragon image" class="img-thumbnail article-preview">
					</div>
					<div class="col-md-12">
						<h3 class="text-center">Article</h3>
						<p>
							Donec id elit non mi porta gravida at 
							eget metus. Fusce dapibus, tellus ac 
							cursus commodo, tortor mauris condimentum 
							nibh, ut fermentum massa justo sit amet 
							risus. Etiam porta sem malesuada magna 
							mollis euismod. Donec sed odio dui.
						</p>
						<div class="pull-right">
							<button class="btn btn-primary">See more</button>
						</div>
						<div class="cleaner"></div>
					</div>
					<div class="col-md-12">
						<div class="space-20"></div>
					</div>
				</div>
				<div class="col-sm-4 hidden-xs">
					<div class="col-md-12">
						<img src="/img/test.jpg" alt="Dragon image" class="img-thumbnail article-preview">
					</div>
					<div class="col-md-12">
						<h3 class="text-center">Article</h3>
						<p>
							Donec id elit non mi porta gravida at 
							eget metus. Fusce dapibus, tellus ac 
							cursus commodo, tortor mauris condimentum 
							nibh, ut fermentum massa justo sit amet 
							risus. Etiam porta sem malesuada magna 
							mollis euismod. Donec sed odio dui.
						</p>
						<div class="pull-right">
							<button class="btn btn-primary">See more</button>
						</div>
						<div class="cleaner"></div>
					</div>
					<div class="col-md-12">
						<div class="space-20"></div>
					</div>
				</div>
				<div class="col-sm-12">
					<div class="space-40"></div>
				</div>
			</div>
			
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
					<h3 class="text-center"><strong>Latest microblog entries</strong></h3>
					<div id="latestEntries">
						<c:if test="${ empty bean.latestBlogEntries}">
							<div class="alert alert-success text-center" role="alert">
								<strong>:) There's no entries yet</strong>
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
					
				</section>
			</div>
		</div>