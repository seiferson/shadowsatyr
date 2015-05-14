$( function( ) {
	$( "[data-toggle='popover']" ).popover( );
});

$( "#registerModal" ).on( "hidden.bs.modal", function ( ) {
	$( "#passwdcon" ).popover( "hide" );
	$( "#passwdcon" ).val( "" );
	$( "#passwdr" ).val( "" );
	$( "#email" ).val( "" );
	$( "#nickname" ).val( "" );
	
});

function validatePasswd(  ){
	if( $( "#passwdr" ).val( ) == $( "#passwdcon" ).val( ) ){
		$( "#passwdcon" ).attr( "class", "has-success form-control" );
		$( "#passwdcon" ).popover("hide");
	} else {
		$( "#passwdcon" ).attr( "class", "has-error form-control" );
		$( "#passwdcon" ).popover("show");
	}
}

function sendSubmit( ){
	if( $( "#passwdr" ).val( ) == $( "#passwdcon" ).val( ) ){
		$( "#submitButton" ).click( );
	} else {
		validatePasswd( );
	}
}