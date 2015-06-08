package com.seifernet.shadowsatyr.engine.hashtag;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashTagProcessor {
	
	private static Pattern hashTagPattern = Pattern.compile( "#\\S*" );
	
	public static ArrayList<String> getHashTags( String data ){
		Matcher 			matcher 	= null;
		ArrayList<String> 	hashtags 	= null;
		
		matcher = hashTagPattern.matcher( data );
		hashtags = new ArrayList<String>( );
		
		while( matcher.find( ) ){
			hashtags.add( matcher.group( 0 ) );
		}
		
		return hashtags;
	}
	
}
