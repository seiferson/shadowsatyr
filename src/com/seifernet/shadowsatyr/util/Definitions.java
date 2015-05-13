package com.seifernet.shadowsatyr.util;

public class Definitions {

	public static final String DEFAULT_ACTION 		= "/";
	public static final String INDEX 				= "/index";
	public static final String LOGIN 				= "/login";
	public static final String REGISTER				= "/register";
	public static final String CREATE_USER			= "/createUser";
	public static final String CREATE_ARTICLE 		= "/user/createArticle";
	public static final String PREVIEW_ARTICLE 		= "/user/previewArticle";
	public static final String CREATE_BLOG_ENTRY 	= "/user/createBlogEntry";
	public static final String LATEST_BLOG_ENTRIES 	= "/user/latestBlogEntries";
	public static final String ERROR_500			= "/error500";
	public static final String ERROR_404			= "/error404";
	
	public static final String LOGGER_ERROR_1 = "Error setting encoding to request, unsupported enconding";
	public static final String LOGGER_ERROR_2 = "Error on http client, unsupported enconding";
	public static final String LOGGER_ERROR_3 = "Error on http client, client protocol";
	public static final String LOGGER_ERROR_4 = "Error on http client, IO";
	public static final String LOGGER_ERROR_5 = "Error on http client, unknown error!";
	public static final String LOGGER_ERROR_6 = "Error creating blog entry, null value on request parameter";
	public static final String LOGGER_ERROR_7 = "Error loading blog entry template";
	
	public static final String HTTP = "http";
	public static final String HTTPS = "https";
	
	public static final String JSON_OK_RESPONSE 			= "{\"status\":\"ok\"}";
	public static final String JSON_ERROR_NOT_AUTHENTICATED = "{\"status\":\"err\", \"error\":\"not_auth\"}";
	public static final String JSON_ERROR_EMPTY_MESSAGE 	= "{\"status\":\"err\", \"error\":\"empty_msg\"}";
	
	public static final String DIGITALOCEAN_API_ACCESS_TOKEN = "Bearer a614a0e43fa36c177e154c000470970770af328ad4818925392ea52ea2649093";
	public static final String DIGITALOCEAN_API_HOST = "api.digitalocean.com";
	public static final String DIGITALOCEAN_API_DROPLET_PATH = "/v2/droplets";
	
}
