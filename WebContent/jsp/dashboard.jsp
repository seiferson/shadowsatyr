<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 sidebar">
					<ul class="nav nav-sidebar" role="tablist">
						<li class="active"><a href="#overview" role="tab" data-toggle="tab">Overview</a></li>
						<li><a href="#system" role="tab" data-toggle="tab">System</a></li>
						<li><a href="#serverLog" role="tab" data-toggle="tab">Server log</a></li>
						<li><a href="#applicationLog" role="tab" data-toggle="tab">Application log</a></li>
					</ul>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="overview">
							
						</div>
						<div role="tabpanel" class="tab-pane fade" id="system">
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