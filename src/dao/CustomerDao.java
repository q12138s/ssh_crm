package dao;

import org.hibernate.Session;

import utils.HibernateUtils;
import domain.Customer;

public class CustomerDao {

	public Customer getById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		return session.get(Customer.class, cust_id);
		
		
	}

}
