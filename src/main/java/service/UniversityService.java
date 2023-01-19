package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//FIXME: complete usage of springframework than
//javax persistence

//import javax.transaction.Transactional;

import pojo.UniversityPojo;

@Service
public class UniversityService {
	
	@Autowired
	private UniversityDa0 dao;
	
	@Transactional(rollbackOb=ApiException.class)
	public void add(UniversityPojo p) throws ApiException{
		normalzie(p);
		if(StringUtil.isEmpty(p.getName())) {
			throw new ApiException("name cannot be empty");
		}
		dao.insert(p);
	}
	
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}
	
	@Transactional(rollbackOn=ApiException.class)
	public UniversityPojo get(int id) throws ApiException{
		return getCheck(id);
	}
	
	@Transactional
	public List<UniversityPojo> getAll(){
		return dao.selectAll();
	}
	
	@Transactional(rollbackOn=ApiException.class)
	public void update(int id, UniversityPojo p) throws ApiException{
		normalize(p);
		UniversityPojo ex=getCheck(id);
		ex.setAge(p.getAge());
		ex.setName(p.getName());
		dao.update(ex);
	}
	
	@Transactional
	public UniversityPojo getCheck(int id) throws ApiException{
		UniversityPojo p = dao.select(p);
		if(p==null) {
			throw new ApiException("University with given id does not exist: " + id);
		}
		return p;
	}
	
	protected static void normalize(UniversityPojo p) {
		p.setName(StringUtil.toLowerCase(p.getName()));
	}
}
