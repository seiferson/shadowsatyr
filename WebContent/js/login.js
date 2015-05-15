$( function( ) {
	$( "[data-toggle='popover']" ).popover( );
});

$( "#registerModal" ).on( "hidden.bs.modal", function ( ) {
	$( "#passwdcon" ).popover( "hide" );
	$( "#passwdcon" ).val( "" );
	$( "#passwdr" ).val( "" );
	$( "#email" ).popover( "hide" );
	$( "#email" ).val( "" );
	$( "#nickname" ).popover( "hide" );
	$( "#nickname" ).val( "" );
	$( "#passwdc" ).attr( "class", "form-group" );
	$( "#emailc" ).attr( "class", "form-group" );
	$( "#nicknamec" ).attr( "class", "form-group" );
	
});

function validatePasswd(  ){
	if( $( "#passwdr" ).val( ) == $( "#passwdcon" ).val( ) ){
		$( "#passwdc" ).attr( "class", "has-success form-group" );
		$( "#passwdcon" ).popover("hide");
	} else {
		$( "#passwdc" ).attr( "class", "has-error form-group" );
		$( "#passwdcon" ).popover("show");
	}
}

function validateNickname( ){
	$.ajax({
		url:"/shadowsatyr/validateNickname",
		dataType: "html",
		type: "post",
		data: $( "#registerForm" ).serialize(),
		success: function ( receivedData ){
			var response = JSON.parse( receivedData );
			if( response.status == "ok" ){
				$( "#nicknamec" ).attr( "class", "has-success form-group" );
				$( "#nickname" ).popover( "hide" );
			} else{
				$( "#nicknamec" ).attr( "class", "has-error form-group" );
				$( "#nickname" ).popover( "show" );
			}
		}
	});	
}

function validateMail( ){
	$.ajax({
		url:"/shadowsatyr/validateMail",
		dataType: "html",
		type: "post",
		data: $( "#registerForm" ).serialize(),
		success: function ( receivedData ){
			var response = JSON.parse( receivedData );
			if( response.status == "ok" ){
				$( "#emailc" ).attr( "class", "has-success form-group" );
				$( "#email" ).popover( "hide" );
			} else{
				$( "#emailc" ).attr( "class", "has-error form-group" );
				$( "#email" ).popover( "show" );
			}
		}
	});	
}

function sendSubmit( ){
	if( $( "#passwdr" ).val( ) == $( "#passwdcon" ).val( ) ){
		$( "#submitButton" ).click( );
	} else {
		validatePasswd( );
	}
}