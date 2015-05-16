package com.seifernet.shadowsatyr.bean;

import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.snwf.bean.Bean;

public class UserProfileBean extends Bean{

	private static final long serialVersionUID = 1L;
	private Account userData;
	private Account profile;
	
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
}
