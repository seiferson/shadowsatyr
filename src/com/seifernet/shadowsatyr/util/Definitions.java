package com.seifernet.shadowsatyr.util;

public class Definitions {

	/* -- System actions -- */
	public static final String DEFAULT_ACTION 		= "/";
	public static final String INDEX 				= "/index";
	public static final String LOGIN 				= "/login";
	public static final String CREATE_ACCOUNT		= "/createaccount";
	public static final String VALIDATE_NICK_NAME 	= "/validatenickname";
	public static final String VALIDATE_MAIL	 	= "/validatemail";
	public static final String ERROR_500			= "/error500";
	public static final String ERROR_404			= "/error404";
	public static final String PROFILE				= "/profile";
	public static final String LATEST_BLOG_ENTRIES 	= "/latestblogentries";
	public static final String HASHTAG				= "/hashtag";
	public static final String CREATE_BLOG_ENTRY 	= "/user/createblogentry";
	public static final String DASHBOARD 			= "/user/dashboard";
	public static final String CREATE_ARTICLE 		= "/user/createarticle";
	
	/* -- Apache Tiles definitions -- */
	public static final String INDEX_TILES_DEF 			= "system.index";
	public static final String INDEX_USER_TILES_DEF 	= "system.index_user";
	public static final String LOGIN_TILES_DEF			= "system.login";
	public static final String ERROR_404_TILES_DEF 		= "system.error404";
	public static final String ERROR_500_TILES_DEF		= "system.error500";
	public static final String ERROR_403_TILES_DEF		= "system.error403";
	public static final String PROFILE_AUTH_TILES_DEF	= "system.profile_auth";
	public static final String PROFILE_TILES_DEF		= "system.profile";
	public static final String DASHBOARD_TILES_DEF		= "system.dashboard";
	
	/* --Logger errors -- */
	public static final String LOGGER_ERROR_ENCODING 				= "Error setting encoding to request, unsupported enconding";
	public static final String LOGGER_ERROR_HTTP_CLIENT_ENCONDING 	= "Error on http client, unsupported enconding";
	public static final String LOGGER_ERROR_CLIENT_PROTOCOL 		= "Error on http client, client protocol";
	public static final String LOGGER_ERROR_IO 						= "Error on http client, IO";
	public static final String LOGGER_ERROR_UNKNOWN 				= "Error on http client, unknown error!";
	public static final String LOGGER_ERROR_BLOG_CREATION 			= "Error creating blog entry, null value on request parameter";
	public static final String LOGGER_ERROR_BLOG_TEMPLATE 			= "Error loading blog entry template";
	public static final String LOGGER_ERROR_HIBERNATE 				= "Error executing hibernate task";
	public static final String LOGGER_ERROR_DATABASE_TESTING 		= "Error testing database connection, default datasource is not available";
	public static final String LOGGER_ERROR_FILE_NOT_FOUND 			= "Error opening file, file not found";
	public static final String LOGGER_ERROR_UNAUTHORIZED			= "Error accessing a system feature, this account is not allowed: ";
	public static final String LOGGER_ERROR_ACCOUNT_PROFILE			= "Error getting data from requested account, invalid account";
	
	/* -- JSON definitions -- */
	public static final String JSON_OK_RESPONSE 			= "{\"status\":\"ok\"}";
	public static final String JSON_ERROR_NOT_AUTHENTICATED = "{\"status\":\"err\", \"error\":\"not_auth\"}";
	public static final String JSON_ERROR_EMPTY_MESSAGE 	= "{\"status\":\"err\", \"error\":\"empty_msg\"}";
	public static final String JSON_ERROR_NOT_AVAILABLE		= "{\"status\":\"err\", \"error\":\"not_avl\"}";
	public static final String JSON_ERROR_EMPTY_NICKNAME	= "{\"status\":\"err\", \"error\":\"empty_nick\"}";
	public static final String JSON_ERROR_EMPTY_MAIL		= "{\"status\":\"err\", \"error\":\"empty_mail\"}";
	
	/* -- Parameter names -- */
	public static final String ACCOUNT_SESSION_PARAM_NAME 		= "account_data";
	public static final String BEAN_REQUEST_PARAM_NAME 			= "bean";
	public static final String DATABASE_TEST_RESULT_PARAM_NAME 	= "database_test";
	
	/* -- Redirect URLs -- */
	public static final String ACCOUNT_CREATED_URL 			= "/shadowsatyr/login?acc=1";
	public static final String ACCOUNT_CREATION_ERROR_URL 	= "/shadowsatyr/login?acc=0";
	public static final String INDEX_URL					= "/shadowsatyr/index";
	
	/* -- Default datasource -- */
	public static final String SHADOW_SATYR_DEFAULT_DATASOURCE 	= "java:jboss/datasources/shadowsatyr";
	
	/* -- Permission list -- */
	public static final String SYSTEM_ADMIN_DASHBOARD_PERMISSION = "system:admin:dashboard";
	
	public static final String HTTP = "http";
	public static final String HTTPS = "https";
}
