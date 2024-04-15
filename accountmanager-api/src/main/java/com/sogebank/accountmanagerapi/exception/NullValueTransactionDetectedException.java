package com.sogebank.accountmanagerapi.exception;

public class NullValueTransactionDetectedException extends RuntimeException{
    public NullValueTransactionDetectedException(String message){super(message);}

    public NullValueTransactionDetectedException(String message, Throwable cause){super(message, cause);}
}
