<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="page-header">
						<h1>New article <small>seifernet.com</small></h1>
					</div>
					<p>
						Hi, here you can create a new article, you can use
						the markdown language or simple plain text, the 
						HTML or other languages are not supported.
					</p>
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#edit" aria-controls="edit" role="tab" data-toggle="tab">Edit</a></li>
						<li role="presentation"><a href="#preview" aria-controls="preview" role="tab" data-toggle="tab">Preview</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="edit">
							<form method="POST" action="/shadowsatyr/saveArticle" id="article-form">
								<div class="form-group">
									<label for="article-title">Title:</label>
									<input type="text" maxlength="255" id="article-title" class="form-control" name="article-title"/>
								</div>
								<div class="form-group">
									<label for="article-content">Your article content</label>
									<div class="btn-toolbar btn-toolbar-margin" role="toolbar">
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"><strong>h1</strong></button>
											<button type="button" class="btn btn-default"><strong>h2</strong></button>
											<button type="button" class="btn btn-default"><strong>h3</strong></button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-picture"></span></button>
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-link"></span></button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-bold"></span></button>
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-italic"></span></button>
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span></button>
										</div>
										<div class="btn-group" role="group">
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list"></span></button>
											<button type="button" class="btn btn-default"><strong>"</strong></button>
											<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-option-horizontal"></span></button>
										</div>
									</div>
									<textarea class="form-control" id="article-content" name="article-content" rows="15" oninput="preview( )"></textarea>
								</div>
								<div class="pull-right">
									<button type="button" class="btn btn-default">Create article</button>
								</div>
							</form>
						</div>
						<div role="tabpanel" class="tab-pane active" id="preview">
							<div id="preview-content"></div>
						</div>
					</div>
				</div>
			</div>
		</div>