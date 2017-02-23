package cn.itcast.yycg.base.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.yycg.util.FastJsonUtil;

public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	private T t;

	@Override
	public T getModel() {
		return t;
	}

	public BaseAction() {
		// 获取当前对象父类的泛型
		try {
			Type type = this.getClass().getGenericSuperclass();
			// 判断是否属于参数化的类型
			if (type instanceof ParameterizedType) {

				ParameterizedType param = (ParameterizedType) type;
				Class<T> clazz = (Class<T>) param.getActualTypeArguments()[0];
				t = clazz.newInstance();

			}
			if (t == null) {
				throw new RuntimeException("Action类【" + this + "】使用BaseAction异常");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * 将数据放入值栈中
	 * @param obj
	 */
	public void pushValueStack(Object obj) {
		ActionContext.getContext().getValueStack().push(obj);
	}
	/**
	 * 将数据放入值栈中
	 * @param key
	 * @param obj
	 */
	public void setValueStack(String key, Object obj) {
		ActionContext.getContext().getValueStack().set(key, obj);
	}
	/**
	 * 将数据放入context域中
	 * @param key
	 * @param value
	 */
	public void Contextput(String key, Object value) {
		ActionContext.getContext().put(key, value);
	}
	/**
	 * 将数据放入session中
	 * @param key
	 * @param value
	 */
	public void putSession(String key, Object value) {
		ActionContext.getContext().getSession().put(key, value);
	}
	/**
	 * 将数据放入Application中
	 * @param key
	 * @param value
	 */
	public void putApplication(String key, Object value) {
		ActionContext.getContext().getApplication().put(key, value);
	}

	// 简化servlet api访问
	/**
	 * 获取response
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	/**
	 * 获取request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	/**
	 * 将对象转换成json对象
	 * @param obj
	 */
   	public void write_object(Object obj){
   		FastJsonUtil.write_object(this.getResponse(), obj);
   	}

}
