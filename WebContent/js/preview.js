function preview( ){
	var converter = new Showdown.converter();
	var content = "<div id=\"preview-content\">" + "<div class=\"page-header\"> <strong>" + 
					$( "#article-title" ).val( ) + "</strong></div>" +
					converter.makeHtml( $( "#article-content" ).val( ) ) + "</div>";
	$( "#preview-content" ).replaceWith( content );
}