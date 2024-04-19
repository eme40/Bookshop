package com.Eric.BookShopApplication.exception;

public class EmailAlreadyExistsException extends RuntimeException{
  public EmailAlreadyExistsException(String message){
    super(message);
  }
}
