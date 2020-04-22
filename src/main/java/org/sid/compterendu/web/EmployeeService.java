package org.sid.compterendu.web;

import java.util.HashMap;
import java.util.Map;

import org.sid.compterendu.dao.AdministrateurRepository;
import org.sid.compterendu.dao.CongeeEmployeeRepository;
import org.sid.compterendu.dao.EmployeeRepository;
import org.sid.compterendu.dao.TacheRepository;
import org.sid.compterendu.entity.CongeeChef;
import org.sid.compterendu.entity.CongeeEmployee;
import org.sid.compterendu.entity.Tache;
import org.sid.compterendu.entity.users.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeerepository ;
	@Autowired
	private TacheRepository tacherepository ;
	@Autowired
	private CongeeEmployeeRepository congeeemployeerepository ;
	@PostMapping(value="/addCongee/{id}")
	public void addEmployee (@RequestBody CongeeEmployee c) {		
		
		
		congeeemployeerepository.save(c);
	}
	
	@DeleteMapping(value = "/deleteCongee/{id}")
	public Map<String, Boolean> deleteCongee(@PathVariable Long id)
			throws ResourceNotFoundException {
		CongeeEmployee congeeemployee = congeeemployeerepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pas de congee :: " + id));

		congeeemployeerepository.delete(congeeemployee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Supprimer", Boolean.TRUE);
		return response;
	}
	
}
