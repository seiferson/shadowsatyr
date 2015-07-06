function preview( ){
	var content = "<div id=\"preview-content\">" + "<div class=\"page-header\"> <h1>" + 
					$( "#article-title" ).val( ) + "</h1></div>" +
					marked( $( "#article-content" ).val( ) ) + "</div>";
	$( "#preview-content" ).replaceWith( content );
	$( "#preview" ).modal( "show" );
}