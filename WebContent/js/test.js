function parseJson(  ){
	var obj = JSON.parse( $( "#jsondata" ).text( ) );
	for( var i = 0; i < obj.droplets.length; i++ ){
		$( "#parsedjson" ).append( "<h3>" + obj.droplets[ i ].name + " droplet id:" + obj.droplets[ i ].id +" </h3>" );
	}
}