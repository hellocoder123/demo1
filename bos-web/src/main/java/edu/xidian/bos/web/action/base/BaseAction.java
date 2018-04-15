package edu.xidian.bos.web.action.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**      
* @Description: TODO 表现层代码抽取实现
* @author sy.wang  
* @date 2018年4月14日 上午11:29:03  
* @version V1.0    
*/
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	public static final String HOME = "home";
	public static final String LIST = "list";
	protected T model;
	
	public BaseAction() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] arr = superclass.getActualTypeArguments();
		Class<T> entity = (Class<T>) arr[0];
		try {
			model = entity.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public T getModel() {
		return model;
	}

}
