<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="container">
			<div class="row">
				<section class="col-md-9">
					<div class="article-space"></div>
					<div class="col-md-12" >
						<div class="page-header">
							<h3>${bean.article.title}</h3> 
						</div>
						<input id="data" value="${bean.article.content}" type="hidden"/>
						<div id="content-data"></div>
					</div>
				</section>
				<section class="col-md-3">
				</section>
			</div>
		</div>