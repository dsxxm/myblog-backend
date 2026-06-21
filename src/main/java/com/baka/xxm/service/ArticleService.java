package com.baka.xxm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.baka.xxm.entity.Article;
import com.baka.xxm.repository.ArticleRepository;
import com.baka.xxm.utils.PageResult;

@Service
public class ArticleService {
  private ArticleRepository article_repository;

  public ArticleService(@Autowired ArticleRepository article_repository) {
    this.article_repository = article_repository;
  }

  /**
   * find article by id
   * 
   * @param id
   * @return {@link Article}
   */
  public Article find(Long id) {
    return article_repository.selectById(id);
  }

  /**
   * get a list of articles by given page and pagesize
   * 
   * @param page
   * @param page_size
   * @return {@link PageResult}
   */
  public PageResult<List<Article>> list(int page, int page_size) {
    int limit = page_size;
    int offset = (page - 1) * page_size;
    List<Article> data = article_repository.selectList(limit, offset);
    int total = article_repository.count();
    int total_page = (total + page_size - 1) / page_size;
    return new PageResult<List<Article>>(data, total, page, page_size, total_page);
  }

  /**
   * create article, created_time and updated_time is auto generated
   * 
   * @param article
   * @return boolean
   */
  public boolean create(Article article) {
    try {
      return article_repository.insert(article);
    } catch (DuplicateKeyException e) {
      return false;
    }
  }

  /**
   * change the article,make sure id is passed
   * 
   * @param article
   * @return boolean
   */
  public boolean change(Article article) {
    return article_repository.update(article);
  }

  /**
   * delete article by id
   * 
   * @param id
   * @return boolean
   */
  public boolean delete(Long id) {
    return article_repository.delete(id);
  }
}
