package edu.xidian.bos.service;

import java.util.List;

import edu.xidian.bos.domain.Subarea;
import edu.xidian.bos.utils.PageBean;

/**      
* @Description: TODO 
* @author sy.wang  
* @date 2018年4月22日 下午1:44:09  
* @version V1.0    
*/
public interface ISubareaService {

	public void save(Subarea model);

	public void pageQuery(PageBean pageBean);

	public List<Subarea> findAll();

	public void saveBatch(List<Subarea> regionList);

	public List<Subarea> findListNotAssociation();

}
