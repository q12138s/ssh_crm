package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import utils.HibernateUtils;
import domain.User;

public class UserDao {

	public User getByUserCode(String user_code) {
		
		Session session = HibernateUtils.getCurrentSession();
		String hql="from User where User_code=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, user_code);
		User u = (User) query.uniqueResult();
		 
		return u;
		
	}

}
