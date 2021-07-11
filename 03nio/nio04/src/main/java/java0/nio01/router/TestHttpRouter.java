package java0.nio01.router;

import java.util.List;

public class TestHttpRouter {

    public String route(String tag) {
        if(tag.equals("baidu")){
            return "http://www.baidu.com";
        }else if(tag.equals("sina")){
            return "http://www.sina.com";
        }else{
            return "http://localhost:8801";
        }
    }
}
