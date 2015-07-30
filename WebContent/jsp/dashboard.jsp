<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar" role="tablist">
						<li class="active"><a href="#overview" role="tab" data-toggle="tab">Overview</a></li>
						<li><a href="#users" role="tab" data-toggle="tab">Users</a></li>
						<li><a href="#panel3" role="tab" data-toggle="tab">Analytics</a></li>
						<li><a href="#serverLog" role="tab" data-toggle="tab">Server log</a></li>
						<li><a href="#applicationLog" role="tab" data-toggle="tab">Application log</a></li>
					</ul>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="overview">
							<canvas id="userChart"></canvas>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="users">
							<table class="table table-striped">
								<thead>
									<tr>
										<th class="text-center hidden-xs"><span class="glyphicon glyphicon-picture"></span> Avatar</th>
										<th class="text-center"><span class="glyphicon glyphicon-user"></span> Nickname</th>
										<th class="text-center hidden-xs"><span class="glyphicon glyphicon-envelope"></span> Mail</th>
										<th class="text-center"><span class="glyphicon glyphicon-lock"></span> Permissions</th>
										<th class="text-center"><span class="glyphicon glyphicon-wrench"></span> Edit</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${bean.accounts}" var="acc">
									<tr>
										<td class="text-center hidden-xs"><img src="http://www.gravatar.com/avatar/${acc.mailMD5}?s=40&d=retro" class="img-circle" /></td>
										<td>${acc.nickname}</td>
										<td class="hidden-xs">${acc.mail}</td>
										<td class="text-center"><button type="button" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-lock"></span></button></td>
										<td class="text-center"><button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#editUser"><span class="glyphicon glyphicon-wrench"></span></button></td>
									</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="text-center">
								<nav>
									<ul class="pagination">
										<li>
											<a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
										</li>
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
										<li>
											<a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
										</li>
									</ul>
								</nav>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="panel3">
						</div>
						<div role="tabpanel" class="tab-pane fade" id="serverLog">
							<div class="well">
								<small>
									${bean.serverLog}
								</small>
							</div>
						</div>
						<div role="tabpanel" class="tab-pane fade" id="applicationLog">
							<div class="well">
								<small>
									${bean.applicationLog}
								</small>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
		
		<div class="modal fade" id="editUser" tabindex="-1" role="dialog" aria-labelledby="editUserLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title" id="editUserLabel">Modal title</h4>
					</div>
					<div class="modal-body">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
			</div>
		</div>
