package com.peer2pay.peer2pay.helperClasses.http;

import com.peer2pay.peer2pay.helperClasses.enums.RequestType;

import java.util.Map;

public class HttpObject {
    private Map<String, String> headers;
    private String body;
    private RequestType type;

    public HttpObject(Map<String, String> headers, String body, RequestType type) {
        this.headers = headers;
        this.body = body;
        this.type = type;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public RequestType getType() {
        return type;
    }
}
