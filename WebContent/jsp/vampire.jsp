<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div class="container">
			<div class="row">
				<div class="col-md-9">
					<div class="well">
						<p>
							<span id="jsondata">${Bean.jsonData}</span>
						</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="panel panel-primary">
						<div class="panel-body">
							<p>
								JSON response obtained using DigitalOcean APIV2 via
								HTTPClient.
							</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="well">
						<p>
							Using JSON.parse from javascript with the code:
						</p>
						<pre>&lt;script&gt;
	var object = JSON.parse( $( "#jsondata" ).text( ) );
	for( var i = 0; i &lt; obj.droplets.length; i++ ){
    	$( "#parsedjson" ).append( "&lt;h3&gt;" + obj.droplets[ i ].name + " droplet id:" + obj.droplets[ i ].id + "&lt;/h3&gt;" );
    }
&lt;/script&gt;</pre>
					<button class="btn btn-primary" onclick="parseJson( )">Parse</button>
					</div>
				</div>
				<div class="col-md-6">
					<div id="parsedjson">
						
					</div>
				</div>
			</div>
		</div>