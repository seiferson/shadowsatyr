$( function( ) {
	$( "[data-toggle='popover']" ).popover( );
});

$( "#registerModal" ).on( "hidden.bs.modal", function ( ) {
	$( "#passwdcon" ).popover( "hide" );
	$( "#passwdcon" ).val( "" );
	$( "#passwdr" ).val( "" );
	$( "#email" ).val( "" );
	$( "#nickname" ).val( "" );
	$( "#passwdc" ).attr( "class", "form-group" );
	
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

function sendSubmit( ){
	if( $( "#passwdr" ).val( ) == $( "#passwdcon" ).val( ) ){
		$( "#submitButton" ).click( );
	} else {
		validatePasswd( );
	}
}