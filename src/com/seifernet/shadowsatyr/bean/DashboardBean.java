package com.seifernet.shadowsatyr.bean;

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
