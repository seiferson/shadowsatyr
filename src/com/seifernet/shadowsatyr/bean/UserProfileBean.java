package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.persistance.dto.BlogEntry;
import com.seifernet.snwf.bean.Bean;

public class UserProfileBean extends Bean{

	private static final long serialVersionUID = 1L;
	private Account userData;
	private Account profile;
	private ArrayList<BlogEntry> blogEntries;
	
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
