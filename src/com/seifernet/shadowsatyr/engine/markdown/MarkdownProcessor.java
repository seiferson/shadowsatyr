package com.seifernet.shadowsatyr.engine.markdown;

import com.github.rjeschke.txtmark.Processor;

public class MarkdownProcessor {
	
	public static String toMarkdown( String text ){
		return Processor.process( text );
	}
	
}
