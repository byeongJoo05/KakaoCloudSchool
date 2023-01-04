package di.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import di.domain.Good;

@Repository
public class HibernateRepository {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertGood(Good good) {
		Session session = sessionFactory.getCurrentSession();
		// 데이터 추가
		session.save(good);
	}
	
	@Transactional
	public void updateGood(Good good) {
		Session session = sessionFactory.getCurrentSession();
		// 동일한 기본키의 데이터를 찾아서 나머지를 수정
		session.update(good);
	}
	
	// 테이블의 전체 데이터 조회
	@Transactional
	public List<Good> listGood() {
		
		 Session session = sessionFactory.getCurrentSession(); // 제약조건 생성
		 /*
		 * CriteriaQuery<Good> criteriaQuery =
		 * session.getCriteriaBuilder().createQuery(Good.class);
		 * criteriaQuery.from(Good.class);
		 */
		return session.createSQLQuery("select * from goods").addEntity(Good.class).getResultList();
	}
	
	// 기본키를 가지고 데이터 1개 조회
	@Transactional
	public Good getGood(int code) {
		return (Good)sessionFactory.getCurrentSession().get(Good.class, code);
	}
}
