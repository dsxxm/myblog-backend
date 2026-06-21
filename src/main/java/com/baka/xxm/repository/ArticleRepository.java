package com.baka.xxm.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baka.xxm.entity.Article;

@Mapper
public interface ArticleRepository {
  public int count();

  public List<Article> selectList(@Param("limit") int limit, @Param("offset") int offset);

  public Article selectById(Long id);

  public boolean insert(Article article);

  public boolean update(Article article);

  public boolean delete(Long id);
}
