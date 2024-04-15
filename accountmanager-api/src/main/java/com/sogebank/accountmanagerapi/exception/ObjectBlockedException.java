package com.sogebank.accountmanagerapi.exception;

public class ObjectBlockedException extends RuntimeException{
    public ObjectBlockedException(String message){super(message);}

    public ObjectBlockedException(String message, Throwable cause){super(message, cause);}
}
