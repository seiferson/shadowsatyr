package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.snwf.bean.Bean;

public class AdminHelper {

	public static void dashboard( HttpServletRequest request, HttpServletResponse response ) {
		Bean bean = null;
		
		bean = new Bean( );
		bean.setLayout( "system.dashboard" );
		request.setAttribute( "Bean", bean );
	}
	
}
