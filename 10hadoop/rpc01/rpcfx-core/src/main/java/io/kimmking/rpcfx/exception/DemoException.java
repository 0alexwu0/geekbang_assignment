package io.kimmking.rpcfx.exception;

import java.util.Map;

public class DemoException extends RuntimeException{

    public DemoException(String msg){
        super(msg);
    }

    public enum TYPE {
        CLASS_NO_HAS("CLASS_NO_HAS", "指定类没有找到"),
        VOID_NO_HAS("VOID_NO_HAS", "指定方法没有找到");

        private String code;
        private String desc;

        TYPE(String code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public String getCode() {
            return this.code;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getDesc(Map<String, String> map) {
            return this.desc;
        }
    }
}
