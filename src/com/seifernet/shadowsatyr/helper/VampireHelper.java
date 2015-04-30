package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.shadowsatyr.bean.VampireBean;
import com.seifernet.shadowsatyr.digitalocean.DigitalOceanAPI;

public class VampireHelper {

	public static void dispatchVampire( HttpServletRequest request, HttpServletResponse response ) {
		VampireBean bean = null;
		
		bean = new VampireBean( );
		bean.setJsonData( DigitalOceanAPI.getDropletsList( ) );
		bean.setLayout( "system.test" );
		
		request.setAttribute( "Bean", bean );
	}

	
}
