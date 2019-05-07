package web;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.apache.commons.lang3.StringUtils;

import service.ListCustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.Customer;
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
		private  Customer customer = new Customer();
	//	private	ListCustomerService cs=new ListCustomerService();
		
		
		public String list()throws Exception{ 
			//获得servletcontext对象
			ServletContext sc = ServletActionContext.getServletContext();
			//从sc中获得容器
			WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
			//从容器中获得customerService
			ListCustomerService cs = (ListCustomerService) ac.getBean("customerService");
			//ListCustomerService cs=new ListCustomerService();
			//接受数据
			String cust_name = ServletActionContext.getRequest().getParameter("cust_name");
			
			//离线查询
			DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
			//判断
			if(StringUtils.isNotBlank(cust_name)){
					dc.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
			}
			//调用service
			List<Customer> list = cs.getAll(dc);
			//转发
			ServletActionContext.getRequest().setAttribute("list", list);	
			return "list";
		}
		
		public String add() throws Exception {
			//获得servletcontext对象
			ServletContext sc = ServletActionContext.getServletContext();
			//从sc中获得容器
			WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
			//从容器中获得customerService
			ListCustomerService cs = (ListCustomerService) ac.getBean("customerService");
			
			cs.save(customer); 
			return "toList";
		}

		@Override
		public Customer getModel() {
			// TODO Auto-generated method stub
			return customer;
		}

}
