package com.baka.xxm.entity;

import java.time.LocalDateTime;

public class Article {
  public Long id;
  public String title;
  public String slug;
  public String summary;
  public String content;
  public String author;
  public LocalDateTime created_at;
  public LocalDateTime updated_at;
}
