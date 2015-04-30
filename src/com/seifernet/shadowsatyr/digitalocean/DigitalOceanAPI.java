package com.seifernet.shadowsatyr.digitalocean;

import java.util.HashMap;

import com.seifernet.shadowsatyr.http.BasicClient;
import com.seifernet.shadowsatyr.util.Definitions;

public class DigitalOceanAPI {
	
	public static String getDropletsList(  ){
		BasicClient 			httpClient 	= null;
		HashMap<String, String> headers 	= null;
		
		httpClient = new BasicClient( );
		headers = new HashMap<String, String>( );
		headers.put( "Content-Type", "application/json" );
		headers.put( "Authorization" , Definitions.DIGITALOCEAN_API_ACCESS_TOKEN );
		
		return httpClient.doGet( null, headers, Definitions.HTTPS, Definitions.DIGITALOCEAN_API_HOST, Definitions.DIGITALOCEAN_API_DROPLET_PATH );
	}
}
