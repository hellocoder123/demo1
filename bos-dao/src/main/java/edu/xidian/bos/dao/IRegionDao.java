package edu.xidian.bos.dao;

import java.util.List;

import edu.xidian.bos.dao.base.IBaseDao;
import edu.xidian.bos.domain.Region;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月19日 下午3:25:06  
* @version V1.0    
*/
public interface IRegionDao extends IBaseDao<Region>{



	public List<Region> findListByQ(String q);



}
