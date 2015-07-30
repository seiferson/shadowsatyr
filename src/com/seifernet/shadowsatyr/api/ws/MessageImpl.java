package com.seifernet.shadowsatyr.api.ws;

import javax.jws.WebService;

@WebService( endpointInterface = "com.seifernet.shadowsatyr.api.ws.Message", serviceName = "MessageWS" )
public class MessageImpl implements Message{

	public String sendMessage( ) {
		return "{'message':'message_data'}";
	}

}
