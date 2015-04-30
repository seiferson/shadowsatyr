package com.seifernet.shadowsatyr.servlet;

import javax.servlet.annotation.WebServlet;

import com.seifernet.shadowsatyr.dispatcher.Dispatcher;
import com.seifernet.snwf.helper.DispatcherHelper;
import com.seifernet.snwf.servlet.ContextServlet;

/**
 * Main servlet implementation, this server
 * implements front controller design pattern
 * and extends SNWF ContextServlet.
 * 
 * @author Seifer ( Cuauhtemoc Herrera Muñoz )
 * @since 1.0.0
 * @version 1.0.0
 *
 */
@WebServlet( "/shadowsatyr/*" )
public class Servlet extends ContextServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected DispatcherHelper getDispatcher() {
		return new Dispatcher( );
	}

}
