package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import pojo.UniversityPojo;


@Repository
public class UniversityInMemDao {

	private HashMap<Integer, UniversityPojo> rows;
	private int lastId;

	@Bean(initMethod="init")
	public void init() {
		rows = new HashMap<Integer, UniversityPojo>();
	}
	
	public void insert(UniversityPojo p) {
		lastId++;
		p.setId(lastId);
		rows.put(lastId, p);
	}

	public void delete(int id) {
		rows.remove(id);
	}

	public UniversityPojo select(int id) {
		return rows.get(id);
	}
	
	public List<UniversityPojo> selectAll() {
		ArrayList<UniversityPojo> list = new ArrayList<UniversityPojo>();
		list.addAll(rows.values());
		return list;
	}

	public void update(int id, UniversityPojo p) {
		rows.put(id, p);
	}

}
