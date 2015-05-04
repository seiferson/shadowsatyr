package com.seifernet.shadowsatyr.markdown;

public class Parser {
	
	public static final String NUMBER_SIGN 			= "#";
	public static final String ASTERISK 			= "*";
	public static final String UNDERSCORE			= "_";
	public static final String LEFT_PARENTHESIS 	= "(";
	public static final String RIGHT_PARENTHESIS 	= ")";
	public static final String LEFT_BRACKET			= "[";
	public static final String RIGHT_BRACKET		= "]";
	public static final String EXCLAMATION_MARK		= "!";
	public static final String BACKTICK				= "`";
	public static final String RIGHT_CHEVRON		= ">";
	public static final String LEFT_CHEVRON			= "<";
	public static final String BACKSLASH			= "\\";
	public static final String LINE_BREAK			= "\n";
	public static final String WHITE_SPACE			= " ";
	public static final String TAB					= "\t";
	public static final String CARRIAGE_RETURN		= "\r";
	
	
	public static final Integer ROOT				= 0;
	public static final Integer HEADER_LV1			= 1;
	public static final Integer HEADER_LV2			= 2;
	public static final Integer HEADER_LV3			= 3;
	public static final Integer LINK				= 4;
	public static final Integer WORD				= 5;
	public static final Integer WORD_BOLD			= 6;
	public static final Integer WORD_ITALIC			= 7;
	public static final Integer CODE_INLINE			= 8;
	public static final Integer CODE_BLOCK			= 9;
	public static final Integer IMAGE				= 10;
	public static final Integer UNORDERED_LIST		= 11;
	public static final Integer ORDERED_LIST		= 12;
	public static final Integer BLOCKQUOTE			= 13;
	public static final Integer HORIZONTAL_RULE		= 14;
	
	
	public String parse( String input ){
		char[] i = input.toCharArray( );
		String out = "";
		
		for( int j = 0; j < i.length; j++ ){
			if( Character.toString( i[ j ] ).equals( LINE_BREAK ) ){
				out += "LINE_BREAK-";
			}
			else{
				out +=  i[ j ] + "-";
			}
		}
		System.out.println( out );
		return out;
	}
	
}
