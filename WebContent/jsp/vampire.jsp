<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="Bean" scope="request" class="com.seifernet.snwf.bean.Bean" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ShadowSatyr</title>
        <link rel="shortcut icon" href="/img/favicon.ico" />
        <link href="/css/bootstrap.css" rel="stylesheet">
        <link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<header class="jumbotron primary-color">
			<div class="container">
				<h1>ShadowSatyr!</h1>
				<p>
					seifernet.com testing application
				</p>
			</div>
		</header>
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
		
		<footer>
			<div class="end-space"></div>
		</footer>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="/js/bootstrap.min.js"></script>
        
        <script type="text/javascript">
        	function parseJson(  ){
        		var obj = JSON.parse( $( "#jsondata" ).text( ) );
        		for( var i = 0; i < obj.droplets.length; i++ ){
        			$( "#parsedjson" ).append( "<h3>" + obj.droplets[ i ].name + " droplet id:" + obj.droplets[ i ].id +" </h3>" );
        		}
        	}
        </script>
	</body>
</html>