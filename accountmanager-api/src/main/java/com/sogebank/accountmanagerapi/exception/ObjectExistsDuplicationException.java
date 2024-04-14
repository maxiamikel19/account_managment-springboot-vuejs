package com.sogebank.accountmanagerapi.exception;

public class ObjectExistsDuplicationException extends RuntimeException{
    
    public ObjectExistsDuplicationException(String message){super(message);}

    public ObjectExistsDuplicationException(String message, Throwable cause){super(message, cause);}
}
