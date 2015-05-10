package com.seifernet.shadowsatyr.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.seifernet.shadowsatyr.persistance.SessionFactoryManager;

/**
 * Servlet context listener used for
 * initialization in the app.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@WebListener
public class ConfigurationListener implements ServletContextListener{

	@Override
	public void contextDestroyed( ServletContextEvent event ) {
		//Nothing to do
	}

	@Override
	public void contextInitialized( ServletContextEvent event ) {
		//Called method to create database on deploy
		SessionFactoryManager.getSessionFactoryInstance( );
	}

}
