package com.baka.xxm.utils;

public class Result<T> {
  private int code;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  private T data;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  private Result(int code, String message, T data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public static <T> Result<T> success(T data) {
    return new Result<>(200, "success", data);
  }

  public static <T> Result<T> success() {
    return new Result<>(200, "success", null);
  }

  public static <T> Result<T> error(int code, String message, T data) {
    return new Result<T>(code, message, data);
  }

  public static <T> Result<T> error(String message, T data) {
    return new Result<T>(500, message, data);
  }

  public static <T> Result<T> error(String message) {
    return new Result<T>(500, message, null);
  }
}
