package com.seifernet.shadowsatyr.bean;

import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.snwf.bean.Bean;

public class IndexBean extends Bean{
	
	private static final long serialVersionUID = 1L;
	private Account userData;
	
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
	
}
