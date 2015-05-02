function preview( ){
	$.ajax({
		url:"/shadowsatyr/previewArticle",
		dataType: "html",
		type: "post",
		data: $( "#article-form" ).serialize(),
		success: function ( receivedData ){
			var content = "<div id=\"preview-content\">" +
						"<div class=\"page-header\"> <h1>" +
						$( "#article-title" ).val( ) +
						"</h1></div>" +
						   receivedData + "</div>";
			$( "#preview-content" ).replaceWith( content );
			$( "#preview" ).modal( "show" );
		}
	});	
}