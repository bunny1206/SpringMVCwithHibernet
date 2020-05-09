package com.anantspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.anantspring.dao.EmployeeDao;
import com.anantspring.model.Employee;


@Service("mployeeService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly = false)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly= false)
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub
		return employeeDao.listEmployeess();
	}

	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		return employeeDao.getEmployee(empid);
	}

	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(employee);
	}
	
	
}
