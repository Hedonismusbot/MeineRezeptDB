package com.mono.myrecipedb.error;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String s) {
        super(s);
    }
}
