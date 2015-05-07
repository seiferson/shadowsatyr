<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="container">
			<div class="col-md-4 col-md-offset-6">
				<div class="panel panel-default">
					<div class="panel-body">
						<form method="POST" action="">
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
									<input type="text" class="form-control" id="account" name="account" placeholder="User">
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></div>
									<input type="text" class="form-control" id="passwd" name="passwd" placeholder="Password">
								</div>
							</div>
							<button type="submit" class="btn btn-default btn-block"><span class="glyphicon glyphicon-log-in"></span> Sign In</button>
							<a href="/shadowsatyr/register" class="btn btn-default btn-block"><span class="glyphicon glyphicon-pencil"></span> Register</a>
						</form>
					</div>
				</div>
			</div>
		</div>