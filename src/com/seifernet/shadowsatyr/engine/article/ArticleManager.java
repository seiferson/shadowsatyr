package com.seifernet.shadowsatyr.engine.article;

import com.seifernet.shadowsatyr.persistance.dao.ArticleDAO;
import com.seifernet.shadowsatyr.persistance.dto.Article;

public class ArticleManager {

	public static void createArticle( Article article ){
		ArticleDAO dao = new ArticleDAO( );
		
		dao.create( article );
	}
	
	public static Article getArticleByHash( String hash ){
		ArticleDAO dao = new ArticleDAO( );
		
		return dao.read( "hashKey" , hash );
	}
}

