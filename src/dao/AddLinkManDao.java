package dao;

import org.hibernate.Session;

import utils.HibernateUtils;
import domain.LinkMan;

public class AddLinkManDao {

	public void save(LinkMan lk) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(lk);
		
	}

}
