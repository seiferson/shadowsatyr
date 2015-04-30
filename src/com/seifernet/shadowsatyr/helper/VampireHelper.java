package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.shadowsatyr.bean.VampireBean;
import com.seifernet.shadowsatyr.digitalocean.DigitalOceanAPI;

public class VampireHelper {

	public static String dispatchVampire( HttpServletRequest request, HttpServletResponse response ) {
		VampireBean bean = null;
		
		bean = new VampireBean( );
		bean.setJsonData( DigitalOceanAPI.getDropletsList( ) );
		
		request.setAttribute( "Bean", bean );
		return "/jsp/vampire.jsp";
	}

	
}
