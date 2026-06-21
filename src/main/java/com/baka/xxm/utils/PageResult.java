package com.baka.xxm.utils;

public class PageResult<T> {
  public T data;
  public int total;
  public int page;
  public int page_size;
  public int total_page;

  public PageResult(T data, int total, int page, int page_size, int total_page) {
    this.data = data;
    this.total = total;
    this.page = page;
    this.page_size = page_size;
    this.total_page = total_page;
  }
}
