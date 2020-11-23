package com.mono.myrecipedb.error;

import java.io.Serializable;

/**
 * Klasse für Fehlermeldungen im Json Format
 */
public class ErrorData implements Serializable {
    private String errormessage;

    public ErrorData(String errormessage) {
        this.errormessage = errormessage;
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage;
    }

}
