package java0.nio01.filter;

import io.netty.handler.codec.http.FullHttpResponse;

public class HeaderHttpResponseFilter {

    public void filter(FullHttpResponse response) {
        response.headers().set("test_response", "alex.wu");
        response.headers().set("Content-Type", "text/html;charset=utf-8");
    }
}
