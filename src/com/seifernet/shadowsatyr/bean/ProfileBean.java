package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.shadowsatyr.persistence.dto.BlogEntry;

/**
 * 
 * Bean to show content on the profile page
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @since 1.0.0
 * @version 1.0.0
 *
 */
public class ProfileBean extends SystemBean{

	private static final long serialVersionUID = 1L;
	private Account profile;
	private ArrayList<BlogEntry> blogEntries;
	
	/**
	 * @return the profile
	 */
	public Account getProfile( ) {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile( Account profile ) {
		this.profile = profile;
	}

	/**
	 * @return the blogEntries
	 */
	public ArrayList<BlogEntry> getBlogEntries( ) {
		return blogEntries;
	}

	/**
	 * @param blogEntries the blogEntries to set
	 */
	public void setBlogEntries( ArrayList<BlogEntry> blogEntries ) {
		this.blogEntries = blogEntries;
	}
}
