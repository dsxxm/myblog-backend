package com.baka.xxm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baka.xxm.entity.Article;
import com.baka.xxm.repository.ArticleRepository;

@Service
public class ArticleService {
  private ArticleRepository article_repository;

  public ArticleService(@Autowired ArticleRepository article_repository) {
    this.article_repository = article_repository;
  }

  /**
   * create article, created_time and updated_time is auto generated
   * 
   * @param article
   * @return Boolean
   */
  public Boolean create(Article article) {
    return article_repository.insert(article);
  }
}
