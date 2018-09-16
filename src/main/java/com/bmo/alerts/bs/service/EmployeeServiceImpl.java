package com.bmo.alerts.bs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bmo.alerts.bs.dao.EmployeeDao;
import com.bmo.alerts.bs.model.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public void addEmployee(Employee e) {
		employeeDao.addEmployee(e);		
	}

	public List<Employee> listEmployees() {
		return	employeeDao.listEmployees();
	}

	public Employee getEMployeeById(int id) {
		return employeeDao.getEMployeeById(id);
	}

	public void removeEmployee(int id) {
		employeeDao.removeEmployee(id);	
	}

	public List<Employee> listEmployes(int pageNo, int totalNoPages) {
		List<Employee>emplist=employeeDao.listEmployes(pageNo, totalNoPages);
		return emplist;
	}

	public void addAllEmployees() {
		employeeDao.addAllEmployees();
	}

	public void updateEmployee(Employee e) {
		employeeDao.updateEmployee(e);		
	}

}
