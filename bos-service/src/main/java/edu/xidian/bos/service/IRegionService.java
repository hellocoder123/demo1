package edu.xidian.bos.service;

import java.util.List;

import edu.xidian.bos.domain.Region;
import edu.xidian.bos.utils.PageBean;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月19日 下午3:19:53  
* @version V1.0    
*/
public interface IRegionService {

	public void saveBatch(List<Region> regionList);

	public void pageQuery(PageBean pageBean);

	public List<Region> findAll();

	public void save(Region model);

}
