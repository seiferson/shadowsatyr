<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> ${Bean.userData.nickname}<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/shadowsatyr/index"><span class="glyphicon glyphicon-home"></span> Home</a></li>
								<li class="divider"></li>
								<li><a href="/shadowsatyr/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</nav>