package com.kathford.howto.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
    private Object object;
    private Strings message;
    private boolean success;

    public Response(Object object, Strings message, boolean success) {
        this.object = object;
        this.message = message;
        this.success = success;
    }
}
