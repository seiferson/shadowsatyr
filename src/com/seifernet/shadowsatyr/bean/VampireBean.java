package com.seifernet.shadowsatyr.bean;

import java.io.Serializable;

import com.seifernet.snwf.bean.Bean;

public class VampireBean extends Bean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String jsonData;

	/**
	 * @return the jsonData
	 */
	public String getJsonData( ) {
		return jsonData;
	}

	/**
	 * @param jsonData the jsonData to set
	 */
	public void setJsonData( String jsonData ) {
		this.jsonData = jsonData;
	}
}
