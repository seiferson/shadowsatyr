<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<script src="/js/showdown.js"></script>
		<script>
			var converter = new Showdown.converter( );
			$( "#content-data" ).replaceWith( converter.makeHtml( $( "#data" ).val( ) ) );
		</script>