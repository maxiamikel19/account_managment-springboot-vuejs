package com.sogebank.accountmanagerapi.exception;

public class ObjectSearchNotFoundException extends RuntimeException{
    
    public ObjectSearchNotFoundException(String message){super(message);}

    public ObjectSearchNotFoundException(String message, Throwable cause){super(message, cause);}
}
