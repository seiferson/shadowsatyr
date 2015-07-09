package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;

/**
 * Bean to show content on the welcome page
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @since 1.0.0
 * @version 1.0.0
 *
 */
public class IndexBean extends SystemBean{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<BlogEntry> latestBlogEntries;

	/**
	 * @return the latestBlogEntries
	 */
	public ArrayList<BlogEntry> getLatestBlogEntries( ) {
		return latestBlogEntries;
	}

	/**
	 * @param latestBlogEntries the latestBlogEntries to set
	 */
	public void setLatestBlogEntries( ArrayList<BlogEntry> latestBlogEntries ) {
		this.latestBlogEntries = latestBlogEntries;
	}
	
}
