package com.seifernet.shadowsatyr.facade;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dao.BlogEntryDAO;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;

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
		
		return blogEntries;
	}
}
