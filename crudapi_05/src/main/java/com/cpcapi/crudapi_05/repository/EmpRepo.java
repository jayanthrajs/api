package com.cpcapi.crudapi_05.repository;

import org.springframework.data.repository.CrudRepository;

import com.cpcapi.crudapi_05.model.Employee;

public interface EmpRepo extends CrudRepository<Employee, Integer>{

	
}
