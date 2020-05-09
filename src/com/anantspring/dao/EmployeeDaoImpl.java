package com.anantspring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anantspring.model.Employee;


@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		if(employee.getEmpId() == null){
			sessionFactory.getCurrentSession().save(employee);
		}else{
			sessionFactory.getCurrentSession().update(employee);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub	
		return (List<Employee>)sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}

	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, empid);
	}

	@Override
	public void  deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("employee id "+employee.getEmpId());
		String hql = "DELETE from Employee WHERE empid = "+employee.getEmpId();
		//sessionFactory.getCurrentSession().createQuery("DELETE from Employee WHERE empid = "+employee.getEmpId());
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("Rows aftected :"+result);
		
	}

}
