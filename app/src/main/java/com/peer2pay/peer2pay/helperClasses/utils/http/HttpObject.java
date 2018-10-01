package com.peer2pay.peer2pay.helperClasses.utils.http;

import com.peer2pay.peer2pay.helperClasses.enums.MediaType;
import com.peer2pay.peer2pay.helperClasses.enums.RequestType;

import java.util.Map;

public class HttpObject {
    private Map<String, String> headers;
    private String body;
    private RequestType requestType;
    private MediaType mediaType;
    private String url;

    public HttpObject(String url, Map<String, String> headers, String body, RequestType requestType, MediaType mediaType) {
        this.url = url;
        this.headers = headers;
        this.mediaType = mediaType;
        this.body = body;
        this.requestType = requestType;
    }

    //getters

    public String getUrl(){
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public MediaType getMediaType() {
        return mediaType;
    }
}
