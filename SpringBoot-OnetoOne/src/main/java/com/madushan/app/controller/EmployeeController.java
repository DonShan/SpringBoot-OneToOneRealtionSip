package com.madushan.app.controller;

import javax.transaction.Transactional;

import com.madushan.app.model.Address;
import com.madushan.app.model.Employee;
import com.madushan.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("service")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("test")
	public Employee test() {
		Employee employee = new Employee();
		employee.setId(10);
		employee.setName("Madushan");
		employee.setMarks("80");
		Address adress = new Address();
		adress.setCity("Kalaniya");
		employee.setAddress(adress);
		return employee;
	}


	@RequestMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		if (id == 0) {
			Employee employee = new Employee();
			employee.setId(10);
			employee.setName("Madushan");
			return employee;
		} else
			return employeeService.findById(id);

	}


	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return employeeService.deleteEmployee(id);
	}

	@Transactional
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee getEmployees(@RequestBody Employee e) {

		Employee eee = employeeService.save(e);
		return eee;
	}
}
