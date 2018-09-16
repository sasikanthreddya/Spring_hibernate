package com.bmo.alerts.bs.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bmo.alerts.bs.model.Employee;

@Repository
public class EmployeeDaoImpl  implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee e) {
        getSession().persist(e);		
	}

	public void updateEmployee(Employee e) {
		getSession().update(e);
		
	}

	public List<Employee> listEmployees() {
		Session session =getSession();
		List<Employee> EmployeeList = session.createQuery("from Employee").list();
		for(Employee e : EmployeeList){
			System.out.println("employee List::"+e);
		}
		return EmployeeList;
	}

	public Employee getEMployeeById(int id) {
		Employee employee=getSession().get(Employee.class, new Integer(id));
		System.out.println("emploee loaded successfully, Person details="+employee);
		return employee;
	}

	public void removeEmployee(int id) {
		Employee employee=getSession().get(Employee.class, new Integer(id));
		if(null != employee){
			getSession().delete(employee);
		}
		System.out.println("Employee deleted successfully, person details="+employee);

		
	}

	public List<Employee> listEmployes(int firstResult, int maxResults) {
		 Criteria criteria = getSession().createCriteria(Employee.class);
		 criteria.setFirstResult(firstResult);
         criteria.setMaxResults(maxResults);
         List<Employee> empList = (List<Employee>) criteria.list();
		return empList;		 
	}

	public void addAllEmployees() {
		 for(int i=1;i <= 100 ; i++){
				// Employee e =new Employee("name"+i, "dept"+i,
				 Employee e =new Employee("name"+i, "dept"+i,1L*i);
				 getSession().save(e);	 
			 }
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
