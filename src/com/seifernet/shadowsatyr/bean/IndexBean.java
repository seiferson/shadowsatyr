package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;
import com.seifernet.snwf.bean.Bean;

public class IndexBean extends Bean{
	
	private static final long serialVersionUID = 1L;
	private Account userData;
	private ArrayList<BlogEntry> latestBlogEntries;
	
	/**
	 * @return the userData
	 */
	public Account getUserData( ) {
		return userData;
	}
	
	/**
	 * @param userData the userData to set
	 */
	public void setUserData( Account userData ) {
		this.userData = userData;
	}

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
