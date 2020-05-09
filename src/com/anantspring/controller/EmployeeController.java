package com.anantspring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anantspring.bean.EmployeeBean;
import com.anantspring.model.Employee;
import com.anantspring.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean,BindingResult result){
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}
	
	@RequestMapping(value="/employees",method = RequestMethod.GET)
	public ModelAndView listEmployees(){
		Map<String, Object> model =  new HashMap<String, Object>();
		model.put("employees", prepareListOfBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList",model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command")EmployeeBean employeeBean,BindingResult result){
		Map<String, Object> model =  new HashMap<String, Object>();
		model.put("employees", prepareListOfBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
	  return new ModelAndView("index");
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command") EmployeeBean employeeBean,BindingResult result){
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model= new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees", prepareListOfBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee",model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command") EmployeeBean employeeBean,BindingResult result ){
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getId())));
		model.put("employees", prepareListOfBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee",model);
	}
	
	
	@RequestMapping(value="/getAjaxTime", method=RequestMethod.GET)
	public @ResponseBody String getAjaxTime(){
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String result = "<h2>"+ft.format(now)+"</h2><br/>";
		return result;
	}
	
	
	private List<EmployeeBean> prepareListOfBean(List<Employee> employees){
		List<EmployeeBean> beans = null ;
		if(employees != null && !employees.isEmpty()){
			EmployeeBean employeeBean = null;
			beans = new ArrayList<EmployeeBean>();
			for (Employee employee : employees) {
				employeeBean = new EmployeeBean();
				employeeBean.setName(employee.getEmpName());
				employeeBean.setAddress(employee.getEmpAddress());
				employeeBean.setAge(employee.getEmpAge());
				employeeBean.setSalary(employee.getSalary());
				employeeBean.setId(employee.getEmpId());
				beans.add(employeeBean);
			}
		}
		return beans;
	}
	
	private Employee prepareModel (EmployeeBean employeeBean){
		Employee employee = new Employee();
		employee.setEmpName(employeeBean.getName());
		employee.setEmpAddress(employeeBean.getAddress());
		employee.setSalary(employeeBean.getSalary());
		employee.setEmpAge(employeeBean.getAge());
		employee.setEmpId(employeeBean.getId());
		employeeBean.setId(null);
		return employee;
	}
	
	private EmployeeBean prepareEmployeeBean(Employee employee){
		EmployeeBean bean = new EmployeeBean();
		  bean.setAddress(employee.getEmpAddress());
		  bean.setAge(employee.getEmpAge());
		  bean.setName(employee.getEmpName());
		  bean.setSalary(employee.getSalary());
		  bean.setId(employee.getEmpId());
		  return bean;
	}
}
