<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<div class="page-header">
						<h1>New article <small>seifernet.com</small></h1>
					</div>
					<p>
						Hi, here you can create a new article, you can use
						the markdown language or simple plain text, the 
						HTML or other languages are not supported.
					</p>
					<div class="panel panel-default">
						<div class="panel-body">
							<form>
								<div class="form-group">
									<label for="article-title">Title:</label>
									<input type="text" maxlength="255" id="article-title" class="form-control" name="article-title"/>
								</div>
								<div class="form-group">
									<label for="article-title">Your article content</label>
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
									<textarea class="form-control" rows="15"></textarea>
								</div>
								<div class="form-group">
									<label for="article-title">Author:</label>
									<input type="text" maxlength="100" id="article-author" class="form-control" name="article-author"/>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>