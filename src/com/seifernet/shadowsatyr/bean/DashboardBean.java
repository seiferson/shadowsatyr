package com.seifernet.shadowsatyr.bean;

import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.snwf.bean.Bean;

public class DashboardBean extends Bean{

	private static final long serialVersionUID = 1L;
	private Account userData;
	private String serverLog;
	private String applicationLog;
	
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
	 * @return the serverLog
	 */
	public String getServerLog( ) {
		return serverLog;
	}

	/**
	 * @param serverLog the serverLog to set
	 */
	public void setServerLog( String serverLog ) {
		this.serverLog = serverLog;
	}

	/**
	 * @return the applicationLog
	 */
	public String getApplicationLog( ) {
		return applicationLog;
	}

	/**
	 * @param applicationLog the applicationLog to set
	 */
	public void setApplicationLog( String applicationLog ) {
		this.applicationLog = applicationLog;
	}

}
