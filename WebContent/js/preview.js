function preview( ){
	$.ajax({
		url:"/shadowsatyr/markdownparser",
		dataType: "html",
		type: "post",
		data: {
			data : $( "#article-content" ).val( )
		},
		success: function ( receivedData ){
			$( "#preview-content" ).replaceWith( "<div id='preview-content'>" +  receivedData +"</div>" )
		}
	});
}