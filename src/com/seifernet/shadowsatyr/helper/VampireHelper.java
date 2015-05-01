package com.seifernet.shadowsatyr.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seifernet.shadowsatyr.bean.VampireBean;
import com.seifernet.shadowsatyr.digitalocean.DigitalOceanAPI;
import com.seifernet.shadowsatyr.persistance.dao.MonsterDA0;
import com.seifernet.shadowsatyr.persistance.dto.Monster;

public class VampireHelper {

	public static void dispatchVampire( HttpServletRequest request, HttpServletResponse response ) {
		VampireBean bean = null;
		
		bean = new VampireBean( );
		bean.setJsonData( DigitalOceanAPI.getDropletsList( ) );
		bean.setLayout( "system.test" );
		
		request.setAttribute( "Bean", bean );
		Monster m = new Monster( );
		m.setName( "Dracula" );
		m.setDescription( "Angry vampire" );
		new MonsterDA0( ).create( m );
	}

	
}
