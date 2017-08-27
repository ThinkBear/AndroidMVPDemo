package cn.thinkbear.app.androidmvpdemo.vo;

/**
 * 封装请求的相关参数数据
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/17
 */

public class Query {
    private int id_int;
    private String id_str;
    private int type_int;
    private String type_str;

    private Object obj;

    public int getId_int() {
        return id_int;
    }

    public void setId_int(int id_int) {
        this.id_int = id_int;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public int getType_int() {
        return type_int;
    }

    public void setType_int(int type_int) {
        this.type_int = type_int;
    }

    public String getType_str() {
        return type_str;
    }

    public void setType_str(String type_str) {
        this.type_str = type_str;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
