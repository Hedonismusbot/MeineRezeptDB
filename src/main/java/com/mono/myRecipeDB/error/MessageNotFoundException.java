package com.mono.myRecipeDB.error;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String s) {
        super(s);
    }
}
