package com.peer2pay.peer2pay.helperClasses.http;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class HttpRequest {
    private static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    public ResponseBody get(HttpObject requestObject, String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = createRequest(requestObject, url);
        return client.newCall(request).execute().body();

    }

    //helper methods

    private Request createRequest(HttpObject request, String url){
        switch (request.getType()) {
            case GET:
                return new Request.Builder()
                        .url(url)
                        .get()
                        .headers(getHeaders(request))
                        .build();
            case POST:
                return new Request.Builder()
                        .url(url)
                        .headers(getHeaders(request))
                        .post(getBody(request))
                        .build();
            case PUT:
                return new Request.Builder()
                        .url(url)
                        .headers(getHeaders(request))
                        .put(getBody(request))
                        .build();
            case PATCH:
                return new Request.Builder()
                        .url(url)
                        .headers(getHeaders(request))
                        .patch(getBody(request))
                        .build();
            case DELETE:
                return new Request.Builder()
                        .url(url)
                        .headers(getHeaders(request))
                        .delete(getBody(request))
                        .build();
        }
        return new Request.Builder()
                .url(url)
                .build();
    }

    private Headers getHeaders(HttpObject request){
        return Headers.of(request.getHeaders());
    }

    private RequestBody getBody(HttpObject request){
        return RequestBody.create(JSON, request.getBody());
    }
}
