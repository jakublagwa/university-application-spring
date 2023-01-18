package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pojo.UniversityPojo;

public class UniversityDao extends AbstractDao{
	
	private static String delete_id="delete from UniversityPojo p where id=:id";
	private static String select_id="select p from UniversityPojo p where id=:id";
	private static String select_all="select p from UniversityPojo p";

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void insert(UniversityPojo p) {
		em.persist(p);
	}
	
	public int delete(int id) {
		Query query = em.createQuery(delete_id);
		query.setParameter("id", id);
		return query.executeUpdate();
	}

	public UniversityPojo select(int id) {
		TypedQuery<UniversityPojo> query = getQuery(select_id, UniversityPojo.class);
		query.setParameter("id", id);
		return getSingle(query);
	}

	public List<UniversityPojo> selectAll() {
		TypedQuery<UniversityPojo> query = getQuery(select_all, UniversityPojo.class);
		return query.getResultList();
	}

	public void update(UniversityPojo p) {
	}
}
