package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistence.dto.BlogEntry;
import com.seifernet.shadowsatyr.persistence.dto.Hashtag;

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
	private String about;
	private ArrayList<Hashtag> popularHashtags;

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

	/**
	 * @return the popularHashtags
	 */
	public ArrayList<Hashtag> getPopularHashtags() {
		return popularHashtags;
	}

	/**
	 * @param popularHashtags the popularHashtags to set
	 */
	public void setPopularHashtags(ArrayList<Hashtag> popularHashtags) {
		this.popularHashtags = popularHashtags;
	}

	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}
	
}
