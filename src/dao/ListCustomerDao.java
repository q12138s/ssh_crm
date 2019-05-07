package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import utils.HibernateUtils;
import domain.Customer;

public class ListCustomerDao {
	public List<Customer> getAll( ) {
		
		Session session = HibernateUtils.getCurrentSession();
		//Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		//tx.commit();
		return list;
		// TODO Auto-generated method stub
		
	}

	public List<Customer> getAll(DetachedCriteria dc) {
		
		Session session = HibernateUtils.getCurrentSession();
		//Transaction tx = session.beginTransaction();
		Criteria c = dc.getExecutableCriteria(session);
		//tx.commit();
		return c.list();
		// TODO Auto-generated method stub
		
	}

	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
		
	}
	

}
