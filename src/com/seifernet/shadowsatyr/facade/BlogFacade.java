package com.seifernet.shadowsatyr.facade;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dao.BlogEntryDAO;
import com.seifernet.shadowsatyr.persistance.dao.HashtagDAO;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;
import com.seifernet.shadowsatyr.persistance.dto.Hashtag;

public class BlogFacade {
	
	public void createBlogEntry( BlogEntry entry ){
		BlogEntryDAO dao = new BlogEntryDAO( );
		
		dao = new BlogEntryDAO( );
		dao.create( entry );
	}
	
	public ArrayList<BlogEntry> getLatestBlogEntries( ){
		ArrayList<BlogEntry> 	blogEntries = null;
		BlogEntryDAO			dao			= null;
		
		dao = new BlogEntryDAO( );
		blogEntries = new ArrayList<BlogEntry>( dao.readAllDsc( "date", 5 ) );
		for( BlogEntry entry : blogEntries ){
			String message = entry.getMessage( );
			ArrayList<Hashtag> hashtags = new ArrayList<Hashtag>( entry.getHashtags( ) ); 
			for( Hashtag hashtag : hashtags ){
				String hs = hashtag.getHashtag( );
				message = message.replace( hs, "<a href='/shadowsatyr/hashtag?hashtag=" + hs + "'>" + hs + "</a>" );
			}
			entry.setMessage( message );
		}
		
		return blogEntries;
	}
	
	public void addHashtag( String hashtag ){
		
	}
	
	public Hashtag getHashtag( String hashtag ){
		HashtagDAO dao = new HashtagDAO( );
		
		return dao.read( "hashtag" , hashtag );
	}
}
