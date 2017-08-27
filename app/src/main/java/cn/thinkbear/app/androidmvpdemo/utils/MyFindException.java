package cn.thinkbear.app.androidmvpdemo.utils;

/**
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/3/24
 */
public class MyFindException extends Exception{
    private int error_code = -1;
    public MyFindException(String msg){
        super(msg);
    }
    public MyFindException(int error_code,String msg){
        super(msg);
        this.error_code = error_code;
    }

    public int getError_code(){
        return this.error_code;
    }

}
