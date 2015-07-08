function preview( ){
	var converter = new Showdown.converter();
	var content = "<div id=\"preview-content\">" + "<div class=\"page-header\"> <h1>" + 
					$( "#article-title" ).val( ) + "</h1></div>" +
					converter.makeHtml( $( "#article-content" ).val( ) ) + "</div>";
	$( "#preview-content" ).replaceWith( content );
}