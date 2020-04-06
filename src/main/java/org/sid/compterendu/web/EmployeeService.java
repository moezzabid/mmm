package org.sid.compterendu.web;

import org.sid.compterendu.dao.AdministrateurRepository;
import org.sid.compterendu.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository ;
	@GetMapping(value="/getById/{id}")
	public ResponseEntity<Object> getByRef(@PathVariable Long id){
	return new ResponseEntity<Object>(employeerepository.findById(id),HttpStatus.OK);
		}
}
