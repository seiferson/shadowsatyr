<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-user"></span> ${Bean.userData.nickname}<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="/shadowsatyr/index"><span class="glyphicon glyphicon-home"></span> Home</a></li>
								<shiro:hasPermission name="shadowsatyr:admin:dashboard">
								<li><a href="/shadowsatyr/user/dashboard"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></li>
								</shiro:hasPermission>
								<li class="divider"></li>
								<li><a href="/shadowsatyr/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
							</ul>
						</li>
					</ul>