package com.seifernet.shadowsatyr.util;

public class Definitions {

	public static final String DEFAULT_ACTION 		= "/";
	public static final String INDEX 				= "/index";
	public static final String LOGIN 				= "/login";
	public static final String CREATE_USER			= "/createUser";
	public static final String VALIDATE_NICK_NAME 	= "/validateNickname";
	public static final String VALIDATE_MAIL	 	= "/validateMail";
	public static final String CREATE_BLOG_ENTRY 	= "/user/createBlogEntry";
	public static final String LATEST_BLOG_ENTRIES 	= "/user/latestBlogEntries";
	public static final String DASHBOARD 			= "/user/dashboard";
	public static final String USER_PROFILE			= "/profile";
	public static final String HASHTAG				= "/hashtag";
	public static final String CREATE_ARTICLE 		= "/user/createArticle";
	public static final String PREVIEW_ARTICLE 		= "/user/previewArticle";
	public static final String ERROR_500			= "/error500";
	public static final String ERROR_404			= "/error404";
	
	public static final String URL_ACCOUNT_CREATED 			= "/shadowsatyr/login?acc=1";
	public static final String URL_ACCOUNT_CREATION_ERROR 	= "/shadowsatyr/login?acc=0";
	
	
	public static final String LOGGER_ERROR_1 = "Error setting encoding to request, unsupported enconding";
	public static final String LOGGER_ERROR_2 = "Error on http client, unsupported enconding";
	public static final String LOGGER_ERROR_3 = "Error on http client, client protocol";
	public static final String LOGGER_ERROR_4 = "Error on http client, IO";
	public static final String LOGGER_ERROR_5 = "Error on http client, unknown error!";
	public static final String LOGGER_ERROR_6 = "Error creating blog entry, null value on request parameter";
	public static final String LOGGER_ERROR_7 = "Error loading blog entry template";
	public static final String LOGGER_ERROR_8 = "Error executing hibernate task";
	public static final String LOGGER_ERROR_9 = "Error testing database connection, default datasource is not available";
	
	public static final String LOGGER_DEBUG_1 = "Deploying system, starting system configuration";
	public static final String LOGGER_DEBUG_2 = "Testing default database connection: ";
	public static final String LOGGER_DEBUG_3 = "Database not available, skipping database validation/configuration";
	public static final String LOGGER_DEBUG_4 = "Success datasource testing";
	
	public static final String HTTP = "http";
	public static final String HTTPS = "https";
	
	public static final String JSON_OK_RESPONSE 			= "{\"status\":\"ok\"}";
	public static final String JSON_ERROR_NOT_AUTHENTICATED = "{\"status\":\"err\", \"error\":\"not_auth\"}";
	public static final String JSON_ERROR_EMPTY_MESSAGE 	= "{\"status\":\"err\", \"error\":\"empty_msg\"}";
	public static final String JSON_ERROR_NOT_AVAILABLE		= "{\"status\":\"err\", \"error\":\"not_avl\"}";
	public static final String JSON_ERROR_EMPTY_NICKNAME	= "{\"status\":\"err\", \"error\":\"empty_nick\"}";
	public static final String JSON_ERROR_EMPTY_MAIL		= "{\"status\":\"err\", \"error\":\"empty_mail\"}";
	
	public static final String DIGITALOCEAN_API_ACCESS_TOKEN = "Bearer a614a0e43fa36c177e154c000470970770af328ad4818925392ea52ea2649093";
	public static final String DIGITALOCEAN_API_HOST = "api.digitalocean.com";
	public static final String DIGITALOCEAN_API_DROPLET_PATH = "/v2/droplets";
	
	public static final String SHADOW_SATYR_DEFAULT_DATASOURCE 	= "java:jboss/datasources/shadowsatyr";
	public static final String SHADOW_SATYR_DATABASE_TEST 		= "database_test";
	
	
}
