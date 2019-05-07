package service;

import org.hibernate.Session;

import utils.HibernateUtils;
import dao.UserDao;
import domain.User;

public class UserService {
	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public User login(User user) {
		Session session = HibernateUtils.getCurrentSession();
		session.beginTransaction();
		User existU=ud.getByUserCode(user.getUser_code());
		session.close();
		if(existU==null){
			throw new RuntimeException("用户名不存在！");
		}
		if(!existU.getUser_password().equals(user.getUser_password())){
			throw new RuntimeException("密码不存在！");
		}
		return existU;
	}

}
