package com.seifernet.shadowsatyr.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.seifernet.shadowsatyr.persistance.dao.GenericDAO;

@WebListener
public class InitialConfigurationListener implements ServletContextListener{

	@Override
	public void contextDestroyed( ServletContextEvent event ) {
		//Nothing to do
	}

	@Override
	public void contextInitialized( ServletContextEvent event ) {
		//Called method to create database on deploy
		GenericDAO.getSessionFactoryInstance( );
	}

}
