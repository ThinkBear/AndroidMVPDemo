package cn.thinkbear.app.androidmvpdemo.vo;

import java.util.List;


/**
 * 接口数据返回统一转化类
 *
 * 利用泛型利用，数据块中的数据可以任意指定
 *
 * @author ThinkBear
 * @version 1.0.0
 * @date 17/4/17
 */
public class Response<T> {

	private int state;
	private String msg;
	private List<T> data;


	public int getState() {
		return state;
	}

	public String getMsg() {
		return msg;
	}

	public List<T> getData() {
		return data;
	}


	public T getSigleData(){
		if(this.data!=null&&this.data.size()>0){
			return this.data.get(0);
		}
		return null;
	}


	public boolean isSuccess(){
		return this.state == 0;
	}
	
}
