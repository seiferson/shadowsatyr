function createEntry( ){
	$.ajax({
		url:"/shadowsatyr/user/createblogentry",
		dataType: "html",
		type: "post",
		data: $( "#blogForm" ).serialize(),
		success: function ( receivedData ){
			var response = JSON.parse( receivedData );
			if( response.status == "ok" ){
				$( "#blog-content" ).val( "" );
				reloadLatestEntries( );
			}else{
				alert( response.error );
			}
		}
	});	
}

function reloadLatestEntries( ){
	$.ajax({
		url:"/shadowsatyr/latestblogentries",
		success: function ( receivedData ){
			$( "#latestEntries" ).fadeOut( "slow", function( ){
				var data = $( "<div id=\"latestEntries\">" + receivedData + "</div>" ).hide( );
				$( "#latestEntries" ).replaceWith( data );
				$( "#latestEntries" ).fadeIn( "slow" );
			});
		}
	});	
	
}