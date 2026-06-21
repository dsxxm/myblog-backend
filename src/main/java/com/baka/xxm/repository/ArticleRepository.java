package com.baka.xxm.repository;

import org.apache.ibatis.annotations.Mapper;

import com.baka.xxm.entity.Article;

@Mapper
public interface ArticleRepository {
  public Article selectById(Long id);

  public boolean insert(Article article);

  public boolean update(Article article);

  public boolean delete(Long id);
}
