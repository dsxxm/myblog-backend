package com.baka.xxm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baka.xxm.entity.Article;
import com.baka.xxm.service.ArticleService;
import com.baka.xxm.utils.Result;

@RestController
@RequestMapping("/bakaxxm/articles")
public class ArticleController {
  private ArticleService article_service;

  public ArticleController(@Autowired ArticleService article_service) {
    this.article_service = article_service;
  }

  @PostMapping("/create")
  Result<String> create(@RequestBody Article article) {
    if (article_service.create(article)) {
      return Result.success();
    } else {
      return Result.error("fail to create article");
    }
  }
}
