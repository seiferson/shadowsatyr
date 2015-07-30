package com.seifernet.shadowsatyr.api.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface Message {
	
	@WebMethod
	public String sendMessage( );
	
}
