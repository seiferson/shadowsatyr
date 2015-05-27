<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar" role="tablist">
						<li class="active"><a href="#panel1" role="tab" data-toggle="tab">Overview</a></li>
						<li><a href="#panel2" role="tab" data-toggle="tab">Reports</a></li>
						<li><a href="#panel3" role="tab" data-toggle="tab">Analytics</a></li>
						<li><a href="#panel4" role="tab" data-toggle="tab">Export</a></li>
						<li><a href="#applicationLog" role="tab" data-toggle="tab">Application log</a></li>
					</ul>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="panel1">
						</div>
						<div role="tabpanel" class="tab-pane fade" id="panel2">
						</div>
						<div role="tabpanel" class="tab-pane fade" id="panel3">
						</div>
						<div role="tabpanel" class="tab-pane fade" id="panel4">
						</div>
						<div role="tabpanel" class="tab-pane fade" id="applicationLog">
							<div class="well">
								${Bean.applicationLog}
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>