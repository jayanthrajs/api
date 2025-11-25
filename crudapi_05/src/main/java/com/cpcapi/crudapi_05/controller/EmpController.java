package com.cpcapi.crudapi_05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpcapi.crudapi_05.model.Employee;
import com.cpcapi.crudapi_05.repository.EmpRepo;

@RestController
@RequestMapping("/emp")
public class EmpController {
	
    @Autowired
	EmpRepo emprepo;
	@SuppressWarnings("unused")
	private Employee empupdate;
    
    
	@PostMapping("/addEmp")
	public String addEmp(@RequestBody Employee employee) {
		
		emprepo.save(employee);
		return "Record Inserted Sucessfully";
	}
	
	@GetMapping("/getEmp")
	public List<Employee> getEmp(){
		
		return(List<Employee>) emprepo.findAll();
	}
	
	@DeleteMapping("/delEmp/{eid}")
	public String delEmp(@PathVariable int eid) {
		
		emprepo.deleteById(eid);
		return "Record Deleted Sucessfully";
		
	}
	@PutMapping("/updEmp")
	public String updEmp(@RequestBody Employee employee) {
		Employee empupdate=emprepo.findById(employee.getEid()).get();
		empupdate.setEname(employee.getEname());
		empupdate.setCompany(employee.getCompany());
		empupdate.setLocation(employee.getLocation());
		emprepo.save(empupdate);
		return "record updates successfully";
	
	}
}
	