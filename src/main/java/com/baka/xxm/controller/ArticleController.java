package com.baka.xxm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baka.xxm.entity.Article;
import com.baka.xxm.service.ArticleService;
import com.baka.xxm.utils.PageResult;
import com.baka.xxm.utils.Result;

@RestController
@RequestMapping("/bakaxxm/articles")
public class ArticleController {
  private ArticleService article_service;

  public ArticleController(@Autowired ArticleService article_service) {
    this.article_service = article_service;
  }

  @GetMapping("/{id}")
  Result<Article> find(@PathVariable Long id) {
    Article article = article_service.find(id);
    if (article == null) {
      return Result.error(404, "can not find article");
    } else {
      return Result.success(article);
    }
  }

  @GetMapping
  Result<PageResult<List<Article>>> list(@RequestParam int page, @RequestParam int page_size) {
    PageResult<List<Article>> page_result = article_service.list(page, page_size);
    if (page_result.data.isEmpty()) {
      return Result.error(404, "no articles for now");
    } else {
      return Result.success(page_result);
    }
  }

  @PostMapping
  Result<String> create(@RequestBody Article article) {
    if (article_service.create(article)) {
      return Result.success();
    } else {
      return Result.error("fail to create");
    }
  }

  @PutMapping("/{id}")
  Result<String> change(@PathVariable Long id, @RequestBody Article article) {
    article.id = id;
    if (article_service.change(article)) {
      return Result.success();
    } else {
      return Result.error("fail to update");
    }
  }

  @DeleteMapping("/{id}")
  Result<String> delete(@PathVariable Long id) {
    if (article_service.delete(id)) {
      return Result.success();
    } else {
      return Result.error("fail to delete");
    }
  }
}
