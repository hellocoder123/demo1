package edu.xidian.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.xidian.bos.dao.ISubareaDao;
import edu.xidian.bos.domain.Subarea;
import edu.xidian.bos.service.ISubareaService;
import edu.xidian.bos.utils.PageBean;


@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	@Autowired
	private ISubareaDao subareaDao;
	public void save(Subarea model) {
		subareaDao.save(model);
	}
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
	}
	public List<Subarea> findAll() {
		return subareaDao.findAll();
	}

	public void saveBatch(List<Subarea> regionList) {
		for (Subarea subarea : regionList) {
			subareaDao.save(subarea);
		}
	}
	
	public List<Subarea> findListNotAssociation() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件，decidedzone = null;
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(detachedCriteria);
	}

	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		detachedCriteria.add(Restrictions.eq("decidedzone.id", decidedzoneId));
		
		return subareaDao.findByCriteria(detachedCriteria);
	}
}
