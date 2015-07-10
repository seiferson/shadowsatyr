function preview( ){
	var converter = new Showdown.converter();
	var content = "<div id=\"preview-content\">" + converter.makeHtml( $( "#article-content" ).val( ) ) + "</div>";
	$( "#preview-content" ).replaceWith( content );
}