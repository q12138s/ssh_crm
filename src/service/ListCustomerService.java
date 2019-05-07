package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import utils.HibernateUtils;
import dao.ListCustomerDao;
import domain.Customer;

public class ListCustomerService {
	private ListCustomerDao dao;
	

	public void setDao(ListCustomerDao dao) {
		this.dao = dao;
	}

	public List<Customer> getAll( ) {
		Session session =  HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//ListCustomerDao dao=new ListCustomerDao();
		List<Customer> list=dao.getAll();
		//dao.getAll(cs);
		tx.commit();
		return list;
	}
	
	public List<Customer> getAll(DetachedCriteria dc) {
		Session session =  HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		//ListCustomerDao dao=new ListCustomerDao();
		List<Customer> list=dao.getAll(dc);
		//dao.getAll(cs);
		tx.commit();
		return list;
	}

	public void save(Customer customer) {
		Session session =  HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		dao.save(customer);
		tx.commit();
	}

	
}
