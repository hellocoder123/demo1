package edu.xidian.bos.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import edu.xidian.bos.dao.base.IBaseDao;

/**      
* @Description: TODO 持久层通用实现类
* @author sy.wang  
* @date 2018年4月14日 上午11:00:35  
* @version V1.0    
*/
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> entityClass;
	
	
	public BaseDaoImpl() {
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>) actualTypeArguments[0];
	}
	//加resource注解，自定义session工厂方法以调用模板
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	
	public List<T> findAll() {
		String hql = "FROM "+entityClass.getSimpleName();
		return (List<T>) this.getHibernateTemplate().find(hql);
	}

}
