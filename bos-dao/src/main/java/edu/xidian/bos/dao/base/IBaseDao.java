package edu.xidian.bos.dao.base;

import java.io.Serializable;
import java.util.List;

/**      
* @Description: TODO 持久层通用接口
* @author sy.wang  
* @date 2018年4月14日 上午10:53:44  
* @version V1.0    
*/
public interface IBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
}
