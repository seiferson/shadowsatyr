<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="container">
			<div class="col-md-4 col-md-offset-4">
				<div class="space"></div>
				<div class="text-center">
					<img src="/img/icon_white.png" class="header-image"/>
				</div>
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="text-center">
							<h3>Login</h3>
						</div>
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
									<input type="password" class="form-control" id="passwd" name="passwd" placeholder="Password">
								</div>
							</div>
							<button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-log-in"></span> Sign In</button>
							<button type="button" data-toggle="modal" data-target="#registerModal" class="btn btn-default btn-block"><span class="glyphicon glyphicon-pencil"></span> Register</button>
						</form>
					</div>
				</div>
				<div class="well text-center">
					Background image generated with <a target="_blank" href="http://app.geokone.net">GeoKone</a>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="registerModalLabel">Create an account</h4>
					</div>
					<div class="modal-body">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<div class="well">
										There's just a few things you need to do
										and you'll have your own account, provide a
										nickname ( As original as you can, we'll check for availability )
										password and an email account ( Needed to get your Gravatar ).
									</div>
								</div>
								<div class="col-md-12">
									<form method="POST" action="/shadowsatyr/createUser" id="registerForm">
										<div class="form-group" id="nicknamec">
											<label class="control-label" for="nickname">Nickname</label>
											<input data-container="body" data-toggle="popover" data-trigger="manual" data-placement="top" data-content="Nickname not available" onchange="validateNickname( )" type="text" class="form-control" id="nickname" name="nickname" placeholder="Nickname" required>
										</div>
										<div class="form-group" id="emailc">
											<label for="email">Email address</label>
											<input data-container="body" data-toggle="popover" data-trigger="manual" data-placement="top" data-content="Mail account already registered" onchange="validateMail( )" type="email" class="form-control" id="email" name="email" placeholder="Email" required>
										</div>
										<div class="form-group">
											<label for="passwdr" class="control-label">Password</label>
											<input type="password" class="form-control" id="passwdr" name="passwdr" placeholder="Password" required>
										</div>
										<div class="form-group" id="passwdc">
											<label class="control-label" for="passwdcon">Confirm Passwd</label>
											<input data-container="body" data-toggle="popover" data-trigger="manual" data-placement="top" data-content="Passwords don't match" onchange="validatePasswd( )" type="password" class="form-control" id="passwdcon" name="passwdcon" placeholder="Password" required>
										</div>
										<button type="submit" class="hide" id="submitButton" name="submitButton"></button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" onclick="sendSubmit( )">Register</button>
					</div>
				</div>
			</div>
		</div>