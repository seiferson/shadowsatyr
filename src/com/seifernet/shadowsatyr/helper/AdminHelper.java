package com.seifernet.shadowsatyr.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jboss.logging.Logger;

import com.seifernet.shadowsatyr.bean.DashboardBean;
import com.seifernet.shadowsatyr.engine.account.AccountManager;
import com.seifernet.shadowsatyr.persistence.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;
import com.seifernet.shadowsatyr.util.Definitions;

/**
 * Helper for system administration tasks
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public class AdminHelper {

	private static Logger logger = Logger.getLogger( AdminHelper.class );
	
	/**
	 * Shows a dashboard with useful information and 
	 * options related to the CMS managment
	 * 
	 * @param request Servlet request
	 * @param response Servlet response
	 */
	public static void dashboard( HttpServletRequest request, HttpServletResponse response ) {
		Subject	subject = SecurityUtils.getSubject( );
		
		if( subject.isPermitted( Definitions.SYSTEM_ADMIN_DASHBOARD_PERMISSION ) ){
			DashboardBean bean = new DashboardBean( );
			
			try{
				
				ReversedLinesFileReader	reader = new ReversedLinesFileReader( new File( System.getProperty("jboss.server.log.dir") + "/shadowsatyr.log" ) );
				String 	tmpLine = null;
				Integer	nLines	= 0;
				String	appLog	= "";
				
				while( ( tmpLine = reader.readLine( ) ) != null && nLines < 50 ){
					appLog = tmpLine + "<br>" + appLog;
					nLines++;
				}
				reader.close( );
				bean.setApplicationLog( appLog );
				
				String serverLog = "";
				nLines = 0;
				reader = new ReversedLinesFileReader( new File( System.getProperty("jboss.server.log.dir") + "/server.log" ) );
				
				while( ( tmpLine = reader.readLine( ) ) != null && nLines < 50 ){
					serverLog = tmpLine + "<br>" + serverLog;
					nLines++;
				}
				reader.close( );
				bean.setServerLog( serverLog );
				bean.setLayout( Definitions.DASHBOARD_TILES_DEF );
				bean.setAccounts( AccountManager.getAccounts( 0 ) );
				bean.setAccount( ( Account )SessionManager.getSession( subject ).getAttribute( Definitions.ACCOUNT_SESSION_PARAM_NAME ) );
				request.setAttribute( Definitions.BEAN_REQUEST_PARAM_NAME, bean );
			} catch ( FileNotFoundException e ){
				logger.error( Definitions.LOGGER_ERROR_FILE_NOT_FOUND );
				ErrorHelper.error500( request, response );
			} catch ( IOException e ){
				logger.error( Definitions.LOGGER_ERROR_IO );
				ErrorHelper.error500( request, response );
			}
		} else {
			logger.error( Definitions.LOGGER_ERROR_UNAUTHORIZED + subject.getPrincipal( ) );
			ErrorHelper.error403( request, response );
		}
	}
	
}
