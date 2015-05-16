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
				$( "#validNickname" ).val( "true" );
			} else{
				if( response.error == "empty_nick" ){
					$( "#nicknamec" ).attr( "class", "form-group" );
					$( "#nickname" ).popover( "hide" );
					$( "#validNickname" ).val( "false" );
				} else {
					$( "#nicknamec" ).attr( "class", "has-error form-group" );
					$( "#nickname" ).popover( "show" );
					$( "#validNickname" ).val( "false" );
				}
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
				$( "#validMail" ).val( "true" );
			} else{
				if( response.error == "empty_mail" ){
					$( "#emailc" ).attr( "class", "form-group" );
					$( "#email" ).popover( "hide" );
					$( "#validMail" ).val( "false" );
				}else{ 
					$( "#emailc" ).attr( "class", "has-error form-group" );
					$( "#email" ).popover( "show" );
					$( "#validMail" ).val( "false" );
				}
			}
		}
	});	
}

function sendSubmit( ){
	validateMail( );
	validateNickname( );
	if( $( "#passwdr" ).val( ) == $( "#passwdcon" ).val( )
		&& $( "#validMail" ).val( ) == "true"
		&& $( "#validNickname" ).val( ) == "true"
	){
		$( "#submitButton" ).click( );
	} else {
		validatePasswd( );
	}
}