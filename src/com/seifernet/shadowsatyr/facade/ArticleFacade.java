package com.seifernet.shadowsatyr.facade;

import com.seifernet.shadowsatyr.persistance.dao.ArticleDAO;
import com.seifernet.shadowsatyr.persistance.dto.Article;

public class ArticleFacade {
	
	public void createArticle( Article article ){
		ArticleDAO dao = null;
		
		dao = new ArticleDAO( );
		dao.create( article );
	}
	
}
