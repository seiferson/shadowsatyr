package com.seifernet.shadowsatyr.bean;

import java.util.ArrayList;

import com.seifernet.shadowsatyr.persistance.dto.Account;

/**
 * Bean with data to show admin dashboard, 
 * includes application and server logs.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class DashboardBean extends SystemBean{

	private static final long serialVersionUID = 1L;
			
	private String serverLog;
	private String applicationLog;
	private ArrayList<Account> accounts;

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

	/**
	 * @return the accounts
	 */
	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

}
