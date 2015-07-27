package com.seifernet.shadowsatyr.bean;

import com.seifernet.shadowsatyr.persistance.dto.Article;

/**
 * 
 * @author seifer
 *
 */
public class ArticleBean extends SystemBean{

	private static final long serialVersionUID = 1L;
	
	private Article article;

	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

}
