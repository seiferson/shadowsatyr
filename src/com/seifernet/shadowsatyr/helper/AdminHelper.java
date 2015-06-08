package com.seifernet.shadowsatyr.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.seifernet.shadowsatyr.bean.DashboardBean;
import com.seifernet.shadowsatyr.engine.hashtag.HashTagProcessor;
import com.seifernet.shadowsatyr.persistance.dto.Account;
import com.seifernet.shadowsatyr.security.SessionManager;

public class AdminHelper {

	public static void dashboard( HttpServletRequest request, HttpServletResponse response ) {
		DashboardBean 	bean 		= null;
		Session			session 	= null;
		Subject			subject		= null;
		String			appLog		= "";
		String			serverLog	= "";
		String			tmpLine		= null;
		ReversedLinesFileReader		reader		= null;	
		Integer			nLines		= 0;
		
		bean = new DashboardBean( );
		subject = SecurityUtils.getSubject( );
		session = SessionManager.getSession( subject );
		
		try{ 
			reader = new ReversedLinesFileReader( new File( System.getProperty("jboss.server.log.dir") + "/shadowsatyr.log" ) );
			while( ( tmpLine = reader.readLine( ) ) != null && nLines < 50 ){
				appLog = tmpLine + "<br>" + appLog;
				nLines++;
			}
			
			nLines = 0;
			reader = new ReversedLinesFileReader( new File( System.getProperty("jboss.server.log.dir") + "/server.log" ) );
			while( ( tmpLine = reader.readLine( ) ) != null && nLines < 50 ){
				serverLog = tmpLine + "<br>" + serverLog;
				nLines++;
			}
		} catch ( FileNotFoundException e ){
			
		} catch ( IOException e ){
			
		}
		
		bean.setLayout( "system.dashboard" );
		bean.setApplicationLog( appLog );
		bean.setServerLog( serverLog );
		bean.setUserData( ( Account )session.getAttribute( "user_data" ) );
		request.setAttribute( "Bean", bean );
	}
	
}
