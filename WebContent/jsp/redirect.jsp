<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<jsp:useBean id="Bean" scope="request" class="com.seifernet.shadowsatyr.bean.SystemBean" />
<tiles:insertDefinition name="${bean.layout}" />