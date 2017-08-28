package cn.thinkbear.app.androidmvpdemo.service;

/**
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/25
 */

public class ApiConstant {

    public static final int TIMEOUT_READ = 10000;
    public static final int TIMEOUT_CONNECT = 10000;

    public static final String PROJECT = "PrawnsServiceV2";
    public static final String DOMAIN = "www.51itexpert.com";

    public static final String BASE_URL = "http://" + DOMAIN + "/" + PROJECT + "/";

    public static class Error {
        public static final int ORTHER = -1;
        public static final int IO_EXCEPTION = -100;
        public static final int RELOGIN = -404;

    }


    public static class Parameter {
        public static final String ID = "id";
        public static final String TYPE = "type";

    }

}
